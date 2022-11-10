<template>
   <Header/>
   <HeroSlider/>
   <About/>
   <Brand/>
   <Course/>
   <Teachers/>
   <Cta/>
   <Testimonial/>
   <WhyArea/>
   <Blog/>
   <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/HomeThree/Header.vue';
import HeroSlider from '../components/HomeThree/HeroSlider.vue';
import About from '../components/common/AboutArea.vue';
import Brand from '../components/common/BrandArea.vue';
import Course from '../components/HomeThree/Courses.vue';
import Teachers from '../components/HomeThree/Teachers.vue';
import Cta from '../components/HomeThree/Cta.vue';
import Testimonial from '../components/HomeThree/Testimonial.vue';
import WhyArea from '../components/HomeTwo/WhyArea.vue';
import Blog from '../components/HomeTwo/Blog.vue';
import Footer from '../components/Home/Footer.vue';

export default {
   name:'HomeThree',
   components:{
      Header,
      HeroSlider,
      About,
      Brand,
      Course,
      Teachers,
      Cta,
      Testimonial,
      WhyArea,
      Blog,
      Footer,
   }
};
</script>
