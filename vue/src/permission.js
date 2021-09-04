import getPageTitle from '@/utils/get-page-title'
import NProgress from 'nprogress'
import router from './router'
import store from './store'
import { getToken } from '@/utils/auth'
import 'nprogress/nprogress.css'

NProgress.configure({ showSpinner: false })
const whiteList = ['/login', '/', '/auth-redirect']

router.beforeEach(async(to, from, next) => {
  NProgress.start()
  document.title = getPageTitle(to.meta.title)

  const hasToken = getToken()

  console.log(hasToken)
  if (hasToken) {
    /** ADMIN **/
    if (hasToken === 'admin-token') {
      if (to.path === '/login') {
        next({ path: '/' })
        NProgress.done()
      } else {
        routerNext('admin', to, next)
      }

    /** EDITOR **/
    } else if (hasToken === 'editor-token') {
      if (to.path === '/login') {
        next({ path: '/' })
        NProgress.done()
      } else {
        routerNext('editor', to, next)
      }

    /** VISITOR **/
    } else {
      if (to.path === '/login') {
        store.dispatch('user/resetToken')
        next()
      } else {
        routerNext('visitor', to, next)
      }
    }

  /** 토큰이 없고 다른 페이지로 이동하려는 경우 **/
  } else {
    store.dispatch('user/resetToken')

    console.log(to.path)
    console.log(whiteList.indexOf(to.path))

    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  NProgress.done()
})

async function routerNext(roleName, to, next) {
  if (store.getters.permission_routes.length === 0) {
    const role = [roleName]
    const accessRoutes = await store.dispatch('permission/generateRoutes', role).catch((error) => {
      console.log(error)
    })

    router.addRoutes(accessRoutes)
    next({ path: to.path })
    NProgress.done()

  /** router.afterEach() 호출 **/
  } else {
    next()
  }
}
