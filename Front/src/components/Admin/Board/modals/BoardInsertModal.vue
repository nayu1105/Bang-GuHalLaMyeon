<template>
  <!-- Modal Insert-->
  <div
    class="modal fade"
    id="insertModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
    
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">글 쓰기</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="titleInsert" class="form-label">제목</label>
            <input type="text" class="form-control" id="titleInsert" v-model="title" />
          </div>
          <div class="mb-3">
            <label for="contentInsert" class="form-label">내용</label>
            <!-- CKEditor -->
            <div id="divEditorInsert"></div>
          </div>
        
          
          <button
            @click="boardInsert"
            id="btnBoardInsert"
            type="button"
            class="btn btn-sm e-btn float-end"
          >
            등록
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue';
import CKEditor from '@ckeditor/ckeditor5-vue2';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import VueAlertify from 'vue-alertify';

Vue.use(CKEditor).use(VueAlertify);

import http from '@/common/axios.js';

export default {
  data() {
    return {
      title: '',
      CKEditor: null,
    };
  },
  methods: {
    initUI() {
      this.title = '';
      this.CKEditor.setData('');
    },
    
    async boardInsert() {
      let params = {
        title : this.title,
        content : this.CKEditor.getData(),
      }
      console.log(params);
      try {
        let response = await http.post('/admin/boards', params);
        let { data } = response;

        console.log(data);

        //interceptor session check fail
        if (data.result == 'login') {
          //sessionTimeout 상태
          this.$router.push('/login');
        } else {
          // 등록 성공
          this.$alertify.success('글이 등록되었습니다.');
          this.closeModal();
        }
      } catch (error) {
        this.$alertify.error('글 등록과정에서 오류가 발생했습니다.');
      }
    },
    closeModal() {
      this.$emit('call-parent-insert');
    },
  },
  async mounted() {
    try {
      this.CKEditor = await ClassicEditor.create(document.querySelector('#divEditorInsert'));
    } catch (error) {
      console.error(error);
    }

    // bootstrap event 처리자 등록
    // show.bs.modal <= 해당 모달창이 show 될 때 호출
    let $this = this; // $this <= vue component
    this.$el.addEventListener('show.bs.modal', function () {
      // 현 시점의 this는 event 처리자. vue component가 아니다. this.initUI()가 안됨
      $this.initUI();
    });
  },
};
</script>

<style>
.ck-editor__editable {
  /* editing area */
  height: 200px;
}

</style>
