<template>
  <div>
    <MapCityBtn></MapCityBtn>
    <MapArea></MapArea>
    <MapSidebar></MapSidebar>
  </div>
</template>

<script>
import MapArea from '@/components/House/MapArea.vue';
import MapSidebar from '@/components/House/MapSidebar.vue';
import MapCityBtn from '@/components/House/MapCityBtn.vue';

export default {
  name: 'HouseDeal',
  components: {
    MapArea,
    MapSidebar,
    MapCityBtn,
  },
};
</script>
