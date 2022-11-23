<template>
  <div class="tab-pane fade" id="review" role="tabpanel" aria-labelledby="review-tab">
    <div class="course__review">
      <div class="course__review-rating mb-50">
        <div class="row g-0">
          <div class="col-xxl-4 col-xl-4 col-lg-4 col-md-4 col-sm-4">
            <div class="course__review-rating-info grey-bg text-center">
              <h5>{{ avgRate }}</h5>
              <ul>
                <li>
                  <a href="#"> <i class="icon_star"></i> </a>
                </li>
                <li>
                  <a href="#"> <i class="icon_star"></i> </a>
                </li>
                <li>
                  <a href="#"> <i class="icon_star"></i> </a>
                </li>
                <li>
                  <a href="#"> <i class="icon_star"></i> </a>
                </li>
                <li>
                  <a href="#"> <i class="icon_star"></i> </a>
                </li>
              </ul>
              <p>4 Ratings</p>
            </div>
          </div>
          <div class="col-xxl-8 col-xl-8 col-lg-8 col-md-8 col-sm-8">
            <div class="course__review-details grey-bg">
              <h5>Detailed Rating</h5>
              <div class="course__review-content mb-20">
                <div class="course__review-item d-flex align-items-center justify-content-between">
                  <div class="course__review-text">
                    <span>5 stars</span>
                  </div>
                  <div class="course__review-progress">
                    <div class="single-progress" data-width="100%"></div>
                  </div>
                  <div class="course__review-percent">
                    <h5>100%</h5>
                  </div>
                </div>
                <div class="course__review-item d-flex align-items-center justify-content-between">
                  <div class="course__review-text">
                    <span>4 stars</span>
                  </div>
                  <div class="course__review-progress">
                    <div class="single-progress" data-width="30%"></div>
                  </div>
                  <div class="course__review-percent">
                    <h5>30%</h5>
                  </div>
                </div>
                <div class="course__review-item d-flex align-items-center justify-content-between">
                  <div class="course__review-text">
                    <span>3 stars</span>
                  </div>
                  <div class="course__review-progress">
                    <div class="single-progress" data-width="0%"></div>
                  </div>
                  <div class="course__review-percent">
                    <h5>0%</h5>
                  </div>
                </div>
                <div class="course__review-item d-flex align-items-center justify-content-between">
                  <div class="course__review-text">
                    <span>2 stars</span>
                  </div>
                  <div class="course__review-progress">
                    <div class="single-progress" data-width="0%"></div>
                  </div>
                  <div class="course__review-percent">
                    <h5>0%</h5>
                  </div>
                </div>
                <div class="course__review-item d-flex align-items-center justify-content-between">
                  <div class="course__review-text">
                    <span>1 stars</span>
                  </div>
                  <div class="course__review-progress">
                    <div class="single-progress" data-width="0%"></div>
                  </div>
                  <div class="course__review-percent">
                    <h5>0%</h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- 리뷰 리스트 시작 -->
      <div class="course__comment mb-75">
        <h3>후기 ({{ $store.state.review.totalListItemCount }})</h3>

        <ul v-if="$store.state.review.totalListItemCount > 0">
          <li v-for="(review, listIdx) in list" :key="listIdx">
            <div class="course__comment-box">
              <div class="course__comment-thumb float-start">
                <img src="@/assets/img/noProfile.png" alt="" />
              </div>
              <div class="course__comment-content">
                <div class="course__comment-wrapper ml-70 fix">
                  <div class="mb-15">
                    <div
                      class="star"
                      v-for="starIdx in review.rate"
                      :key="starIdx"
                      style="display: inline"
                    >
                      <span>
                        <i class="fa-solid fa-star"></i>
                      </span>
                    </div>
                    <div
                      class="star"
                      v-for="starIdx in 5 - review.rate"
                      :key="starIdx"
                      style="display: inline"
                    >
                      <span>
                        <i class="fa-regular fa-star"></i>
                      </span>
                    </div>
                  </div>
                  <div class="course__comment-info float-start">
                    <h5>{{ review.title }}</h5>
                    <span>{{ review.userName }}</span
                    >&nbsp; | &nbsp;
                    <span>{{ review.regDt.date | makeDateStr(".") }}</span>
                  </div>
                  <div class="course__comment-rating float-start float-sm-end">
                    <ul>
                      <li>
                        <a href="#"> <i class="icon_star"></i> </a>
                      </li>
                      <li>
                        <a href="#"> <i class="icon_star"></i> </a>
                      </li>
                      <li>
                        <a href="#"> <i class="icon_star"></i> </a>
                      </li>
                      <li>
                        <a href="#"> <i class="icon_star"></i> </a>
                      </li>
                      <li>
                        <a href="#"> <i class="icon_star"></i> </a>
                      </li>
                    </ul>
                  </div>
                </div>
                <div class="course__comment-text ml-70">
                  <!-- <h5>{{ review.title }}</h5> -->
                  <p>
                    {{ review.content }}
                  </p>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
      <div class="course__form">
        <h3>후기 쓰기</h3>
        <div class="course__form-inner">
          <form action="#">
            <div class="row">
              <div class="col-xxl-12">
                <div class="course__form-input">
                  <div class="course__form-rating">
                    <div>
                      <div
                        class="star"
                        v-for="index in 5"
                        :key="index"
                        @click="check(index)"
                        style="display: inline"
                      >
                        <span v-if="index < score">
                          <i class="fa-solid fa-star fa-2x"></i>
                        </span>
                        <span v-if="index >= score">
                          <i class="fa-regular fa-star fa-2x"></i>
                        </span>
                      </div>
                    </div>
                  </div>
                  <div class="col-xxl-12 mt-20">
                    <div class="course__form-input">
                      <input type="text" placeholder="제목" v-model="title" />
                    </div>
                  </div>
                  <textarea placeholder="내용" v-model="content"></textarea>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xxl-12">
                <div class="course__form-btn mt-10 mb-55">
                  <button @click="reviewInsert" type="submit" class="e-btn">등록하기</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/common/axios.js";

