<template>
  <div>
    <Header headerShadow="header__area header__padding header__padding-2 header__shadow " />
    <BoardsDetailsArea></BoardsDetailsArea>
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '@/components/Home/Header.vue';
import BoardsDetailsArea from '@/components/Boards/BoardsDetailsArea.vue';
import Footer from '@/components/Home/Footer.vue';

export default {
  name: 'BoardsDetails',
  components: {
    Header,
    BoardsDetailsArea,
    Footer,
  },
};
</script>
