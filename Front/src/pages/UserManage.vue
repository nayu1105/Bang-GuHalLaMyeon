<template>
  <Header headerShadow="header__area header__padding header__padding-2 header__shadow " />
  <h4>User Manage</h4>
  <Footer footerPadding="true" />
</template>

<script>
import Header from "../components/HomeTwo/Header.vue";
import Footer from "../components/HomeTwo/Footer.vue";

export default {
  name: "UserManage",
  components: {
    Header,
    Footer,
  },
};
</script>
