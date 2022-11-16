<template>
  <div>
    <Header></Header>
    <MapArea></MapArea>
  </div>
</template>

<script>
import Header from "@/components/Home/Header.vue";
import MapArea from "@/components/Map/MapArea.vue";

export default {
  name: "HouseDeal",
  components: {
    Header,
    MapArea,
  },
};
</script>
