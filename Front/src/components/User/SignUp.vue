<template>
  <section class="signup__area po-rel-z1 pt-50 pb-145">
    <div class="container">
      <div class="row">
        <div class="col-xxl-8 offset-xxl-2 col-xl-8 offset-xl-2">
          <div class="section__title-wrapper text-center mb-30">
            <h2 class="section__title">회원가입</h2>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-xxl-6 offset-xxl-3 col-xl-6 offset-xl-3 col-lg-8 offset-lg-2">
          <div class="sign__wrapper white-bg">
            <!-- <div class="sign__header mb-35">
              <div class="sign__in text-center">
                <a href="#" class="sign__social g-plus text-start mb-15"
                  ><i class="fab fa-google-plus-g"></i>Sign Up with Google</a
                >
                <p>
                  <span>........</span> Or,
                  <router-link to="/register">sign up</router-link>
                  with your email<span> ........</span>
                </p>
              </div>
            </div> -->
            <div class="sign__form">
              <form action="#">
                <div class="sign__input-wrapper mb-25">
                  <h5>이름</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="이름" v-model="userName" />
                    <i class="fal fa-user"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-25">
                  <h5>이메일</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="이메일" v-model="userEmail" />
                    <i class="fal fa-envelope"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-25">
                  <h5>비밀번호</h5>
                  <span id="validate-password">8~20자리 이내, 공백 없는 영문, 숫자, 특수문자</span>
                  <div class="sign__input">
                    <input type="password" placeholder="비밀번호" v-model="userPassword" />
                    <i class="fal fa-lock"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-10">
                  <h5>비밀번호 재입력</h5>
                  <div class="sign__input">
                    <input type="password" placeholder="비밀번호 재입력" v-model="userPassword2" />
                    <i class="fal fa-lock"></i>
                  </div>
                </div>
                <button class="e-btn w-100" @click="register"><span></span> 회원가입</button>
                <div class="sign__new text-center mt-20">
                  <p><router-link to="/login"> 로그인하러 가기</router-link></p>
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
  name: "SignUpArea",
  data() {
    return {
      // v-model
      userName: "",
      userEmail: "",
      userPassword: "",
      userPassword2: "",

      // 회원 구분
      groupCode: "001",
      codeList: [], // 회원 구분의 리스트들이 create하면 담김
      userClsf: "001", // 일반회원 default
    };
  },
  methods: {
    validateEmail(email) {
      var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
      return re.test(email);
    },
    validatePassword(pw) {
      var num = pw.search(/[0-9]/g);
      var eng = pw.search(/[a-z]/gi);
      var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

      if (pw.length < 8 || pw.length > 20) {
        return false;
      } else if (pw.search(/\s/) != -1) {
        return false;
      } else if (num < 0 || eng < 0 || spe < 0) {
        return false;
      } else {
        return true;
      }
    },
    async register() {
      if (!this.validateEmail(this.userEmail)) {
        this.$alertify.error("이메일 형식이 올바르지 않습니다.");
        return;
      }

      if (!this.validatePassword(this.userPassword)) {
        this.$alertify.error("비밀번호 형식이 올바르지 않습니다.");
        return;
      }

      if (this.userPassword != this.userPassword2) {
        // valid
        this.$alertify.error("비밀번호를 다시 확인해주세요");
      } else {
        let params = {
          userName: this.userName,
          userEmail: this.userEmail,
          userPassword: this.userPassword,
          userClsf: this.userClsf,
        };

        console.log(params);
        let { data } = await http.post("/register", params);
        console.log(data);

        let $this = this;
        this.$alertify.alert("회원가입을 축하합니다. 로그인 페이지로 이동합니다", function () {
          $this.$router.push("/home").catch(() => {});
        });
      }
    },
  },
  async created() {
    try {
      let { data } = await http.get("/register/getcommon/" + this.groupCode); // params : params shorthand property, Not JSON request
      console.log("RegisterVue: data : ");
      console.log(data);

      this.codeList = data;

      // make code btn ( 구분코드 리스트 들로 버튼만들어서 설정가능하도록 하기)
    } catch (error) {
      console.log("RegisterVue: error : ");
      console.log(error);
      this.$alertify.error("서버에 문제가 발생했습니다.");
    }
  },
};
</script>

<style scoped>
#validate-password {
  font-size: 13px;
  padding: 10px;
  color: red;
}
</style>
