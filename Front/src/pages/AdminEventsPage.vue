<template>
  <div>
    <Header />
    <AdminEvents />
    <Footer footerPadding="true" />
  </div>
</template>

<script>
import Header from '@/components/Home/Header.vue';
import AdminEvents from '@/components/Admin/AdminEvents.vue';
import Footer from '@/components/Home/Footer.vue';
import Header from "../components/Home/Header.vue";

export default {
  name: 'AdminEventsPage',
  components: {
    Header,
    AdminEvents,
    Footer
    Header,
  },
};
</script>
