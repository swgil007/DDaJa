/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/layout'

const network1Router = {
    path: '/network1',
    component: Layout,
    redirect: 'noRedirect',
    name: 'network1',
    meta: {
        title: '네트워크 관리사 1급',
        icon: 'chart'
    },
    children: [
        {
            path: '/examination',
            component: {
                render(c) { return c('router-view') }
            },
            name: '/examination',
            meta: { title: 'TEST', noCache: true },
            children: [
                {
                    path: '/all-test',
                    component: () => import('@/views/network1/examination/all-test'),
                    name: 'ALL TEST',
                    meta: { title: 'ALL TEST', noCache: true }
                },
                {
                    path: '/unit-test',
                    component: () => import('@/views/network1/examination/unit-test'),
                    name: 'UNIT TEST',
                    meta: { title: 'UNIT TEST', noCache: true }
                }
            ]

        },
        {
            path: '/grades-mng',
            component: () => import('@/views/network1/grades-mng'),
            name: 'grades-mng',
            meta: { title: '성적 관리', noCache: true }
        },
        {
            path: '/memorizing-words',
            component: () => import('@/views/network1/memorizing-words'),
            name: 'memorizing-words',
            meta: { title: '단어 외우기', noCache: true }
        },
        {
            path: '/community',
            component: () => import('@/views/network1/community'),
            name: 'community',
            meta: { title: '동아리', noCache: true }
        },
        {
            path: '/review',
            component: () => import('@/views/network1/review'),
            name: 'review',
            meta: { title: '합격 후기', noCache: true }
        }
    ]
}

export default network1Router
