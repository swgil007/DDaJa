import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

import jeongboCheoliGisaRouter from './license/jeongbo-cheoli-gisa'
import jeongboCheoliSanupGisaRouter from './license/jeongbo-cheoli-sanup-gisa'
import bigDataGisaRouter from './license/big-data-gisa'
import computerUtilizeOneRouter from './license/computer-utilize-one'
import computerUtilizeTwoRouter from './license/computer-utilize-two'
import networkAdminOneRouter from './license/network-admin-one'
import networkAdminTwoRouter from './license/network-admin-two'
import adminRouter from './admin'

export const constantRoutes = [

  {
    path: '/admin',
    component: () => import('@/views/admin'),
    name: 'admin',
    roles: ['admin'],
    test: ['test']
  },
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
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: 'Dashboard', icon: 'dashboard', affix: true }
      }
    ]
  },
  {
    path: '/admin',
    component: () => import('@/views/admin'),
    name: 'admin',
    roles: ['admin']
  },
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

  jeongboCheoliGisaRouter,
  jeongboCheoliSanupGisaRouter,
  bigDataGisaRouter,
  computerUtilizeOneRouter,
  computerUtilizeTwoRouter,
  networkAdminOneRouter,
  networkAdminTwoRouter,
  adminRouter,
  {
    path: '/permission',
    component: Layout,
    redirect: '/permission/page',
    alwaysShow: true, // will always show the root menu
    name: 'Permission',
    meta: {
      title: 'Permission',
      icon: 'lock',
      roles: ['admin', 'editor'] // you can set roles in root nav
    },
    children: [
      {
        path: 'page',
        component: () => import('@/views-copy/permission/page'),
        name: 'PagePermission',
        meta: {
          title: 'Page Permission',
          roles: ['admin']
        }
      },
      {
        path: 'directive',
        component: () => import('@/views-copy/permission/directive'),
        name: 'DirectivePermission',
        meta: {
          title: 'Directive Permission'
          // if do not set roles, means: this page does not require permission
        }
      }
    ]
  },

  {
    path: '/error',
    component: Layout,
    redirect: 'noRedirect',
    name: 'ErrorPages',
    meta: {
      title: 'Error Pages',
      icon: '404'
    },
    children: [
      {
        path: '401',
        component: () => import('@/views-copy/error-page/401'),
        name: 'Page401',
        meta: { title: '401', noCache: true }
      },
      {
        path: '404',
        component: () => import('@/views-copy/error-page/404'),
        name: 'Page404',
        meta: { title: '404', noCache: true }
      }
    ]
  },

  {
    path: '/error-log',
    component: Layout,
    children: [
      {
        path: 'log',
        component: () => import('@/views-copy/error-log/index'),
        name: 'ErrorLog',
        meta: { title: 'Error Log', icon: 'bug' }
      }
    ]
  },
  {
    path: '/pdf/download',
    component: () => import('@/views-copy/pdf/download'),
    hidden: true
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  mode: 'history', // require service support
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
