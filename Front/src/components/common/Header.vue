<template>
  <div>
    <header>
      <div
        id="header-sticky"
        :class="`${
          isSticky
            ? 'header__area header__transparent header__padding-2 sticky'
            : `${
                headerShadow ? headerShadow : 'header__area header__transparent header__padding-2'
              }`
        }`"
      >
        <div class="container">
          <div class="row align-items-center">
            <div class="col-xxl-4 col-xl-4 col-lg-5 col-md-3 col-sm-5 col-7">
              <div class="header__left d-flex">
                <div class="logo" style="vertical-align: middle">
                  <router-link to="/">
                    <img src="@/assets/img/logo/logo-gif.gif" style="width: 50px" alt="logo" />
                    <span>방구할라면</span>
                  </router-link>
                </div>
              </div>
            </div>
            <div class="col-xxl-8 col-xl-8 col-lg-7 col-md-9 col-sm-7 col-5">
              <div class="header__right d-flex justify-content-end align-items-center">
                <div class="main-menu main-menu-2">
                  <nav id="mobile-menu" class="d-none d-xl-block">
                    <ul>
                      <li><router-link to="/">Home</router-link></li>
                      <li class="has-dropdown">
                        <router-link to="/boards">공지사항</router-link>
                        <ul class="submenu">
                          <li>
                            <router-link to="/boards">공지사항</router-link>
                          </li>
                          <li>
                            <router-link to="/events">이벤트</router-link>
                          </li>
                        </ul>
                      </li>
                      <li>
                        <router-link to="/houseDeal">실거래가</router-link>
                      </li>
                      <li class="has-dropdown" v-show="this.$store.state.login.userCode === '002'">
                        <router-link to="/adminBoards">관리자</router-link>
                        <ul class="submenu">
                          <li><router-link to="/adminEvents">관리자 정보</router-link></li>
                          <li><router-link to="/adminBoards">공지사항 관리</router-link></li>
                          <li><router-link to="/adminEvents">이벤트 관리</router-link></li>
                          <li><router-link to="/userManage">회원 정보 관리</router-link></li>
                        </ul>
                      </li>
                      <li class="has-dropdown" v-show="this.$store.state.login.isLogin">
                        <router-link to="/userDatail">내 정보</router-link>
                        <ul class="submenu">
                          <li><router-link to="/userDatail">회원 정보</router-link></li>
                          <li><router-link to="/bookmark">찜한 목록</router-link></li>
                        </ul>
                      </li>
                    </ul>
                  </nav>
                </div>
                <div class="header__btn header__btn-2 ml-50 d-none d-sm-block">
                  <router-link
                    to="/login"
                    class="e-btn login-btn"
                    v-show="!this.$store.state.login.isLogin"
                    >Login</router-link
                  >
                  <button
                    class="e-btn login-btn"
                    v-show="this.$store.state.login.isLogin"
                    @click="doLogout"
                  >
                    Logout
                  </button>
                </div>
                <div class="sidebar__menu d-xl-none">
                  <div @click="handleSidebar" class="sidebar-toggle-btn ml-30" id="sidebar-toggle">
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
            <router-link
              to="/login"
              class="e-btn login-btn"
              v-show="!this.$store.state.login.isLogin"
              >Login
            </router-link>
            <button
              class="e-btn login-btn"
              v-show="this.$store.state.login.isLogin"
              @click="doLogout"
            >
              Logout
            </button>
          </div>

          <div class="side-info-content sidebar-menu mm-menu">
            <ul>
              <li>
                <router-link to="/home" class="border-0">Home</router-link>
              </li>
              <li
                class="menu-item-has-children has-droupdown"
                :class="[menuOption.boardsDropdown === true ? 'active' : '']"
              >
                <a @click="menuOption.boardsDropdown = !menuOption.boardsDropdown">공지사항</a>
                <ul class="sub-menu" :class="[menuOption.boardsDropdown === true ? 'active' : '']">
                  <li>
                    <router-link to="/boards">공지사항</router-link>
                  </li>
                  <li>
                    <router-link to="/events">이벤트</router-link>
                  </li>
                </ul>
              </li>
              <li>
                <router-link to="houseDeal" class="border-0">실거래가</router-link>
              </li>

              <li
                v-show="this.$store.state.login.userCode === '002'"
                class="menu-item-has-children has-droupdown"
                :class="[menuOption.adminDropDown === true ? 'active' : '']"
              >
                <a @click="menuOption.adminDropDown = !menuOption.adminDropDown">관리자</a>
                <ul class="sub-menu" :class="[menuOption.adminDropDown === true ? 'active' : '']">
                  <li><router-link to="/adminBoards">공지사항 관리</router-link></li>
                  <li><router-link to="/adminEvents">이벤트 관리</router-link></li>
                  <li><router-link to="/userManage">회원 정보 관리</router-link></li>
                </ul>
              </li>
              <li
                v-show="this.$store.state.login.isLogin"
                class="menu-item-has-children has-droupdown"
                :class="[menuOption.myDropDown === true ? 'active' : '']"
              >
                <a @click="menuOption.myDropDown = !menuOption.myDropDown">내 정보</a>
                <ul class="sub-menu" :class="[menuOption.myDropDown === true ? 'active' : '']">
                  <li><router-link to="/userDatail">회원 정보</router-link></li>
                  <li><router-link to="/bookmark">찜한 목록</router-link></li>
                </ul>
              </li>
            </ul>
            <div class="sidebar__search p-relative mt-40">
              <form v-show="this.$store.state.login.isLogin" action="#">
                <input type="text" placeholder="Search..." />
                <button type="submit"><i class="fad fa-search"></i></button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div
      @click="handleSidebarClose"
      :class="[showSidebar ? 'body-overlay opened' : 'body-overlay']"
    ></div>
    <!-- sidebar area end -->
  </div>
</template>

<script>
export default {
  name: "HomeHeader",
  data() {
    return {
      isSticky: false,
      showSidebar: false,
      menuOption: {
        menuShow: false,
        menuSearch: false,
        boardsDropdown: false,
        adminDropDown: false,
        myDropDown: false,
      },
    };
  },
  props: {
    headerShadow: String,
  },
  methods: {
    handleSticky() {
      if (window.scrollY > 80) {
        this.isSticky = true;
      } else {
        this.isSticky = false;
      }
    },

    handleSidebar() {
      this.showSidebar = true;
    },
    handleSidebarClose() {
      this.showSidebar = false;
    },
    doLogout() {
      this.$store.commit("SET_LOGIN", {
        isLogin: false,
        userName: "",
        userProfileImageUrl: "",
        userSeq: "",
        userCode: "",
      });
      console.log("logout");
      this.$store.state.bookmark.list = [];
      this.$router.push("/home");
    },
  },
  mounted() {
    window.addEventListener("scroll", this.handleSticky);
  },
};
</script>
