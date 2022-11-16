import { createWebHistory, createRouter } from 'vue-router';
import Home from '../pages/HomeTwo.vue';
import Bookmark from '../pages/CoursesList.vue';
import BoardsDetails from '../pages/InstructorDetails.vue';
import EventDetails from '../pages/EventDetails.vue';
import SignIn from '../pages/SignIn.vue';
import SignUp from '../pages/SignUp.vue';
import UserDetail from '../pages/UserDetail.vue';
import BoardsPage from '../pages/BoardsPage.vue';
import EventsPage from '../pages/EventsPage.vue';
import AdminBoardsPage from '../pages/AdminBoardsPage.vue';
import AdminEventsPage from '../pages/AdminEventsPage.vue';
import HouseDeal from '../pages/HouseDeal.vue';
import UserManage from '../pages/UserManage.vue';
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home,
    },
    {
      path: '/home',
      component: Home,
    },
    {
      path: '/login',
      component: SignIn,
    },
    {
      path: '/register',
      component: SignUp,
    },
    {
      path: '/boardsPage',
      component: BoardsPage,
    },
    {
      path: '/boards-details',
      component: BoardsDetails,
    },
    {
      path: '/eventsPage',
      component: EventsPage,
    },
    {
      path: '/event-details',
      component: EventDetails,
    },
    {
      path: '/houseDeal',
      component: HouseDeal,
    },
    {
      path: '/adminDetail',
      component: UserDetail,
    },
    {
      path: '/userManage',
      component: UserManage,
    },
    {
      path: '/adminBoardsPage',
      component: AdminBoardsPage,
    },
    {
      path: '/adminEventsPage',
      component: AdminEventsPage,
    },
    {
      path: '/userDatail',
      component: UserDetail,
    },
    {
      path: '/bookmark',
      component: Bookmark,
    },
  ],
});

router.beforeEach((to, from, next) => {
  next();
  window.scrollTo(0, 0);
});

export default router;
