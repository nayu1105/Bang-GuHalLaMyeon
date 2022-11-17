<template>
  <div>
    <MapArea></MapArea>
    <MapSidebar></MapSidebar>
  </div>
</template>

<script>
import MapArea from '@/components/House/MapArea.vue';
import MapSidebar from '@/components/House/MapSidebar.vue';

export default {
  name: 'HouseDeal',
  components: {
    MapArea,
    MapSidebar,
  },
};
</script>
