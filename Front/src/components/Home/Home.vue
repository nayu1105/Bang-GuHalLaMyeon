<template>
  <div>
    <HeroArea />
    <BannerArea />
    <Events />
  </div>
</template>

<script>
import BannerArea from '@/components/Home/BannerArea.vue';
import Events from '@/components/Events/Events.vue';
import HeroArea from '@/components/Home/HeroArea.vue';

export default {
  name: 'HomePage',
  components: {
    HeroArea,
    BannerArea,
    Events,
  },
};
</script>
