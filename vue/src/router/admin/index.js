import Layout from '@/layout'

const adminRouter = {
  path: '/admin',
  component: Layout,
  redirect: '/',
  name: 'admin',
  children: [
    {
      path: 'dashboard',
      component: () => import('@/views/admin/dashboard'),
      name: '관리자 메인화면',
      roles: ['admin']
    },
    {
      path: 'exam',
      component: () => import('@/views/admin/exam'),
      name: '시험 관리',
      roles: ['admin']
    },
    {
      path: 'notice',
      component: () => import('@/views/admin/notice'),
      name: '공지사항 관리',
      roles: ['admin']
    },
    {
      path: 'license',
      component: () => import('@/views/admin/license'),
      name: '자격증 관리',
      roles: ['admin']
    },
    {
      path: 'user',
      component: () => import('@/views/admin/user'),
      name: '회원 관리',
      roles: ['admin']
    }
  ]
}
export default adminRouter
