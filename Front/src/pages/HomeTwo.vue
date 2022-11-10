<template>
  <Header />
  <HeroArea />
  <BannerArea />
  <Events />
  <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import BannerArea from '../components/HomeTwo/BannerArea.vue';
import Events from '../components/HomeTwo/Events.vue';
import HeroArea from '../components/HomeTwo/HeroArea.vue';
import Footer from '../components/HomeTwo/Footer.vue';

export default {
  name: 'HomeTwo',
  components: {
    Header,
    HeroArea,
    BannerArea,
    Events,
    Footer,
  },
};
</script>
