<template>
  <div>
    <Header />
    <h4>BookMark</h4>
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '../components/Home/Header.vue';
import Footer from '../components/Home/Footer.vue';

export default {
  name: 'BookMarkPage',
  components: {
    Header,
    Footer,
  },
};
</script>
