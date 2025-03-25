<script setup>
const platforms = [
  { name: 'GitHub', url: 'https://github.com/mattkje', icon: '/path/to/github-icon.svg' },
  { name: 'LinkedIn', url: 'https://www.linkedin.com/in/mattkje', icon: '/path/to/linkedin-icon.svg' },
  { name: 'YouTube', url: 'https://www.youtube.com/channel/UCmattkje', icon: '/path/to/youtube-icon.svg' },
  { name: 'Shelstad Store', url: 'https://shelstadstore.com', icon: '/path/to/store-icon.svg' }
];
</script>

<template>
  <div class="contact-section">
    <h2>Contact & Platforms</h2>
    <div class="platforms">

        <a href="https://github.com/mattkje" target="_blank" rel="noopener noreferrer">
          <img src="@/assets/icons/github.png" alt="?" class="platform-icon" />
          <p>GitHub</p>
        </a>
        <a href="https://www.linkedin.com/in/matti-kjellstadli-39a0a028a/" target="_blank" rel="noopener noreferrer">
          <img src="@/assets/icons/linkedin.png" alt="?" class="platform-icon" />
          <p>LinkedIn</p>
        </a>
        <a href="https://www.youtube.com/@Shelstad" target="_blank" rel="noopener noreferrer">
          <img src="@/assets/icons/youtube.png" alt="?" class="platform-icon" />
          <p>YouTube</p>
        </a>
        <a href="https://shelstad.store" target="_blank" rel="noopener noreferrer">
          <img src="@/assets/images/game/shelstad-color.svg" alt="?" class="platform-icon" />
          <p>Shelstad Store</p>
        </a>

    </div>
  </div>
</template>

<style scoped>
.contact-section {
  margin-bottom: 5rem;
  text-align: center;
}

.platforms {
  border-bottom: #e3e3e3 solid 1px;
  border-top: #e3e3e3 solid 1px;
  width: 50%;
  padding-top: 2rem;
  margin: auto;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.platform {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin: 1rem;
}

.platform-icon {
  width: 50px;
  height: 50px;
  object-fit: contain;
  margin-bottom: 0.5rem;
  filter: grayscale(100%);
  transition: transform 0.3s ease, filter 0.3s ease;
}

.platform-icon:hover {
  transform: scale(1.2);
  filter: grayscale(0%);
}

.platform p {
  font-size: 1rem;
  margin: 0;
}

a {
  text-decoration: none;
}

a p {
  margin-top: 0;
  color: #a9a9a9;
  transition: color 0.3s;
}

a:hover p {
  color: black;
}
</style>