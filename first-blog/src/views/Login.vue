<template xmlns:to="http://www.w3.org/1999/xhtml">
  <div class="login_conent">
    <div class="login-box">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="login_form">
        <el-form-item prop="username">
          <el-input v-model="ruleForm.username" placeholder="用户名" prefix-icon="el-icon-user"></el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input v-model="ruleForm.password" type="password" placeholder="密码" prefix-icon="el-icon-lock"></el-input>
        </el-form-item>

<!--        <span><a href="/register" >还没有账号？去注册</a></span>-->

        <div class="login-a">
          <router-link class="span-ui" :to="{path: '/register'}"><span>还没有账号？去注册</span></router-link>

        </div>
        <span>{{ruleForm.name}}</span>

        <el-form-item style="padding-top: 15px">
          <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>

        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import {loginSubmit} from '../api/user'

  export default {
    name: 'Login',
    data() {
      return {
        ruleForm: {
          username: '',
          password: '',
          name :''
        },
        rules: {
          username: [
            {required: true, message: '请输入用户名称', trigger: 'blur'},
            {min: 3, max: 16, message: '长度在 3 到 16 个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 3, max: 16, message: '长度在 3 到 16 个字符', trigger: 'blur'}
          ]
        }

      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            loginSubmit(this.ruleForm.username,this.ruleForm.password)
                    .then(res=>{
                if(res.data.code!== 20000){
                  this.$message({
                    showClose: true,
                    message:  res.data.message,
                    type: 'error'
                  });
                }else {
                  this.$notify({
                    // title: '登录成功',
                    message: res.data.message ,
                    type: 'success'
                  });
                  this.$router.push("/admin/index/"+this.ruleForm.username+"/"+this.ruleForm.password);
                }
            })

          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      async LoginSubmit(){
        const {data}= await loginSubmit(this.ruleForm.username,this.ruleForm.password)
        console.log(data.data)
      }
    }
  }
</script>

<style lang="less" scoped>

  .login_conent {
    margin: 0;
    padding: 0;
    width: 1520px;
    height: 740px;
    border: 1px #FFFFFF solid;
    background-color: #f8f8f8;
  }

  .login-box {
    margin-left: 500px;
    margin-top: 150px;
    border-radius: 15px;
    width: 500px;
    height: 400px;
    background-color: #FFFFFF;

    .login_form {
      padding-top: 100px;
      padding-right: 60px;
    }

    .login-a {

      padding-left: 296px;
      .span-ui{
        text-decoration: none;
        font-weight: 100;
      }
    }

  }

  @media (max-width: 900px) {
    .login-box {
      margin-left: 350px;
      width: 400px;
      height: 400px;
    }

    .login-a, span {
      text-decoration: none;
      padding-left: 200px;
      margin-left: -198px;
    }

  }

  @media (max-width: 700px) {
    .login-box {
      margin-left: 200px;
      width: 350px;
      height: 400px;

    }

    @media (max-width: 500px) {
      .login-box {
        margin-left: 85px;
        width: 350px;
        height: 400px;
      }

      /*.login-a ,span{*/
      /*  text-decoration: none;*/
      /*  margin-left: -195px;*/
      /*}*/

    }
  }



</style>
