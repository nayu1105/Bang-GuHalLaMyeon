<template>
  <section class="events__area pt-115 pb-120 p-relative">
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 offset-xxl-4">
          <div class="section__title-wrapper mb-60 text-center">
            <h2 class="section__title">
              <span class="yellow-bg yellow-bg-big"
                >이벤트 관리<img src="@/assets/img/shape/yellow-bg.png" alt=""
              /></span>
            </h2>
            <p>We found 13 events available for you.</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div
          v-for="(event, index) in listGetters"
          :key="index"
          class="col-xxl-10 offset-xxl-1 col-xl-10 offset-xl-1 col-lg-10 offset-lg-1"
        >
          <div class="events__item mb-10 hover__active">
            <div
              class="events__item-inner d-sm-flex align-items-center justify-content-between white-bg"
            >
              <div class="events__content">
                <div class="events__meta">
                  <span>{{ event.regDt.date | makeDateStr(".") }}</span>
                </div>
                <h3 class="events__title">
                  <router-link :to="`/admin/event-details/${event.eventId}`">
                    {{ event.title }}
                  </router-link>
                </h3>
              </div>
              <div class="events__more">
                <div class="link-btn" style="cursor: pointer">
                  <router-link :to="`/admin/event-details/${event.eventId}`"> More </router-link>
                  <i class="far fa-arrow-right"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- <paginationUI v-on:call-parent="movePage"></paginationUI> -->
      <button class="d-sm-block e-btn mb-50" @click="showInsertModal" style="cursor: pointer">
        등록
      </button>
      <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
    </div>
  </section>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import InsertModal from "@/components/Admin/Event/modals/EventInsertModal.vue";
import { Modal } from "bootstrap"; // vue 컴포넌트에서 bootstrap modal 을 사용하기 위함.

export default {
  name: "EventArea",
  data() {
    return {
      insertModal: null,
    };
  },
  components: {
    InsertModal,
  },
  computed: {
    // getters 이용
    listGetters() {
      return this.$store.getters.getEventList;
    },
  },
  methods: {
    eventList() {
      this.$store.dispatch("eventList");
    },
    showInsertModal() {
      this.insertModal.show();
    },
    closeAfterInsert() {
      this.insertModal.hide();
      this.eventList();
    },
  },
  created() {
    this.eventList();
  },
  mounted() {
    this.insertModal = new Modal(document.querySelector("#insertModal"));
  },
  filters: {
    makeDateStr: function (date, separator) {
      return (
        date.year +
        separator +
        (date.month < 10 ? "0" + date.month : date.month) +
        separator +
        (date.day < 10 ? "0" + date.day : date.day)
      );
    },
  },
};
</script>
