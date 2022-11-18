<template>
  <section class="page__title-area pt-120">
    <div class="page__title-shape">
      <img
        class="page-title-shape-5 d-none d-sm-block"
        src="@/assets/img/page-title/page-title-shape-1.png"
        alt=""
      />
      <img class="page-title-shape-6" src="@/assets/img/page-title/page-title-shape-2.png" alt="" />
      <img class="page-title-shape-7" src="@/assets/img/page-title/page-title-shape-4.png" alt="" />
      <img class="page-title-shape-8" src="@/assets/img/page-title/page-title-shape-5.png" alt="" />
    </div>
    <div class="container">
      <div class="row">
        <div class="col-xxl-9 col-xl-8">
          <div class="page__title-content mb-25 pr-40">
            <h5 class="page__title-3">{{ $store.state.event.title }}</h5>
          </div>
          <div class="course__meta-2 d-sm-flex mb-30">
            <div class="course__teacher-3 d-flex align-items-center mr-70 mb-30">
              <div class="course__teacher-thumb-3 mr-15">
                <img src="@/assets/img/course/teacher/teacher-1.jpg" alt="" />
              </div>
              <div class="course__teacher-info-3">
                <!-- <h5>Teacher</h5> -->
                <p><a href="#">Elon Gated</a></p>
              </div>
            </div>
            <div class="course__update mr-80 mb-30">
              <h5>Update:</h5>
              <p>2022-11-10 19:24</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import util from "@/common/util.js";

export default {
  name: "EventDetailsTitle",
  methods: {
    // util
    makeDateStr: util.makeDateStr,
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
