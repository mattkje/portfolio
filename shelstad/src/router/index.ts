// src/router/index.ts
import { createRouter, createWebHistory } from 'vue-router';
import Home from "@/views/Home.vue";
import Games from '../views/Games.vue';
import Tools from '../views/Tools.vue';
import GamePage from "@/views/GamePage.vue";
import ToolPage from "@/views/ToolPage.vue";
import IconPage from "@/views/IconPage.vue";


const routes = [
    { path: '/', component: Home },
    { path: '/games', component: Games },
    { path: '/tools', component: Tools },
    {
        path: '/game/:id',
        name: 'GamePage',
        component: GamePage,
        props: true
    },
    {
        path: '/tool/:id',
        name: 'ToolPage',
        component: ToolPage,
        props: true
    },
    { path: '/icons', component: IconPage }

];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;

