<template>
  <Header header__white="header__white" />
  <Breadcrumb title="Blog Grid" subtitle="Blog Grid" />
  <BlogArea/>
  <Footer footerPadding="true"/>
</template>

<script>
import Header from '../components/Home/Header.vue';
import Breadcrumb from '../components/common/Breadcrumb.vue';
import BlogArea from '../components/Blog/BlogArea.vue';
import Footer from '../components/Home/Footer.vue';

export default {
   name:'BlogPage',
   components:{
      Header,
      Breadcrumb,
      BlogArea,
      Footer,
   }
}
</script>

