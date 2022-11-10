<template>
  <Header header__white="header__white" />
  <Breadcrumb title="My Cart" subtitle="Cart" />
  <CartArea/>
  <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/Home/Header.vue';
import Breadcrumb from '../components/common/Breadcrumb.vue';
import CartArea from '../components/Cart/CartArea.vue';
import Footer from '../components/Home/Footer.vue';

export default {
    name:'CartPage',
    Header,
    Breadcrumb,
    components:{
        Header,
        Breadcrumb,
        CartArea,
        Footer,
    }
}
</script>

