<template>
  <Header />
  <Events />
  <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import Events from '../components/HomeTwo/Events.vue';
import Footer from '../components/HomeTwo/Footer.vue';

export default {
  name: 'EventsPage',
  components: {
    Header,
    Events,
    Footer,
  },
};
</script>
