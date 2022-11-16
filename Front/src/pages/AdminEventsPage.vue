<template>
  <Header />
  <AdminEvents />
  <Footer footerPadding="true" />
</template>

<script>
import Header from "../components/HomeTwo/Header.vue";
import AdminEvents from "../components/HomeTwo/AdminEvents.vue";
import Footer from "../components/HomeTwo/Footer.vue";

export default {
  name: "AdminEventsPage",
  components: {
    Header,
    AdminEvents,
    Footer,
  },
};
</script>
