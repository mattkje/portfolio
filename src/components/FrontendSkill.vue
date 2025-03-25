<script setup>
const skills = [
  { name: 'HTML, CSS, JavaScript', icon: '@/assets/icons/js.png' },
  { name: 'Vue.js, React', icon: '@/assets/icons/vue.svg' },
  { name: 'Asset creation with Photoshop, Affinity Designer', icon: '@/assets/icons/unity.png' }
];

document.addEventListener('DOMContentLoaded', () => {
  const elements = document.querySelectorAll('.scroll-animation');

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
});
</script>
<template>
  <h1 class="scroll-animation">Frontend Development & Asset Creation</h1>
  <div class="skills-section scroll-animation">
    <div class="skill-block">
      <img src="@/assets/icons/js.png" alt="icon missing" class="skill-icon" />
      <p>HTML, CSS, JavaScript</p>
      <button class="link">Learn more</button>
    </div>
    <div class="skill-block">
      <img src="@/assets/icons/vue.svg" alt="icon missing" class="skill-icon" />
      <p>Vue.js, React</p>
      <button class="link">Learn more</button>
    </div>
    <div class="skill-block">
      <img src="@/assets/icons/affinity.png" alt="icon missing" class="skill-icon" />
      <p>Asset creation with Adobe Photoshop, Affinity Designer</p>
      <button class="link">Check Out My Icon library</button>
    </div>
  </div>
</template>

<style scoped>
.skills-section {
  width: 70%;
  display: flex;
  justify-content: space-around;
  margin: auto;
}

.skill-block {
  background-color: #f9f9f9;
  width: 300px;
  height: 400px;
  border-radius: 2rem;
  padding: 1.5rem;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.skill-icon {
  width: 50px;
  height: 50px;
  margin-bottom: 0.5rem;
}

.skill-block p {
  font-size: 1rem;
  line-height: 1.5rem;
  margin: 0;
}

.link {
  align-self: flex-end;
  color: white;
  padding: 0.7rem 1.2rem;
  margin: auto;
  border-radius: 1.5rem;
  background-color: hsla(210, 100%, 50%, 1); /* Blue color */
  text-decoration: none;
  font-weight: bold;
  transition: color 0.3s, transform 0.3s;
}
.link:hover {
  color: hsl(210, 100%, 92%); /* Lighter blue on hover */
  transform: scale(1.1); /* Slightly enlarge on hover */
}

.scroll-animation {
  opacity: 0;
  transform: translateY(20px);
  transition: opacity 0.6s ease-out, transform 0.6s ease-out;
}

.scroll-animation.visible {
  opacity: 1;
  transform: translateY(0);
}

</style>