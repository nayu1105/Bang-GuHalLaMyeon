<template>
  <section class="events__area pt-115 pb-120 p-relative">
    <div class="events__shape">
      <img class="events-1-shape" src="../../assets/img/events/events-shape.png" alt="" />
    </div>
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 offset-xxl-4">
          <div class="section__title-wrapper mb-60 text-center">
            <h2 class="section__title">
              <span class="yellow-bg yellow-bg-big"
                >공지사항<img src="../../assets/img/shape/yellow-bg.png" alt=""
              /></span>
            </h2>
          </div>
        </div>
      </div>
      <div class="row">
        <div
          v-for="(board, index) in listGetters"
          :key="index"
          class="col-xxl-10 offset-xxl-1 col-xl-10 offset-xl-1 col-lg-10 offset-lg-1"
        >
          <div class="events__item mb-10 hover__active">
            <div
              class="events__item-inner d-sm-flex align-items-center justify-content-between white-bg"
            >
              <div class="events__content">
                <div class="events__meta">
                  <span>{{ board.regDt.date }}</span>
                  <span>{{ board.regDt.date }}</span>
                </div>
                <h3 class="events__title">
                  <router-link to="/boards-details">{{ board.title }}</router-link>
                </h3>
              </div>
              <div class="events__more">
                <router-link to="/boards-details" class="link-btn">
                  More
                  <i class="far fa-arrow-right"></i>
                  <i class="far fa-arrow-right"></i>
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
// import http from '@/common/axios.js';
// import util from '@/common/util.js';

import Vue from 'vue';
import VueAlertify from 'vue-alertify';
Vue.use(VueAlertify);
export default {
  name: 'BoardArea',
  computed: {
    // gttters 이용
    listGetters() {
      return this.$store.getters.getBoardList; // no getBoardList()
    },
  },
  methods: {
    // list
    // store actions 에 구현
    // 가능한 한 가지 방법
    boardList() {
      this.$store.dispatch('boardList');
    },
  },
  created() {
    this.boardList();
  },
};
</script>
