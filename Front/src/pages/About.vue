<template>
  <Header header__white="header__white" />
  <Breadcrumb title="About" subtitle="About" />
  <AboutArea />
  <BrandArea />
  <Testimonial />
  <WhyArea />
  <CounterArea />
  <BannerArea />
  <Footer footerPadding="true" />
</template>

<script>
import Header from "../components/HomeTwo/Header.vue";
import Breadcrumb from "../components/common/Breadcrumb.vue";
import AboutArea from "../components/common/AboutArea.vue";
import BrandArea from "../components/common/BrandArea.vue";
import WhyArea from "../components/HomeTwo/WhyArea.vue";
import CounterArea from "../components/HomeTwo/Counter.vue";
import BannerArea from "../components/HomeTwo/BannerArea.vue";
import Footer from "../components/HomeTwo/Footer.vue";

export default {
  name: "AboutPage",
  components: {
    Header,
    Breadcrumb,
    AboutArea,
    BrandArea,
    WhyArea,
    CounterArea,
    BannerArea,
    Footer,
  },
};
</script>
