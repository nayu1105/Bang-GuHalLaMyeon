<template>
  <Header />
  <AdminEvents />
  <Footer footerPadding="true" />
</template>

<script>
import Header from "../components/Home/Header.vue";
// import AdminEvents from '../components/Home/AdminEvents.vue';
import Footer from "../components/Home/Footer.vue";

export default {
  name: "AdminEventsPage",
  components: {
    Header,
    // AdminEvents,
    Footer,
  },
};
</script>
