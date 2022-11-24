import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module

Vue.use(VueRouter);

import Home from '@/components/Home/Home.vue';
import SignIn from '@/components/User/SignIn.vue';
import SignUp from '@/components/User/SignUp.vue';
import UserDetail from '@/components/User/UserDetail.vue';
import Boards from '@/components/Boards/Boards.vue';
import BoardsDetails from '@/components/Boards/BoardsDetails.vue';
import AdminBoardsDetails from '@/components/Admin/Board/AdminBoardsDetails.vue';
import Events from '@/components/Events/Events.vue';
import EventDetails from '@/components/Events/EventDetailsArea.vue';
import Bookmark from '@/components/BookMark/BookMark.vue';
import AdminBoards from '@/components/Admin/Board/AdminBoards.vue';
import AdminEvents from '@/components/Admin/Event/AdminEvents.vue';
import HouseDeal from '@/components/House/HouseDeal.vue';
import UserManage from '@/components/Admin/User/UserManage.vue';
import HouseDetail from '@/components/House/HouseDetail.vue';
import AdminEventDetails from '@/components/Admin/Event/AdminEventDetailsArea';

export default new VueRouter({
  // mode: "history",
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
      path: '/boards',
      component: Boards,
    },
    {
      path: '/boards-details',
      component: BoardsDetails,
    },
    {
      path: '/admin/boards-details',
      component: AdminBoardsDetails,
    },
    {
      path: '/events',
      component: Events,
    },
    {
      path: '/event-details/:eventId',
      component: EventDetails,
    },
    {
      path: '/admin/event-details/:eventId',
      component: AdminEventDetails,
    },
    {
      path: '/houseDeal',
      component: HouseDeal,
    },
    {
      path: '/house-details/:aptCode',
      component: HouseDetail,
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
      path: '/adminBoards',
      component: AdminBoards,
    },
    {
      path: '/adminEvents',
      component: AdminEvents,
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
