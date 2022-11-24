<template>
  <section class="signup__area po-rel-z1 pt-100 pb-145">
    <div class="container">
      <div class="row">
        <div class="col-xxl-8 offset-xxl-2 col-xl-8 offset-xl-2">
          <div class="section__title-wrapper text-center mb-55">
            <h2 class="section__title">로그인</h2>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-xxl-6 offset-xxl-3 col-xl-6 offset-xl-3 col-lg-8 offset-lg-2">
          <div class="sign__wrapper white-bg">
            <!-- <div class="sign__header mb-35">
              <div class="sign__in text-center">
                <a href="#" class="sign__social text-start mb-15">
                  <i class="fab fa-facebook-f"></i>Sign in with Facebook</a
                >
                <p>
                  <span>........</span> Or,
                  <router-link to="/login">sign in</router-link>
                  with your email<span> ........</span>
                </p>
              </div>
            </div> -->
            <div class="sign__form">
              <form action="#">
                <div class="sign__input-wrapper mb-25">
                  <h5>이메일</h5>
                  <div class="sign__input">
                    <input
                      type="text"
                      placeholder="이메일"
                      v-model="$store.state.login.userEmail"
                    />
                    <i class="fal fa-envelope"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-10">
                  <h5>비밀번호</h5>
                  <div class="sign__input">
                    <input
                      type="text"
                      placeholder="비밀번호"
                      v-model="$store.state.login.userPassword"
                    />
                    <i class="fal fa-lock"></i>
                  </div>
                </div>
                <div class="sign__action d-sm-flex justify-content-between mb-30">
                  <!-- <div class="sign__agree d-flex align-items-center">
                    <input class="m-check-input" type="checkbox" id="m-agree" />
                    <label class="m-check-label" for="m-agree">Keep me signed in </label>
                  </div> -->
                  <div class="sign__forgot">
                    <!-- <a href="#">Forgot your password?</a> -->
                  </div>
                </div>
                <button class="e-btn w-100" @click="login"><span></span> 로그인</button>
                <div class="sign__new text-center mt-20">
                  <p>계정이 없다면?<router-link to="/register"> 회원가입</router-link></p>
                </div>
              </form>
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

import http from "@/common/axios.js";
export default {
  name: "LoginArea",
  methods: {
    async login() {
      let params = {
        userEmail: this.$store.state.login.userEmail,
        userPassword: this.$store.state.login.userPassword,
      };

      try {
        let { data } = await http.post("/login", params);
        
        console.log(data);

        this.$store.commit('SET_LOGIN', {
          isLogin: true,
          userName: data.userName,
          userSeq: data.userSeq,
          userProfileImageUrl: data.userProfileImageUrl,
          userCode: data.userCode,
        });
        console.log(this.$store.state.login.userCode);
        this.$router.push('/home');
      } catch (error) {
        if (error.response.status == "404") {
          this.$alertify.error("이메일 또는 비밀번호를 확인하세요.");
        } else {
          this.$alertify.error("Opps!! 서버에 문제가 발생했습니다.");
        }
      }
    },
  },
};
</script>
