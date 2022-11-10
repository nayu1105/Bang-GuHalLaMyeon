<template>
   <Header header__white="header__white" />
   <Breadcrumb title="Courses" subtitle="Courses" />
   <CoursesListArea/>
   <Footer footerPadding="true"/>
</template>

<script>
import Header from '../components/Home/Header.vue';
import Breadcrumb from '../components/common/Breadcrumb.vue';
import CoursesListArea from '../components/CoursesList/CoursesList.vue';
import Footer from '../components/Home/Footer.vue';

export default {
   name:'CoursesList',
   components:{
      Header,
      Breadcrumb,
      CoursesListArea,
      Footer
   }
};
</script>
