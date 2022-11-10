<template>
  <Header headerShadow="header__area header__padding header__padding-2 header__shadow "/>
  <EventDetailsArea/>
  <Footer footerPadding="true"/>
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import EventDetailsArea from '../components/EventDetails/EventDetailsArea.vue';
import Footer from '../components/Home/Footer.vue';

export default {
    name:'EventDetails',
    components:{
        Header,
        EventDetailsArea,
        Footer
    }
}
</script>

