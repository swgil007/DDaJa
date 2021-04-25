import Layout from '@/layout'

const adminRouter = {
  path: '/admin',
  component: Layout,
  redirect: '/',
  name: 'admin',
  children: [
    {
      path: 'dashboard',
      component: () => import('@/views/admin/component/dashboard'),
      name: '관리자 메인화면'
    }
  ]
}
export default adminRouter
