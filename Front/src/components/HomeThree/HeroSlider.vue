<template>
  <section class="slider__area p-relative">
    <div class="slider__wrapper swiper-container">
      <swiper ref="mySwiper" :modules="modules" :effect="'fade'" 
      :loop="true" :autoplay="{delay: 5000}">

        <swiper-slide >
            <div class="single-slider swiper-slide slider__height slider__overlay d-flex align-items-center" :style="{background:'url('+ require(`@/assets/img/slider/slider-4.jpg`)+')'}">
                    <div class="container">
                    <div class="row">
                        <div class="col-xxl-7 col-xl-8 col-lg-9 col-md-9 col-sm-10">
                            <div class="slider__content">
                                <span>Learn & Achieve</span>
                                <h3 class="slider__title">Find the right Online <span class="yellow-bg">tutor <img src="../../assets/img/shape/yellow-bg.png" alt=""> </span> for you.</h3>
                                <p>Meet university,and cultural institutions, who'll share their experience.</p>
                                <router-link to="/about" class="e-btn slider__btn">Ready to get Started?</router-link>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
        </swiper-slide>

        <swiper-slide >
            <div class="single-slider swiper-slide slider__height slider__overlay d-flex align-items-center" :style="{background:'url('+ require(`@/assets/img/slider/slider-1.jpg`)+')'}">
                    <div class="container">
                    <div class="row">
                        <div class="col-xxl-7 col-xl-8 col-lg-9 col-md-9 col-sm-10">
                            <div class="slider__content">
                                <span>Learn & Achieve</span>
                                <h3 class="slider__title">Become a product  <span class="yellow-bg">Manager <img src="../../assets/img/shape/yellow-bg.png" alt=""> </span> & learn.</h3>
                                <p>Meet university,and cultural institutions, who'll share their experience.</p>
                                <router-link to="/about" class="e-btn slider__btn">Ready to get Started?</router-link>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
        </swiper-slide>

        <swiper-slide >
            <div class="single-slider swiper-slide slider__height slider__overlay d-flex align-items-center" :style="{background:'url('+ require(`@/assets/img/slider/slider-2.jpg`)+')'}">
                    <div class="container">
                    <div class="row">
                        <div class="col-xxl-7 col-xl-8 col-lg-9 col-md-9 col-sm-10">
                            <div class="slider__content">
                                <span>Learn & Achieve</span>
                               <h3 class="slider__title">Launch your <span class="yellow-bg">online <img src="../../assets/img/shape/yellow-bg.png" alt=""> </span> learning Platform.</h3>
                                <p>Meet university,and cultural institutions, who'll share their experience.</p>
                                <router-link to="/about" class="e-btn slider__btn">Ready to get Started?</router-link>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
        </swiper-slide>

        <swiper-slide >
            <div class="single-slider swiper-slide slider__height slider__overlay d-flex align-items-center" :style="{background:'url('+ require(`@/assets/img/slider/slider-3.jpg`)+')'}">
                    <div class="container">
                    <div class="row">
                        <div class="col-xxl-7 col-xl-8 col-lg-9 col-md-9 col-sm-10">
                            <div class="slider__content">
                                <span>Learn & Achieve</span>
                                <h3 class="slider__title">Fundamentals of music <span class="yellow-bg">theory <img src="../../assets/img/shape/yellow-bg.png" alt=""> </span> Learn</h3>
                                <p>Meet university,and cultural institutions, who'll share their experience.</p>
                                <router-link to="/about" class="e-btn slider__btn">Ready to get Started?</router-link>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
        </swiper-slide>

      </swiper>
    </div>

    <div class="row g-0">
      <div v-for="item in sliderNavData" :key="item.id" 
      class="d-none d-md-block col-md-6 col-lg-3">
        <div
          :class="`slider__nav-item swiper-slide ${item.bgColor}`"
          :style="{background:'url('+ item.img +')'}"
        >
          <div class="slider__nav-content">
            <span>{{item.title}}</span>
            <h4>{{item.subtitle}}</h4>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { Swiper, SwiperSlide } from "swiper/vue";
import { Navigation, EffectFade, Autoplay } from "swiper";

export default {
  name: "HeroSlider",
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      sliderData: [
        {
          id: 1,
          img: require(`@/assets/img/slider/slider-4.jpg`),
          title:
            'Find the right Online <span class="yellow-bg">tutor <img src="img/shape/yellow-bg.png" alt=""> </span> for you.',
        },
        {
          id: 2,
          img: require(`@/assets/img/slider/slider-1.jpg`),
          title:
            'Fundamentals of music <span class="yellow-bg">theory <img src="../../assets/img/shape/yellow-bg.png" alt=""> </span> Learn',
        },
        {
          id: 3,
          img: require(`@/assets/img/slider/slider-2.jpg`),
          title:
            'Become a product  <span class="yellow-bg">Manager <img src="../../assets/img/shape/yellow-bg.png" alt=""> </span> & learn.',
        },
        {
          id: 4,
          img: require(`@/assets/img/slider/slider-3.jpg`),
          title:
            'Launch your <span class="yellow-bg">online <img src="../../assets/img/shape/yellow-bg.png" alt=""> </span> learning Platform.',
        },
      ],
      sliderNavData: [
        {
          id: 1,
          img: require(`@/assets/img/slider/nav/slider-nav-4.jpg`),
          title: "6 Courses",
          subtitle: "Programming Languages",
          bgColor: "orange-bg",
        },
        {
          id: 2,
          img: require(`@/assets/img/slider/nav/slider-nav-1.jpg`),
          title: "4 Courses",
          subtitle: "Idea Discussion",
          bgColor: "blue-bg",
        },
        {
          id: 3,
          img: require(`@/assets/img/slider/nav/slider-nav-2.jpg`),
          title: "8 Courses",
          subtitle: "Web Development",
          bgColor: "pink-bg",
        },
        {
          id: 4,
          img: require(`@/assets/img/slider/nav/slider-nav-3.jpg`),
          title: "9 Courses",
          subtitle: "System Administration",
          bgColor: "green-bg",
        },
      ],
    };
  },
  setup() {
    return {
      modules: [Navigation, EffectFade, Autoplay],
    };
  },
};
</script>
