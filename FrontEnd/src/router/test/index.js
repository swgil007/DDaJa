const constantRoutes = {
    path: '/test',
    name: 'Test',
    component: () => import('@/views/test/Test'),
    meta: {
        title : 'Test'
    },
    children: [
        {
          path: 'two',
          component: () => import('@/views/test/TestTwo'),
          name: 'Test Two',
          meta: {
            title: 'Test Two'
          }
        }
    ]
}

export default constantRoutes