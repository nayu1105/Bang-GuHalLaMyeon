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
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

export default {
  name: "BoardsDetails",
  computed: {},
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
