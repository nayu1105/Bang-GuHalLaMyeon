<template>
  <section class="events__area pt-115 pb-120 p-relative">
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 offset-xxl-4">
          <div class="section__title-wrapper mb-60 text-center">
            <h2 class="section__title">
              <span class="yellow-bg yellow-bg-big"
                >공지사항<img src="@/assets/img/shape/yellow-bg.png" alt=""
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
                  <span>{{ board.regDt.date | makeDateStr(".") }}</span>
                </div>
                <h3 class="events__title link-btn" @click="boardDetail(board.boardId)">
                  {{ board.title }}
                </h3>
              </div>
              <div class="events__more">
                <div class="link-btn" @click="boardDetail(board.boardId)">
                  More
                  <i class="far fa-arrow-right"></i>
                  <i class="far fa-arrow-right"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import http from "@/common/axios.js";
// import util from '@/common/util.js';

import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);
export default {
  name: "BoardArea",
  computed: {
    // gttters 이용
    listGetters() {
      return this.$store.getters.getBoardList; // no getBoardList()
    },
  },
  methods: {
    boardList() {
      this.$store.dispatch("boardList");
    },
    async boardDetail(boardId) {
      // back-end에서 detail 정보 가지고 와서
      // store 에 detail 요소 바꾼 후
      // router 를 이용해 이동

      try {
        let { data } = await http.get("/boards/" + boardId); // params: params shorthand property, let response 도 제거
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          this.$store.commit("SET_BOARD_DETAIL", data.dto);
        }
      } catch (error) {
        console.log(error);
        this.$alertify.error("서버에 문제가 있습니다");
      }

      this.$router.push("/boards-details");
    },
  },
  created() {
    this.boardList();
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
