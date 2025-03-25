<script setup>


import IconButton from "@/components/IconButton.vue";
import MkIcon from "@/assets/logo.svg";
import GitHubIcon from "@/assets/icons/git.png";
</script>

<template>
  <div class="main-store-container">
    <div class="icon-grid">
      <IconButton title="MK" :icon="MkIcon" />
      <IconButton title="GitHub" :icon="GitHubIcon" />
    </div>
  </div>
</template>

<style scoped>
.main-store-container {
  text-align: center;
  margin-top: 100px;
  padding: 2rem;
}

.icon-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
  gap: 1rem;
  margin-top: 2rem;
}
</style>