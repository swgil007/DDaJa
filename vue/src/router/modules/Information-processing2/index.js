/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/layout'

const InformationProcessing2Router = {
    path: '/Information-processing2',
    component: Layout,
    redirect: 'noRedirect',
    name: 'Information-processing2',
    meta: {
        title: '정보처리산업기사',
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
                    component: () => import('@/views/Information-processing2/examination/all-test'),
                    name: 'ALL TEST',
                    meta: { title: 'ALL TEST', noCache: true }
                },
                {
                    path: '/unit-test',
                    component: () => import('@/views/Information-processing2/examination/unit-test'),
                    name: 'UNIT TEST',
                    meta: { title: 'UNIT TEST', noCache: true }
                }
            ]

        },
        {
            path: '/grades-mng',
            component: () => import('@/views/Information-processing2/grades-mng'),
            name: 'grades-mng',
            meta: { title: '성적 관리', noCache: true }
        },
        {
            path: '/memorizing-words',
            component: () => import('@/views/Information-processing2/memorizing-words'),
            name: 'memorizing-words',
            meta: { title: '단어 외우기', noCache: true }
        },
        {
            path: '/community',
            component: () => import('@/views/Information-processing2/community'),
            name: 'community',
            meta: { title: '동아리', noCache: true }
        },
        {
            path: '/review',
            component: () => import('@/views/Information-processing2/review'),
            name: 'review',
            meta: { title: '합격 후기', noCache: true }
        }
    ]
}

export default InformationProcessing2Router
