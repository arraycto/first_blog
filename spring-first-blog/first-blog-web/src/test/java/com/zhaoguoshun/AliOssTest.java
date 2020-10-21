package com.zhaoguoshun;

import com.zhaoguoshun.entity.OssEntity;
import com.zhaoguoshun.service.impl.AliOssServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FirstBlog_web_8001.class)
public class AliOssTest {
    @Autowired
    private OssEntity ossEntity;

    @Autowired
    private AliOssServiceImpl ossService;

    @Test
    public void contextLoads(){
//       System.out.println(ossEntity.getBucketName());
        ossService.createBucket();
    }

}
