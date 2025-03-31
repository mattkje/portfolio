<script setup>
const projects = [
  { year: "2023", title: "Project A", description: "Description of Project A", icon: "path/to/iconA.png", link: "https://example.com/projectA", context: 'School' },
  { year: "2023", title: "Project B", description: "Description of Project B", icon: "path/to/iconB.png", link: "https://example.com/projectB", context: 'Solo' },
  { year: "2022", title: "Project C", description: "Description of Project C", icon: "path/to/iconC.png", link: "https://example.com/projectC", context: 'School' }
  // Add more projects as needed
];
</script>

<template>
  <div class="timeline">
    <h1>Projects Timeline</h1>
    <ul>
      <li v-for="project in projects" :key="project.title" :class="['timeline-item', project.context.toLowerCase()]">
        <div class="timeline-content">
          <img :src="project.icon" alt="Project Icon" class="project-icon" />
          <h2>{{ project.year }}</h2>
          <h3><a :href="project.link" target="_blank">{{ project.title }}</a></h3>
          <p>{{ project.description }}</p>
        </div>
      </li>
    </ul>
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

.timeline ul {
  list-style: none;
  padding: 0;
}

.timeline-item {
  height: 200px;
  border: 1px solid #e3e3e3;
  border-radius: 4rem;
  justify-content: space-between;
  display: flex;
  padding: 1rem 3rem 1rem 1rem;
  transition: background-color 0.3s, border-color 0.3s;
  flex-direction: column;
  margin: 2rem auto;
  width: 70%;
}

.timeline-item.school {
  border-left: 5px solid #00bfa5;
}

.timeline-item.solo {
  border-left: 5px solid #ff9800;
}

.timeline-content {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.project-icon {
  width: 50px;
  height: 50px;
  margin-bottom: 1rem;
}

.timeline-content h2 {
  margin: 0;
  font-size: 1.5rem;
  color: #00bfa5;
}

.timeline-content h3 {
  margin: 0.5rem 0;
  font-size: 1.25rem;
}

.timeline-content p {
  margin: 0;
  font-size: 1rem;
  color: #666;
}

.timeline-content a {
  text-decoration: none;
  color: inherit;
}

.timeline-content a:hover {
  text-decoration: underline;
}
</style>