/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/layout'

const computerUtilization1Router = {
    path: '/computer-utilization1',
    component: Layout,
    redirect: 'noRedirect',
    name: 'computer-utilization1',
    meta: {
        title: '컴퓨터 활용 자격증 1급',
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
                    component: () => import('@/views/computer-utilization1/examination/all-test'),
                    name: 'ALL TEST',
                    meta: { title: 'ALL TEST', noCache: true }
                },
                {
                    path: '/unit-test',
                    component: () => import('@/views/computer-utilization1/examination/unit-test'),
                    name: 'UNIT TEST',
                    meta: { title: 'UNIT TEST', noCache: true }
                }
            ]

        },
        {
            path: '/grades-mng',
            component: () => import('@/views/computer-utilization1/grades-mng'),
            name: 'grades-mng',
            meta: { title: '성적 관리', noCache: true }
        },
        {
            path: '/memorizing-words',
            component: () => import('@/views/computer-utilization1/memorizing-words'),
            name: 'memorizing-words',
            meta: { title: '단어 외우기', noCache: true }
        },
        {
            path: '/community',
            component: () => import('@/views/computer-utilization1/community'),
            name: 'community',
            meta: { title: '동아리', noCache: true }
        },
        {
            path: '/review',
            component: () => import('@/views/computer-utilization1/review'),
            name: 'review',
            meta: { title: '합격 후기', noCache: true }
        }
    ]
}

export default computerUtilization1Router
