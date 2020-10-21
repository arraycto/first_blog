<template>
  <div class="main-content">
    <div class="header-nav">
      <!--    导航条-->
      <el-menu :default-active="activeIndex" background-color="#f8f8f8" class="el-menu-demo" mode="horizontal"
               @select="handleSelect">
        <div class="main-radio">
          <div class="toggle_box" @click="toggleCollapsed">
            <router-link to="/admin/index"><i class="el-icon-s-fold"></i></router-link>
          </div>
        </div>
        <div>
          <div class="right_box">
            <el-dropdown>
              <img src="../assets/imgage/avatar.jpg">
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item icon="el-icon-house">系统首页</el-dropdown-item>
                <el-dropdown-item icon="el-icon-ship">交流讨论</el-dropdown-item>
                <el-dropdown-item icon="el-icon-switch-button">退出登录</el-dropdown-item>
                <span>{{this.username}}</span>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </div>
      </el-menu>
    </div>
    <!--    侧边栏-->
    <div class="">
      <el-col :span="12" class="el-col">
        <el-menu
          default-active="2"
          background-color="#f8f8f8"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          :collapse-transition="false"
          :collapse="isCollapse"
          :default-openeds="['1','2']"
          :router="true">
          <MenuTree :menuList="this.menuList"></MenuTree>
        </el-menu>
      </el-col>
    </div>
    <div class="main-middle">
      <router-view></router-view>
    </div>
  </div>

</template>

<script>
  import MenuTree from '../components/MenuTree'

  import {listMenu} from '../api/menu'

  export default {
    name: 'Main',
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1',
        isCollapse: false,
        menuList:[
          {
            "id": 1,
            "menuName": '个人中心',
            "url": '/admin/index',
            "icon": 'el-icon-user-solid',
            "children": [
              {
                "id": 12,
                "menuName": '我的主页',
                "url": '/admin',
                "children": []
              }
            ]
          },
          {
            "id": 2,
            "menuName": '我的关注',
            "icon": 'el-icon-star-off',
            "children": [
              {
                "id": 1,
                "menuName": '我的关注',
                "url": '/admin',
                "children": []
              },{
                "id": 2,
                "menuName": '我的收藏',
                "url": '/admin',
                "children": []
              },{
                "id": 3,
                "menuName": '我的粉丝',
                "url": '/admin',
                "children": []
              }
            ]
          },
          {
            "id":3,
            "menuName": '我的博客',
            "url": "",
            "icon": 'el-icon-edit',
            "children": [
              {
                "id":1,
                "menuName": '我的博客',
                "url": '/admin',
                "children": []
              },{
                "id":2,
                "menuName": '管理博客',
                "url": '/admin',
                "children": []
              },
              {
                "id":3,
                "menuName": '添加博客',
                "url": '/admin',
                "children": []
              },
            ]
          },{
            "id":4,
            "menuName": '我的标签',
            "url": "",
            "icon": "el-icon-price-tag",
            "children": [
              {
                "id":3,
                "menuName": '我的标签',
                "url": '/queryTag',
                "children": []
              },{
                "id":3,
                "menuName": '添加标签',
                "url": '/insert/tag',
                "children": []
              }
            ]
          }, {
            "id": 4,
            "menuName": '账号设置',
            "url": "",
            "icon": 'el-icon-s-tools',
            "children": [
              {
                "id": 1,
                "menuName": '账号首页',
                "url": "/admin/user/",
                "children": []
              }, {
                "id": 2,
                "menuName": '修改密码',
                "url": '/admin/user/editPass',
                "children": []
              }, {
                "id": 3,
                "menuName": '修改邮箱',
                "url": '/admin/user/editEmail',
                "children": []
              }, {
                "id": 4,
                "menuName": '登录日志',
                "url": '',
                "children": []
              }, {
                "id": 5,
                "menuName": '账号注销',
                "url": '',
                "children": []
              }
            ]
          }]
      }
    },
    props:['username','password'],
    components:{
      MenuTree
    },
    created () {
      this.getMen();
    },
    methods: {
      toggleCollapsed() {
        //页面原因只好将此功能去掉，让它永远成为false
        this.isCollapse = this.isCollapse;
      },
      activeIndex() {

      },
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },

       getMen(){
        listMenu().then(res=>{
          console.log(res.data.data.menu)
          // alert(res.data.data.menu)
          // this.menuList=res.data.data.menu
        })
      }
    }
  }
</script>

<style lang="less" scoped>

  div, ul, ol, dl, dt, dd, li, dl, h1, h2, h3, h4 {
    outline: none;
  }

  a {
    color: black;
    font-weight: 200;
    text-decoration: none;
  }

  .main-content {
    width: 100%;
  }

  .header-nav {
    width: 100%;
    position: fixed;
  }

  .main-middle {
    width: 2000px;
    height: 745px;
    margin-left: 200px;
    margin-top: 85px;
    border: 1px #f8f8f8 solid;
    position: fixed;
    /*background-color: #f8f8f8;*/
  }

  .el-menu-demo {
    background-color: #f8f8f8;
    height: 80px;
  }

  .right_box {
    margin-left: 1400px;
    padding-top: 10px;

    .el-dropdown > img {
      width: 55px;
      height: 55px;
      border-radius: 50%;
      background-color: #FFFFFF;
    }
  }

  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }

  /*展开收起*/
  .toggle_box {
    height: 50px;
    font-size: 50px;
    font-weight: bold;
    line-height: 24px;
    color: gray;
    letter-spacing: 0.2em;
    padding-left: 200px;
    padding-top: 10px;
    cursor: pointer;
  }

  .main-radio {
    width: 10px;
    height: 10px;
  }

  .el-col {
    width: 200px;
    height: 745px;
    background-color: #f8f8f8;
  }

  @media (max-width: 1450px) {
    .right_box {
      margin-left: 1200px;
    }
  }


  @media (max-width: 1250px) {
    .right_box {
      margin-left: 1000px;
    }

    @media (max-width: 1000px) {
      .right_box {
        margin-left: 800px;
      }

    }

    @media (max-width: 800px) {
      .right_box {
        margin-left: 600px;
      }
    }

    @media (max-width: 600px) {
      .right_box {
        margin-left: 420px;
      }
    }

  }
  @media (max-width: 400px) {
    .el-col {
      width: 10px;
      height: 100%;
    }
  }

</style>
