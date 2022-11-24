<template>
  <div>
    <HeroArea />
    <Boards />
  </div>
</template>

<script>
import Boards from "@/components/Boards/Boards.vue";
import HeroArea from "@/components/Home/HeroArea.vue";

export default {
  name: "HomePage",
  components: {
    HeroArea,
    Boards,
  },
};
</script>