export default {
  name: "BoardsReviewTab",
  data() {
    return {
      userName: "",
      title: "",
      content: "",
      rate: 0,
      houseNo: 0,
      list: this.$store.state.review.list,
      avgRate: this.$store.state.review.avgRate,

      score: 6,
    };
  },
  computed: {
    listGetters() {
      return this.$store.getters.getReviewList;
    },
  },
  created() {
    this.reviewList();
  },
  methods: {
    check(index) {
      this.score = index + 1;
    },
    reviewList() {
      this.$store.dispatch("reviewList");
    },
    async reviewInsert() {
      let formData = new FormData();
      formData.append("title", this.title);
      formData.append("content", this.content);

      formData.append("rate", this.score - 1);
      formData.append("houseNo", this.$store.state.house.aptCode);

      // multipart/form-data
      let options = {
        headers: { "Content-Type": "multipart/form-data" },
      };

      try {
        let response = await http.post("/reviews", formData, options);
        let { data } = response;

        console.log(data);

        // interceptor session check fail
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          // 등록 성공
          this.$alertify.success("리뷰가 등록되었습니다. ");
        }
      } catch (error) {
        this.$alertify.error("리뷰 등록 과정에서 오류가 발생했습니다. ");
      }
    },
    closeModal() {
      this.$emit("call-parent-insert");
    },
  },
  filters: {
    makeDateStr: function (date, separator) {
      return (
        date.year +
        separator +
        (date.month < 10 ? "0" + date.month : date.month) +
        separator +
        (date.day < 10 ? "0" + date.day : date.day)
      );
    },
  },
};
</script>

<style scoped>
.fa-solid {
  color: #f49d1a;
}
</style>
