<script setup>
import Hero from "@/components/Hero.vue";
import FrontendSkill from "@/components/FrontendSkill.vue";
import Contact from "@/components/Contact.vue";
import FeaturedProjects from "@/components/FeaturedProjects.vue";



</script>

<template>
  <div class="container">
    <Hero />
    <FrontendSkill/>
    <FeaturedProjects/>
    <Contact/>
  </div>
</template>

<style scoped>
.container {
  margin: 0;
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

.skills-section {
  margin: 5rem;
  text-align: left;
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
