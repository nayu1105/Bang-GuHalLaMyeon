<template>
  <div>
    <HeroArea />
    <BannerArea />
    <Boards />
  </div>
</template>

<script>
import BannerArea from "@/components/Home/BannerArea.vue";
import Boards from "@/components/Boards/Boards.vue";
import HeroArea from "@/components/Home/HeroArea.vue";

export default {
  name: "HomePage",
  components: {
    HeroArea,
    BannerArea,
    Boards,
  },
};
</script>
