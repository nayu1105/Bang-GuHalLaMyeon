<template>
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
              <button class="btn apt-btn" @click="linkToHouseDtail">아파트 상세보기</button>
              <button class="btn bookmark-btn">찜하기</button>
            </div>
          </div>
        </div>
      </ul>
    </div>
</template>

<script>
export default {
  name: 'MapSidebar',
  methods: {
    linkToHouseDtail(){
      this.$router.push("/house-details");
    }
  },
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url("@/assets/css/map.css");
</style>
