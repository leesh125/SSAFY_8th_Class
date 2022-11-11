import EmpView from "@/views/EmpView.vue"
import DeptView from "@/views/DeptView.vue"
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/dept'
  },
  {
    path: '/dept',
    name: 'dept',
    component: DeptView,
    children: [
      {
        path: 'regForm',
        component:() => import('@/components/DeptForm')
      },
      {
        path: 'detail/:deptno',
        props:true,
        component:() => import('@/components/DeptDetail')
      },
    ]

  },
  {
    path: '/emp',
    name: 'emp',
    component: EmpView,
    children: [
      {
        path: 'regForm',
        component:() => import('@/components/EmpForm')
      },
      {
        path: 'detail/:empno',
        props:true,
        component:() => import('@/components/EmpDetail')
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
