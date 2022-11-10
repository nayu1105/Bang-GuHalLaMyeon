<template>
  <Header header__white="header__white" />
  <BlogDetailsArea/>
  <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/Home/Header.vue';
import BlogDetailsArea from '../components/BlogDetails/BlogDetailsArea.vue';
import Footer from '../components/Home/Footer.vue';

export default {
    name:'BlogDetails',
    components:{
        Header,
        BlogDetailsArea,
        Footer,
    }
}
</script>
