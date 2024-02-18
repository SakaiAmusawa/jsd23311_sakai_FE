import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }, {
    path: '/bind',
    name: 'bind',
    component: () => import('../views/Bind.vue')
  }, {
    path: '/TW-bind',
    name: 'TW-bind',
    component: () => import('../views/TwoWaysBind.vue')
  }
  , {
    path: '/Event-bind',
    name: 'Event-bind',
    component: () => import('../views/EventBand.vue')
  }, {
    path: '/For-cmd', name: 'For-cmd', component: () => import('../views/ForCmd.vue')
  }, {
    path: '/hidden-display', name: 'hidden-display', component: () => import('../views/HiddenOrDisplay.vue')
  }, {
    path: '/calculator', name: 'calculator', component: () => import('../views/CalculatorExec.vue')
  }
  , {
    path: '/guess', name: 'guess', component: () => import('../views/GuessExec.vue')
  }, {
    path: '/empList', name: 'empList', component: () => import('../views/EmpListExec.vue')
  }
  , {
    path: '/resume', name: 'resume', component: () => import('../views/ResumeExec.vue')
  }, {
    path: '/elButton', name: 'elButton', component: () => import('../views/ElementButton.vue')
  }
  , {
    path: '/elIcon', name: 'elIcon', component: () => import('../views/ElementIcon.vue')
  }, {
    path: '/elMessage', name: 'elMessage', component: () => import('../views/ElementMessage.vue')
  }, {
    path: '/elRadio', component: () => import('../views/ElementRadio.vue')
  }, {
    path: '/n', component: () => import('../views/NView.vue')
  }, {
    path: '/o', component: () => import('../views/OView.vue')
  }, {
    path: '/p', component: () => import('../views/PView.vue')
  }, {
    path: '/q', component: () => import('../views/QView.vue')
  }, {
    path: '/r', component: () => import('../views/RView.vue')
  }, {
    path: '/s', component: () => import('../views/SView.vue')
  }, {
    path: '/t', component: () => import('../views/TView.vue')
  }, {
    path: '/u', component: () => import('../views/UView.vue')
  }, {
    path: '/v', component: () => import('../views/VView.vue')
  }, {
    path: '/w', component: () => import('../views/WView.vue')
  }, {
    path: '/x', component: () => import('../views/XView.vue')
  }, {
    path: '/EmployeesList', component: () => import('../views/EmployeesList.vue')
  }, {
    path: '/exec', component: () => import('../views/Exec.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
