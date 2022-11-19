<template>
  <div>
    <EventDetailsTitle />
    <section class="event__area pb-110">
      <div class="container">
        <div class="row">
          <div class="col-xxl-8 col-xl-8 col-lg-8">
            <div class="events__wrapper">
              <!-- <div class="events__thumb mb-35 w-img">
                <img src="../../assets/img/events/event-1.jpg" alt="" />
              </div> -->
              <div class="events__details mb-35">
                <p>
                  {{ $store.state.event.content }}
                </p>
              </div>
            </div>
          </div>
          <div class="col-xxl-4 col-xl-4 col-lg-4">
            <div class="events__sidebar pl-70">
              <div class="events__sidebar-widget white-bg mb-20">
                <div class="events__sidebar-shape">
                  <img
                    class="events-sidebar-img-2"
                    src="@/assets/img/events/event-shape-2.png"
                    alt=""
                  />
                  <img
                    class="events-sidebar-img-3"
                    src="@/assets/img/events/event-shape-3.png"
                    alt=""
                  />
                </div>
                <div class="events__info">
                  <!-- <div
                    class="events__info-meta mb-25 d-flex align-items-center justify-content-between"
                  >
                    <div class="events__info-price">
                      <h5>$76.<span>00</span></h5>
                      <h5 class="old-price">$142.00</h5>
                    </div>
                    <div class="events__info-discount">
                      <span>68% OFF</span>
                    </div>
                  </div> -->
                  <div class="events__info-content mb-35">
                    <div class="events__allow mb-30">
                      <h3>시간</h3>
                      <ul>
                        <li>
                          <i class="fal fa-check"></i> 시작 일자: &nbsp;{{
                            $store.state.event.startDate
                          }}
                        </li>
                        <li>
                          <i class="fal fa-check"></i> 종료 일자: &nbsp;{{
                            $store.state.event.endDate
                          }}
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div class="admin-footer">
                <button type="button" @click="changeToUpdate" class="btn btn-sm btn-primary">
                  수정
                </button>
                <button type="button" @click="changeToDelete" class="btn btn-sm btn-warning">
                  삭제
                </button>
              </div>

              <update-modal
                v-bind:event="event"
                v-on:call-parent-update="closeAfterUpdate"
              ></update-modal>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import http from "@/common/axios.js";
import EventDetailsTitle from "@/components/Events/EventDetailsTitle.vue";

import UpdateModal from "./modals/EventUpdateModal.vue"; // vue 컴포넌트
import { Modal } from "bootstrap"; // vue 컴포넌트에서 boostrap modal 을 사용하기 위함

export default {
  props: ["event"],
  name: "EventDetailsArea",
  components: {
    EventDetailsTitle,
    UpdateModal,
  },
  data() {
    return {
      updateModal: null,
    };
  },
  created() {
    let eventId = this.$route.params.eventId;
    this.eventDetail(eventId);
  },
  mounted() {
    this.updateModal = new Modal(document.querySelector("#updateModal"));
  },
  methods: {
    async eventDetail(eventId) {
      // back-end에서 detail 정보 가지고 와서
      // store 에 detail 요소 바꾼 후
      // router 를 이용해 이동

      try {
        let { data } = await http.get("/events/" + eventId);

        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          let { dto } = data;
          this.$store.commit("SET_EVENT_DETAIL", dto);
        }
      } catch (error) {
        console.log("EventMainVue: error : ");
        console.log(error);
      }
    },
    changeToUpdate() {
      this.updateModal.show();
    },
    closeAfterUpdate() {
      this.updateModal.hide();
    },
    changeToDelete() {
      var $this = this;
      this.$alertify.confirm(
        "이벤트를 삭제하시겠습니까?",
        function () {
          $this.eventDelete($this.$store.state.event.eventId); // this 아님
          $this.$router.push("/adminEvents");
        },
        function () {
          console.log("canceled!!!");
        }
      );
    },
    async eventDelete(eventId) {
      try {
        let response = await http.delete("/admin/events/" + eventId);
        let { data } = response;

        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          this.$alertify.success("이벤트가 삭제되었습니다. ");
        }
      } catch (error) {
        console.error(error);
        this.$alertify.error("서버에 문제가 생겼습니다. ");
      }
    },
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
    makeTimeStr: function (hour, minute, second, type) {
      return (
        hour +
        type +
        (minute < 10 ? "0" + minute : minute) +
        type +
        (second < 10 ? "0" + second : second)
      );
    },
  },
};
</script>
