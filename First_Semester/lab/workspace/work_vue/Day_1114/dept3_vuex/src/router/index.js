import Vue from 'vue'
import VueRouter from 'vue-router'
import DeptView from '@/views/DeptView.vue'
import EmpView from '@/views/EmpView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/dept'
  },
  {
    path: '/dept',
    name: 'dept',
    component: DeptView,

    children: [
      {
        path: 'regForm' ,
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
    component: EmpView
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
