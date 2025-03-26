<script setup lang="ts">
    import { ref, onMounted } from 'vue';
    import IconButton from '@/components/IconButton.vue';

    interface Icon {
      id: number;
      fileName: string;
      filePath: string;
    }

    const icons = ref<Icon[]>([]);

    const fetchIcons = async () => {
      const response = await fetch('http://localhost:8080/api/icons');
      icons.value = await response.json();
    };

    onMounted(() => {
      fetchIcons();
    });
    </script>

    <template>
      <div class="main-store-container">
        <div class="icon-grid">
          <IconButton v-for="icon in icons" :key="icon.id" :icon="icon" />
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