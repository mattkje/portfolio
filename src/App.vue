<script setup>

import Brands from "@/components/Brands.vue";
</script>

<template>
  <Brands
      image="https://yt3.googleusercontent.com/QvzqDJOtfThI4QVIqw3qORtKEmcE3zd97PCxOAVG0NMdWegygXFbUm7pPmSSfmC8SRH6Ue5Fpw=s160-c-k-c0x00ffffff-no-rj"
      :links="['https://shelstad.itch.io/', 'https://www.youtube.com/channel/UCCffG6dAJjgbZbw2p0KgVBQ']"
      name="Shelstad Studios"
      description="Personal Game Development Projects"
  />
  <Brands
      image="https://yt3.googleusercontent.com/IxJunmeSafWr3Y81_N_g1CZVHUuY6AOAHSOx2AFuetArLsSVojwksdHV2kyqkFzan5Kc_DhvDA=s160-c-k-c0x00ffffff-no-rj"
      :links="['https://www.youtube.com/@Triggas', 'https://github.com/mattkje']"
      name="TRGS"
      description="Personal Web Development Projects"
/>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
