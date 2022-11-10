<template>
  <Header header__white="header__white" />
  
  <section class="page__title-area page__title-height-2 page__title-overlay d-flex align-items-center" :style="{background:'url('+require('../assets/img/page-title/page-title-3.jpg')+')',backgroundPosition:'center',backgroundSize:'cover',backgroundRepeat:'no-repeat'}">
   <div class="page__title-shape">
      <img class="page-title-shape-1" src="../assets/img/page-title/page-title-shape-1.png" alt="">
      <img class="page-title-shape-2" src="../assets/img/page-title/page-title-shape-2.png" alt="">
      <img class="page-title-shape-3" src="../assets/img/page-title/page-title-shape-3.png" alt="">
      <img class="page-title-shape-4" src="../assets/img/page-title/page-title-shape-4.png" alt="">
   </div>
   <div class="container">
      <div class="row">
         <div class="col-xxl-10 col-xl-10 col-lg-10 ">
            <div class="page__title-wrapper mt-110">
               <span class="page__title-pre">{{blog.category}}</span>
               <h3 class="page__title-2">{{blog.title}}</h3> 
               <div class="blog__meta d-flex align-items-center">
                  <div class="blog__author d-flex align-items-center mr-40">
                     <div class="blog__author-thumb mr-10">
                        <img :src="blog.authorImg" alt="">
                     </div>
                     <div class="blog__author-info blog__author-info-2">
                        <h5>{{blog.authorName}}</h5>
                     </div>
                  </div>
                  <div class="blog__date blog__date-2 d-flex align-items-center">
                     <i class="fal fa-clock"></i>
                     <span>{{blog.date}}</span>
                  </div>
               </div>                      
            </div>
         </div>
      </div>
   </div>
