import { createRouter, createWebHistory } from 'vue-router';
import Home from "@/views/Home.vue";
import Games from '../views/Games.vue';
import Tools from '../views/Tools.vue';
import GamePage from "@/views/GamePage.vue";
import ToolPage from "@/views/ToolPage.vue";
import IconPage from "@/views/IconPage.vue";
import AboutPage from "@/views/AboutPage.vue";

const routes = [
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/games',
        name: 'games',
        component: Games
    },
    {
        path: '/tools',
        name: 'tools',
        component: Tools
    },
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
    {
        path: '/icons',
        name: 'icons',
        component: IconPage
    },
    {
        path: '/about',
        name: 'about',
        component: AboutPage
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
    scrollBehavior (to, from, savedPosition) {
        return { top: 0 }
    }
});

export default router;