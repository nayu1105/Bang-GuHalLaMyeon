<template>
  <Header header__white="header__white" />
  <Breadcrumb title="Courses" subtitle="Courses" />
  <CourseSidebarArea />
  <Footer footerPadding="true" />
</template>

<script>
import Header from "../components/HomeTwo/Header.vue";
import Breadcrumb from "../components/common/Breadcrumb.vue";
import CourseSidebarArea from "../components/CourseSidebar/CourseSidebarArea.vue";
import Footer from "../components/HomeTwo/Footer.vue";

export default {
  name: "CourseSidebar",
  components: {
    Header,
    Breadcrumb,
    CourseSidebarArea,
    Footer,
  },
};
</script>
