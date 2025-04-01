<script setup>
import '@fortawesome/fontawesome-free/css/all.css';
import Contact from "@/components/Contact.vue";
import {onMounted, ref} from "vue";

const contactInfo = {
  name: 'Matti Kjellstadli',
  birthday: '27.06.2003',
  email: 'mattikjellstadli@icloud.com',
  phone: '+47 457 71 234',
  address: 'Ålesund, Norway'
};

const avatarUrl = ref('');

onMounted(async () => {
  try {
    const response = await fetch('https://api.github.com/users/mattkje');
    const data = await response.json();
    avatarUrl.value = data.avatar_url;
  } catch (error) {
    console.error('Error fetching GitHub profile image:', error);
  }
});
</script>

<template>
  <div class="cv-container">
    <aside class="sidebar">
      <img :src="avatarUrl" alt="Portrait of Matti Kjellstadli" class="portrait"/>
      <section class="contact-info">
        <h2>Contact Information</h2>
        <ul>
          <li><i class="fas fa-user"></i> <strong>Name:&nbsp;</strong> {{ contactInfo.name }}</li>
          <li><i class="fas fa-birthday-cake"></i> <strong>Birthday:&nbsp;</strong> {{ contactInfo.birthday }}</li>
          <li><i class="fas fa-envelope"></i> <strong>Email:&nbsp;</strong> {{ contactInfo.email }}</li>
          <li><i class="fas fa-phone"></i> <strong>Phone:&nbsp;</strong> {{ contactInfo.phone }}</li>
          <li><i class="fas fa-map-marker-alt"></i> <strong>Location:&nbsp;</strong> {{ contactInfo.address }}</li>
        </ul>
        <Contact :is-mobile="true"/>
      </section>
    </aside>
    <main class="main-content">
      <header>
        <h1>Matti Kjellstadli</h1>
       <p>Current Role: Student at NTNU Ålesund</p>
      </header>
      <section>
        <h2>Professional Summary</h2>
        <p>
          I am a passionate developer with experience in various technologies, including frontend and backend development. I am eager to apply my skills in a professional setting and am open to a variety of job opportunities, including software development, web development, and mobile app development. I have an eye for detail and am enthusiastic about learning new technologies and contributing to innovative projects.
        </p>
      </section>
      <section>
        <h2>Work Experience</h2>
        <ul>
          <li>
            <strong>Joker and Spar (Store) | 2022 - 2024:</strong> Although not directly related to software development, my experience in grocery stores provided valuable customer service and operational skills. This experience enhanced my problem-solving abilities, attention to detail, and teamwork, all of which are crucial in a software engineering role.
          </li>
          <li>
            <strong>Solwr Robotics | 2024:</strong> Completed a frontend Vue.js work internship, contributing to the development of innovative robotic solutions. Worked closely with a team of engineers to design and implement user interfaces, improve application performance, and ensure a seamless user experience. Gained hands-on experience with modern web technologies and agile development practices.
          </li>
        </ul>
      </section>
      <section>
        <h2>Education</h2>
        <ul>
          <li>
            <i class="fas fa-university"></i>
            <div>
              <strong>Norwegian University of Science and Technology:</strong>
              <p>Bachelor's degree in computer science, focusing on software development, algorithms, and data structures.</p>
            </div>
          </li>
        </ul>
      </section>
      <section class="skills-languages-container">
        <div class="skills">
          <h2>Skills</h2>
          <ul>
            <li><i class="fas fa-code"></i> HTML, CSS</li>
            <li class="preferred"><i class="fas fa-paint-brush"></i> Asset creation with Adobe Photoshop, Affinity Designer, and Figma</li>
            <li><i class="fas fa-database"></i> Experience with databases and backend development</li>
            <li><i class="fas fa-code-branch"></i> Version control with Git. (GitHub and GitLab)</li>
            <li><i class="fas fa-cogs"></i> Familiarity with Agile methodologies</li>
            <li><i class="fas fa-language"></i> Fluent in Norwegian and English</li>
            <li><i class="fas fa-gamepad"></i> Game development with Unity</li>
            <li><i class="fas fa-mobile-alt"></i> Mobile app development</li>
            <li><i class="fas fa-server"></i> Basic knowledge of server-side programming</li>
            <li><i class="fas fa-chart-line"></i> Data analysis and visualization</li>
          </ul>
        </div>

        <div class="programming-languages">
          <h2>Programming</h2>
          <ul>
            <li><i class="fas fa-code"></i> Java</li>
            <li><i class="fas fa-code"></i> JavaScript</li>
            <li class="preferred"><i class="fas fa-code"></i> TypeScript</li>
            <li><i class="fas fa-code"></i> Python</li>
            <li class="preferred"><i class="fas fa-code"></i> C#</li>
            <li><i class="fas fa-code"></i> Dart</li>
            <li class="preferred"><i class="fas fa-database"></i> MySQL</li>
          </ul>
        </div>

        <div class="frameworks">
          <h2>Frameworks</h2>
          <ul>
            <li class="preferred"><i class="fas fa-code"></i> Vue.js</li>
            <li><i class="fas fa-code"></i> React</li>
            <li class="preferred"><i class="fas fa-code"></i> Spring Boot</li>
            <li><i class="fas fa-code"></i> Flutter</li>
            <li><i class="fas fa-code"></i> JavaFX</li>
            <li><i class="fas fa-code"></i> Unity</li>
          </ul>
        </div>
      </section>
      <p>Note: The skills marked in blue are my preferred skills.</p>
    </main>
  </div>
</template>

<style scoped>
.cv-container {
  display: flex;
  margin: 50px auto 0 auto;
  background-color: #fff;
  font-family: Avenir, Arial, sans-serif;
}

.sidebar {
  width: 300px;
  padding: 2rem;
  border-right: 1px solid #e3e3e3;
}

.portrait {
  width: 100%;
  border-radius: 50%;
  margin-bottom: 2rem;
}

.contact-info {
  margin-top: 2rem;
}

.contact-info h2 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  color: #333;
}

.contact-info ul {
  list-style: none;
  text-align: left;
  padding: 0;
}

.contact-info li {
  margin-bottom: 1rem;
}

.contact-info li i {
  margin-right: 0.5rem;
  color: #608AFF;
}

.main-content {
  flex: 1;
  padding: 2rem;
}

header {
  text-align: center;
  margin-bottom: 2rem;
}

header h1 {
  color: #608AFF;
  text-align: left;
  font-size: 2.5rem;
  margin-bottom: 0.5rem;
}

header p {
  text-align: left;
  font-size: 1.2rem;
  color: #666;
}

section {
  margin-bottom: 2rem;
}

section h2 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  color: #333;
  border-bottom: 1px solid #ccc;
  padding-bottom: 0.5rem;
}

section p, section ul {
  font-size: 1rem;
  line-height: 1.5;
  text-align: left;
  color: #333;
}

ul {
  list-style: none;
  padding: 0;
}

li {
  margin-bottom: 1rem;
}

li:not(.preferred) {
  margin-left: 0.6rem;
}


li i {
  margin-right: 0.5rem;
  color: #608AFF;
}

li div {
  display: flex;
  flex-direction: column;
}

li p {
  margin: 0;
  font-size: 1rem;
  color: #666;
}

strong {
  color: #333;
}

.skills-languages-container {
  display: flex;
  justify-content: space-between;
}

.skills, .programming-languages, .frameworks {
  width: 30%;
}

.preferred {
  padding: 0.6rem;
  color: white;
  border-radius: 1.5rem;
  background-color: #608AFF;
}

.preferred i {
  color: white;
}
</style>