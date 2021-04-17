import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* CHAPTER */
import bigdataRouter from './modules/big-data/index.js' 
import computerUtilization1Router from './modules/computer-utilization1/index.js'
import computerUtilization2Router from './modules/computer-utilization2/index.js'
import InformationProcessing1Router from './modules/Information-processing1/index.js'
import InformationProcessing2Router from './modules/Information-processing2/index.js'
import network1Router from './modules/network1/index.js'
import network2Router from './modules/network2/index.js'

export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('@/views-copy/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views-copy/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views-copy/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views-copy/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views-copy/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views-copy/dashboard'),
        name: 'Dashboard',
        meta: { title: 'M A I N', icon: 'dashboard', affix: true }
      }
    ]
  }, 
  bigdataRouter,
  computerUtilization1Router,
  computerUtilization2Router,
  InformationProcessing1Router,
  InformationProcessing2Router,
  network1Router,
  network2Router,
  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/index',
    hidden: true,
    children: [
      {
        path: 'index',
        component: () => import('@/views-copy/profile/index'),
        name: 'Profile',
        meta: { title: 'Profile', icon: 'user', noCache: true }
      }
    ]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
