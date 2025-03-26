<script setup lang="ts">
import { defineProps } from 'vue';

interface Icon {
  id: number;
  fileName: string;
  filePath: string;
}

const props = defineProps<{ icon: Icon }>();
</script>

<template>
  <div class="icon-button">
      <img :src="`http://localhost:8080/api/icons/${props.icon.fileName}`" :alt="props.icon.fileName.split('.')[0]" class="icon-image" />
  </div>
</template>

<style scoped>
.icon-button {
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid #e3e3e3;
  border-radius: 1rem;
  padding: 1rem;
  cursor: pointer;
  transition: transform 0.3s;
}

.icon-button:hover {
  transform: scale(1.1);
}

.icon-image {
  width: 100px;
  height: auto;
  border-radius: 1rem;
}
</style>