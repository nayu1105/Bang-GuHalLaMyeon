<template>
  <section class="page__title-area pt-120 pb-90">
    <div class="container">
      <div class="row">
        <div class="col-xxl-8 col-xl-8 col-lg-8">
          <div class="course__wrapper">
            <div class="page__title-content mb-25">
              <h5 class="page__title-3">{{ $store.state.house.aptName }}</h5>
            </div>
            <div class="course__meta-2 d-sm-flex mb-30">
              <div class="course__update mr-80 mb-30">
                <h5>최근 거래 일자 :</h5>
                <p>2022-11-17</p>
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
                    <h3>상세 정보</h3>
                    <p>
                      Only a quid me old mucker squiffy tomfoolery grub cheers ruddy cor blimey
                      guvnor in my flat, up the duff Eaton car boot up the kyver pardon you A bit of
                      how's your father David skive off sloshed, don't get shirty with me chip shop
                      vagabond crikey bugger Queen's English chap. Matie boy nancy boy bite your arm
                      off up the kyver old no biggie fantastic boot, David have it show off show off
                      pick your nose and blow off lost the plot porkies bits and bobs only a quid
                      bugger all mate, absolutely bladdered bamboozled it's your round don't get
                      shirty with me down the pub well. Give us a bell bits and bobs Charles he lost
                      his bottle super my lady cras starkers bite your arm off Queen's English,
                    </p>

                    <div class="course__tag-2 mb-35 mt-35">
                      <i class="fal fa-tag"></i>
                      <a href="#">Big data,</a>
                      <a href="#">Data analysis,</a>
                      <a href="#">Data modeling</a>
                    </div>
                    <div class="course__description-list mb-45">
                      <h4>거래 일자</h4>
                      <ul>
                        <li><i class="icon_check"></i> Business's managers, leaders</li>
                        <li>
                          <i class="icon_check"></i> Downloadable lectures, code and design assets
                          for all projects
                        </li>
                        <li>
                          <i class="icon_check"></i> Anyone who is finding a chance to get the
                          promotion
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>

                <!-- CurriculumTab start -->
                <HouseContents />
                <!-- CurriculumTab end -->

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
import http from "@/common/axios.js";

export default {
  name: "HouseDetail",
  components: {
    HouseReviewTab,
  },
  created() {
    let houseNo = this.$route.params.houseNo;
    this.houseDetail(houseNo);
  },
  methods: {
    async houseDetail(houseNo) {
      // back-end에서 detail 정보 가지고 와서
      // store 에 detail 요소 바꾼 후
      // router 를 이용해 이동

      try {
        let { data } = await http.get("/" + houseNo);

        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          let { dto } = data;
          this.$store.commit("SET_HOUSE_DETAIL", dto);
        }
      } catch (error) {
        console.log("HouseMainVue: error : ");
        console.log(error);
      }
    },
  },
};
</script>
