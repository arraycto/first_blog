import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: () => import( '../views/Login.vue')
  }, {
    path: '/',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Regist/Register.vue')
  },
  {
    path: '/admin/index/:username/:password',
    name: 'Main',
    props: true,
    component: () => import('../views/Main.vue'),
    children: [
      {
        path: "/admin/user",
        name: "User",
        component: () => import('../views/setting/User/User.vue')
      },
      {
        path: "/admin/user/editPass",
        name: "PassEdit",
        component: () => import('../views/setting/PassEdit/PassEdit')
      },
      {
        path: "/admin/user/editEmail",
        name: "Email",
        component: () => import('../views/setting/email/Email.vue')
      },
    ],
  },

]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
