<template>
  <section class="blog__area pt-120 pb-120">
      <div class="container">
         <div class="row">
            <div class="col-xxl-8 col-xl-8 col-lg-8">
               <div class="row">

                  <div v-for="blog in blogItems" :key="blog.id" 
                  class="col-xxl-6 col-xl-6 col-lg-6 col-md-6">
                     <div class="blog__wrapper">
                        <div class="blog__item white-bg mb-30 transition-3 fix">
                           <div class="blog__thumb w-img fix">
                              <router-link :to="`/blog-details/${blog.id}`">
                                 <img :src="blog.blogImg" alt="">
                              </router-link>
                           </div>
                           <div class="blog__content">
                              <div class="blog__tag">
                                 <a href="#" :class="blog.color">{{blog.category}}</a>
                              </div>
                              <h3 class="blog__title">
                                 <router-link :to="`/blog-details/${blog.id}`">
                                 {{blog.title}}</router-link>
                              </h3>
   
                              <div class="blog__meta d-flex align-items-center justify-content-between">
                                 <div class="blog__author d-flex align-items-center">
                                    <div class="blog__author-thumb mr-10">
                                       <img :src="blog.authorImg" alt="">
                                    </div>
                                    <div class="blog__author-info">
                                       <h5>{{blog.authorName}}</h5>
                                    </div>
                                 </div>
                                 <div class="blog__date d-flex align-items-center">
                                    <i class="fal fa-clock"></i>
                                    <span>{{blog.date}}</span>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- Pagination start -->
               <Pagination/>
               <!-- Pagination end -->
            </div>
            <!-- BlogRightSide start  -->
            <BlogRightSide/>
            <!-- BlogRightSide end  -->
         </div>
      </div>
   </section>
</template>

<script>
import Pagination from '../common/Pagination.vue';
import BlogRightSide from './BlogRightSide.vue';
import BlogMixin from '../../mixins/blogMixin';

export default {
   name:'BlogArea',
   mixins:[BlogMixin],
   components:{
      Pagination,
      BlogRightSide,
   }
};
</script>
