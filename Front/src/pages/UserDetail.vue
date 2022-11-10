<template>
  <Header headerShadow="header__area header__padding header__padding-2 header__shadow " />
  <SignUpArea />
  <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import SignUpArea from '../components/SignUp/SignUpArea.vue';
import Footer from '../components/Home/Footer.vue';

export default {
  name: 'UserDetail',
  components: {
    Header,
    SignUpArea,
    Footer,
  },
};
</script>
