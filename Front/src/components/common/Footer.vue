<template>
  <footer>
    <div :class="`footer__area ${footerBgTwo ? 'grey-bg-2' : 'footer-bg'}`">
      <div :class="`footer__top ${footerPadding ? 'pt-90' : 'pt-190'} pb-40`">
        <div class="container">
          <div class="row">
            <div class="col-xxl-3 col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <div class="footer__widget mb-50">
                <div class="footer__widget-head mb-22">
                  <div class="footer__logo">
                    <router-link to="/">
                      <!-- <img :src="`${footerBgTwo ? require('../../assets/img/logo/logo.png') : require('../../assets/img/logo/logo-2.png')}`" alt=""> -->
                      <h3 style="color: white">방구할라면</h3>
                    </router-link>
                  </div>
                </div>
                <div :class="`${footerBgTwo ? 'footer__widget-body-2' : 'footer__widget-body'}`">
                  <p>부울경 3반 7조 나유진, 반유진</p>
                </div>
              </div>
            </div>
            <div class="company-box">
              <div class="footer__widget mb-50">
                <div class="footer__widget-head mb-22">
                  <h3 :class="`${footerBgTwo ? 'footer__widget-title-2' : 'footer__widget-title'}`">
                    Company
                  </h3>
                </div>
                <div class="footer__widget-body">
                  <div :class="`${footerBgTwo ? 'footer__link-2' : 'footer__link'}`">
                    <ul>
                      <li>
                        <a href="https://www.ssafy.com" target="_blank">SSAFY</a> &nbsp;<span
                          >부산광역시 강서구 송정동 녹산산업중로 333</span
                        >
                      </li>

                      <li>
                        <a href="https://github.com/nayu1105" target="_blank">NaYuJin</a>
                        &nbsp;<span>dbwls387@gmail.com</span>
                      </li>
                      <li>
                        <a href="https://github.com/dbwls387" target="_blank">BanYuJin</a>
                        &nbsp;<span>dbwls387@gmail.com</span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
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
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'FooterArea',
  props: {
    footerBgTwo: String,
    footerPadding: String,
  },
};
</script>
