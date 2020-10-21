<template xmlns:to="http://www.w3.org/1999/xhtml">
  <div class="register-content">

    <div class="register-box">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="register_form" >

        <el-form-item prop="username">
          <span style="font-size: 12px; color: red;font-weight: 300 ">{{ruleForm.getname}}</span>
          <el-input v-model="ruleForm.username" placeholder="请输入用户名" prefix-icon="el-icon-user"></el-input>
        </el-form-item>

        <el-form-item prop="nickname">
          <el-input v-model="ruleForm.nickname" placeholder="请输入用户名称"></el-input>
        </el-form-item>

        <el-form-item prop="pass">
          <el-input type="password" prefix-icon="el-icon-lock"  placeholder="请输入密码" v-model="ruleForm.pass"
                    autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="checkPass">
          <el-input type="password" prefix-icon="el-icon-lock"  placeholder="请再次输入密码" v-model="ruleForm.checkPass"
                    autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item prop="email">
          <el-input v-model="ruleForm.email" placeholder="请输入邮箱" prefix-icon="el-icon-message"></el-input>
        </el-form-item>


        <div class="register-a" >
          <router-link class="span-ui" :to="{path: '/'}"><span>已有账号？去登录</span></router-link>
        </div>


        <el-form-item style="padding-top: 15px">
          <el-button type="primary :" @click="submitForm('ruleForm')" :plain="true">立即注册</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {Registers} from '../../api/user'
import {findGetUserName} from '../../api/user'

export default {
    name: 'Register',
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
          username: '',
          nickname: '',
          pass: '',
          checkPass: '',
          email: '',
          getname: '',
        },
        rules: {
          username: [
            {required: true, message: '请输入用户名',  trigger: 'blur'},
            {validator: this.validateUsername , trigger: 'blur'},
            {min: 3, max: 16, message: '长度在 3 到 16 个字符', trigger: 'blur'}
          ],
          nickname: [
            {required: true, message: '请输入用户名称', trigger: 'blur'}
          ],
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
      };
    },
    created () {
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let User= {
              userName: this.ruleForm.username,
              userPass: this.ruleForm.checkPass,
              userNickname: this.ruleForm.nickname,
              userEmail: this.ruleForm.email
            }
              if(this.ruleForm.getname==''){
                this.getRegisters();
                this.$message('恭喜您，您的账户: ' + this.ruleForm.username + '注册成功,马上去登录吧')
              }else {
                this.$alert(this.ruleForm.getname, {
                  confirmButtonText: '确定',

                });
              }
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      async getRegisters() {
         await Registers(this.ruleForm.username,this.ruleForm.checkPass,this.ruleForm.nickname,this.ruleForm.email)
      },
      async validateUsername(){
        const {data}=await findGetUserName(this.ruleForm.username);
        console.log(data.message)
        this.ruleForm.getname=data.message
      }
    }
  }
</script>

<style lang="less" scoped>

  .register-content {
    margin: 0;
    padding: 0;
    width: 1520px;
    height: 741px;
    border: 1px #FFFFFF solid;
    background-color: #f8f8f8;

    .register-box {
      margin-left: 500px;
      margin-top: 150px;
      border-radius: 15px;
      width: 500px;
      height: 550px;
      background-color: #FFFFFF;

      .register_form {
        padding-top: 100px;
        padding-right: 60px;

        .register-a {
          padding-left: 296px;
          .span-ui{
            text-decoration: none;
            font-weight: 100;
          }
        }
      }
      .username-ui{
        height: 3px;
      }
    }

  }

  .a {
    text-decoration: none;
  }

  @media (max-width: 900px) {
    .register-box {
      margin-left: 10px;
    }
  }


</style>
