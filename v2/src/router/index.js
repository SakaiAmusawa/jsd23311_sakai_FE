import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        component: HomeView,
        /*重定向至首页*/
        redirect: '/index',
        children: [
            {
                path: '/reg',
                component: () => import('../views/home/RegView.vue')
            },
            {
                path: 'login',
                component: () => import('../views/home/LoginView.vue')
            },
            {
                path: 'index',
                component: () => import('../views/home/IndexView.vue')
            },
            {
                path: 'detail',
                component: () => import('../views/home/DetailView.vue')
            }
        ]
    },
    {
        path: '/admin',
        component: () => import('../views/AdminView.vue'),
        children: [
            {
                path: 'user',
                component: () => import('../views/admin/UserView.vue')
            }, {
                path: 'banner',
                component: () => import('../views/admin/BannerView.vue')
            }, {
                path: 'product',
                component: () => import('../views/admin/ProductView.vue')
            },
        ]
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
