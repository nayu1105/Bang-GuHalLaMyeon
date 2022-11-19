<template>
  <section class="signup__area po-rel-z1 pt-100 pb-145">
    <div class="container">
      <div class="row">
        <div class="col-xxl-8 offset-xxl-2 col-xl-8 offset-xl-2">
          <div class="section__title-wrapper text-center mb-55">
            <h2 class="section__title">User Detail</h2>
            <p>I'm a subhead that goes with a story.</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-xxl-6 offset-xxl-3 col-xl-6 offset-xl-3 col-lg-8 offset-lg-2">
          <div class="sign__wrapper white-bg">
            <div class="sign__form">
              <form action="#">
                <div class="sign__input-wrapper mb-25">
                  <h5>User Name</h5>
                  <div class="sign__input">
                    <input type="text" v-model="userName" disabled />
                    <i class="fal fa-user"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-25">
                  <h5>Email</h5>
                  <div class="sign__input">
                    <input type="text" v-model="userEmail" disabled />
                    <i class="fal fa-envelope"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-25">
                  <h5>Password</h5>
                  <div class="sign__input">
                    <input type="text" v-model="userPassword" disabled />
                    <i class="fal fa-lock"></i>
                  </div>
                </div>
                <div class="user_btn">
                <button class="e-btn"><span></span> 수정</button>
                <button class="e-btn ml-10"><span></span> 탈퇴</button>
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
import http from '@/common/axios.js';
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);
export default {
  name: "UserDetailArea",
  data() {
    return {
      userName: "",
      userEmail: "",
      userPassword: "",
    };
  },
  methods: {
    async getUserDetail() {
      let userSeq = this.$store.state.login.userSeq;
      try {
        let {data} = await http.get("/user/"+userSeq);
        this.userName = data.userName;
        this.userEmail = data.userEmail;
        this.userPassword = data.userPassword;
      } catch (error) {
        console.log(error);
        this.$alertify.error("Opps!! 서버에 문제가 발생했습니다.");
      }
    },
  },
  created() {
    this.getUserDetail();
  },
};
</script>
