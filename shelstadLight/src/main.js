import { createApp } from 'vue';
import App from './App.vue';
import router from './router/index.js';

const app = createApp(App);


app.config.globalProperties.$apiAddress = 'http://localhost:8443/api';

//app.config.globalProperties.$apiAddress = 'https://shelstad.store:8443/api';

app.use(router);
app.mount('#app');