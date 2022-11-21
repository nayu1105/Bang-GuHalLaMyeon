<template>
  <div class="house-btn">
    <!-- select/option -> ul/li  -->
    <article class="cont-select mt-5" @click.stop="">
      <button class="btn-select" @click="doBtnToggle" ref="doSelect">도/광역시</button>
      <ul class="list-member">
        <li v-for="(sido, index) in sidoListGetters" :key="index">
          <button type="button" @click="doAddNodeName(sido.sidoCode)">{{ sido.sidoName }}</button>
        </li>
      </ul>
    </article>

    <article class="cont-select mt-5" @click.stop="">
      <button class="btn-select" @click="siBtnToggle" ref="siSelect">시/군/구</button>
      <ul class="list-member">
        <li v-for="(gugun, index) in gugunListGetters" :key="index">
          <button type="button" @click="siAddNodeName(gugun.gugunCode)">
            {{ gugun.gugunName }}
          </button>
        </li>
      </ul>
    </article>

    <article class="cont-select mt-5" @click.stop="">
      <button class="btn-select" @click="dongBtnToggle" ref="dongSelect">동</button>
      <ul class="list-member">
        <li v-for="(dong, index) in dongListGetters" :key="index">
          <button type="button" @click="dongAddNodeName(dong.dongCode)">{{ dong.dongName }}</button>
        </li>
      </ul>
    </article>
  </div>
</template>

<script>
export default {
  name: 'MapCityBtn',
  computed: {
    // gttters 이용
    sidoListGetters() {
      return this.$store.getters.getSidoList; // no getBoardList()
    },

    gugunListGetters() {
      return this.$store.getters.getGugunList;
    },

    dongListGetters() {
      return this.$store.getters.getDongList;
    },
  },
  methods: {
    doBtnToggle() {
      const doSelect = this.$refs.doSelect;
      doSelect.classList.toggle('on');

      const siSelect = this.$refs.siSelect;
      siSelect.classList.remove('on');
      const dongSelect = this.$refs.dongSelect;
      dongSelect.classList.remove('on');
    },

    siBtnToggle() {
      const siSelect = this.$refs.siSelect;
      siSelect.classList.toggle('on');

      const doSelect = this.$refs.doSelect;
      doSelect.classList.remove('on');
      const dongSelect = this.$refs.dongSelect;
      dongSelect.classList.remove('on');
    },

    dongBtnToggle() {
      const dongSelect = this.$refs.dongSelect;
      dongSelect.classList.toggle('on');

      const doSelect = this.$refs.doSelect;
      doSelect.classList.remove('on');
      const siSelect = this.$refs.siSelect;
      siSelect.classList.remove('on');
    },

    doAddNodeName(sidoCode) {
      const doSelect = this.$refs.doSelect;
      if (event.target.nodeName === 'BUTTON') {
        doSelect.innerText = event.target.innerText;
        this.$store.state.house.sido = doSelect.innerText;
        this.gugunList(sidoCode);
        const siSelect = this.$refs.siSelect;
        siSelect.innerText = '시/군/구';
        this.$store.state.house.gugun = '';
        doSelect.classList.remove('on');
      }
    },

    siAddNodeName(gugunCode) {
      const siSelect = this.$refs.siSelect;
      if (event.target.nodeName === 'BUTTON') {
        siSelect.innerText = event.target.innerText;
        this.$store.state.house.gugun = siSelect.innerText;
        this.dongList(gugunCode);
        const dongSelect = this.$refs.dongSelect;
        dongSelect.innerText = '동';
        this.$store.state.house.dong = '';
        siSelect.classList.remove('on');
        this.getHouse(gugunCode);
      }
    },

    dongAddNodeName(dongCode) {
      const dongSelect = this.$refs.dongSelect;
      if (event.target.nodeName === 'BUTTON') {
        dongSelect.innerText = event.target.innerText;
        dongSelect.classList.remove('on');
        this.$store.state.house.dong = dongSelect.innerText;
        console.log('dongcode');
        console.log(dongCode);
      }
    },

    getHouse(dongCode) {
      let param = dongCode.substr(0, 5);
      this.$store.dispatch('houseList', param);
    },

    clickBack() {
      const doSelect = this.$refs.doSelect;
      doSelect.classList.remove('on');

      const siSelect = this.$refs.siSelect;
      siSelect.classList.remove('on');

      const dongSelect = this.$refs.dongSelect;
      dongSelect.classList.remove('on');
    },
    sidoList() {
      this.$store.dispatch('sidoList');
    },
    gugunList(sidoCode) {
      this.$store.dispatch('gugunList', sidoCode);
    },
    dongList(gugunCode) {
      this.$store.dispatch('dongList', gugunCode);
    },
  },
  created() {
    this.sidoList();
  },
};
</script>

<style scoped>
.form-select {
  margin-right: 5px;
  display: inline-block;
}

#selectForm {
  display: flex;
  justify-content: center;
}

.form-select,
.select-btn {
  border-radius: 12px;
  margin: 3px;
  padding: 8px;
}

.hero__title {
  display: flex;
  justify-content: center;
}

.container-80 {
  width: 70%;
  padding-bottom: 130px;
}

.main-box {
  display: flex;
  justify-content: center;
}

.hero__search {
  display: flex;
  justify-content: center;
}

#sectionImg {
  margin: 10px;
  background-image: url('../../assets/img/hero/home_bg2.jpg');
  background-size: cover;
}

.hero__title {
  color: white;
}

.perfect {
  color: #f0c332;
}

/* select ul/li */

.cont-select {
  position: relative;
  /* width: 200px; */
  margin: 5px;
}

.btn-select {
  /* width: 200px; */
  padding: 13px 30px 13px 14px;
  font-size: 15px;
  line-height: 15px;
  background-color: #fff !important;
  border: 1px solid #c4c4c4;
  box-sizing: border-box;
  border-radius: 10px;
  cursor: pointer;
  text-align: left;
  background: url('../../assets/img/icon/select-arrow.svg') center right 0px no-repeat;
}

.btn-select:hover,
.btn-select:focus {
  border: 2px solid #f0c332;
}

.list-member {
  display: none;
  position: absolute;
  width: 100%;
  top: 49px;
  left: 0;
  border: 1px solid #c4c4c4;
  box-sizing: border-box;
  box-shadow: 4px 4px 14px rgba(0, 0, 0, 0.15);
  border-radius: 10px;
  background-color: #fff !important;
}

.btn-select.on {
  background-color: white !important;
  background: url('../../assets/img/icon/select-arrow.svg') center right 0px no-repeat;
}

.btn-select.on + .list-member {
  z-index: 999;
  display: block;
}

.list-member li {
  height: 43px;
  padding: 5px 8px;
  box-sizing: border-box;
  border-radius: 8px;
  background-color: #fff !important;
}

.list-member li button {
  width: 100%;
  padding: 5px 10px;
  border: none;
  background-color: #fff;
  border-radius: 8px;
  cursor: pointer;
  text-align: left;
}

.list-member li button:hover,
.list-member li button:focus {
  background-color: #f0c432b6;
}

.house-btn {
  display: flex;
  justify-content: center;
  background-color: transparent;
  z-index: 1;
  position: fixed;
  margin: 0 auto;
  left: 300px;
  right: 0;
  top: 110px;
}

.house-btn button {
  width: 200px;
}
</style>
