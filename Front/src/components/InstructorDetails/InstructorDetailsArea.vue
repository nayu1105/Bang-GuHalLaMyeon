<template>
  <section class="teacher__area pt-100 pb-110">
    <div class="page__title-shape">
      <img
        class="page-title-shape-5 d-none d-sm-block"
        src="../../assets/img/page-title/page-title-shape-1.png"
        alt=""
      />
      <img
        class="page-title-shape-6"
        src="../../assets/img/page-title/page-title-shape-6.png"
        alt=""
      />
      <img
        class="page-title-shape-3"
        src="../../assets/img/page-title/page-title-shape-3.png"
        alt=""
      />
      <img
        class="page-title-shape-7"
        src="../../assets/img/page-title/page-title-shape-4.png"
        alt=""
      />
    </div>
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 col-xl-4 col-lg-4 col-md-6">
          <div class="teacher__details-thumb p-relative w-img pr-30">
            <img src="../../assets/img/teacher/details/teacer-details-1.jpg" alt="" />
            <div class="teacher__details-shape">
              <img
                class="teacher-details-shape-1"
                src="../../assets/img/teacher/details/shape/shape-1.png"
                alt=""
              />
              <img
                class="teacher-details-shape-2"
                src="../../assets/img/teacher/details/shape/shape-2.png"
                alt=""
              />
            </div>
          </div>
        </div>
        <div class="col-xxl-8 col-xl-8 col-lg-8">
          <div class="teacher__wrapper">
            <div class="teacher__top d-md-flex align-items-end justify-content-between">
              <div class="teacher__info">
                <h4>2022-11-10 수정사항</h4>
                <span>by Bruner</span>
              </div>
              <!-- <div class="teacher__rating">
                <h5>Review:</h5>
                <div class="teacher__rating-inner d-flex align-items-center">
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
              </div> -->
              <div class="teacher__social-2">
                <h4>Follow Us:</h4>
                <ul>
                  <li>
                    <a href="#">
                      <i class="fab fa-facebook-f"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fab fa-twitter ms-2"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fab fa-vimeo-v ms-2"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fab fa-linkedin-in ms-2"></i>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="teacher__bio">
              <h3>배너 변경</h3>
              <p>
                Only a quid me old mucker squiffy tomfoolery grub cheers ruddy cor blimey guvnor in
                my flat, up the duff Eaton car boot up the kyver pardon you A bit of how's your
                father David skive off sloshed, don't get shirty with me chip shop vagabond crikey
                bugger Queen's English chap. Matie boy nancy boy bite your arm off up the kyver old
                no biggie fantastic boot, David have it show off show off pick your nose and blow
                off lost the plot porkies bits and bobs only a quid bugger all mate, absolutely
                bladdered bamboozled it's your round don't get shirty with me down the pub well.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import CourseMixin from '../../mixins/courseItemsMixin';

export default {
  name: 'InstructorDetailsArea',
  mixins: [CourseMixin],
};
</script>
