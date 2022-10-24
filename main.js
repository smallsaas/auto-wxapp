import Vue from 'vue'
import App from './App'

// import request from '@/utils/request/request.js'
import request from '@/utils/api.js'
Vue.prototype.$request = request

Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()
