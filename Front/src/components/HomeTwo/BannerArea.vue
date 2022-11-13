<template>
  <section class="banner__area pb-110">
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 offset-xxl-4">
          <div class="section__title-wrapper mb-60 text-center">
            <h2 class="section__title">
              Current
              <span class="yellow-bg yellow-bg-big"
                >Events<img src="../../assets/img/shape/yellow-bg.png" alt=""
              /></span>
            </h2>
            <p>이벤트 참여하고 혜택 받아가세요!</p>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-xxl-6 col-xl-6 col-lg-6 col-md-6">
          <div
            class="banner__item p-relative mb-40"
            :style="{
              background: 'url(' + require('../../assets/img/banner/banner-bg-1.jpg') + ')',
              backgroundRepeat: 'no-repeat',
              backgroundSize: 'cover',
            }"
          >
            <div class="banner__content">
              <span>Event</span>
              <h3 class="banner__title">
                <router-link to="/course-details">Open Event <br />월세 지원 이벤트!</router-link>
              </h3>
              <router-link to="/courses" class="e-btn e-btn-2">이벤트 참여하기</router-link>
            </div>
            <div class="banner__thumb d-none d-sm-block d-md-none d-lg-block">
              <!-- <img src="../../assets/img/banner/banner-img-1.png" alt="" /> -->
            </div>
          </div>
        </div>
        <div class="col-xxl-6 col-xl-6 col-lg-6 col-md-6">
          <div
            class="banner__item p-relative mb-40"
            :style="{
              background: 'url(' + require('../../assets/img/banner/banner-bg-2.jpg') + ')',
              backgroundRepeat: 'no-repeat',
              backgroundSize: 'cover',
            }"
          >
            <div class="banner__content">
              <span class="orange">Event</span>
              <h3 class="banner__title">
                <router-link to="/course-details"
                  >회원가입 이벤트 <br />지금 가입하면 포인트 증정!
                </router-link>
              </h3>
              <router-link to="/courses" class="e-btn e-btn-2">회원가입</router-link>
            </div>
            <div class="banner__thumb banner__thumb-2 d-none d-sm-block d-md-none d-lg-block">
              <!-- <img src="../../assets/img/cta/cta-shape-2.png" alt="" /> -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "BannerArea",
};
</script>

<style scoped>
.banner__area {
  margin-top: 80px;
}
</style>
