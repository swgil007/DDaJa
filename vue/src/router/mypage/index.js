import Layout from '@/layout'
const mypageRouter = {
  path: '/mypage',
  component: Layout,
  redirect: '/mypage',
  name: 'mypage',
  meta: {
    title: '마이 페이지'
  }
}
export default mypageRouter
