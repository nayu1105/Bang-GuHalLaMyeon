<template>
<section class="teacher__area pt-115 pb-110">
   <div class="container">
      <div class="row">
         <div class="col-xxl-6 offset-xxl-3">
            <div class="section__title-wrapper text-center mb-60">
               <h2 class="section__title">Our Most <br>
                  Popular <span class="yellow-bg"> Teachers <img src="assets/img/shape/yellow-bg-2.png" alt="">  </span> <br>
               </h2>
               <p>You don't have to struggle alone, you've got our assistance and help.</p>
            </div>
         </div>
      </div>
      <div class="row">
         <div v-for="instructor in instructorData" :key="instructor.id" 
         class="col-xxl-4 col-xl-4 col-lg-4 col-md-6">
            <div class="teacher__item text-center grey-bg-5 transition-3 mb-30">
               <div class="teacher__thumb w-img fix">
                  <a href="#">
                     <img :src="instructor.img" alt="">
                  </a>
               </div>
               <div class="teacher__content">
                  <h3 class="teacher__title">{{instructor.name}}</h3> 
                  <span> {{instructor.title}}</span>

                  <div class="teacher__social">
                     <ul>
                        <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fab fa-vimeo-v"></i></a></li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
</template>

<script>
export default {
   name:'InstructorArea',
   data () {
        return {
            instructorData:[
                {
                    id:1,
                    img:require(`@/assets/img/teacher/teacger-1.jpg`),
                    name:'Lillian Walsh,',
                    title:'CO Founder',
                },
                {
                    id:2,
                    img:require(`@/assets/img/teacher/teacher-2.jpg`),
                    name:'Kelly Franklin,',
                    title:'Designer',
                },
                {
                    id:3,
                    img:require(`@/assets/img/teacher/teacher-3.jpg`),
                    name:'Hilary Ouse,',
                    title:'Marketer',
                },
                {
                    id:4,
                    img:require(`@/assets/img/teacher/teacher-4.jpg`),
                    name:'Lillian Walsh,',
                    title:'CO Founder',
                },
                {
                    id:5,
                    img:require(`@/assets/img/teacher/teacher-5.jpg`),
                    name:'Shahnewaz,',
                    title:'Web Developer',
                },
                {
                    id:6,
                    img:require(`@/assets/img/teacher/teacher-6.jpg`),
                    name:'Nicola Tesla,,',
                    title:'Engineer',
                },
            ]
        }
    }
};
</script>
