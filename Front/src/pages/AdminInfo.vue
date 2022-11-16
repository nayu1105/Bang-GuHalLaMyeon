<template>
  <div>
    <Header />
    <h4>admin Info</h4>
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import Footer from '../components/HomeTwo/Footer.vue';

export default {
  name: 'HomeTwo',
  components: {
    Header,
    Footer,
  },
};
</script>
