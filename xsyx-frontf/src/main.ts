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

Vue.config.productionTip = false
Vue.use(ElementUi);

//Axios.defaults.baseURL = '';

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
