<template>
  <div>
    <MapCityBtn></MapCityBtn>
    <div class="map_wrap">
      <div id="map"></div>
    </div>
    <MapSidebar v-show="this.$store.state.map.showSidebar"></MapSidebar>
  </div>
</template>

<script>
import MapCityBtn from '@/components/House/MapCityBtn.vue';
import MapSidebar from '@/components/House/MapSidebar.vue';

import Vue from 'vue';
import VueAlertify from 'vue-alertify';
Vue.use(VueAlertify);

import http from '@/common/axios.js';

export default {
  name: 'KakaoMap',
  components: {
    MapCityBtn,
    MapSidebar,
  },
  data() {
    return {
      infowindow: null,
      markers: [],
      map: null,
      clusterer: null,
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      script.src =
        '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9fa060a9b4a46b0e7e27c1cfe9d4e2f4&libraries=services,clusterer,drawing';

      /* global kakao */
      script.addEventListener('load', () => {
        kakao.maps.load(this.initMap);
      });
      document.head.appendChild(script);
    }
  },
  // map init 후 모든 마커 생성 & 클러스터링
  // 그 후 infowindow OR Marker Image 손보고
  // house detail 뜨고

  methods: {
    initMap() {
      const container = document.getElementById('map');
      const options = {
        center: new kakao.maps.LatLng(37.5366059, 126.9917822),
        level: 3,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);

      var mapTypeControl = new kakao.maps.MapTypeControl();

      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

      // 마커 클러스터러를 생성합니다
      this.clusterer = new kakao.maps.MarkerClusterer({
        map: this.map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 2, // 클러스터 할 최소 지도 레벨
      });

      kakao.maps.event.addListener(this.clusterer, 'clusterclick', function (cluster) {
        cluster.getBounds()      
      });
    },
    // map.setBounds(bounds);
    /////////////////////////////////* Open Api ver *///////////////////////////////////

    // getHouseList() {
    //   this.$store.dispatch('houseTotalList');
    // },

    async getHouseList() {      
      let params = {
        lawdcd: this.$store.state.house.lawdcd,
      };

      try {
        let { data } = await http.get('/houses', { params });
        if (data.result == 'login') {
          this.$router.push('/login');
        } else {
          console.log("makeClusterMakers");
          this.makeClusterMakers(data.list);
        }
      } catch (error) {
        console.log(error);
      }
    },

    makeClusterMakers(list) {
      var $this = this;

      if ($this.markers.length != 0) {
        this.clusterer.removeMarkers($this.markers);
      }

      $this.markers = [];
      var imageSrc = require('@/assets/img/icon/marker/marker.png'); // 마커이미지의 주소입니다
      var imageSize = new kakao.maps.Size(45, 45); // 마커이미지의 크기입니다
      var imageOption = { offset: new kakao.maps.Point(13, 34) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

      list.forEach((el) => {
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
        var marker = new kakao.maps.Marker({
          position: new kakao.maps.LatLng(el.lat, el.lng),
          image: markerImage, // 마커이미지 설정
          clickable: true,  // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
          title: el.aptCode,
        });

        kakao.maps.event.addListener(marker, 'click', function() {            
            $this.map.setCenter(marker.getPosition());
            console.log(marker.getTitle());
            $this.$store.dispatch('houseDetail',marker.getTitle());

            $this.$store.state.map.showSidebar=true;
            // marker의 title store에 저장 후 자식 sidebar의 async detail 함수 불러서 sidebar에 데이터 주기
            // 클릭한 위치를 중앙에 정렬하기
        });

        $this.markers.push(marker);
      });
      this.clusterer.addMarkers($this.markers);

      this.setMapCenterLocation();
    },

    setMapCenterLocation() {
      var $this = this;
      var geocoder = new kakao.maps.services.Geocoder();

      var location = this.$store.state.house.sido + ' ' + this.$store.state.house.gugun;

      if(this.$store.state.house.dong!=''){
        location += ' ' + this.$store.state.house.dong;
      }

      geocoder.addressSearch(location, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
          $this.map.setCenter(coords);
        }
      });
    },
  },
  created() {
    this.getHouseList();
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('@/assets/css/map.css');
</style>
