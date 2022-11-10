<template>
    <Header/>
    <HeroArea/>
    <Services/>
    <AboutArea/>
    <Courses/>
    <WhatArea/>
    <WhyArea/>
    <Counter/>
    <Testimonial/>
    <Blog/>
    <Cta/>
    <Footer footerPadding="true"/>
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import HeroArea from '../components/HomeTwo/HeroArea.vue';
import Services from '../components/HomeTwo/Services.vue';
import AboutArea from '../components/common/AboutArea.vue';
import Courses from '../components/Home/Course.vue';
import WhatArea from '../components/HomeTwo/WhatArea.vue';
import WhyArea from '../components/HomeTwo/WhyArea.vue';
import Counter from '../components/HomeTwo/Counter.vue';
import Testimonial from '../components/HomeTwo/Testimonial.vue';
import Blog from '../components/HomeTwo/Blog.vue';
import Footer from '../components/Home/Footer.vue';

export default {
   name:'HomeTwo',
   components:{
       Header,
       HeroArea,
       Services,
       AboutArea,
       Courses,
       WhatArea,
       WhyArea,
       Counter,
       Testimonial,
       Blog,
       Footer,
   }
}
</script>