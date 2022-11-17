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
            <div class="sign__header mb-35">
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
            </div>
            <div class="sign__form">
              <form action="#">
                <div class="sign__input-wrapper mb-25">
                  <h5>Name</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="Name" v-model="userName" />
                    <i class="fal fa-user"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-25">
                  <h5>Email</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="Email" v-model="userEmail" />
                    <i class="fal fa-envelope"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-25">
                  <h5>Password</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="Password" v-model="userPassword" />
                    <i class="fal fa-lock"></i>
                  </div>
                </div>
                <div class="sign__input-wrapper mb-10">
                  <h5>Re-Password</h5>
                  <div class="sign__input">
                    <input type="text" placeholder="Re-Password" v-model="userPassword2" />
                    <i class="fal fa-lock"></i>
                  </div>
                </div>
                <button class="e-btn w-100" @click="register"><span></span> Sign Up</button>
                <div class="sign__new text-center mt-20">
                  <p>Already in Educal ? <router-link to="/login"> Sign In</router-link></p>
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
import Vue from 'vue';
import VueAlertify from 'vue-alertify';
Vue.use(VueAlertify);

import http from '@/common/axios.js';

export default {
  name: 'SignUpArea',
  data() {
    return {
      // v-model
      userName: '',
      userEmail: '',
      userPassword: '',
      userPassword2: '',

      // 회원 구분
      groupCode: '001',
      codeList: [], // 회원 구분의 리스트들이 create하면 담김
      userClsf: '001', // 일반회원 default
    };
  },
  methods: {
    async register() {
      if (this.userPassword != this.userPassword2) {
        // valid
        this.$alertify.error('비밀번호를 다시 확인해주세요');
      } else {
        let params = {
          userName: this.userName,
          userEmail: this.userEmail,
          userPassword: this.userPassword,
          userClsf: this.userClsf,
        };

        console.log(params);
        let { data } = await http.post('/register', params);
        console.log(data);

        let $this = this;
        this.$alertify.alert('회원가입을 축하합니다. 로그인 페이지로 이동합니다', function () {
          $this.$router.push('/home');
        });
      }
    },
  },
  async created() {
    try {
      let { data } = await http.get('/register/getcommon/' + this.groupCode); // params : params shorthand property, Not JSON request
      console.log('RegisterVue: data : ');
      console.log(data);

      this.codeList = data;

      // make code btn ( 구분코드 리스트 들로 버튼만들어서 설정가능하도록 하기)
    } catch (error) {
      console.log('RegisterVue: error : ');
      console.log(error);
      this.$alertify.error('서버에 문제가 발생했습니다.');
    }
  },
};
</script>
