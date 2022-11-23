<template>
  <section class="events__area pt-115 pb-120 p-relative">
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 offset-xxl-4">
          <div class="section__title-wrapper mb-60 text-center">
            <h2 class="section__title">
              <span class="yellow-bg yellow-bg-big">
                회원 관리<img src="@/assets/img/shape/yellow-bg.png" alt="" />
              </span>
            </h2>
          </div>
        </div>
      </div>
      <div class="course__member mb-45">
        <div class="course__member-item" v-for="(user, index) in list" :key="index">
          <div class="row align-items-center">
            <div class="col-xxl-5 col-xl-5 col-lg-5 col-md-5 col-sm-6">
              <div class="course__member-thumb d-flex align-items-center">
                <img src="@/assets/img/noProfile.png" alt="" />
                <div class="course__member-name ml-20">
                  <h5>{{ user.userName }}</h5>
                  <span>구분 | {{ user.userClsf }}</span>
                </div>
              </div>
            </div>
            <div class="col-xxl-2 col-xl-2 col-lg-2 col-md-2 col-sm-2 col-4">
              <div class="course__member-info pl-45">
                <h5>Email</h5>
                <span>{{ user.userEmail }}</span>
              </div>
            </div>
            <div class="col-xxl-2 col-xl-2 col-lg-2 col-md-2 col-sm-2 col-4">
              <div class="course__member-info">
                <h5>Password</h5>
                <span>{{ user.userPassword }}</span>
              </div>
            </div>
            <div class="col-xxl-2 col-xl-2 col-lg-2 col-md-2 col-sm-2 col-4">
              <div class="admin-user-btns">
                <button class="btn admin-user-btn" @click="changeToUpdate(user)">수정</button>

                <button
                  class="btn admin-user-btn"
                  @click="changeToDelete(user.userEmail, user.userSeq)"
                >
                  삭제
                </button>
              </div>
            </div>
          </div>
        </div>
        <user-manage-update-modal
          v-on:call-parent-update="closeAfterUpdate"
          :updateUser="updateUser"
        ></user-manage-update-modal>
      </div>
    </div>
  </section>
</template>

<script>
import http from '@/common/axios.js';
import Vue from 'vue';
import VueAlertify from 'vue-alertify';
Vue.use(VueAlertify);

import { Modal } from 'bootstrap'; // vue 컴포넌트에서 bootstrap modal 을 사용하기 위함.
import UserManageUpdateModal from './modals/UserManageUpdateModal.vue';

export default {
  name: 'UserManage',
  data() {
    return {
      list: [],
      limit: 10,
      offset: 0,
      userManageUpdateModal: null,
      updateUser: {
        userClsf: '',
        userEmail: '',
        userName: '',
        userPassword: '',
        userSeqa: 0,
      },
    };
  },
  components: {
    UserManageUpdateModal,
  },
  methods: {
    async userList() {
      try {
        let params = {
          limit: this.limit,
          offst: this.offset,
        };
        console.log(params);
        let { data } = await http.get('/admin/users', { params }); // params: params shorthand property, let response 도 제거
        if (data.result == 'login') {
          this.$router.push('/login');
        } else {
          if (data.result == 1) {
            this.list = data.list;
            console.log(data);
          } else {
            this.$alertify.error('서버에 문제가 있습니다');
          }
        }
      } catch (error) {
        console.log(error);
        this.$alertify.error('서버에 문제가 있습니다');
      }
    },
    changeToDelete(deleteEmail, userSeq) {
      var $this = this;

      this.$alertify.confirm(
        ` 삭제할 회원의 이메일이 ${deleteEmail} 가 맞습니까?`,
        function () {
          $this.userDelete(userSeq); // this 아니고 $this
        },
        function () {
          console.log('cancled!');
        }
      );
    },
    changeToUpdate(user) {
      this.updateUser = user;
      console.log(user);
      this.userManageUpdateModal.show();
    },
    closeAfterUpdate() {
      this.userManageUpdateModal.hide();
    },
    async userDelete(userSeq) {
      try {
        let response = await http.delete('/admin/users/' + userSeq);
        let { data } = response;
        if (data.result == 'login') {
          this.$router.push('/login');
        } else {
          this.$alertify.success('회원이 삭제되었습니다');
          this.$router.go();
        }
      } catch (error) {
        this.$alertify.error('서버에 문제가 있습니다.');
      }
    },
  },
  mounted() {
    console.log('mounted');
    this.userManageUpdateModal = new Modal(document.querySelector('#updateModal'));
  },
  created() {
    this.userList();
    this.$store.dispatch('userCodeList');
  },
  filters: {
    makeDateStr: function (date, separator) {
      return (
        date.year +
        separator +
        (date.month < 10 ? '0' + date.month : date.month) +
        separator +
        (date.day < 10 ? '0' + date.day : date.day)
      );
    },
  },
};
</script>
