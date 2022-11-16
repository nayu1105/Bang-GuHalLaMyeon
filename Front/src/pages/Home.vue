<template>
  <div>
    <Header />
    <HeroArea />
    <BannerArea />
    <Events />
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '../components/Home/Header.vue';
import BannerArea from '../components/Home/BannerArea.vue';
import Events from '../components/Home/Events.vue';
import HeroArea from '../components/Home/HeroArea.vue';
import Footer from '../components/Home/Footer.vue';

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
