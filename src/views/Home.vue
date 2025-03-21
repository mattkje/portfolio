<script setup>
import { onMounted, onUnmounted } from 'vue';
import Brands from "@/components/Brands.vue";
import Project from "@/components/Project.vue";
import Hero from "@/components/Hero.vue";
import Menubar from "@/components/Menubar.vue";
import partyPoopersImage from '@/assets/images/projects/party-poopers.png';
import warehouseSimulatorImage from '@/assets/images/projects/wws.svg';
import learniverseConnectImage from '@/assets/images/projects/learniverse-connect.svg';
import pathsImage from '@/assets/images/projects/paths.png';
import Skills from "@/components/Skills.vue";

onMounted(() => {
  const menubar = document.querySelector('.menubar');
  const handleScroll = () => {
    if (window.scrollY > 0) {
      menubar.classList.add('scrolled');
    } else {
      menubar.classList.remove('scrolled');
    }
  };
  window.addEventListener('scroll', handleScroll);
  onUnmounted(() => {
    window.removeEventListener('scroll', handleScroll);
  });
});


</script>

<template>
  <Menubar class="menubar"/>
  <div class="container">
    <Hero />
    <Skills/>
    <header>
      <div class="brands">
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
      </div>
    </header>
    <h1>Featured Projects</h1>
    <div class="project-grid">
      <Project
          date="Spring 2023"
          :icon="pathsImage"
          name="Paths"
          description="Final Project for Programming 2 Course"
          link="https://mattkje.github.io/"
      />
      <Project
          date="Spring 2024"
          :icon="learniverseConnectImage"
          name="Learniverse Connect"
          description="Final Project for Web Development Course"
          link="https://mattkje.github.io/"
      />
      <Project
          date="Fall 2024"
          :icon="partyPoopersImage"
          name="Party Poopers"
          description="Final Project for Game Development Course"
          link="https://shelstad.itch.io/party-poopers"
      />
      <Project
          date="Spring 2025"
          :icon="warehouseSimulatorImage"
          name="Warehouse Simulator (WWS)"
          description="Bachelor's Thesis Project"
          link="https://github.com/mattkje/group01-bachelor-2025"
      />
    </div>
  </div>
</template>

<style scoped>
.container {
  margin: 0;
}

.menubar {
  background-color: white;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  transition: box-shadow 0.3s ease;
}

.menubar.scrolled {
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

.brands {
  display: flex;
  flex-direction: row;
}

.project-grid {
  margin: 5rem;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1rem;
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
