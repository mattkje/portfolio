<script setup lang="ts">
import { ref} from 'vue';
import { useRouter } from 'vue-router';
import ToolCard from "@/components/ToolCard.vue";
import { Tool } from "@/assets/types";
import jsonData from '@/assets/data.json';

const tools = ref<Tool[] | null>(jsonData.tables.tools);

const router = useRouter();

const navigateToToolView = (tool: Tool) => {
  router.push({ name: 'ToolPage', params: { id: tool.id } });
};
</script>

<template>
  <div class="game-store">
    <h1>Apps</h1>
    <div class="game-grid">
      <ToolCard
          v-for="tool in tools || []"
          :key="tool.id"
          :id="tool.id"
          :title="tool.name"
          :description="tool.description"
          :version="tool.version"
          :icon-id="tool.icon_id"
          :link="tool.link"
          :price="tool.price"
          :created-at="tool.created_at"
          @game-clicked="navigateToToolView"
      />
    </div>
  </div>
</template>

<style scoped>
.game-store {
  max-width: 1920px;
  text-align: left;
  padding: 5rem 2rem 0 2rem;
}

.game-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(400px, 1fr));
  gap: 1rem;
  margin: auto;
}
</style>