<template>
  <Header header__white="header__white" />
  <Breadcrumb title="Checkout" subtitle="Checkout" />
  <CheckoutArea/>
  <Footer footerPadding="true" />
</template>

<script>
import Header from '../components/Home/Header.vue';
import Breadcrumb from '../components/common/Breadcrumb.vue';
import CheckoutArea from '../components/Checkout/CheckoutArea.vue';
import Footer from '../components/Home/Footer.vue';

export default {
    name:'CheckoutPage',
    components : {
        Header,
        Breadcrumb,
        CheckoutArea,
        Footer,
    }
}
</script>
