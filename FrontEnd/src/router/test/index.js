const router = {
  path: '/test',
  name: 'test',
  meta: {
    title: '관리자'
  },
  children: [
    {
      path: 'two',
      component: () => import('@/views/test/Test'),
      name: '테스트',
      meta: {
        title: '관리자 메인'
      }
    }
  ]
}
export default router
