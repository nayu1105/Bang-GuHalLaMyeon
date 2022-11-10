<template>
  <Header />
  <Boards />
  <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import Boards from '../components/HomeTwo/Boards.vue';
import Footer from '../components/HomeTwo/Footer.vue';

export default {
  name: 'AdminBoardsPage',
  components: {
    Header,
    Boards,
    Footer,
  },
};
</script>
