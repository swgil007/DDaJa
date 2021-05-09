// import Layout from '@/layout'

const examinationRouter = {
  path: 'exam',
  component: { render(c) { return c('router-view') } },
  redirect: '/admin/exam',
  name: 'exam',
  meta: {
    title: '시험 관리'
  },
  children: [
    {
      path: '/',
      component: () => import('@/views/admin/examination'),
      props: (route) => ({ query: route.query.test }),
      name: '시험 관리 메인',
      meta: {
        title: '시험 관리 메인'
      },
      roles: ['admin']
    }
  ]
}
export default examinationRouter
