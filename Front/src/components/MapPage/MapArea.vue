<template>
  <div class="map_wrap">
    <div id="map"></div>
    <div class="select_wrap z-index-2">
      <select id="sido" class="form-select" aria-label="Default select example">
        <option selected>광역시/도</option>
      </select>
      <select id="gugun" class="form-select" aria-label="Default select example">
        <option selected>구/군</option>
      </select>
      <select id="dong" class="form-select" aria-label="Default select example">
        <option selected>동</option>
      </select>
    </div>
    <div id="menu_wrap" class="bg_white">
      <div>
        <p class="menu_title">거래 정보</p>
      </div>
      <ul id="placesList">
        <div class="card">
          <img src="@/assets/img/apt/noAptImg.jpg" class="card-img-top" />
          <div class="card-body">
            <p class="card-title">111</p>
            <p class="card-subtitle">111</p>
            <p class="card-text">111㎡ 111층</p>
            <p class="card-text">건축년도: 111 거래날짜 : 111.111.111</p>
            <div style="display: inline-block">
              <a href="" class="btn btn-primary">아파트 상세보기</a>
              <a href="" class="btn btn-primary">찜하기</a>
            </div>
          </div>
        </div>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'KakaoMap',
  data() {
    return {
      infowindow: null,
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9fa060a9b4a46b0e7e27c1cfe9d4e2f4';
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById('map');
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
  font-size: 12px;
}
.map_wrap a,
.map_wrap a:hover,
.map_wrap a:active {
  color: #000;
  text-decoration: none;
}
.map_wrap {
  height: 91vh;
  position: fixed;
  margin-top: 84px;
  width: 100%;
}
#map {
  width: 100%;
  height: 100%;
  position: relative;
  overflow: hidden;
}
#menu_wrap {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  width: 250px;
  margin: 10px 0 30px 10px;
  padding: 5px;
  overflow-y: auto;
  background: rgba(255, 255, 255, 0.7);
  z-index: 1;
  font-size: 12px;
  border-radius: 10px;
}
.bg_white {
  background: #fff;
}
#menu_wrap hr {
  display: block;
  height: 1px;
  border: 0;
  border-top: 2px solid #5f5f5f;
  margin: 3px 0;
}
#menu_wrap .option {
  text-align: center;
}
#menu_wrap .option p {
  margin: 10px 0;
}
#menu_wrap .option button {
  margin-left: 5px;
}
#menu_wrap {
  position: absolute;
  top: 80px;
  left: 0;
  bottom: 0;
  max-width: 430px;
  max-height: 100%;
  margin: 10px 0 30px 10px;
  padding: 20px;
  overflow-y: auto;
  background: rgba(255, 255, 255, 0.7);
  z-index: 1;
  font-size: 12px;
  border-radius: 10px;
}

.menu_title {
  font-size: 30px;
  font-weight: bold;
  margin: 15px;
}

.dropdowns {
  margin-bottom: 15px;
}

.form-select {
  display: inline-block;
  font-size: large;
  width: 120px !important;
  color: white;
  background-color: #003580;
  padding: 5px;
  text_align: center;
}

/* dropdown scrollable */
.scrollable-menu {
  height: auto;
  max-height: 100px;
  overflow-x: hidden;
}

.btn {
  padding: 5px;
}

/* dropdown button 
.btn {
  font-size: large;
  width: 120px;
  --bs-btn-bg: #003580;
  --bs-btn-color: var(--bs-white);
  --bs-btn-hover-color: #003580;
  --bs-btn-hover-bg: #{shade-color($bd-violet, 10%)};
  --bs-btn-active-color: var(--bs-btn-hover-color);
  --bs-btn-active-bg: #{shade-color($bd-violet, 20%)};
  --bs-btn-active-border-color: #{shade-color($bd-violet, 20%)};
}*/

/* card css */
.card {
  margin-bottom: 5px;
  width: 100%;
}

.card-body {
  margin: 15px;
}

.card-title {
  font-size: 25px;
  font-weight: bold;
  color: #009fe3;
}

.card-subtitle {
  color: grey;
  margin-bottom: 5px;
}

.card-text {
  color: black;
  padding-top: 5px;
  padding-bottom: 5px;
  padding-left: 20px;
}

/*  */
</style>
