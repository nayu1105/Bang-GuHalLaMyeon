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
                <!-- <img
                  v-bind:src="require(`@/assets${$store.state.event.userProfileImageUrl}`)"
                  style="width: 42px; height: 42px; border-radius: 50%; background-color: #f49d1a"
                /> -->
                <img
                  src="@/assets/img/noProfile.png"
                  style="width: 42px; height: 42px; border-radius: 50%; background-color: #f49d1a"
                />
              </div>
              <div class="course__teacher-info-3">
                <!-- <h5>Teacher</h5> -->
                <p>
                  <a href="#">{{ $store.state.event.userName }}</a>
                </p>
              </div>
            </div>
            <div class="course__update mr-80 mb-30">
              <h5>Update</h5>
              <p>{{ $store.state.event.regDate }}</p>
              <!-- &nbsp;<span>{{ $store.state.event.regTime }}</span> -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import http from "@/common/axios.js";

export default {
  name: "EventDetailsTitle",
  created() {
    let eventId = this.$route.params.eventId;
    this.eventDetail(eventId);
  },
  methods: {
    async eventDetail(eventId) {
      // back-end에서 detail 정보 가지고 와서
      // store 에 detail 요소 바꾼 후
      // router 를 이용해 이동

      console.log(eventId);

      try {
        let { data } = await http.get("/events/" + eventId);
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
    },
  },
};
</script>
