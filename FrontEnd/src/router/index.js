import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

import testRouter from './test'

export const constantRoutes = [
  {
    path: '/',
    redirect: '/',
    children: [
      {
        path: '',
        component: HelloWorld,
        name: '따자',
        meta: { title: '따자', noCache: true }
      }
    ]
  },
  testRouter
]

const createRouter = () => new Router({
  mode: 'history',
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher
}

export default router
