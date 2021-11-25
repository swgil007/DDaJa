import Index from '@/views/test'
import TestTwo from '@/views/test/components/TestTwo'

const constantRoutes = {
    path: '/test',
    name: 'Test',
    component: Index,
    meta: {
        title : 'Test'
    },
    children: [
        {
          path: 'two',
          component: TestTwo,
          name: 'Test Two',
          meta: {
            title: 'Test Two'
          }
        }
    ]
}

export default constantRoutes