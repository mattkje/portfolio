<script setup lang="ts">
import {defineProps, ref, onMounted, getCurrentInstance} from 'vue';
import {Icon} from '@/assets/types';

const svgToPng = async (icon: Icon): Promise<string> => {
  const svg = `/data/icons/${icon.fileName}.png`

  const svgBlob = new Blob([svg], {type: 'image/svg+xml;charset=utf-8'});
  const url = URL.createObjectURL(svgBlob);

  const img = new Image();
  img.src = url;

  return new Promise<string>((resolve, reject) => {
    img.onload = () => {
      const canvas = document.createElement('canvas');
      canvas.width = 200;
      canvas.height = 200;
      const ctx = canvas.getContext('2d');
      if (ctx) {
        ctx.drawImage(img, 0, 0, 200, 200);
        URL.revokeObjectURL(url);
        resolve(canvas.toDataURL('image/png'));
      } else {
        reject(new Error('Failed to get canvas context'));
      }
    };
    img.onerror = (error) => {
      URL.revokeObjectURL(url);
      reject(error);
    };
  });
};

const props = defineProps<{ icon: Icon }>();

</script>

<template>
  <div class="icon-button" >
    <img :src="`/data/icons/${icon.fileName}.svg`" :alt="props.icon.fileName.split('.')[0]" class="icon-image"/>
    <div class="bottom-box">
      <p>{{ props.icon.fileName }}</p>
    </div>
  </div>
</template>

<style scoped>
.icon-button {
  display: flex;
  background: none;
  flex-direction: column;
  width: 110px;
  height: 130px;
  justify-content: flex-end;
  align-items: center;
  background: white;
  border: 1px solid var(--border-color);
  border-radius: 1.2rem;
  cursor: pointer;
  text-decoration: none;
  color: inherit;
  transition: transform 0.3s, box-shadow 0.3s;
}

.icon-button:hover {
  transform: scale(1.1);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
}

.bottom-box {
  background-color: var(--border-color);
  width: 100%;
  height: 30%;
  text-align: center;
  border-radius: 0 0 1rem 1rem;
}

.bottom-box p {
  font-size: 0.7rem;
  font-weight: 900;
  margin: 0.5rem auto;
}

.icon-image {
  width: 50px;
  height: 50px;
  margin: auto;
  object-fit: contain;
  border-radius: 0.5rem;
}
</style>