<template>
   <div class="modal fade" tabindex="-1" id="updateModal">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title">글 수정</h5>
               <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
               <div class="mb-3">
                  <!-- v-model 을 store 와 직접 연결하기 보다 computed-get-set 을 사용(strict mode 에서는 오류 발생) -->
                  <!-- <input v-model="$store.state.board.title" type="text" class="form-control" placeholder="제목"> -->
                  <input v-model="title" type="text" class="form-control" placeholder="제목" />
               </div>
               <div class="mb-3">
                  <div id="divEditorUpdate"></div>
               </div>
            </div>
            <div class="modal-footer">
               <button @click="boardUpdate" class="btn btn-sm e-btn btn-outline" data-dismiss="modal" type="button">수정</button>
            </div>
         </div>
      </div>
   </div>
</template>

<script>
import Vue from "vue";
import CKEditor from "@ckeditor/ckeditor5-vue2";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import VueAlertify from "vue-alertify";

Vue.use(CKEditor).use(VueAlertify);

import http from "@/common/axios.js";

export default {
   name: "UpdateModal",
   // props: ["board"],
   // data 는 CKEditor, attachFile, fileList UI 관련 3개만
   data() {
      return {
         CKEditor: "",
         title: this.$store.state.board.title,
      };
   },
   methods: {
      // modal 초기화
      initUI() {
         this.CKEditor.setData(this.$store.state.board.content);
      },
      // 굳이 actions 에 있을 필요 없다. backend async 작업이지만, 그 결과로 store 를 변경하는 내용이 없다.
      async boardUpdate() {
         let params = {
            boardId : this.$store.state.board.boardId,
            title : this.title,
            content : this.CKEditor.getData(),
         }

         console.log(params);
         // not put, REST but FileUpload
         try {
            let { data } = await http.put("/admin/boards/",params);

            console.log("UpdateModalVue: data : ");
            console.log(data);
            if (data.result == "login") {
               this.doLogout();
            } else {
               this.$alertify.success("글이 수정되었습니다.");
               this.closeModal();
               this.$router.push("/adminBoards");
               this.$store.commit("SET_BOARD_UPDATE", params);
            }
         } catch (error) {
            console.log("UpdateModalVue: error ");
            console.log(error);
         }
      },
      closeModal() {
         this.$emit("call-parent-update"); // no parameter
      },
      // logout 처리 별도 method
      doLogout() {
         this.$store.commit("SET_LOGIN", { isLogin: false, userName: "", userProfileImageUrl: "" });
         this.$router.push("/login");
      },
   },
   // modal.show() 이전에 이미 mounted() 호출됨
   async mounted() {
      try {
         this.CKEditor = await ClassicEditor.create(document.querySelector("#divEditorUpdate"));
      } catch (error) {
         console.error(error);
      }

      // bootstrap modal show event hook
      // UpdateModal 이 보일 때 초기화
      let $this = this;
      this.$el.addEventListener("show.bs.modal", function () {
         $this.initUI();
      });
   },
   // watch 사용 X
   // props 사용 X
   // watch: {
   //   board : function(){
   //     // props --> data
   //     this.boardId = this.board.boardId;
   //     this.title = this.board.title;
   //     this.CKEditor.setData( this.board.content );
   //     // 아래의 내용을 추가하지 않음
   //     // 기존 파일 내용은 props - board 를 이용
   //     // fileList 는 신규 파일에 적용
   //     //this.fileList = this.board.fileList;

   //     // 첨부 파일 관련 초기화
   //     // 수정 또는 수정 전 첨부 파일을 선택하면 그대로 남아 있다.
   //     this.attachFile = false;
   //     this.fileList = [];
   //   }
   // }
};
</script>

<style>
.ck-editor__editable {
  /* editing area */
  height: 200px;
}
</style>
