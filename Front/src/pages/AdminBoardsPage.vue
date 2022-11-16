<template>
  <div>
    <Header />
    <Boards />
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '../components/Home/Header.vue';
import Boards from '../components/Boards/Boards.vue';
import Footer from '../components/Home/Footer.vue';

export default {
  name: 'AdminBoardsPage',
  components: {
    Header,
    Boards,
    Footer,
  },
};
</script>
