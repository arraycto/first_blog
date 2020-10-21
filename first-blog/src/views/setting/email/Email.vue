<template>
  <div>
    <div class="main-breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>账号设置</el-breadcrumb-item>
        <el-breadcrumb-item>修改邮箱</el-breadcrumb-item>
      </el-breadcrumb>
    </div>


    <div>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>修改邮箱</span>
        </div>

        <div class="el-input">

          <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="register_form">

            <el-form-item prop="name">
              <el-input placeholder="输入登录密码" v-model="ruleForm.input" show-password></el-input>
            </el-form-item>
            <el-form-item prop="email">
              <el-input v-model="ruleForm.email" placeholder="输入邮箱地址" prefix-icon="el-icon-message"></el-input>
            </el-form-item>

            <el-form-item style="padding-top: 15px">
              <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </div>

      </el-card>
    </div>
  </div>


</template>

<script>
  export default {
    name: 'Email',

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
          email: ''
        },

        rules: {
          pass: [
            {validator: validatePass, trigger: 'blur'}
          ],
          checkPass: [
            {validator: validatePass2, trigger: 'blur'}
          ],
          email: [
            {required: true, message: '请输入邮箱', trigger: 'blur'},
            {type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change']}
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
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
    margin-left: 40px;
    margin-top: 0px;
  }

  .el-input {
    width: 750px;
    margin-left: 40px;
    margin-top: 10px;
  }

  .box-card {
    margin-left: 100px;
    margin-top: 20px;
    width: 1100px;
    height: 500px;
  }

</style>
