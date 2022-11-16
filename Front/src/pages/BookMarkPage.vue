<template>
  <div>
    <Header header__white="header__white" />
    <Breadcrumb title="Courses" subtitle="Courses" />
    <BookMarkListArea />
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from "@/components/Home/Header.vue";
import BookMarkListArea from "@/components/BookMark/BookMarkList.vue";
import Footer from "@/components/Home/Footer.vue";

export default {
  name: "CoursesList",
  components: {
    Header,
    BookMarkListArea,
    Footer,
  },
};
</script>
