<template>
   <section id="sectionImg"
     class="hero__area hero__height hero__height-2 d-flex align-items-center blue-bg-3 p-relative fix"
   >
     <div class="container container-80">
       <div class="hero__content-wrapper mt-90">
         <div class="main-box align-items-center">
           <div class="col-xxl">
             <div class="hero__content hero__content-2 p-relative z-index-1">
               <h3 class="hero__title hero__title-2">
                 Find Your&nbsp;<span class="perfect">Perfect</span>&nbsp;Home <br />
                 
               </h3>
 
               <div class="hero__search">
                 <!--  -->
                 <div id="selectForm">
                   <select
                     id="selectDo"
                     class="form-select mt-5"
                     aria-label="Default select example"
                   >
                     <option selected>도/광역시</option>
                     <option value="1">One</option>
                     <option value="2">Two</option>
                   </select>
                   <select class="form-select mt-5" aria-label="Default select example">
                     <option selected>시/군/구</option>
                     <option value="1">One</option>
                     <option value="2">Two</option>
                   </select>
                   <select class="form-select mt-5 mb-5" aria-label="Default select example">
                     <option selected>동</option>
                     <option value="1">One</option>
                     <option value="2">Two</option>
                   </select>
 
                   <button type="button" class="btn btn-light mb-5">Search</button>
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
 export default {
   name: 'HeroArea',
 };
 </script>
 
 <style scoped>
 .form-select {
   width: 25%;
   margin-right: 5px;
   display: inline-block;
 }
 
 #selectForm {
    width: 80%;
   display: flex;
   justify-content: center;
 }
 
 .hero__title{
   display: flex;
   justify-content: center;
 }
 
 .container-80{
    width: 70%;
 }
 
 .main-box {
   display: flex;
   justify-content: center;
 }
 
 .hero__search{   
   display: flex;
   justify-content: center;
 }

 #sectionImg {
  background-image: url("../../assets/img/hero/home_bg2.jpg");
  background-size: cover;
 }

 .hero__title {
  color: white;
 }

 .perfect {
  color: rgb(240, 195, 50);
 }
 </style>
 