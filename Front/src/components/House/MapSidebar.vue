<template>
  <div id="menu_wrap" class="bg_white">
    <div>
      <p class="menu_title">거래 정보</p>
    </div>
    <ul id="placesList">
      <div class="card">
        <!-- <img src="@/assets/img/apt/noAptImg.jpg" class="card-img-top" /> -->
        <div id="roadview" style="width: 100%; height: 300px"></div>
        <div class="card-body">
          <p class="card-title">{{ detailGetters.dealList[0].aptName }}</p>
          <br />

          <span style="font-size: 15px; font-weight: 700">면적 :</span>
          <span class="ml-10" style="font-size: 15px">{{ detailGetters.dealList[0].area }}</span>
          <br />
          <span style="font-size: 15px; font-weight: 700">최근 거래 일자 :</span>
          <span class="ml-10" style="font-size: 15px"
            >{{ detailGetters.dealList[0].dealYear }}.{{
              detailGetters.dealList[0].dealMonth | fillZero()
            }}.{{ detailGetters.dealList[0].dealDay | fillZero() }}</span
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
import http from "@/common/axios.js";

import Vue from "vue";
import VueAlertify from "vue-alertify";

Vue.use(VueAlertify);

export default {
  name: "MapSidebar",
  data() {
    return {
      roadviewContainer: null,
      roadview: null,
      roadviewClient: null,
    };
  },
  methods: {
    linkToHouseDetail() {
      let aptCode = this.$store.state.house.aptCode;
      this.$router.push("/house-details/" + aptCode);
    },
    houseDetail() {
      this.$store.dispatch("houseDetail");
      console.log(this.detailGetters.dealList);
    },
    async bookmarkInsert() {
      let params = {
        userSeq: this.$store.state.login.userSeq,
        houseNo: this.$store.state.house.aptCode,
      };
      try {
        let response = await http.post("/bookmarks", params);
        let { data } = response;

        console.log(data);

        //interceptor session check fail
        if (data.result == "login") {
          //sessionTimeout 상태
          this.$router.push("/login");
        } else {
          if (data.exist == 1) {
            this.$alertify.error("이미 북마크에 추가 되어있습니다.");
          } else {
            this.$alertify.success("북마크에 추가되었습니다.");
          }
        }
      } catch (error) {
        this.$alertify.error("글 등록과정에서 오류가 발생했습니다.");
      }
    },
    initMap() {
      var $this = this;

      $this.roadviewContainer = document.getElementById("roadview"); //로드뷰를 표시할 div
      $this.roadview = new kakao.maps.Roadview($this.roadviewContainer); //로드뷰 객체
      $this.roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

      var position = new kakao.maps.LatLng(
        $this.detailGetters.dealList[0].lat,
        $this.detailGetters.dealList[0].lng
      );

      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      $this.roadviewClient.getNearestPanoId(position, 50, function (panoId) {
        $this.roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
      });
    },
    // 전달받은 좌표(position)에 가까운 로드뷰의 파노라마 ID를 추출하여
    // 로드뷰를 설정하는 함수입니다
    toggleRoadview(position) {
      var $this = this;

      $this.roadviewClient.getNearestPanoId(position, 50, function (panoId) {
        $this.roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
      });
    },
  },
  // data() {
  //   return {
  //     // list: this.$store.state.house.houseDetailList.avgDealAmount,

  //   };
  // },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9fa060a9b4a46b0e7e27c1cfe9d4e2f4&libraries=services,clusterer,drawing";

      /* global kakao */
      script.addEventListener("load", () => {
        kakao.maps.load(this.initMap);
      });
      document.head.appendChild(script);
    }
  },
  computed: {
    detailGetters() {
      return this.$store.getters.getHouseDetail;
    },
  },
  created() {
    this.houseDetail();
  },
  filters: {
    fillZero(num) {
      let str = String(num);
      return str.padStart(2, "0");
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url("@/assets/css/map.css");
</style>
