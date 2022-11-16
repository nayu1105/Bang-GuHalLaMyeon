<template>
  <Header headerShadow="header__area header__padding header__padding-2 header__shadow " />
  <InstructorDetailsArea />
  <Footer footerPadding="true" />
</template>

<script>
import Header from "../components/HomeTwo/Header.vue";
import InstructorDetailsArea from "../components/InstructorDetails/InstructorDetailsArea.vue";
import Footer from "../components/HomeTwo/Footer.vue";

export default {
  name: "InstructorDetails",
  components: {
    Header,
    InstructorDetailsArea,
    Footer,
  },
};
</script>
