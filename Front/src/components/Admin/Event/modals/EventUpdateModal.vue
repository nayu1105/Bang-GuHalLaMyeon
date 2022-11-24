<template>
  <!-- Modal Update -->
  <div
    class="modal fade"
    id="updateModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-xl" style="background-color: white; border-radius: 10px">
      <div class="modal-content">
        <h4 class="title" id="exampleModalLabel" style="margin: 15px">이벤트 수정</h4>
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
            <label for="titleUpdate" class="form-label">제목</label>
            <input type="text" class="form-control" v-model="title" />
          </div>
          <div class="mb-3">
            <label for="contentUpdate" class="form-label">내용</label>
            <!-- CKEditor Update -->
            <div id="divEditorUpdate"></div>
          </div>
          <div class="mb-3">
            <label for="startUpdate" class="form-label">시작 일시</label>
            <input type="date" class="form-control" v-model="startDate" />
          </div>
          <div class="mb-3">
            <label for="endUpdate" class="form-label">종료 일시</label>
            <input type="date" class="form-control" v-model="endDate" />
          </div>
          <div class="mb-3">
            <label for="statusUpdate" class="form-label">진행 상태</label>
            <!-- 
                0: 참여하기
                1: 참여 완료
                2: 이벤트 종료
                3: 버튼 안보이기
            -->
            <div class="radioBtn">
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
            @click="eventUpdate"
            type="button"
            class="btn btn-outline-success float-end"
            data-bs-dismiss="modal"
          >
            수정하기
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
  props: ["event"],

  data() {
    return {
      eventId: this.$store.state.event.eventId,
      title: this.$store.state.event.title,
      CKEditor: "",
      startDate: this.$store.state.event.startDate,
      endDate: this.$store.state.event.endDate,
      statusCode: this.$store.state.event.statusCode,
    };
  },

  methods: {
    radioChange(event) {
      this.statusCode = event.target.value;
    },
    initUI() {
      this.CKEditor.setData(this.$store.state.event.content);
    },
    async eventUpdate() {
      let formData = new FormData();
      this.eventId = this.$store.state.event.eventId;
      formData.append("eventId", this.eventId);
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
        let response = await http.put("/admin/events/" + this.eventId, formData, options);
        let { data } = response;

        console.log(data);

        var $this = this;
        // interceptor session check fail
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          // 등록 성공
          this.$alertify.alert("수정되었습니다. ", function () {
            $this.$router.go();
          });
        }
      } catch (error) {
        this.$alertify.error("글 수정 과정에서 오류가 발생했습니다. ");
      }
    },
    closeModal() {
      this.$emit("call-parent-update");
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

      $this.title = $this.$store.state.event.title;
      $this.startDate = $this.$store.state.event.startDate;
      $this.endDate = $this.$store.state.event.endDate;
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
