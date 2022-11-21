<template>
  <section class="teacher__area pt-100 pb-110">
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 col-xl-4 col-lg-4 col-md-6">
          <div class="teacher__details-thumb p-relative w-img pr-30">
            <img src="@/assets/img/profile/profile.png" alt="" />
          </div>
        </div>
        <div class="col-xxl-8 col-xl-8 col-lg-8">
          <div class="teacher__wrapper">
            <div class="teacher__top d-md-flex align-items-end justify-content-between">
              <div class="teacher__info">
                <h4>{{ $store.state.board.title }}</h4>
                <span>
                  작성일시 : {{ $store.state.board.regDate }} {{ $store.state.board.regTime }}
                </span>
              </div>
            </div>
            <div class="teacher__bio">
              <h3>{{ $store.state.board.userName }}</h3>
              <p v-html="$store.state.board.content"></p>
            </div>
          </div>
          <div class="admin_board_btn" style="display: flex;">
            <div class="board_modfiy_btn d-sm-block mt-5" @click="changeToUpdate">
              <button class="e-btn">수정</button>
            </div>
            <div
              class="board_delete_btn d-sm-block ml-5 mt-5"
              @click="changeToDelete"
            >
              <button class="e-btn">삭제</button>
            </div>
            
            <update-modal v-on:call-parent-update="closeAfterUpdate"></update-modal>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import http from "@/common/axios.js";

import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import UpdateModal from "@/components/Admin/Board/modals/BoardUpdateModal.vue";
import { Modal } from "bootstrap"; // vue 컴포넌트에서 bootstrap modal 을 사용하기 위함.

export default {
  name: "BoardsDetails",
  data() {
    return {
      updateModal : null,
    }
  },
  components:{
    UpdateModal,
  },
  methods: {
    changeToDelete() {
      var $this = this;
      
      this.$alertify.confirm(
        "이 글을 삭제하시겠습니까?",
        function () {
          $this.boardDelete($this.$store.state.board.boardId); // this 아니고 $this
        },
        function () {
          console.log("cancled!");
        }
      );
    },
    async boardDelete(boardId) {
      try {
        let response = await http.delete("/admin/boards/" + boardId);
        let { data } = response;
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          this.$alertify.success("글이 삭제되었습니다");
          this.$router.push("/adminBoards");
        }
      } catch (error) {
        this.$alertify.error("서버에 문제가 있습니다.");
      }
    },
    changeToUpdate() {
      this.updateModal.show();
    },
    closeAfterUpdate() {
      this.updateModal.hide();
    },
  },
  mounted() {
      this.updateModal = new Modal(document.querySelector("#updateModal"));
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
    makeTimeStr: function (hour, minute, second, type) {
      return (
        hour +
        type +
        (minute < 10 ? "0" + minute : minute) +
        type +
        (second < 10 ? "0" + second : second)
      );
    },
  },
};
</script>
