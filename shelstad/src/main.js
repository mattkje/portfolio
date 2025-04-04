import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

const app = createApp(App);

// Set global properties
//app.config.globalProperties.$apiAddress = 'http://localhost:8443/api';
// Uncomment the line below for production
app.config.globalProperties.$apiAddress = 'https://shelstad.store:8443/api';

app.use(router);
app.mount('#app');