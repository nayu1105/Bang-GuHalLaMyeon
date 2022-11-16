<template>
  <div>
    <Header />
    <Events />
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '../components/Home/Header.vue';
import Events from '../components/Events/Events.vue';
import Footer from '../components/Home/Footer.vue';

export default {
  name: 'EventsPage',
  components: {
    Header,
    Events,
    Footer,
  },
};
</script>
