<template>
  <div>
    <MapCityBtn></MapCityBtn>
    <div class="map_wrap">
      <div id="map"></div>
    </div>
  </div>
</template>

<script>
import MapCityBtn from "@/components/House/MapCityBtn.vue";
export default {
  name: "KakaoMap",
  components: {
    MapCityBtn,
  },
  data() {
    return {
      infowindow: null,
      markers : [],
    };
  },
  watch: {
    houseList: "initMap",
    map: null,
  },
  computed: {
    // gttters 이용
    houseList: {
      get() {
        return this.$store.state.house.houseList;
      },
    },
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9fa060a9b4a46b0e7e27c1cfe9d4e2f4&libraries=services";

      /* global kakao */
      script.addEventListener("load", () => {
        kakao.maps.load(this.initMap);
      });
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {

      this.map = null;
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.5366059, 126.9917822),
        level: 8,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      let map = new kakao.maps.Map(container, options);

      var mapTypeControl = new kakao.maps.MapTypeControl();

      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

      //검색 된 곳으로 마커 표시
      var list = this.houseList;

      // var bounds = map.getBounds();

      list.forEach((element) => {
        // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new kakao.maps.services.Geocoder();
        var location = element.법정동 + " " + element.지번;
        console.log(location);

        geocoder.addressSearch(location, function (result, status) {
          // 정상적으로 검색이 완료됐으면
          if (status === kakao.maps.services.Status.OK) {
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            var message = "latlng: new kakao.maps.LatLng(" + result[0].y + ", " + result[0].x + ")";

            console.log(coords);
            console.log(message);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
              map: map,
              position: coords,
            });

            this.markers.push(marker);
            console.log(marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            // this.map.setCenter(coords);
          }
        });
      });

      this.map =map;

      // map.setBounds(bounds);
    },

    // 처음 마커가 생성되는데 map이 여러개 생성되는 느낌임.
    // map init 후 마커만 생성 & 제어 하는 방법 찾기
    // 그 후 클러스터링
    // 그 후 infowindow OR Marker Image 손보고
    // house detail 뜨고 
    changeCenter(){
      // 이전 마크 삭제
      for (let i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);        
      }
      this.markers =[];

      // var bounds = this.map.getBounds();

      var list = this.houseList;

      list.forEach((element) => {
          // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new kakao.maps.services.Geocoder();
        var location = element.법정동 + " " + element.지번;
        console.log(location);
        geocoder.addressSearch(location, function (result, status) {
            // 정상적으로 검색이 완료됐으면
            if (status === kakao.maps.services.Status.OK) {
              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
              var message = "latlng: new kakao.maps.LatLng(" + result[0].y + ", " + result[0].x + ")";

              console.log(coords);
              console.log(message);

              // 결과값으로 받은 위치를 마커로 표시합니다
              var marker = new kakao.maps.Marker({
                map: this.map,
                position: coords,
              });

              this.markers.push(marker);
              console.log(marker);

              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
              // this.map.setCenter(coords);
            }
        });
      });
      // this.map.setBounds(bounds);
    }
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url("@/assets/css/map.css");
</style>
