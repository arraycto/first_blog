<template>
  <div>
    <div class="main-breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>账号设置</el-breadcrumb-item>
        <el-breadcrumb-item>修改密码</el-breadcrumb-item>
      </el-breadcrumb>
    </div>


    <div>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>修改密码</span>
        </div>

        <div class="el-input">

          <el-input placeholder="输入登录密码" v-model="ruleForm.input" show-password></el-input>
          <el-input placeholder="输入新密码" v-model="ruleForm.password" show-password></el-input>

          <el-button type="submit">确定</el-button>
        </div>

      </el-card>
    </div>
  </div>


</template>

<script>
  export default {
    name: 'PassEdit',

    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };

      return {
        ruleForm: {
          input: '',
          password: '',
          chenkpass: '',
        },

        rules: {
          pass: [
            {validator: validatePass, trigger: 'blur'}
          ],
          checkPass: [
            {validator: validatePass2, trigger: 'blur'}
          ]
        }
      }
    }
  }
</script>

<style scoped>

  .main-breadcrumb {
    margin-left: 10px;
  }


  .el-button {
    width: 750px;
    margin-left: 80px;
    margin-top: 25px;
  }

  .el-input {
    width: 750px;
    margin-left: 80px;
    margin-top: 25px;
  }

  .box-card {
    margin-left: 100px;
    margin-top: 20px;
    width: 1100px;
    height: 500px;
  }

</style>
