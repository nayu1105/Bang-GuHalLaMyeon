<template>
  <!-- Modal Insert -->
  <div
    class="modal fade"
    id="insertModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-xl" style="background-color: white; border-radius: 10px">
      <div class="modal-content">
        <h4 class="title" id="exampleModalLabel" style="margin: 15px">이벤트 등록</h4>
        <div class="modal-header">
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
            style="margin: 5px"
          ></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="titleInsert" class="form-label">제목</label>
            <input type="text" class="form-control" id="titleInsert" v-model="title" />
          </div>
          <div class="mb-3">
            <label for="contentInsert" class="form-label">내용</label>
            <!-- CKEditor insert -->
            <div id="divEditorInsert"></div>
          </div>
          <div class="mb-3">
            <label for="startInsert" class="form-label">시작 일시</label>
            <input type="date" class="form-control" id="startInsert" v-model="startDate" />
          </div>
          <div class="mb-3">
            <label for="endInsert" class="form-label">종료 일시</label>
            <input type="date" class="form-control" id="endInsert" v-model="endDate" />
          </div>
          <div class="mb-3">
            <label for="statusUpdate" class="form-label">진행 상태</label>
            <div class="radioBtn">
              <!-- 
                0: 참여하기
                1: 참여 완료
                2: 이벤트 종료
                3: 버튼 안보이기
              -->
              <input
                type="radio"
                name="status"
                value="2"
                autocomplete="off"
                @change="radioChange($event)"
                class="ml-10"
              />
              이벤트 종료
              <input
                type="radio"
                name="status"
                value="0"
                autocomplete="off"
                @change="radioChange($event)"
                class="ml-10"
              />
              진행 중
              <input
                type="radio"
                name="status"
                value="3"
                autocomplete="off"
                @change="radioChange($event)"
                class="ml-10"
              />
              발표 게시글
            </div>
          </div>

          <button
            @click="eventInsert"
            id="btnEventInsert"
            type="button"
            class="btn btn-outline-success float-end"
            data-bs-dismiss="modal"
          >
            등록
          </button>
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
  data() {
    return {
      title: "",
      CKEditor: null,
      startDate: "",
      endDate: "",
      statusCode: 0,
    };
  },

  methods: {
    radioChange(event) {
      this.statusCode = event.target.value;
    },
    initUI() {
      this.title = "";
      this.CKEditor.setData("");
      this.startDate = "";
      this.endDate = "";
    },
    async eventInsert() {
      let formData = new FormData();
      formData.append("title", this.title);
      formData.append("content", this.CKEditor.getData());
      formData.append("startDate", this.startDate);
      formData.append("endDate", this.endDate);
      formData.append("statusCode", this.statusCode);

      // multipart/form-data
      let options = {
        headers: { "Content-Type": "multipart/form-data" },
      };

      try {
        let response = await http.post("/admin/events", formData, options);
        let { data } = response;

        console.log(data);

        // interceptor session check fail
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          // 등록 성공
          this.$alertify.success("글이 등록되었습니다. ");
          this.closeModal();
        }
      } catch (error) {
        this.$alertify.error("글 등록 과정에서 오류가 발생했습니다. ");
      }
    },
    closeModal() {
      this.$emit("call-parent-insert");
    },
  },

  async mounted() {
    try {
      this.CKEditor = await ClassicEditor.create(document.querySelector("#divEditorInsert"));
    } catch (error) {
      console.error(error);
    }

    // bootstrap event 처리자 등록
    // show.bs.modal <= 해당 모달창이 show 될 때 호출
    let $this = this; //  $this <= component
    this.$el.addEventListener("show.bs.modal", function () {
      // 현 시점의 this 는 event 처리자, vue component 가 아니다.
      $this.initUI();
    });
  },
};
</script>

<style>
/* deep selector */
.ck-editor__editable {
  height: 200px;
}
</style>
