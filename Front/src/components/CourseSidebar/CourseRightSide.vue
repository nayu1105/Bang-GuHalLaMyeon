<template>
 <div class="col-xxl-4 col-xl-4 col-lg-4">
   <div class="course__sidebar pl-70">
      <div class="course__sidebar-search mb-50">
         <form action="#">
            <input type="text" placeholder="Search for courses...">
            <button type="submit">
               <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 584.4 584.4" style="enable-background:new 0 0 584.4 584.4;" xml:space="preserve">
                  <g>
                     <g>
                        <path class="st0" d="M565.7,474.9l-61.1-61.1c-3.8-3.8-8.8-5.9-13.9-5.9c-6.3,0-12.1,3-15.9,8.3c-16.3,22.4-36,42.1-58.4,58.4    c-4.8,3.5-7.8,8.8-8.3,14.5c-0.4,5.6,1.7,11.3,5.8,15.4l61.1,61.1c12.1,12.1,28.2,18.8,45.4,18.8c17.1,0,33.3-6.7,45.4-18.8    C590.7,540.6,590.7,499.9,565.7,474.9z"/>
                        <path class="st1" d="M254.6,509.1c140.4,0,254.5-114.2,254.5-254.5C509.1,114.2,394.9,0,254.6,0C114.2,0,0,114.2,0,254.5    C0,394.9,114.2,509.1,254.6,509.1z M254.6,76.4c98.2,0,178.1,79.9,178.1,178.1s-79.9,178.1-178.1,178.1S76.4,352.8,76.4,254.5    S156.3,76.4,254.6,76.4z"/>
                     </g>
                  </g>
               </svg>
            </button>
         </form>
      </div>
      <div class="course__sidebar-widget grey-bg">
         <div class="course__sidebar-info">
            <h3 class="course__sidebar-title">Categories</h3>
            <ul>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-eng">
                     <label class="m-check-label" for="m-eng">English  (6)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-edu">
                     <label class="m-check-label" for="m-edu">Education  (8)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-bus">
                     <label class="m-check-label" for="m-bus">Business  (5)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-design">
                     <label class="m-check-label" for="m-design">UX Design  (3)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-math">
                     <label class="m-check-label" for="m-math">Mathematics  (3)</label>
                  </div>
               </li>
            </ul>
         </div>
      </div>
      <div class="course__sidebar-widget grey-bg">
         <div class="course__sidebar-info">
            <h3 class="course__sidebar-title">Language</h3>
            <ul>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-all">
                     <label class="m-check-label" for="m-all">All Language</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-eng-2">
                     <label class="m-check-label" for="m-eng-2">English</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-russ">
                     <label class="m-check-label" for="m-russ">Russian</label>
                  </div>
               </li>
            </ul>
         </div>
      </div>
      <div class="course__sidebar-widget grey-bg">
         <div class="course__sidebar-info">
            <h3 class="course__sidebar-title">Price Filter</h3>
            <ul>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-all-course">
                     <label class="m-check-label" for="m-all-course">All  (204)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-free">
                     <label class="m-check-label" for="m-free">Free Courses  (36)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-premium">
                     <label class="m-check-label" for="m-premium">Premium Courses  (184)</label>
                  </div>
               </li>
            </ul>
         </div>
      </div>
      <div class="course__sidebar-widget grey-bg">
         <div class="course__sidebar-info">
            <h3 class="course__sidebar-title">Skill level</h3>
            <ul>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-level">
                     <label class="m-check-label" for="m-level">All Levels  (50)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-beginner">
                     <label class="m-check-label" for="m-beginner">Beginner  (32)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-intermediate">
                     <label class="m-check-label" for="m-intermediate">Intermediate  (17)</label>
                  </div>
               </li>
               <li>
                  <div class="course__sidebar-check mb-10 d-flex align-items-center">
                     <input class="m-check-input" type="checkbox" id="m-expert">
                     <label class="m-check-label" for="m-expert">Expert  (2)</label>
                  </div>
               </li>
            </ul>
         </div>
      </div>

      <!-- related course start -->
      <RelatedCourse/>
      <!-- related course end -->

   </div>
</div>
</template>

<script>
import RelatedCourse from '../common/RelatedCourse.vue';
export default {
   name:'CourseRightSide',
   components:{
      RelatedCourse,
   }
};
</script>

