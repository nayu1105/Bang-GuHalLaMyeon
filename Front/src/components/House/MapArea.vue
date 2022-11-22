<template>
  <div class="map_wrap">
    <div id="map"></div>
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
        '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9fa060a9b4a46b0e7e27c1cfe9d4e2f4&libraries=services';
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

      this.makeMapController();
    },

    makeMapController() {
      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
      var mapTypeControl = new kakao.maps.MapTypeControl();

      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
    },
    // getLatLng(){
    // // 주소-좌표 변환 객체를 생성합니다
    // var geocoder = new kakao.maps.services.Geocoder();

    // // 주소로 좌표를 검색합니다
    // geocoder.addressSearch('제주특별자치도 제주시 첨단로 242', function(result, status) {

    // // 정상적으로 검색이 완료됐으면
    //  if (status === kakao.maps.services.Status.OK) {

    //     var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    //     // 결과값으로 받은 위치를 마커로 표시합니다
    //     var marker = new kakao.maps.Marker({
    //         map: map,
    //         position: coords
    //     });

    //     // 인포윈도우로 장소에 대한 설명을 표시합니다
    //     var infowindow = new kakao.maps.InfoWindow({
    //         content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
    //     });
    //     infowindow.open(map, marker);

    //     // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    //     map.setCenter(coords)
    //     }
    // }
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('@/assets/css/map.css');
</style>
