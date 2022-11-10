<template>
  <header>
    <div
      id="header-sticky"
      :class="`${
        isSticky
          ? 'header__area header__transparent header__padding-2 sticky'
          : 'header__area header__transparent header__padding-2'
      }`"
    >
      <div class="container">
        <div class="row align-items-center">
          <div class="col-xxl-2 col-xl-2 col-lg-6 col-md-6 col-sm-6 col-6">
            <div class="header__left d-flex">
              <div class="logo">
                <router-link to="/">
                  <img
                    class="logo-white"
                    src="../../assets/img/logo/logo-2.png"
                    alt="logo"
                  />
                  <img
                    class="logo-black"
                    src="../../assets/img/logo/logo.png"
                    alt="logo"
                  />
                </router-link>
              </div>
            </div>
          </div>
          <div class="col-xxl-5 col-xl-5 d-none d-xl-block">
            <div class="main-menu main-menu-3">
              <nav id="mobile-menu">
                <ul>
                  <li class="has-dropdown">
                    <router-link to="/">Home</router-link>
                    <ul class="submenu">
                      <li>
                        <router-link to="/home">Home Style 1</router-link>
                      </li>
                      <li>
                        <router-link to="/home-two">Home Style 2</router-link>
                      </li>
                      <li>
                        <router-link to="/home-three">Home Style 3</router-link>
                      </li>
                    </ul>
                  </li>
                  <li class="has-dropdown">
                    <router-link to="/courses">Courses</router-link>
                    <ul class="submenu">
                      <li>
                        <router-link to="/courses">Courses</router-link>
                      </li>
                      <li>
                        <router-link to="/courses-list"
                          >Course List</router-link
                        >
                      </li>
                      <li>
                        <router-link to="/courses-sidebar"
                          >Course sidebar
                        </router-link>
                      </li>
                      <li>
                        <router-link to="/course-details"
                          >Course Details
                        </router-link>
                      </li>
                    </ul>
                  </li>
                  <li class="has-dropdown">
                    <router-link to="/blog">Blog</router-link>
                    <ul class="submenu">
                      <li><router-link to="/blog">Blog</router-link></li>
                      <li>
                        <router-link to="/blog-details"
                          >Blog Details</router-link
                        >
                      </li>
                    </ul>
                  </li>
                  <li class="has-dropdown">
                    <router-link to="/courses">Pages</router-link>
                    <ul class="submenu">
                      <li><router-link to="/about">About</router-link></li>
                      <li>
                        <router-link to="/instructor">Instructor</router-link>
                      </li>
                      <li>
                        <router-link to="/instructor-details">
                          Instructor Details</router-link
                        >
                      </li>
                      <li>
                        <router-link to="/event-details"
                          >Event Details</router-link
                        >
                      </li>
                      <li><router-link to="/cart">My Cart</router-link></li>
                      <li>
                        <router-link to="/checkout">Checkout</router-link>
                      </li>
                      <li><router-link to="/login">Sign In</router-link></li>
                      <li><router-link to="/register">Sign Up</router-link></li>
                      <li><router-link to="/errorPage">Error</router-link></li>
                    </ul>
                  </li>
                  <li><router-link to="/contact">Contact</router-link></li>
                </ul>
              </nav>
            </div>
          </div>
          <div class="col-xxl-5 col-xl-5 col-lg-6 col-md-6 col-sm-6 col-6">
            <div
              class="
                header__right
                d-flex
                justify-content-end
                align-items-center
              "
            >
              <div @click="handleSearch" class="header__search-2">
                <svg class="search-toggle" viewBox="0 0 584.4 584.4">
                  <g>
                    <g>
                      <path
                        class="st0"
                        d="M565.7,474.9l-61.1-61.1c-3.8-3.8-8.8-5.9-13.9-5.9c-6.3,0-12.1,3-15.9,8.3c-16.3,22.4-36,42.1-58.4,58.4    c-4.8,3.5-7.8,8.8-8.3,14.5c-0.4,5.6,1.7,11.3,5.8,15.4l61.1,61.1c12.1,12.1,28.2,18.8,45.4,18.8c17.1,0,33.3-6.7,45.4-18.8    C590.7,540.6,590.7,499.9,565.7,474.9z"
                      />
                      <path
                        class="st1"
                        d="M254.6,509.1c140.4,0,254.5-114.2,254.5-254.5C509.1,114.2,394.9,0,254.6,0C114.2,0,0,114.2,0,254.5    C0,394.9,114.2,509.1,254.6,509.1z M254.6,76.4c98.2,0,178.1,79.9,178.1,178.1s-79.9,178.1-178.1,178.1S76.4,352.8,76.4,254.5    S156.3,76.4,254.6,76.4z"
                      />
                    </g>
                  </g>
                </svg>
              </div>
              <div class="header__btn header__btn-2 ml-30 d-none d-sm-block">
                <router-link to="/register" class="e-btn">Sign up</router-link>
              </div>
              <div class="sidebar__menu d-xl-none">
                <div @click="handleSidebar"
                  class="sidebar-toggle-btn sidebar-toggle-btn-white ml-30"
                  id="sidebar-toggle"
                >
                  <span class="line"></span>
                  <span class="line"></span>
                  <span class="line"></span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>


  <!-- sidebar area start -->
  <div :class="`${showSidebar ? 'sidebar__area sidebar-opened' : 'sidebar__area'}`">
      <div class="sidebar__wrapper">
        <div @click="handleSidebarClose" class="sidebar__close">
            <button class="sidebar__close-btn" id="sidebar__close-btn">
            <span><i class="fal fa-times"></i></span>
            <span>close</span>
            </button>
        </div>
        <div class="sidebar__content">
            <div class="logo mb-40">
              <router-link to="/">
                <img src="../../assets/img/logo/logo.png" alt="logo">
              </router-link>
            </div>

             <div class="side-info-content sidebar-menu mm-menu">
                  
                <ul>
                  <li class="menu-item-has-children has-droupdown" 
                  v-bind:class="[menuOption.homeDropdown === true ? 'active' : '']">
                      <a @click="menuOption.homeDropdown = !menuOption.homeDropdown">Home</a >
                      <ul class="sub-menu" :class="[menuOption.homeDropdown === true ? 'active' : '',]">
                        <li>
                            <router-link to="/home">Home Style 1</router-link>
                        </li>
                        <li>
                            <router-link to="/home-two">Home Style 2</router-link>
                        </li>
                        <li>
                            <router-link to="/home-three">Home Style 3</router-link>
                        </li>
                      </ul>
                  </li>


                    <li class="menu-item-has-children has-droupdown" 
                      :class="[menuOption.coursesDropdown === true ? 'active' : '',]">
                        <a @click="menuOption.coursesDropdown = !menuOption.coursesDropdown">Courses</a>
                        <ul class="sub-menu" :class="[menuOption.coursesDropdown === true ? 'active' : '',]">
                              <li>
                                <router-link to="/courses">Courses</router-link>
                              </li>
                              <li>
                                <router-link to="/courses-list">Course List</router-link>
                              </li>
                              <li>
                                <router-link to="/courses-sidebar">Course sidebar
                                </router-link>
                              </li>
                              <li>
                                <router-link to="/course-details">Course Details
                                </router-link>
                              </li>
                        </ul>
                      </li>

                  <li class="menu-item-has-children has-droupdown"
                    :class="[menuOption.blogDropdown === true ? 'active' : '']">

                    <a v-on:click="menuOption.blogDropdown = !menuOption.blogDropdown">Blog</a>
                    <ul class="sub-menu"
                      :class="[menuOption.blogDropdown === true ? 'active' : '',]">
                      <li>
                          <router-link to="/blog">Blog</router-link>
                      </li>
                      <li>
                          <router-link to="/blog-details">Blog Details</router-link>
                      </li>
                    </ul>
                  </li>

                      
                  <li class="menu-item-has-children has-droupdown" 
                  :class="[menuOption.pagesDropDown === true ? 'active' : '',]">
                      <a @click="menuOption.pagesDropDown = !menuOption.pagesDropDown">Pages</a>
                      <ul class="sub-menu" 
                      :class="[menuOption.pagesDropDown === true ? 'active' : '',]">
                            <li><router-link to="/about">About</router-link></li>
                            <li><router-link to="/instructor">Instructor</router-link></li>
                            <li>
                            <router-link to="/instructor-details">
                            Instructor Details</router-link>
                            </li>
                            <li><router-link to="/event-details">Event Details</router-link></li>
                            <li><router-link to="/cart">My Cart</router-link></li>
                            <li><router-link to="/checkout">Checkout</router-link></li>
                            <li><router-link to="/login">Sign In</router-link></li>
                            <li><router-link to="/register">Sign Up</router-link></li>
                            <li><router-link to="/errorPage">Error</router-link></li>
                      </ul>
                  </li>

                  <li>
                      <router-link to="/contact" class="border-0">Contact</router-link>
                  </li>
                  
              </ul>
            </div>

            <div class="sidebar__search p-relative mt-40 ">
              <form action="#">
                  <input type="text" placeholder="Search...">
                  <button type="submit"><i class="fad fa-search"></i></button>
              </form>
            </div>
            <div class="sidebar__cart mt-30">
              <a href="#">
                  <div class="header__cart-icon">
                    <svg viewBox="0 0 24 24">
                        <circle class="st0" cx="9" cy="21" r="1"/>
                        <circle class="st0" cx="20" cy="21" r="1"/>
                        <path class="st0" d="M1,1h4l2.7,13.4c0.2,1,1,1.6,2,1.6h9.7c1,0,1.8-0.7,2-1.6L23,6H6"/>
                    </svg>
                  </div>
                  <span class="cart-item">2</span>
              </a>
            </div>
        </div>
      </div>
  </div> 
  <div @click="handleSidebarClose" :class="[showSidebar ? 'body-overlay opened' : 'body-overlay']"></div>
  <!-- sidebar area end -->


<!-- search area start -->
<div :class="[searchOption ? 'header__search-3 white-bg transition-3 search-opened' 
:'header__search-3 white-bg transition-3']">
    <div class="container">
          <div class="row">
            <div class="col-xl-12">
                <div class="header__search-3-inner text-center">
                      <form action="#">
                        <div @click="handleSearchClose" class="header__search-3-btn">
                            <a href="javascript:void(0);" class="header__search-3-btn-close">
                              <i class="fal fa-times"></i></a>
                        </div>
                        <div class="header__search-3-header">
                            <h3>Search</h3>
                        </div>
                        <div class="header__search-3-categories">
                            <ul class="search-category">
                                  <li><router-link to="/cart">All Categories</router-link></li>
                                  <li><router-link to="/cart">Accessories</router-link></li>
                                  <li><router-link to="/cart">Chair</router-link></li>
                                  <li><router-link to="/cart">Tablet</router-link></li>
                                  <li><router-link to="/cart">Men</router-link></li>
                                  <li><router-link to="/cart">Women</router-link></li>
                                  
                            </ul>
                        </div>
                        <div class="header__search-3-input p-relative">
                            <input type="text" placeholder="Search for products... ">
                            <button type="submit"><i class="far fa-search"></i></button>
                        </div>
                      </form>
                </div>
            </div>
          </div>
    </div>
</div>
<!-- search area end -->
</template>

<script>
export default {
  name: "HomeThreeHeader",
  data() {
    return {
      isSticky: false,
      searchOption:false,
      showSidebar:false,
        menuOption: {
        menuShow: false,
        menuSearch: false,
        homeDropdown: false,
        coursesDropdown: false,
        pagesDropDown: false,
        blogDropdown: false,
        aboutDropdown: false,
      },
    };
  },
  methods: {
    handleSticky() {
      if (window.scrollY > 80) {
        this.isSticky = true;
      } else {
        this.isSticky = false;
      }
    },
    handleSidebar () {
      this.showSidebar = true;
    },
    handleSidebarClose () {
      this.showSidebar = false;
    },
    handleSearch () {
      this.searchOption = true;
    },
    handleSearchClose () {
      this.searchOption = false;
    },
  },
  mounted() {
    window.addEventListener("scroll", this.handleSticky);
  },
};
</script>
