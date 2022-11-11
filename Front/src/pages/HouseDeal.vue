<template>
  <Header />
  <MapArea />
</template>

<script>
import Header from '../components/HomeTwo/Header.vue';
import MapArea from '../components/MapPage/MapArea.vue';

export default {
  name: 'HouseDeal',
  components: {
    Header,
    MapArea,
  },
};
</script>