</section>

   <section class="blog__area pt-120 pb-120">
      <div class="container">
         <div class="row">
            <div class="col-xxl-8 col-xl-8 col-lg-8">
               <div class="blog__wrapper">
                  <div class="blog__text mb-40">
                     <p>Me old mucker argy-bargy  I'm telling pear shaped Jeffrey super brilliant, I excuse my French blatant gormless up the duff, cup of char up the kyver tosser cras happy days. The full monty he nicked it he legged it bum bag burke plastered arse over tit it's your round owt to do with me pardon you, on your bike mate hanky panky mush cuppa only a quid crikey Jeffrey skive off, faff about so I said what a load of rubbish blag David knees up cockup cras. Argy-bargy give us a bell wellies gosh skive off old bodge cheesed off A bit of how's your father off his nut bamboozled, bugger say I'm telling morish bleeding boot up the kyver nice one brilliant, ruddy jolly good fanny around chinwag amongst brown bread arse brolly. Horse play it's all gone to pot codswallop easy peasy mush knees up down the pub jolly good nice one tosser it's your round lurgy, I vagabond barmy off his nut only a quid so I said is gosh Charles blow off, pardon me chip shop Richard spiffing skive off bleeding get stuffed mate porkies amongst the full monty.</p>
                  </div>
                  <div class="blog__quote grey-bg mb-45 p-relative fix">
                     <img class="quote" src="../assets/img/blog/quote-1.png" alt="">
                     <blockquote>
                        <p>After I started learning design with Quillow, I realized that I had Improved to very advanced levels.</p>
                        <h4>Chris Collins</h4>
                     </blockquote>
                  </div>
                  <div class="blog__text mb-30">
                     <p>Horse play it's all gone to pot codswallop easy peasy mush knees up down the pub jolly good nice one tosser it's your round lurgy, I vagabond barmy off his nut only a quid so I said is gosh Charles blow off, pardon me chip shop Richard spiffing skive off bleeding get stuffed mate porkies amongst the full monty. Daft burke you</p>
                  </div>
                  <div class="blog__link mb-35">
                     <p>The little rotter bum bag a blinding shot gosh spifing butty eatonwha load of rubbish bamboozled. <a href="#"> https://educal.com/courses</a> </p>
                  </div>
                  <div class="blog__img w-img mb-45" >
                     <img :src="blog.blogImg" alt="">
                  </div>
                  <div class="blog__text mb-40">
                     <h3>Build a beautiful website with Quillow</h3>
                     <p>Some dodgy chav car boot blower starkers bonnet tickety-boo no biggie cheesed off, Oxford bloke fantastic the wireless bevvy cobblers chancer give us a bell, bleeder jolly good hanky panky do one gormless matie boy. Pear shaped my good sir I cobblers at public school quaint tickety-boo crikey bits and bobs, wellies bugger all mate golly gosh brolly matie boy fanny around chimney pot cracking goal my lady, bodge so I said spiffing posh the full monty don't get shirty with me no biggie.</p>

                     <p>Brolly grub blimey victoria sponge blag nancy boy don't get shirty with me skive off bobby burke in my flat bog-standard, easy peasy golly gosh up the duff show off show off pick your nose and blow off gosh a brilliant that what a load of rubbish.</p>
                  </div>
                  <div class="blog__line"></div>
                  <div class="blog__meta-3 d-sm-flex justify-content-between align-items-center mb-80">
                     <div class="blog__tag-2">
                        <a href="#">Art & Design</a>
                        <a href="#">Education</a>
                        <a href="#">App</a>
                     </div>
                     <div class="blog__social d-flex align-items-center">
                        <h4>Share:</h4>
                        <ul>
                           <li><a href="#" class="fb" >
                              <i class="fab fa-facebook-f"></i>
                              </a></li>
                           <li><a href="#" class="tw" >
                              <i class="fab fa-twitter"></i>
                              </a></li>
                           <li><a href="#" class="pin" >
                              <i class="fab fa-pinterest-p"></i>
                              </a></li>
                        </ul>
                     </div>
                  </div>
                  <div class="blog__author-3 d-sm-flex grey-bg mb-90">
                     <div class="blog__author-thumb-3 mr-20">
                        <img :src="blog.authorImg" alt="">
                     </div>
                     <div class="blog__author-content">
                        <h4>{{blog.authorName}}</h4>
                        <span>Author</span>
                        <p>So I said blower wellies a blinding shot jolly good argy-bargy he nicked it, in my flat don't get shirty with me tosser.</p>
                     </div>
                  </div>
                  <div class="blog__recent mb-65">
                     <div class="section__title-wrapper mb-40">
                        <h2 class="section__title">Related <span class="yellow-bg-sm">Post <img src="../assets/img/shape/yellow-bg-4.png" alt="">  </span></h2>
                        <p>You don't have to struggle alone, you've got our assistance and help.</p>
                     </div>
                     <div class="row">
                        <div v-for="blog in blogItems.slice(0,2)" :key="blog.id" class="col-xxl-6 col-xl-6 col-lg-6 col-md-6">
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

                  <!-- latest comment start -->
                  <LatestComment/>
                  <!-- latest comment end -->

                  <!-- blog comment start -->
                  <BlogWriteComment/>
                  <!-- blog comment end -->
               </div>
            </div>
            <!-- BlogRightSide start -->
            <BlogRightSide/>
            <!-- BlogRightSide end -->
         </div>
      </div>
    </section>
  <Footer footerPadding="true" />
</template>

<script>
import BlogItemMixin from '../mixins/blogMixin';
import Header from '../components/Home/Header.vue';
import LatestComment from '../components/BlogDetails/LatestComment.vue';
import BlogWriteComment from '../components/BlogDetails/BlogWriteComment.vue';
import BlogRightSide from '../components/Blog/BlogRightSide.vue';
import Footer from '../components/Home/Footer.vue';

export default {
  name: "BlogDetails",
  mixins: [BlogItemMixin],
  components:{
     Header,
     LatestComment,
     BlogWriteComment,
     BlogRightSide,
     Footer,
  },
    data() {
        return {
            id: this.$route.params.id,
            blog: {}
        }
    },
    methods: {
        getBlog(blogId) {
            this.blog = this.blogItems.find(item => item.id == blogId);
        }
    },
    created() {
        this.getBlog(this.id);
    }
};
</script>
