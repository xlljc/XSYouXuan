import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import './views/style.css';
import './views/logine.css';
import './views/reset.css'
import Axios from "axios";
import './assets/icon/iconfont.js';
import {MenuHelper} from "@/helper/back/MenuHelper";

Vue.config.productionTip = false;
Vue.use(ElementUi);

Vue.use({
  install: (Vue1, options) => {
    Vue1.prototype.$host = "http://localhost:8080/";
    Vue1.prototype.$axios = Axios;
    Vue1.prototype.$btnPermissions = MenuHelper.hasBtnPermissions;
  }
})

Axios.defaults.baseURL = 'http://localhost:8080/';

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
