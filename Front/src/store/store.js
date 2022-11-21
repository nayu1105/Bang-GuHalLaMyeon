import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

import http from '@/common/axios.js';
import util from '@/common/util.js';

import router from '@/routers/routers.js';

export default new Vuex.Store({
  state: {
    // login, NavBar
    login: {
      // NavBar
      isLogin: false,

      userSeq: '',
      userName: '',
      userProfileImageUrl: '',

      // Login
      userEmail: 'nanana@ssafy.com',
      userPassword: '1234',
    },
    //
    board: {
      // list
      list: [],
      limit: 10,
      offset: 0,
      searchWord: '',

      // pagination
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,

      totalListItemCount: 0,

      // detail, update, delete

      boardId: 0,
      title: '',
      content: '',
      userName: '',
      regDate: '',
      regTime: '',
      readCount: 0,
    },
    event: {
      // list
      list: [],
      limit: 10,
      offset: 0,

      // pagination
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,

      totalListItemCount: 0,

      // detail, update, delete

      eventId: 0,
      title: '',
      content: '',
      startDate: '',
      endDate: '',
      htmlUrl: '',
      statusCode: 0,
      userSeq: 0,
      regDate: '',
      regTime: '',
      // regDt: {
      //   date: {},
      //   time: {},
      //   // date: { year: 0, month: 0, day: 0 },
      //   // time: { hour: 0, minute: 0, second: 0, nano: 0 },
      // },
      userName: '',
      userProfileImageUrl: '',
    },
    house: {
      houseList: [],

      sidoList: [],
      gugunList: [],
      dongList: [],

      sido: '',
      gugun: '',
      dong: '',
    },
  },
  // state 상태를 변경하는 유일한 방법
  mutations: {
    SET_LOGIN(state, payload) {
      state.login.isLogin = payload.isLogin;
      state.login.userName = payload.userName;
      state.login.userSeq = payload.userSeq;
      state.login.userProfileImageUrl = payload.userProfileImageUrl;
    },

    UPDATE_USER(state, payload) {
      state.login.userName = payload.userName;
      state.login.userPassword = payload.userPassword;
    },

    SET_BOARD_LIST(state, list) {
      state.board.list = list;
    },

    SET_BOARD_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.board.totalListItemCount = count;
    },

    SET_BOARD_MOVE_PAGE(state, pageIndex) {
      state.board.offset = (pageIndex - 1) * state.board.listRowCount;
      state.board.currentPageIndex = pageIndex;
    },

    SET_BOARD_DETAIL(state, payload) {
      state.board.boardId = payload.boardId;
      state.board.title = payload.title;
      state.board.content = payload.content;
      state.board.userName = payload.userName;
      state.board.regDate = util.makeDateStr(
        payload.regDt.date.year,
        payload.regDt.date.month,
        payload.regDt.date.day,
        '.'
      );
      state.board.regTime = util.makeTimeStr(
        payload.regDt.time.hour,
        payload.regDt.time.minute,
        payload.regDt.time.second,
        ':'
      );
      state.board.readCount = payload.readCount;
      state.board.sameUser = payload.sameUser;
    },
    // for UpdateModal title v-modal
    SET_BOARD_TITLE(state, title) {
      state.board.title = title;
    },
    SET_BOARD_UPDATE(state, payload) {
      state.board.boardId = payload.boardId;
      state.board.title = payload.title;
      state.board.content = payload.content;
    },
    SET_HOUSE_SIDO_LIST(state, sidoList) {
      state.house.sidoList = sidoList;
    },
    SET_HOUSE_GUGUN_LIST(state, gugunList) {
      state.house.gugunList = gugunList;
    },
    SET_HOUSE_DONG_LIST(state, dongList) {
      state.house.dongList = dongList;
    },
    SET_HOUSE_LIST(state, list) {
      state.house.houseList = list;
    },

    SET_EVENT_LIST(state, list) {
      state.event.list = list;
    },

    SET_EVENT_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.event.totalListItemCount = count;
    },

    SET_EVENT_MOVE_PAGE(state, pageIndex) {
      state.event.offset = (pageIndex - 1) * state.event.listRowCount;
      state.event.currentPageIndex = pageIndex;
    },

    SET_EVENT_DETAIL(state, payload) {
      state.event.eventId = payload.eventId;
      state.event.title = payload.title;
      state.event.content = payload.content;
      state.event.startDate = payload.startDate;
      state.event.endDate = payload.endDate;
      state.event.htmlUrl = payload.htmlUrl;
      state.event.statusCode = payload.statusCode;
      state.event.userSeq = payload.userSeq;
      state.event.userName = payload.userName;
      state.event.userProfileImageUrl = payload.userProfileImageUrl;
      state.event.regDate = util.makeDateStr(
        payload.regDt.date.year,
        payload.regDt.date.month,
        payload.regDt.date.day,
        '.'
      );
      state.event.regTime = util.makeTimeStr(
        payload.regDt.time.hour,
        payload.regDt.time.minute,
        payload.regDt.time.second,
        ':'
      );
    },
    // for UpdateModal event v-modal
    SET_EVENT_TITLE(state, title) {
      state.event.title = title;
    },
    SET_EVENT_STARTDATE(state, startDate) {
      state.event.startDate = startDate;
    },
    SET_EVENT_ENDDATE(state, endDate) {
      state.event.endDate = endDate;
    },
  },
  // for async method
  actions: {
    async boardList(context) {
      let params = {
        limit: this.state.board.limit,
        offset: this.state.board.offset,
        searchWord: this.state.board.searchWord,
      };
      try {
        let { data } = await http.get('/boards', { params }); // params: params shorthand property, let response 도 제거
        console.log('BoardMainVue: data : ');
        console.log(data);
        if (data.result == 'login') {
          router.push('/login');
        } else {
          context.commit('SET_BOARD_LIST', data.list);
          context.commit('SET_BOARD_TOTAL_LIST_ITEM_COUNT', data.count);
        }
      } catch (error) {
        console.error(error);
      }
    },
    async eventList(context) {
      let params = {
        limit: this.state.event.limit,
        offset: this.state.event.offset,
        searchWord: this.state.event.searchWord,
      };

      try {
        let { data } = await http.get('/events', { params }); // params: params shorthand property, let response 도 제거
        console.log('EventMainVue: data : ');
        console.log(data);
        if (data.result == 'login') {
          router.push('/login');
        } else {
          context.commit('SET_EVENT_LIST', data.list);
          context.commit('SET_EVENT_TOTAL_LIST_ITEM_COUNT', data.count);
        }
      } catch (error) {
        console.error(error);
      }
    },
    async sidoList(context) {
      let params = {
        option: 'sido',
      };
      try {
        let { data } = await http.get('/city', { params }); // params: params shorthand property, let response 도 제거
        if (data.result == 'login') {
          router.push('/login');
        } else {
          context.commit('SET_HOUSE_SIDO_LIST', data.list);
        }
      } catch (error) {
        console.error(error);
      }
    },
    async gugunList(context, payload) {
      let params = {
        option: 'gugun',
        sidoCode: payload,
      };
      try {
        let { data } = await http.get('/city', { params }); // params: params shorthand property, let response 도 제거
        if (data.result == 'login') {
          router.push('/login');
        } else {
          context.commit('SET_HOUSE_GUGUN_LIST', data.list);
          console.log(data);
        }
      } catch (error) {
        console.error(error);
      }
    },
    async dongList(context, payload) {
      let params = {
        option: 'dong',
        gugunCode: payload,
      };
      try {
        let { data } = await http.get('/city', { params }); // params: params shorthand property, let response 도 제거
        if (data.result == 'login') {
          router.push('/login');
        } else {
          context.commit('SET_HOUSE_DONG_LIST', data.list);
          console.log(data);
        }
      } catch (error) {
        console.error(error);
      }
    },
    async houseList(context, payload) {
      let lawd_cd = payload;
      let deal_ymd = 202112;
      try {
        let { data } = await http.get('/houses/search/' + lawd_cd + '/' + deal_ymd); // params: params shorthand property, let response 도 제거
        if (data.result == 'login') {
          router.push('/login');
        } else {
          context.commit('SET_HOUSE_LIST', data.list);
          console.log(data);
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
  getters: {
    isLogin: function (state) {
      return state.login.isLogin;
    },

    getBoardList: function (state) {
      return state.board.list;
    },

    getSidoList: function (state) {
      return state.house.sidoList;
    },
    getGugunList: function (state) {
      return state.house.gugunList;
    },

    getDongList: function (state) {
      return state.house.dongList;
    },

    getHouseList: function (state) {
      return state.house.houseList;
    },

    getEventList: function (state) {
      return state.event.list;
    },

    // pagination
    getBoardsPageCount: function (state) {
      return Math.ceil(state.board.totalListItemCount / state.board.listRowCount);
    },
    getBoardsStartPageIndex: function (state) {
      if (state.board.currentPageIndex % state.board.pageLinkCount == 0) {
        //10, 20...맨마지막
        return (
          (state.board.currentPageIndex / state.board.pageLinkCount - 1) *
            state.board.pageLinkCount +
          1
        );
      } else {
        return (
          Math.floor(state.board.currentPageIndex / state.board.pageLinkCount) *
            state.board.pageLinkCount +
          1
        );
      }
    },
    getBoardsEndPageIndex: function (state, getBoardsters) {
      let ret = 0;
      if (state.board.currentPageIndex % state.board.pageLinkCount == 0) {
        //10, 20...맨마지막
        ret =
          (state.board.currentPageIndex / state.board.pageLinkCount - 1) *
            state.board.pageLinkCount +
          state.board.pageLinkCount;
      } else {
        ret =
          Math.floor(state.board.currentPageIndex / state.board.pageLinkCount) *
            state.board.pageLinkCount +
          state.board.pageLinkCount;
      }
      // 위 오류나는 코드를 아래와 같이 비교해서 처리
      return ret > getBoardsters.getBoardsPageCount ? getBoardsters.getBoardsPageCount : ret;
    },
    getBoardsPrev: function (state) {
      if (state.board.currentPageIndex <= state.board.pageLinkCount) {
        return false;
      } else {
        return true;
      }
    },
    getBoardsNext: function (state, getBoardsters) {
      if (
        Math.floor(getBoardsters.getBoardsPageCount / state.board.pageLinkCount) *
          state.board.pageLinkCount <
        state.board.currentPageIndex
      ) {
        return false;
      } else {
        return true;
      }
    },
    // pagination
    getEventsPageCount: function (state) {
      return Math.ceil(state.board.totalListItemCount / state.board.listRowCount);
    },
    getEventsStartPageIndex: function (state) {
      if (state.board.currentPageIndex % state.board.pageLinkCount == 0) {
        //10, 20...맨마지막
        return (
          (state.board.currentPageIndex / state.board.pageLinkCount - 1) *
            state.board.pageLinkCount +
          1
        );
      } else {
        return (
          Math.floor(state.board.currentPageIndex / state.board.pageLinkCount) *
            state.board.pageLinkCount +
          1
        );
      }
    },
    getEventsEndPageIndex: function (state, getEventsters) {
      let ret = 0;
      if (state.board.currentPageIndex % state.board.pageLinkCount == 0) {
        //10, 20...맨마지막
        ret =
          (state.board.currentPageIndex / state.board.pageLinkCount - 1) *
            state.board.pageLinkCount +
          state.board.pageLinkCount;
      } else {
        ret =
          Math.floor(state.board.currentPageIndex / state.board.pageLinkCount) *
            state.board.pageLinkCount +
          state.board.pageLinkCount;
      }
      // 위 오류나는 코드를 아래와 같이 비교해서 처리
      return ret > getEventsters.getEventsPageCount ? getEventsters.getEventsPageCount : ret;
    },
    getEventsPrev: function (state) {
      if (state.board.currentPageIndex <= state.board.pageLinkCount) {
        return false;
      } else {
        return true;
      }
    },
    getEventsNext: function (state, getEventsters) {
      if (
        Math.floor(getEventsters.getEventsPageCount / state.board.pageLinkCount) *
          state.board.pageLinkCount <
        state.board.currentPageIndex
      ) {
        return false;
      } else {
        return true;
      }
    },
  },
});
