import Vue from 'vue'
import Router from 'vue-router'
import TestRouter from './test'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export const constantRoutes = [
  {
    path: '/',
    name: 'HelloWorld',
    component: HelloWorld,
    meta: {
      title : 'DDaJa'
    }
  }
]

export const asyncRoutes = [
  TestRouter
]

const createRouter = () => new Router({
  mode: 'history',
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

router.afterEach((to, from) => {
  const title = to.meta.title === undefined ? 'DDaJa' : to.meta.title;
  Vue.nextTick(() => {
    document.title = title;
  });
});

export default router