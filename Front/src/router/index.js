import { createWebHistory, createRouter } from 'vue-router';
import Home from '../pages/Home.vue';
import HomeTwo from '../pages/HomeTwo.vue';
import HomeThree from '../pages/HomeThree.vue';
import Courses from '../pages/Courses.vue';
import CoursesList from '../pages/CoursesList.vue';
import CourseSidebar from '../pages/CourseSidebar.vue';
import CourseDetails from '../pages/CourseDetails.vue';
import Blog from '../pages/Blog.vue';
import BlogDetails from '../pages/BlogDetails.vue';
import About from '../pages/About.vue';
import Instructor from '../pages/Instructor.vue';
import InstructorDetails from '../pages/InstructorDetails.vue';
import EventDetails from '../pages/EventDetails.vue';
import Cart from '../pages/Cart.vue';
import Checkout from '../pages/Checkout.vue';
import SignIn from '../pages/SignIn.vue';
import SignUp from '../pages/SignUp.vue';
import UserDetail from '../pages/UserDetail.vue';
import ErrorPage from '../pages/ErrorPage.vue';
import Contact from '../pages/Contact.vue';
import CourseDetailsPage from '../pages/DynamicCourseDetails.vue';
import DynamicBlogDetails from '../pages/DynamicBlogDetails.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: HomeTwo,
    },
    {
      path: '/home',
      component: Home,
    },
    {
      path: '/home-two',
      component: HomeTwo,
    },
    {
      path: '/home-three',
      component: HomeThree,
    },
    {
      path: '/courses',
      component: Courses,
    },
    {
      path: '/courses-list',
      component: CoursesList,
    },
    {
      path: '/courses-sidebar',
      component: CourseSidebar,
    },
    {
      path: '/course-details',
      component: CourseDetails,
    },
    {
      path: '/blog',
      component: Blog,
    },
    {
      path: '/blog-details',
      component: BlogDetails,
    },
    {
      path: '/about',
      component: About,
    },
    {
      path: '/instructor',
      component: Instructor,
    },
    {
      path: '/instructor-details',
      component: InstructorDetails,
    },
    {
      path: '/event-details',
      component: EventDetails,
    },
    {
      path: '/cart',
      component: Cart,
    },
    {
      path: '/checkout',
      component: Checkout,
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
      path: '/errorPage',
      component: ErrorPage,
    },
    {
      path: '/contact',
      component: Contact,
    },
    {
      path: '/course-details/:id',
      component: CourseDetailsPage,
    },
    {
      path: '/blog-details/:id',
      component: DynamicBlogDetails,
    },
    {
      path: '/userDetail',
      component: UserDetail,
    },
  ],
});

router.beforeEach((to, from, next) => {
  next();
  window.scrollTo(0, 0);
});

export default router;
