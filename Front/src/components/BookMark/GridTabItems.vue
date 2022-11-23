<template>
  <div>
    <div v-if="listGetters.length == 0" class="bookmark-zero"> 찜한 목록이 없습니다.</div>
    <div
      v-for="(bookmark, index) in listGetters" :key="index"
      class="col-xxl-4 col-xl-4 col-lg-4 col-md-6"
    >
      <div class="course__item white-bg mb-30 fix">
        <div class="course__thumb w-img p-relative fix">
          <router-link :to="`/house-details/${bookmark.aptCode}`">
            <img src="@/assets/img/apt/noAptImg.jpg" alt="" />
          </router-link>
        </div>
        <div class="course__content">
          <div class="course__meta d-flex align-items-center justify-content-between">
            <div class="course__lesson">
              <span>{{ bookmark.sidoName }} {{ bookmark.gugunName }} {{ bookmark.dongName }}</span>
            </div>
          </div>
          <h3 class="course__title">
            <router-link :to="`/house-details/${bookmark.aptCode}`">{{ bookmark.aptName }}</router-link>
          </h3>
        </div>
        <div class="course__more d-flex justify-content-between align-items-center">
          <div class="course__btn">
            <router-link :to="`/house-details/${bookmark.aptCode}`" class="link-btn">
              상세보기
              <i class="far fa-arrow-right"></i>
              <i class="far fa-arrow-right"></i>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/common/axios.js";

export default {
  name: 'GridTab',
    computed: {
    listGetters(){
      return this.$store.state.bookmark.list;
    }
  },
  methods:{
    async bookmarkList() {
      let userSeq = this.$store.state.login.userSeq;
      try {
        let { data } = await http.get("/bookmarks/" + userSeq);
        console.log(data);
        if (data.login == "login") {
          this.$router.push("/login");
        } else {
          this.$store.commit("SET_BOOKMARK_LIST", data.list);
        }
      } catch (error) {
        console.log(error);
        this.$alertify.error("서버에 문제가 있습니다");
      }
    },
  },
  mounted() {
    console.log("mounted");
    this.bookmarkList();
  }
};
</script>
