import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { getToken } from '@/utils/auth'
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({ showSpinner: false })
const whiteList = [ '/login','/', '/auth-redirect']

/**
* Page 이동시 매번 호출
* - 권한 확인
**/
router.beforeEach(async(to, from, next) => {

  NProgress.start()
  document.title = getPageTitle(to.meta.title)
  
  const hasToken = getToken()
  
  /** **/
  /** Token == Y **/
  if (hasToken) {

    /** Token 이 존재하는데 Login Page 접근 시도시 **/
    if (to.path === '/login') {
      next({ path: '/' })
      NProgress.done()

    /** Token 이 존재하는데 Login Page 외에 모든 Page 접근 시도시 Router 생성 **/
    }else{
      /** (permission_route == X, store == 초기화 ) -> 사용자 새로고침 **/
      if(store.getters.permission_routes.length === 0){ 

        const role = ['admin']
        const accessRoutes = await store.dispatch('permission/generateRoutes', role).catch((error) => {
          console.log(error)
        })

        router.addRoutes(accessRoutes)
        next({path : to.path})
        NProgress.done()

      /** router.afterEach() 호출 **/
      }else{
        next()
      }
    }
    
  /** 토큰이 없고 다른 페이지로 이동하려는 경우 **/
  }else{
    /** store에서도 token을 리셋 **/
    store.dispatch('user/resetToken')

    /** whiteList에 해당하는 페이지 일 때 **/
    if(whiteList.indexOf(to.path) !== -1) {
      next()
    
    /** whiteList에 해당하는 페이지가 아닌 경우 **/
    }else{
      alert('Login 후에 이용할 수 있습니다.')
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  NProgress.done()
})