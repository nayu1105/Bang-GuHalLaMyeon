import Vue from 'vue';
import App from './App.vue';
import router from './routers/routers.js';
import store from './store/store.js';

import 'bootstrap/scss/bootstrap.scss';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import 'swiper/css/bundle';
import './assets/css/fontAwesome5Pro.css';
import 'bootstrap';
// import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import './assets/scss/main.scss';
Vue.config.productionTip = false;
new Vue({
  render: (h) => h(App),
  router,
  store,
}).$mount('#app');
