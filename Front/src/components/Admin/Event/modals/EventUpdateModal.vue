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
            <label for="titleUpdate" class="form-label">제목</label>
            <input type="text" class="form-control" id="titleUpdate" v-model="title" />
          </div>
          <div class="mb-3">
            <label for="contentUpdate" class="form-label">내용</label>
            <!-- CKEditor Update -->
            <div id="divEditorUpdate"></div>
          </div>
          <div class="mb-3">
            <label for="startUpdate" class="form-label">시작 일시</label>
            <input type="date" class="form-control" id="startUpdate" v-model="startDate" />
          </div>
          <div class="mb-3">
            <label for="endUpdate" class="form-label">종료 일시</label>
            <input type="date" class="form-control" id="endUpdate" v-model="endDate" />
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
      content: "",
      CKEditor: null,
      startDate: "",
      endDate: "",
    };
  },

  methods: {
    async eventUpdate() {
      let formData = new FormData();
      this.eventId = this.$store.state.event.eventId;
      formData.append("eventId", this.eventId);
      formData.append("title", this.title);
      formData.append("content", this.CKEditor.getData());
      formData.append("startDate", this.startDate);
      formData.append("endDate", this.endDate);

      // multipart/form-data
      let options = {
        headers: { "Content-Type": "multipart/form-data" },
      };

      try {
        let response = await http.put("/admin/events/" + this.eventId, formData, options);
        let { data } = response;

        console.log(data);

        // interceptor session check fail
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          // 등록 성공
          this.$alertify.success("이벤트가 수정되었습니다. ");
        }
      } catch (error) {
        this.$alertify.error("글 수정 과정에서 오류가 발생했습니다. ");
      }
    },
    closeModal() {
      this.$emit("call-parent-update");
    },
  },
  async mounted() {
    try {
      this.CKEditor = await ClassicEditor.create(document.querySelector("#divEditorUpdate"));
    } catch (error) {
      console.error(error);
    }
  },
  watch: {
    // props event 를 watch
    event: function () {
      console.log("watch!!");
      this.eventId = this.$store.state.event.eventId; // this.event <- props
      this.title = this.$store.state.event.eventId;
      this.CKEditor.setData(this.event.content);
      this.startDate = this.event.startDate;
      this.endDate = this.event.endDate;
    },
  },
};
</script>

<style>
/* deep selector */
.ck-editor__editable {
  height: 200px;
}
</style>
