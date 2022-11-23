<template>
  <div>
    <div v-if="listGetters.length == 0" class="bookmark-zero">찜한 목록이 없습니다.</div>
    <div v-for="(bookmark, index) in listGetters" :key="index" class="col-xxl-12">
      <div class="course__item white-bg mb-30 fix">
        <div class="row gx-0">
          <div class="col-xxl-4 col-xl-4 col-lg-4">
            <div class="course__thumb course__thumb-list w-img p-relative fix">
              <router-link :to="`/house-details/${bookmark.aptCode}`">
                <img src="@/assets/img/apt/noAptImg.jpg" alt="" />
              </router-link>
            </div>
          </div>
          <div class="col-xxl-8 col-xl-8 col-lg-8">
            <div class="course__right">
              <div class="course__content course__content-3">
                <div class="bookmark-btn">
                  <img
                    src="@/assets/img/bookmark/clear.png"
                    alt=""
                    @click="bookmarkDelete(bookmark.aptCode)"
                  />                  
                </div>
                <div class="course__meta d-flex align-items-center">
                  <div class="course__lesson mr-20">
                    <span
                      >{{ bookmark.sidoName }} {{ bookmark.gugunName }}
                      {{ bookmark.dongName }}</span
                    >
                  </div>
                </div>
                <h3 class="course__title course__title-3">
                  <router-link :to="`/house-details/${bookmark.aptCode}`">{{
                    bookmark.aptName
                  }}</router-link>
                </h3>
              </div>
              <div
                class="course__more course__more-2 d-flex align-items-center bookmark-detail-btn"
              >
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
      </div>
    </div>
  </div>
</template>
<script>
import http from '@/common/axios.js';

export default {
  name: 'ListTabItems',
  computed: {
    listGetters() {
      return this.$store.state.bookmark.list;
    },
  },
  methods: {
    async bookmarkList() {
      let userSeq = this.$store.state.login.userSeq;
      try {
        let { data } = await http.get('/bookmarks/' + userSeq);
        console.log(data);
        if (data.login == 'login') {
          this.$router.push('/login');
        } else {
          this.$store.commit('SET_BOOKMARK_LIST', data.list);
        }
      } catch (error) {
        console.log(error);
        this.$alertify.error('서버에 문제가 있습니다');
      }
    },
    async bookmarkDelete(aptCode) {   
         let params = {
        userSeq: this.$store.state.login.userSeq,
        houseNo: aptCode,
      };

      try {
        let { data } = await http.delete('/bookmarks', {params});
        if (data.login == 'login') {
          this.$router.push('/login');
        }else{
          this.$router.go();
        }
      } catch (error) {
        console.log(error);
        this.$alertify.error('서버에 문제가 있습니다');
      }
    },
    async bookmarkInsert(aptCode) {
      let params = {
        userSeq: this.$store.state.login.userSeq,
        houseNo: aptCode,
      };
      try {
        let { data } = await http.post('/bookmarks', params);
        if (data.login == 'login') {
          this.$router.push('/login');
        }
      } catch (error) {
        console.log(error);
        this.$alertify.error('서버에 문제가 있습니다');
      }
    },
  },
  mounted() {
    console.log('mounted');
    this.bookmarkList();
  },
};
</script>
