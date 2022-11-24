<template>
  <div class="modal fade" tabindex="-1" id="updateModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">회원 정보 수정</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="mb-3 row">
            <label for="staticName" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
              <input
                type="text"
                class="form-control-plaintext"
                id="staticName"
                v-model="updateData.userName"
              />
            </div>
          </div>
          <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
              <input
                type="text"
                class="form-control-plaintext"
                id="staticEmail"
                v-model="updateData.userEmail"
              />
            </div>
          </div>
          <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
              <input
                type="text"
                class="form-control-plaintext"
                id="staticEmail"
                v-model="updateData.userPassword"
              />
            </div>
          </div>
          <div class="mb-3 row">
            <label for="staticClsf" class="col-sm-2 col-form-label">회원 구분</label>
            <div class="col-sm-10">
              <div
                class="form-check form-check-inline"
                v-for="(clsf, index) in userClsf"
                :key="index"
              >
                <div v-if="clsf.code === updateData.userClsf">
                  <input
                    class="form-check-input"
                    type="radio"
                    name="inlineRadioOptions"
                    id="`${clsf.code}`"
                    :value="clsf.code"
                    checked
                    @change="changeClsf(clsf.code)"
                  />
                  <label class="form-check-label" for="`${clsf.code}`">{{ clsf.codeName }}</label>
                </div>
                <div v-else>
                  <input
                    class="form-check-input"
                    type="radio"
                    name="inlineRadioOptions"
                    id="`${clsf.code}`"
                    :value="clsf.code"
                    @change="changeClsf(clsf.code)"
                  />
                  <label class="form-check-label" for="`${clsf.code}`">{{ clsf.codeName }}</label>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button
            class="btn btn-sm e-btn btn-outline modal-button"
            data-dismiss="modal"
            type="button"
            @click="userUpdate"
          >
            수정
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue';
import VueAlertify from 'vue-alertify';

Vue.use(VueAlertify);

import http from '@/common/axios.js';

export default {
  name: 'UserManageUpdateModal',
  // props: ["board"],
  // data 는 CKEditor, attachFile, fileList UI 관련 3개만
  data() {
    return {
      updateData: this.updateUser,
      userClsf: [],
      checkClsf: '',
    };
  },
  watch: {
    updateUser() {
      this.updateData = this.updateUser;
    },
  },
  props: {
    updateUser: {},
  },
  methods: {
    // modal 초기화
    initUI() {
      console.log('init');
    },

    closeModal() {
      this.$emit('call-parent-update'); // no parameter
    },
    // logout 처리 별도 method
    doLogout() {
      this.$store.commit('SET_LOGIN', { isLogin: false, userName: '', userProfileImageUrl: '' });
      this.$router.push('/login');
    },
    changeClsf(code) {
      console.log('clsfCodeChange!! ' + code);
      this.checkClsf = code;
    },
    async userUpdate() {
      let params = {
        userName: this.updateData.userName,
        userPassword: this.updateData.userPassword,
        userEmail: this.updateData.userEmail,
        userClsf: this.checkClsf,
        userSeq: this.updateData.userSeq,
      };
      console.log(params);
      try {
        let response = await http.put('/admin/users', params);
        let { data } = response;
        if (data.result == 'login') {
          this.$router.push('/login');
        } else {
          this.$alertify.success('회원 정보가 수정되었습니다.');
          this.closeModal();
          this.$parent.userList();
        }
      } catch (error) {
        console.log(error);
        this.$alertify.error('서버에 문제가 있습니다.');
      }
    },
  },
  // modal.show() 이전에 이미 mounted() 호출됨
  async mounted() {
    // bootstrap modal show event hook
    // UpdateModal 이 보일 때 초기화
    let $this = this;
    this.$el.addEventListener('show.bs.modal', function () {
      $this.initUI();
    });
  },
  created() {
    this.userClsf = this.$store.state.clsf.userClsf;
  },
};
</script>

<style>
.ck-editor__editable {
  /* editing area */
  height: 200px;
}
</style>
