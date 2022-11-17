<template>
  <div>
    <Header headerShadow="header__area header__padding header__padding-2 header__shadow " />
    <router-view></router-view>
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '@/components/common/Header.vue';
import Footer from '@/components/common/Footer.vue';
export default {
  name: 'App',
  components: {
    Header,
    Footer,
  },
};
</script>
