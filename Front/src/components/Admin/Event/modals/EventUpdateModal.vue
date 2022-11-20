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
            <input type="text" class="form-control" id="titleUpdate" v-model="storeTitle" />
          </div>
          <div class="mb-3">
            <label for="contentUpdate" class="form-label">내용</label>
            <!-- CKEditor Update -->
            <div id="divEditorUpdate"></div>
          </div>
          <div class="mb-3">
            <label for="startUpdate" class="form-label">시작 일시</label>
            <input type="date" class="form-control" id="startUpdate" v-model="storeStartDate" />
          </div>
          <div class="mb-3">
            <label for="endUpdate" class="form-label">종료 일시</label>
            <input
              type="date"
              class="form-control"
              id="endUpdate"
              v-model="storeEndDate"
              value="endDate"
            />
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
      CKEditor: "",
      startDate: this.$store.state.event.startDate,
      endDate: this.$store.state.event.endDate,
    };
  },
  computed: {
    storeTitle: {
      get() {
        return this.$store.state.event.title;
      },
      set(title) {
        this.$store.commit("SET_EVENT_TITLE", title);
      },
    },
    storeStartDate: {
      get() {
        return this.$store.state.event.startDate;
      },
      set(startDate) {
        this.$store.commit("SET_EVENT_STARTDATE", startDate);
      },
    },
    storeEndDate: {
      get() {
        return this.$store.state.event.endDate;
      },
      set(endDate) {
        this.$store.commit("SET_EVENT_ENDDATE", endDate);
      },
    },
  },
  methods: {
    initUI() {
      this.CKEditor.setData(this.$store.state.event.content);
    },
    async eventUpdate() {
      let formData = new FormData();
      this.eventId = this.$store.state.event.eventId;
      formData.append("eventId", this.eventId);
      formData.append("title", this.storeTitle);
      formData.append("content", this.CKEditor.getData());
      formData.append("startDate", this.storeStartDate);
      formData.append("endDate", this.storeEndDate);

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
};
</script>

<style>
/* deep selector */
.ck-editor__editable {
  height: 200px;
}
</style>
