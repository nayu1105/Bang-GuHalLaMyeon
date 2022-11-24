<template>
  <section class="page__title-area pt-120 pb-90">
    <div class="container">
      <div class="row">
        <div class="col-xxl-12 col-xl-12 col-lg-12">
          <div class="course__wrapper">
            <div class="page__title-content mb-25">
              <h5 class="page__title-3">{{ detailGetters.dealList[0].aptName }}</h5>
            </div>
            <div class="course__meta-2 d-sm-flex mb-30">
              <div class="course__update mr-80 mb-30">
                <h5>최근 거래 일자 :</h5>
                <p>
                  {{ detailGetters.dealList[0].dealYear }}.{{
                    detailGetters.dealList[0].dealMonth | fillZero()
                  }}.{{ detailGetters.dealList[0].dealDay | fillZero() }}
                </p>
              </div>
              <div class="course__rating-2 mb-30" v-if="$store.state.review.totalListItemCount > 0">
                <h5>Review :</h5>
                <div class="course__rating-inner d-flex align-items-center">
                  <div>
                    <div
                      class="star"
                      v-for="starIdx in $store.state.review.list[0].avgRate"
                      :key="starIdx"
                      style="display: inline"
                    >
                      <span>
                        <i class="fa-solid fa-star"></i>
                      </span>
                    </div>
                    <div
                      class="star"
                      v-for="starIdx in 5 - $store.state.review.list[0].avgRate"
                      :key="starIdx"
                      style="display: inline"
                    >
                      <span>
                        <i class="fa-regular fa-star"></i>
                      </span>
                    </div>
                  </div>
                  <p class="ml-10">{{ $store.state.review.list[0].avgRate }}</p>
                </div>
              </div>
            </div>
            <div class="course__img w-img mb-30">
              <img src="@/assets/img/apt/noAptImg.jpg" alt="" />
            </div>
            <div class="course__tab-2 mb-45">
              <ul class="nav nav-tabs" id="courseTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button
                    class="nav-link active"
                    id="description-tab"
                    data-bs-toggle="tab"
                    data-bs-target="#description"
                    type="button"
                    role="tab"
                    aria-controls="description"
                    aria-selected="true"
                  >
                    <i class="icon_ribbon_alt"></i> <span>Detail</span>
                  </button>
                </li>
                <li class="nav-item" role="presentation">
                  <button
                    class="nav-link"
                    id="review-tab"
                    data-bs-toggle="tab"
                    data-bs-target="#review"
                    type="button"
                    role="tab"
                    aria-controls="review"
                    aria-selected="false"
                  >
                    <i class="icon_star_alt"></i> <span>리뷰</span>
                  </button>
                </li>
              </ul>
            </div>
            <div class="course__tab-content mb-95">
              <div class="tab-content" id="courseTabContent">
                <div
                  class="tab-pane fade show active"
                  id="description"
                  role="tabpanel"
                  aria-labelledby="description-tab"
                >
                  <div class="course__description">
                    <div>
                      <h3>월별 평균 매매 실거래가</h3>
                      <HouseDealAmountChart />
                    </div>

                    <br />

                    <div class="course__description-list mt-55 mb-45">
                      <h4>거래 일자</h4>
                      <div class="tableBox" style="width: 100%; height: 450px; display: block">
                        <table class="table">
                          <thead>
                            <tr>
                              <th class="col-3">계약 일자</th>
                              <th class="col-3">매매가 (단위: 만 원)</th>
                              <th class="col-3">면적</th>
                              <th class="col-3">층수</th>
                            </tr>
                          </thead>
                          <tbody style="display: block">
                            <tr v-for="(apt, aptIdx) in detailGetters.dealList" :key="aptIdx">
                              <td scope="row">
                                {{ apt.dealYear }}. {{ apt.dealMonth | fillZero() }}.
                                {{ apt.dealDay | fillZero() }}
                              </td>
                              <td style="padding-left: 13px">{{ apt.dealAmount }}</td>
                              <td style="padding-left: 16px">{{ apt.area }}</td>
                              <td style="padding-left: 20px">{{ apt.floor }}</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>

                <!-- CurriculumTab start -->
                <HouseReviewTab />
                <!-- CurriculumTab end -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import HouseReviewTab from "@/components/House/HouseReviewTab.vue";
import HouseDealAmountChart from "@/components/House/HouseDealAmountChart.vue";

export default {
  name: "HouseDetail",
  components: {
    HouseReviewTab,
    HouseDealAmountChart,
  },
  data() {
    return {
      list: this.$store.state.house.houseDetailList.avgDealAmount,
    };
  },
  computed: {
    detailGetters() {
      return this.$store.getters.getHouseDetail;
    },
    listGetters() {
      return this.$store.getters.getReviewList;
    },
  },
  created() {
    this.$store.state.house.aptCode = this.$route.params.aptCode;
    this.houseDetail();
    this.makeData();
    this.reviewList();
  },
  methods: {
    houseDetail() {
      this.$store.dispatch("houseDetail");
      console.log(this.detailGetters.dealList);
    },
    reviewList() {
      this.$store.dispatch("reviewList");
    },
    makeData() {
      this.$store.state.house.listLabel = [];
      this.$store.state.house.listData = [];
      this.$store.state.house.houseDetailList.avgDealAmount = [];

      let idx = 0;
      this.list.forEach((el) => {
        this.$store.state.house.listLabel[idx] = el.dealYear + "." + this.fillZero(el.dealMonth);
        this.$store.state.house.listData[idx] = el.avgDealAmount;
        idx++;
      });
    },
    fillZero(num) {
      let str = String(num);
      return str.padStart(2, "0");
    },
  },
  filters: {
    fillZero(num) {
      let str = String(num);
      return str.padStart(2, "0");
    },
  },
};
</script>

<style scoped>
.fa-solid {
  color: #f49d1a;
}

.table tbody::-webkit-scrollbar {
  width: 10px;
}
.table tbody::-webkit-scrollbar-thumb {
  background-color: #f49d1a;
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}
.table tbody::-webkit-scrollbar-track {
  background-color: #f49d1a38;
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
}

.table thead {
  float: left;
  width: 100%;
}

.table tbody {
  overflow: auto;
  float: left;
  width: 100%;
  height: 500px;
}

.table tbody tr {
  display: table;
  width: 100%;
}

.table thead tr {
  display: table;
  width: 100%;
}

.table td {
  width: 100px;
}
</style>
