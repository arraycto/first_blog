package com.zhaoguoshun.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.zhaoguoshun.entity.OssEntity;
import com.zhaoguoshun.service.AliOssService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@Service
public class AliOssServiceImpl implements AliOssService, InitializingBean {

    @Autowired
    private OssEntity ossEntity;


    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;


    /**
     * 初始化之后的操作
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        //// Endpoint以杭州为例，其它Region请按实际情况填写。
        endpoint = ossEntity.getEndpoint();
        //// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        accessKeyId = ossEntity.getAccessKeyId();
        accessKeySecret = ossEntity.getAccessKeySecret();
        bucketName = ossEntity.getBucketName();

    }

    /**
     * 创建存储空间
     */
    @Override
    public void createBucket() {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //真贱
//        if (ossClient.doesBucketExist(bucketName)) {
//            throw new RuntimeException(bucketName + "在对象存储的Bucket列表中已经存在");
//        }
        // 创建存储空间。
        ossClient.createBucket(bucketName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return
     */
    @Override
    public String upload(MultipartFile file) {
        String uploadUrl=null;


        try {

            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            if (!ossClient.doesBucketExist(bucketName)) {
                //创建bucketName
                ossClient.createBucket(bucketName);
                //设置buckname属性
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            //获取上传文件的文件流
            InputStream inputStream = file.getInputStream();

            //构建日期文件夹目录
            String dataPath = new DateTime().toString("yyyy/MM/dd");


            //获取上传文件的全名称
            String original = file.getOriginalFilename();

            //获取uuid
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");

            //获取上传文件扩展名
            String fileType = original.substring(original.lastIndexOf("."));

            //拼接文件名称
            String newName = fileName + fileType;

            fileName= dataPath+"/"+newName;

            //如果想要实现图片预览效果，一定要设置一下几点
            //1.设置图片的ACL(权限)，要么是公共读，要么是公共读写
            //2.一定要设置文本类型（image/jpg）
            ObjectMetadata objectMetadata=new ObjectMetadata();
            //设置公共读权限
            objectMetadata.setObjectAcl(CannedAccessControlList.PublicRead);
            objectMetadata.setContentType(getcontentType(fileType));


            //每次上传得到的名字肯定是不能相同的，在JAva中如何让每次生成的名字不一样呢
            //uuid redis分布式ID 雪花算法  为了更加方便的区分，这边的文件格式 yyyy/MM/dd+uuid


            ossClient.putObject(bucketName, fileName,inputStream,objectMetadata);
            //关闭OSSClient。
            ossClient.shutdown();

            //默认十年不过期
            Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
            //bucket名称  文件名   过期时间
            uploadUrl = ossClient.generatePresignedUrl(bucketName, fileName, expiration).toString();

            //获取url地址
            //uploadUrl = "https://" + bucketName + "." + endPoint + "/" + fileName;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return uploadUrl.substring(0, uploadUrl.indexOf("?"));
        //return uploadUrl;
    }

    /**
     * 下载文件
     *
     * @param fileName
     * @throws IOException
     */
    @Override
    public void download(String fileName) throws IOException {

    }

    /**
     * 列举文件
     */
    @Override
    public void listFile() {

    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    @Override
    public void deleteFile(String fileName) {

    }



    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpg";
    }
}
