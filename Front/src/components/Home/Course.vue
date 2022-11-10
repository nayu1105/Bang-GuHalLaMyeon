<template>
    <section class="course__area pt-115 pb-120 grey-bg">
            <div class="container">
               <div class="row align-items-end">
                  <div class="col-xxl-5 col-xl-6 col-lg-6">
                     <div class="section__title-wrapper mb-60">
                        <h2 class="section__title">Find the Right<br>Online <span class="yellow-bg yellow-bg-big">Course<img src="../../assets/img/shape/yellow-bg.png" alt=""></span> for you</h2>
                        <p>You don't have to struggle alone, you've got our assistance and help.</p>
                     </div>
                  </div>
                  <div class="col-xxl-7 col-xl-6 col-lg-6">
                     <div class="course__menu d-flex justify-content-lg-end mb-60">
                        <div class="masonary-menu filter-button-group">
                           <nav>
                           <div className="nav nav-tabs justify-content-center" id="portfolio-tab" role="tablist">
                           <button className="nav-link active" id="nav-all-tab" data-bs-toggle="tab" data-bs-target="#nav-all" type="button" role="tab" aria-controls="nav-all" aria-selected="true">See All <span class="tag">new</span> </button>

                           <button className="nav-link" id="nav-trending-tab" data-bs-toggle="tab" data-bs-target="#nav-trending" type="button" role="tab" aria-controls="nav-trending" aria-selected="false">Trending</button>

                           <button className="nav-link" id="nav-popularity-tab" data-bs-toggle="tab" data-bs-target="#nav-popularity" type="button" role="tab" aria-controls="nav-popularity" aria-selected="false">Popularity</button>

                           <button className="nav-link" id="nav-featured-tab" data-bs-toggle="tab" data-bs-target="#nav-featured" type="button" role="tab" aria-controls="nav-featured" aria-selected="false">Featured</button>

                           <button className="nav-link" id="nav-art-design-tab" data-bs-toggle="tab" data-bs-target="#nav-art-design" type="button" role="tab" aria-controls="nav-art-design" aria-selected="false">Art & Design</button>
                           </div>
                        </nav>

                       </div>
                     </div>
                  </div>
               </div>
               <div class="row grid tab-content">

                  <div className="tab-pane fade show active" id="nav-all" role="tabpanel"    aria-labelledby="nav-all-tab">
                     <CourseItems :itemNumberStart='0' :itemNumberEnd="6" />
                  </div>

                   <div className="tab-pane fade" id="nav-trending" role="tabpanel" aria-labelledby="nav-trending">
                      <CourseItems :itemNumberStart='1' :itemNumberEnd="5" />
                   </div>

                    <div className="tab-pane fade" id="nav-popularity" role="tabpanel" aria-labelledby="nav-popularity">
                       <CourseItems :itemNumberStart='2' :itemNumberEnd="5" />
                   </div>

                    <div className="tab-pane fade" id="nav-featured" role="tabpanel" aria-labelledby="nav-featured">
                       <CourseItems :itemNumberStart='4' :itemNumberEnd="6" />
                   </div>

                   <div className="tab-pane fade" id="nav-art-design" role="tabpanel" aria-labelledby="nav-art-design">
                     <CourseItems :itemNumberStart='3' :itemNumberEnd="6" />
                  </div>

               </div>
            </div>
         </section>
</template>

<script>
import CourseItems from '../courseItems/CoursesItems.vue';

export default {
   name:'homeCourse',
   components:{CourseItems}
};
</script>
