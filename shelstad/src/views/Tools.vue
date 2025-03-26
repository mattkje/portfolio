<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
import ToolCard from "@/components/ToolCard.vue";

interface Tool {
  id: number;
  name: string;
  description: string;
  iconId: number;
  screenshot: string;
  price: number;
  link: string;
}

const tools = ref<Tool[] | null>(null);

const fetchTools = async () => {
  try {
    const response = await fetch('http://localhost:8080/api/tools');
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data: Tool[] = await response.json();
    tools.value = data;
  } catch (error) {
    console.error('Failed to fetch games:', error);
  }
};

const router = useRouter();

const navigateToToolView = (tool: Tool) => {
  router.push({ name: 'ToolPage', params: { id: tool.id } });
};

onMounted(fetchTools);
</script>

<template>
  <div class="game-store">
    <h1>Tools</h1>
    <div class="game-grid">
      <ToolCard
          v-for="tool in tools || []"
          :key="tool.id"
          :id="tool.id"
          :title="tool.name"
          :description="tool.description"
          :icon-id="tool.iconId"
          :link="tool.link"
          :price="tool.price"
          @game-clicked="navigateToToolView"
      />
    </div>
  </div>
</template>

<style scoped>
.game-store {
  text-align: left;
  padding: 5rem 2rem 0 2rem;
}

.game-grid {
  max-width: 1920px;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(400px, 1fr));
  gap: 1rem;
  margin: auto;
}
</style>