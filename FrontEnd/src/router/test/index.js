const constantRoutes = {
    path: '/test',
    name: 'Test',
    meta: {
        title : 'Test'
    },
    children: [
        {
          path: 'two',
          component: () => import('@/views/test/Test'),
          name: 'Test Two',
          meta: {
            title: 'Test Two'
          }
        }
    ]
}

export default constantRoutes