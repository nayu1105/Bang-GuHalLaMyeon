<template>
  <div>
    <Header headerShadow="header__area header__padding header__padding-2 header__shadow " />
    <h4>WriteReview</h4>
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '../components/Home/Header.vue';
import Footer from '../components/Home/Footer.vue';

export default {
  name: 'UserDetail',
  components: {
    Header,
    Footer,
  },
};
</script>
