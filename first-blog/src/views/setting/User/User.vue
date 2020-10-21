<template>
  <div>
    <div class="main-breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>账号设置</el-breadcrumb-item>
        <el-breadcrumb-item>账号首页</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  <div class="personal">
    <span style="font-weight: 500">绑定邮箱</span>
    <span style="padding-left: 300px">已绑定绑定邮箱</span>
    <span style="padding-left: 400px">更换邮箱</span>
    <el-divider></el-divider>
    <span>设置密码</span>
    <span style="padding-left: 300px">已设置密码</span>
    <span style="padding-left: 430px">修改密码</span>

    <el-divider></el-divider>
    <span>绑定手机</span>
    <span style="padding-left: 300px">未绑定手机</span>
    <span style="padding-left: 430px">更换手机</span>
  </div>
  </div>
</template>

<script>
  export default {
    name: 'user',
    data() {
      return {
        tableData: [
                {
          title: '密码安全',
          status: '已设置密码',
          bind: '更换密码',

        },
          {
            title: '绑定安全邮箱',

            status: '已绑定邮箱',
            bind: '更换邮箱'
          }, {
            title: '绑定手机号',

            status: '未绑定',
            bind: '绑定手机号'
          }

        ]
      }
    },
    methods: {}
  }
</script>


<style scoped>
  .main-breadcrumb {
    margin-left: 10px;
  }

  .main-card {
    width: 1100px;
    padding-top: 50px;
    padding-left: 100px;
  }

  .box-card {
    width: 1100px;
    height: 500px;
  }
  a{
    text-decoration: none;
  }
  .personal{
    width: 1100px;
    padding-left: 100px;
    padding-top: 80px;
  }
</style>
