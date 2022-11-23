<template>
  <div id="menu_wrap" class="bg_white">
    <div>
      <p class="menu_title">거래 정보</p>
    </div>
    <ul id="placesList">
      <div class="card">
        <img src="@/assets/img/apt/noAptImg.jpg" class="card-img-top" />
        <div class="card-body">
          <p class="card-title">{{ detailGetters.dealList[0].aptName }}</p>
          <br />

          <span style="font-size: 15px; font-weight: 700">면적 :</span>
          <span class="ml-10" style="font-size: 15px">{{ detailGetters.dealList[0].area }}</span>
          <br />
          <span style="font-size: 15px; font-weight: 700">최근 거래 일자 :</span>
          <span class="ml-10" style="font-size: 15px"
            >{{ detailGetters.dealList[0].dealYear }}.{{ detailGetters.dealList[0].dealMonth }}.{{
              detailGetters.dealList[0].dealDay
            }}</span
          >
          <br />
          <span style="font-size: 15px; font-weight: 700">거래 매매가 :</span>
          <span class="ml-10" style="font-size: 15px"
            >{{ detailGetters.dealList[0].dealAmount }} (단위: 만 원)</span
          >

          <div class="mt-20" style="display: flex; justify-content: space-between">
            <button class="btn apt-btn" @click="linkToHouseDetail">아파트 상세보기</button>
            <button class="btn sidebar-bookmark-btn" @click="bookmarkInsert">찜하기</button>
          </div>
        </div>
      </div>
    </ul>
  </div>
</template>

<script>
import http from '@/common/axios.js';

import Vue from 'vue';
import VueAlertify from 'vue-alertify';

Vue.use(VueAlertify);

export default {
  name: 'MapSidebar',
  methods: {
    linkToHouseDetail() {
      let aptCode = this.$store.state.house.aptCode;
      this.$router.push('/house-details/' + aptCode);
    },
    houseDetail() {
      this.$store.dispatch('houseDetail');
      console.log(this.detailGetters.dealList);
    },
    async bookmarkInsert(){
      let params = {
        userSeq : this.$store.state.login.userSeq,
        houseNo : this.$store.state.house.aptCode,
      }
      try {
        let response = await http.post('/bookmarks', params);
        let { data } = response;

        console.log(data);

        //interceptor session check fail
        if (data.result == 'login') {
          //sessionTimeout 상태
          this.$router.push('/login');
        } else {
          this.$alertify.success("북마크에 추가되었습니다.");
        }
      } catch (error) {
        this.$alertify.error('글 등록과정에서 오류가 발생했습니다.');
      }
    }
  },
  data() {
    return {
      // list: this.$store.state.house.houseDetailList.avgDealAmount,
    };
  },
  computed: {
    detailGetters() {
      return this.$store.getters.getHouseDetail;
    },
  },
  created() {
    this.houseDetail();
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('@/assets/css/map.css');
</style>
