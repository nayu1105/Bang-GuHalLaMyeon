<template>
  <Header />
  <HeroArea />
  <!-- <Services /> -->
  <!-- <AboutArea /> -->
  <!-- <Courses /> -->
  <!-- <WhatArea /> -->
  <!-- <WhyArea /> -->
  <!-- <Counter /> -->
  <!-- <Testimonial /> -->
  <!-- <Blog /> -->
  <!-- <Cta /> -->
  <BannerArea />
  <Events />
  <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import BannerArea from '../components/HomeTwo/BannerArea.vue';
import Events from '../components/HomeTwo/Events.vue';
import HeroArea from '../components/HomeTwo/HeroArea.vue';
// import Services from '../components/HomeTwo/Services.vue';
// import AboutArea from '../components/common/AboutArea.vue';
// import Courses from '../components/Home/Course.vue';
// import WhatArea from '../components/HomeTwo/WhatArea.vue';
// import WhyArea from '../components/HomeTwo/WhyArea.vue';
// import Counter from '../components/HomeTwo/Counter.vue';
// import Testimonial from '../components/HomeTwo/Testimonial.vue';
// import Blog from '../components/HomeTwo/Blog.vue';
import Footer from '../components/HomeTwo/Footer.vue';

export default {
  name: 'HomeTwo',
  components: {
    Header,
    HeroArea,
    BannerArea,
    Events,
    //    Services,
    //    AboutArea,
    //    Courses,
    //    WhatArea,
    //    WhyArea,
    //    Counter,
    //    Testimonial,
    //    Blog,
    Footer,
  },
};
</script>
