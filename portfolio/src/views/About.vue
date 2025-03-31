<script setup>
    import '@fortawesome/fontawesome-free/css/all.css';
    import Contact from "@/components/Contact.vue";

    const contactInfo = {
      email: 'mattikjellstadli@icloud.com',
      phone: '+47 457 71 234',
      address: 'Ålesund, Norway'
    };
    </script>

    <template>
      <div class="about-container">
        <h1>About Me</h1>
        <p>
          I am a passionate developer with experience in various technologies.
        </p>
        <hr />
        <h2>Work Experience</h2>
        <ul>
          <li><strong>Grocery Stores:</strong> Worked in various roles, gaining valuable customer service and operational experience.</li>
          <li><strong>Solwr Robotics:</strong> Completed a frontend Vue.js work internship, contributing to the development of innovative robotic solutions.</li>
        </ul>
        <hr />
        <h2>Education</h2>
        <ul>
          <li>
            <i class="fas fa-university"></i>
            <div>
              <strong>Norwegian University of Science and Technology:</strong>
              <p>Studied computer science, focusing on software development, algorithms, and data structures.</p>
            </div>
          </li>
        </ul>
        <hr />
        <h2>Skills</h2>
        <ul>
          <li><i class="fas fa-code"></i> HTML, CSS, JavaScript</li>
          <li><i class="fas fa-code"></i> Vue.js, React</li>
          <li><i class="fas fa-paint-brush"></i> Asset creation with Adobe Photoshop, Affinity Designer, and Figma</li>
          <li><i class="fas fa-database"></i> Experience with databases and backend development</li>
          <li><i class="fas fa-git"></i> Version control with Git</li>
          <li><i class="fas fa-cogs"></i> Familiarity with Agile methodologies</li>
          <li><i class="fas fa-language"></i> Fluent in Norwegian and English</li>
          <li><i class="fas fa-gamepad"></i> Game development with Unity</li>
          <li><i class="fas fa-mobile-alt"></i> Mobile app development</li>
          <li><i class="fas fa-server"></i> Basic knowledge of server-side programming</li>
          <li><i class="fas fa-chart-line"></i> Data analysis and visualization</li>
        </ul>
        <hr />
        <Contact/>
        <h3>Additional Contact Information</h3>
        <ul>
          <li><i class="fas fa-envelope"></i> <strong> Personal Email:&nbsp;</strong> {{ contactInfo.email }}</li>
          <li><i class="fas fa-phone"></i> <strong> Phone:&nbsp;</strong> {{ contactInfo.phone }}</li>
          <li><i class="fas fa-map-marker-alt"></i> <strong> Location:&nbsp;</strong> {{ contactInfo.address }}</li>
        </ul>
      </div>
    </template>

    <style scoped>
    .about-container {
      padding: 2rem;
      max-width: 800px;
      margin: 100px auto;
      border-radius: 10px;
      background-color: #f9f9f9;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1, h2, h3 {
      text-align: center;
      color: #333;
    }

    h1 {
      font-size: 2.5rem;
      margin-bottom: 1rem;
    }

    h2 {
      font-size: 2rem;
      margin-top: 2rem;
      margin-bottom: 1rem;
    }

    h3 {
      font-size: 1.75rem;
      margin-top: 2rem;
      margin-bottom: 1rem;
    }

    p {
      font-size: 1.25rem;
      line-height: 1.5;
      margin-bottom: 2rem;
      text-align: center;
    }

    ul {
      list-style: none;
      padding: 0;
      text-align: center;
    }

    li {
      font-size: 1.25rem;
      margin-bottom: 0.5rem;
      display: flex;
      align-items: flex-start;
      justify-content: center;
    }

    li i {
      margin-right: 0.5rem;
      color: #608AFF;
      font-size: 1.5rem;
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

    hr {
      border: 0;
      height: 1px;
      background: #ccc;
      margin: 2rem 0;
    }
    </style>