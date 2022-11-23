<template>
  <section class="page__title-area pt-120 pb-90">
    <div class="container">
      <div class="row">
        <div class="col-xxl-8 col-xl-8 col-lg-8">
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
              <div class="course__rating-2 mb-30">
                <h5>Review :</h5>
                <div class="course__rating-inner d-flex align-items-center">
                  <ul>
                    <li>
                      <a href="#"> <i class="fas fa-star"></i> </a>
                    </li>
                    <li>
                      <a href="#"> <i class="fas fa-star"></i> </a>
                    </li>
                    <li>
                      <a href="#"> <i class="fas fa-star"></i> </a>
                    </li>
                    <li>
                      <a href="#"> <i class="fas fa-star"></i> </a>
                    </li>
                    <li>
                      <a href="#"> <i class="fas fa-star"></i> </a>
                    </li>
                  </ul>
                  <p>4.5</p>
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
                      <table class="table">
                        <thead>
                          <tr>
                            <th class="col-3">계약 일자</th>
                            <th class="col-4">매매가 (단위: 만 원)</th>
                            <th class="col-3">면적</th>
                            <th class="col-2">층수</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr v-for="(apt, aptIdx) in detailGetters.dealList" :key="aptIdx">
                            <td scope="row">
                              {{ apt.dealYear }}. {{ apt.dealMonth | fillZero() }}.
                              {{ apt.dealDay | fillZero() }}
                            </td>
                            <td>{{ apt.dealAmount }}</td>
                            <td>{{ apt.area }}</td>
                            <td>{{ apt.floor }}</td>
                          </tr>
                        </tbody>
                      </table>
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
