<template>
  <Header header__white="header__white" />
  <Breadcrumb title="Instructor" subtitle="Instructor" />
  <InstructorArea />
  <BannerArea />
  <Footer footerPadding="true" />
</template>

<script>
import Header from "../components/HomeTwo/Header.vue";
import Breadcrumb from "../components/common/Breadcrumb.vue";
import InstructorArea from "../components/Instructor/InstructorArea.vue";
import BannerArea from "../components/HomeTwo/BannerArea.vue";
import Footer from "../components/HomeTwo/Footer.vue";

export default {
  name: "InstructorPage",
  components: {
    Header,
    Breadcrumb,
    InstructorArea,
    BannerArea,
    Footer,
  },
};
</script>
