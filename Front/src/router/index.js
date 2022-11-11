import { createWebHistory, createRouter } from "vue-router";
import HomeTwo from "../pages/HomeTwo.vue";
import Courses from "../pages/Courses.vue";
import CoursesList from "../pages/CoursesList.vue";
import CourseSidebar from "../pages/CourseSidebar.vue";
import CourseDetails from "../pages/CourseDetails.vue";
import About from "../pages/About.vue";
import Instructor from "../pages/Instructor.vue";
import InstructorDetails from "../pages/InstructorDetails.vue";
import EventDetails from "../pages/EventDetails.vue";
import SignIn from "../pages/SignIn.vue";
import SignUp from "../pages/SignUp.vue";
import UserDetail from "../pages/UserDetail.vue";
import ErrorPage from "../pages/ErrorPage.vue";
import Contact from "../pages/Contact.vue";
import BoardsPage from "../pages/BoardsPage.vue";
import EventsPage from "../pages/EventsPage.vue";
import AdminBoardsPage from "../pages/AdminBoardsPage.vue";
import AdminEventsPage from "../pages/AdminEventsPage.vue";
import CourseDetailsPage from "../pages/DynamicCourseDetails.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      component: HomeTwo,
    },
    {
      path: "/home-two",
      component: HomeTwo,
    },
    {
      path: "/courses",
      component: Courses,
    },
    {
      path: "/courses-list",
      component: CoursesList,
    },
    {
      path: "/courses-sidebar",
      component: CourseSidebar,
    },
    {
      path: "/course-details",
      component: CourseDetails,
    },
    {
      path: "/about",
      component: About,
    },
    {
      path: "/instructor",
      component: Instructor,
    },
    {
      path: "/instructor-details",
      component: InstructorDetails,
    },
    {
      path: "/event-details",
      component: EventDetails,
    },
    {
      path: "/login",
      component: SignIn,
    },
    {
      path: "/register",
      component: SignUp,
    },
    {
      path: "/course-details/:id",
      component: CourseDetailsPage,
    },
    {
      path: "/errorPage",
      component: ErrorPage,
    },
    {
      path: "/contact",
      component: Contact,
    },
    {
      path: "/userDetail",
      component: UserDetail,
    },
    {
      path: "/boardsPage",
      component: BoardsPage,
    },
    {
      path: "/eventsPage",
      component: EventsPage,
    },
    {
      path: "/adminBoardsPage",
      component: AdminBoardsPage,
    },
    {
      path: "/adminEventsPage",
      component: AdminEventsPage,
    },
    {
      path: "/userDatail",
      component: UserDetail,
    },
  ],
});

router.beforeEach((to, from, next) => {
  next();
  window.scrollTo(0, 0);
});

export default router;
