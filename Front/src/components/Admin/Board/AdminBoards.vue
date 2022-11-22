<template>
  <section class="events__area pt-115 pb-120 p-relative">
    <div class="events__shape">
      <img class="events-1-shape" src="@/assets/img/events/events-shape.png" alt="" />
    </div>
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

        <div
          class="board_insert_btn col-xxl-10 offset-xxl-1 col-xl-10 offset-xl-1 col-lg-10 offset-lg-1"
        >
          <div class="d-sm-block e-btn" @click="showInsertModal">등록</div>
        </div>
      </div>

      <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
    </div>
  </section>
</template>

<script>
import http from "@/common/axios.js";
// import util from '@/common/util.js';

import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import InsertModal from "@/components/Admin/Board/modals/BoardInsertModal.vue";

import { Modal } from "bootstrap"; // vue 컴포넌트에서 bootstrap modal 을 사용하기 위함.

export default {
  name: "AdminBoards",
  data() {
    return {
      insertModal: null,
    };
  },
  components: {
    InsertModal,
  },
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
        console.log(data);
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          this.$store.commit("SET_BOARD_DETAIL", data.dto);
        }
      } catch (error) {
        console.log(error);
        this.$alertify.error("서버에 문제가 있습니다");
      }

      this.$router.push("/admin/boards-details");
    },
    showInsertModal() {
      this.insertModal.show();
    },
    closeAfterInsert() {
      this.insertModal.hide();
      this.boardList();
    },
  },
  created() {
    this.boardList();
  },
  mounted() {
    this.insertModal = new Modal(document.querySelector("#insertModal"));
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
