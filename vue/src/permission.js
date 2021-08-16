import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { getToken } from '@/utils/auth'
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({ showSpinner: false })
const whiteList = ['/', '/auth-redirect']

router.beforeEach(async(to, from, next) => {
  
  NProgress.start()
  document.title = getPageTitle(to.meta.title)

  /** 임시로 Token 하드 코딩. Token 개발시 로직 수정 **/
  // const hasToken = getToken()
  const hasToken = 'admin-token';

  if (hasToken) {
    if (to.path === '/login') {
      next({ path: '/' })
      NProgress.done()
    } else {
      const hasRoles = store.getters.roles && store.getters.roles.length > 0
      if (hasRoles) {
        next()
      } else {
        try {
          const { roles } = await store.dispatch('user/getInfo')
          const accessRoutes = await store.dispatch('permission/generateRoutes', roles)
          router.addRoutes(accessRoutes)
          next({ ...to, replace: true })

        } catch (error) {
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()

        }
      }
    }
  }
})

router.afterEach(() => {
  // finish progress bar
  NProgress.done()
})
