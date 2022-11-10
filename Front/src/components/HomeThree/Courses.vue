<template>
   <section class="course__area grey-bg pt-115 pb-120">
      <div class="container">
         <div class="row align-items-end">
            <div class="col-xxl-6 col-xl-6 col-lg-6 col-md-8">
               <div class="section__title-wrapper mb-60">
                  <h2 class="section__title">Online<span class="yellow-bg"> Courses <img src="assets/img/shape/yellow-bg-2.png" alt="">  </span> <br> For anyone, anywhere 
                  </h2>
                  <p>You don't have to struggle alone, you've got our assistance and help.</p>
               </div>
            </div>
            <div class="col-xxl-6 col-xl-6 col-lg-6 col-md-4">
               <div class="category__more mb-60 float-md-end fix">
                  <router-link to="/courses" class="link-btn">
                     View All Courses
                     <i class="far fa-arrow-right"></i>
                     <i class="far fa-arrow-right"></i>
                  </router-link>
               </div>
            </div>
         </div>
         <div class="row">
            <div v-for="course in courseItems.slice(0,2)" :key="course.id" 
            class="col-xxl-6 col-xl-6 col-lg-6 col-md-6">
               <div class="course__item course__item-2 white-bg mb-30 transition-3">
                  <div class="course__thumb fix w-img">
                    <router-link :to="`/course-details/${course.id}`">
                        <img :src="course.courseImage" alt="">
                     </router-link>
                  </div>
                  <div class="course__content-2">
                     <h3 class="course__title-2">
                        <router-link :to="`/course-details/${course.id}`">
                           {{course.title.substring(0,35)}}...</router-link>
                     </h3>
                     <p>Top instructors from around the world teach millions of students on Quillow. Get unlimited.</p>
                     <div class="course__bottom d-sm-flex justify-content-between align-items-center">
                        <div class="course__teacher-2 d-flex align-items-center">
                           <div class="course__teacher-thumb-2 mr-20">
                              <img :src="course.teacherImg" alt="">
                              <div class="course__teacher-rating">
                                 <i class="fal fa-star"></i>
                              </div>
                           </div>
                           <div class="course__teacher-info">
                              <h6>
                                 <router-link to="/instructor-details">
                                 {{course.teacherName}}</router-link>
                              </h6>
                              <span>{{course.category.concat('er')}}</span>
                           </div>
                        </div>
                        <div class="course__meta">
                           <div class="course__lesson">
                              <span><i class="far fa-book-alt"></i>{{course.lesson}} Lesson</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
</template>

<script>
import CoursesMixin from '../../mixins/courseItemsMixin';
export default {
   name:'CourseArea',
   mixins:[CoursesMixin]
};
</script>
