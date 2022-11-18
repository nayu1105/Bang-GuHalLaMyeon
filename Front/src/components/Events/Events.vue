<template>
  <section class="events__area pt-115 p-relative">
    <div class="events__shape">
      <img class="events-1-shape" src="@/assets/img/events/events-shape.png" alt="" />
    </div>
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 offset-xxl-4">
          <div class="section__title-wrapper mb-60 text-center">
            <h2 class="section__title">
              <span class="yellow-bg yellow-bg-big"
                >이벤트<img src="@/assets/img/shape/yellow-bg.png" alt=""
              /></span>
            </h2>
            <p>We found 13 events available for you.</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div
          v-for="(event, index) in listGetters"
          :key="index"
          class="col-xxl-10 offset-xxl-1 col-xl-10 offset-xl-1 col-lg-10 offset-lg-1"
        >
          <div class="events__item mb-10 hover__active">
            <div
              class="events__item-inner d-sm-flex align-items-center justify-content-between white-bg"
            >
              <div class="events__content">
                <div class="events__meta">
                  <span>{{ event.regDt.date | makeDateStr(".") }}</span>
                </div>
                <h3 class="events__title" @click="eventDetail(event.eventId)">
                  {{ event.title }}
                </h3>
              </div>
              <div class="events__more">
                <div class="link-btn" @click="eventDetail(event.eventId)">
                  More
                  <i class="far fa-arrow-right"></i>
                  <i class="far fa-arrow-right"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- <paginationUI v-on:call-parent="movePage"></paginationUI> -->
    </div>
  </section>
</template>

<script>
import http from "@/common/axios.js";

import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

export default {
  name: "EventArea",
  data() {
    return {};
  },
  computed: {
    // getters 이용
    listGetters() {
      return this.$store.getters.getEventList;
    },
  },
  methods: {
    eventList() {
      this.$store.dispatch("eventList");
    },
    async eventDetail(eventId) {
      // back-end에서 detail 정보 가지고 와서
      // store 에 detail 요소 바꾼 후
      // router 를 이용해 이동

      console.log(eventId);

      try {
        // 이 부분.. 이 코드로 하면 아예 백에 가지를 않고
        let { data } = await http.get("/events", { eventId });

        // 이 코드로 하면 백엔드 콘솔엔 잘 찍히는데 500 에러 뜸 ... ㅠㅠ 흑ㅎㄱ
        // 백이 잘못된 걸까 ..
        // let { data } = await http.get("/events/" + eventId);

        console.log(data);

        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          let { dto } = data;
          this.$store.commit("SET_EVENT_DETAIL", dto);
        }
      } catch (error) {
        console.log("EventMainVue: error : ");
        console.log(error);
      }

      this.$router.push("/event-details");
    },
  },
  created() {
    this.eventList();
  },
  filters: {
    makeDateStr: function (date, separator) {
      return (
        date.year +
        separator +
        (date.month < 10 ? "0" + date.month : date.month) +
        separator +
        (date.day < 10 ? "0" + date.day : date.day)
      );
    },
  },
};
</script>
