<script setup>
import Project from '@/components/Project.vue';
import pathsImage from "@/assets/images/projects/paths.png";
import learniverseConnectImage from "@/assets/images/projects/learniverse-connect.svg";
import partyPoopersImage from "@/assets/images/projects/party-poopers.svg";
import warehouseSimulatorImage from "@/assets/images/projects/wws.svg";
import baseBrwalersImage from "@/assets/images/projects/base-brawlers.png";
import gitLockerImage from "@/assets/images/projects/gitlocker.svg";
import theCarGameImage from "@/assets/images/projects/the-car-game.png";
import fitnessImage from "@/assets/images/projects/fitness.png";
import fluentiaImage from "@/assets/images/projects/fluentia.svg";
import econImage from "@/assets/images/projects/econ.png";

import {onMounted, onUnmounted} from "vue";

onMounted(() => {
  const elements = document.querySelectorAll('.scroll-animation, .project-grid-item-animation, .project-box, .vertical-timeline');

  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add('visible');
      } else {
        entry.target.classList.remove('visible');
      }
    });
  });

  elements.forEach(element => {
    observer.observe(element);
  });

  onUnmounted(() => {
    elements.forEach(element => {
      observer.unobserve(element);
    });
  });
});

const projects = [
  {
    date: "12/12/2024",
    title: "Party Poopers",
    description: "A 4-player multiplayer minigame bonanza",
    icon: partyPoopersImage,
    link: "",
    shelstadLink: "https://shelstad.store/game/1",
    context: 'School'
  },
  {
    date: "31/05/2023",
    title: "Paths",
    description: "Simple story game made in Java",
    icon: pathsImage,
    link: "https://github.com/mattkje/Paths",
    shelstadLink: "https://shelstad.store/game/2",
    context: 'School'
  },
  {
    date: "08/10/2024",
    title: "The Car Game",
    description: "Simple car game made in Unity",
    icon: theCarGameImage,
    link: "",
    shelstadLink: "https://shelstad.store/game/3",
    context: 'School'
  },
  {
    date: "20/05/2025",
    title: "WWS",
    description: "Warehouse Simulator",
    icon: warehouseSimulatorImage,
    link: "https://github.com/mattkje/group01-bachelor-2025",
    shelstadLink: "https://shelstad.store/tool/1",
    context: 'School'
  },
  {
    date: "23/05/2024",
    title: "Learniverse Connect",
    description: "Course store concept website",
    icon: learniverseConnectImage,
    link: "https://github.com/mattkje/course-project-team-5",
    shelstadLink: "https://shelstad.store/tool/3",
    context: 'School'
  },
  {
    date: "",
    title: "Base Brawlers",
    description: "Multiplayer team shooter made in unity",
    icon: baseBrwalersImage,
    link: "",
    shelstadLink: "https://shelstad.store/game/4",
    context: 'Solo'
  },
  {
    date: "16/10/2023",
    title: "GitLocker",
    description: "Simple git key manager made in java",
    icon: gitLockerImage,
    link: "",
    shelstadLink: "https://shelstad.store/tool/2",
    context: 'Solo'
  },
  {
    date: "",
    title: "Fluentia",
    description: "A speech training app for patients with aphasia",
    icon: fluentiaImage,
    link: "",
    shelstadLink: "https://shelstad.store/tool/4",
    context: 'Group'
  },
  {
    date: "02/12/2024",
    title: "G5 Fitness",
    description: "A personal fitness app",
    icon: fitnessImage,
    link: "https://github.com/AbsolutelyHaakon/FitnessApp-IDATA2503",
    shelstadLink: "https://shelstad.store/tool/5",
    context: 'School'
  },
  {
    date: "02/05/2023",
    title: "Econ&Me",
    description: "A personal and commercial finance app",
    icon: econImage,
    link: "https://github.com/mattkje/idata1002_2023_05",
    shelstadLink: "https://shelstad.store/tool/6",
    context: 'School'
  },
  // Add more projects as needed
];

// Function to parse date strings in the format "DD/MM/YYYY"
const parseDate = (dateString) => {
  if (!dateString) return null; // Handle empty date strings
  const [day, month, year] = dateString.split('/').map(Number);
  return new Date(year, month - 1, day);
};

// Sort projects by date, placing those without a date at the end
projects.sort((a, b) => {
  const dateA = parseDate(a.date);
  const dateB = parseDate(b.date);

  if (dateA === null) return 1; // a has no date, place it after b
  if (dateB === null) return -1; // b has no date, place it after a

  return dateB - dateA; // Sort by date in descending order
});
</script>

<template>
  <div class="timeline">
    <h1>Major Projects Timeline</h1>
    <div class="project-timeline">
      <Project v-for="project in projects" :key="project.title" :project="project"/>
    </div>
  </div>
</template>

<style scoped>
.timeline {
  margin-top: 3rem;
  padding: 2rem;
}

.timeline h1 {
  text-align: center;
  margin-bottom: 2rem;
}

.project-timeline {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>