// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

axios.defaults.headers.common['Access-Control-Allow-Origin'] = 'http://localhost'
axios.defaults.headers.common['Access-Control-Allow-Headers'] = 'origin, access-control-allow-origin'
axios.defaults.headers.post['Content-Type'] = 'application/json'
axios.defaults.timeout = 100000
axios.defaults.withCredentials = true

Vue.prototype.$http = axios

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
