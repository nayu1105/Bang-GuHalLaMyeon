import Vue from "vue";
import App from "./App.vue";
import router from "./routers/routers.js";
import store from "./store/store.js";

import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { far } from "@fortawesome/free-regular-svg-icons";

import "bootstrap/scss/bootstrap.scss";
import "bootstrap-vue/dist/bootstrap-vue.css";
import "swiper/css/bundle";
import "./assets/css/fontAwesome5Pro.css";
import "bootstrap";
// import BootstrapVue from 'bootstrap-vue';
import "bootstrap/dist/css/bootstrap.css";
import "./assets/scss/main.scss";
Vue.config.productionTip = false;

library.add(fas, far);
Vue.component("font-awesome-icon", FontAwesomeIcon);

// import VueApexCharts from "vue-apexcharts";
// Vue.use(VueApexCharts);
// Vue.component("apexchart", VueApexCharts);

new Vue({
  render: (h) => h(App),
  router,
  store,
}).$mount("#app");
