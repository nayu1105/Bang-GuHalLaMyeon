<template>
  <footer :class="`footer__area ${footerBgTwo ? 'grey-bg-2' : 'footer-bg'}`">
    <section
      :class="`footer__area ${footerBgTwo ? 'grey-bg-2' : 'footer-bg'}`"
      class="d-flex justify-content-center justify-content-lg-between p-4"
    >
      <!-- Right -->
      <div></div>
      <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
      <div class="container text-center text-md-start mt-5">
        <!-- Grid row -->
        <div class="row mt-3">
          <!-- Grid column -->
          <div class="col-md-4 col-lg-5 col-xl-4 mx-auto mb-4">
            <!-- Links -->
            <router-link to="/">
              <!-- <img :src="`${footerBgTwo ? require('../../assets/img/logo/logo.png') : require('../../assets/img/logo/logo-2.png')}`" alt=""> -->
              <h3 class="text-uppercase fw-bold mb-4" style="color: white">방구할라면</h3>
            </router-link>

            <p>부울경 3반 7조 나유진, 반유진</p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-8 col-lg-7 col-xl-8 mx-auto mb-4">
            <!-- Links -->
            <h4 class="text-uppercase fw-bold mb-4" style="color: white">Company</h4>

            <p>
              <a href="https://www.ssafy.com" target="_blank">SSAFY</a> &nbsp; &nbsp; &nbsp; &nbsp;
              <i class="fas fa-home me-3 text-secondary"></i
              ><span>부산광역시 강서구 송정동 녹산산업중로 333</span>
            </p>
            <p>
              <a href="https://github.com/nayu1105" target="_blank">NaYuJin</a>&nbsp; &nbsp; &nbsp;
              <i class="fas fa-envelope me-3 text-secondary"></i><span>dbwls387@gmail.com</span>
            </p>
            <p>
              <a href="https://github.com/dbwls387" target="_blank">BanYuJin</a>&nbsp; &nbsp;
              <i class="fas fa-envelope me-3 text-secondary"></i><span>dbwls387@gmail.com</span>
            </p>
          </div>
          <!-- Grid column -->
        </div>
        <!-- Grid row -->
      </div>
    </section>
    <!-- Section: Links  -->

    <div :class="`${footerBgTwo ? 'footer__bottom footer__bottom-2' : 'footer__bottom'}`">
      <div class="container">
        <div class="row">
          <div class="col-xxl-12">
            <div
              :class="`${
                footerBgTwo ? 'footer__copyright-2 text-center' : 'footer__copyright text-center'
              }`"
            >
              <p>
                © 2022 SSAFY-8th, All Rights Reserved. BUK-3
                <span style="color: white">TwoYuJin.</span>
              </p>
              <a
                href="https://github.com/nayu1105/wimh"
                target="_blank"
                class="me-4 link-secondary"
                id="githubLogo"
              >
                <i class="fab fa-github fa-lg"></i>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: "FooterArea",
  props: {
    footerBgTwo: String,
    footerPadding: String,
  },
};
</script>

<style scoped>
#githubLogo :hover {
  color: white;
  transition: 0.5s;
}
</style>
