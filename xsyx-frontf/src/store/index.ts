import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {

    'back': {
      namespaced: true,
      state: {
        url: ""
      },
      getters: {
        /**
         * 获取url
         * @param state
         */
        url(state) {
          return state.url;
        }
      },
      mutations: {
        /**
         * 设置url
         * @param state
         * @param data
         */
        url(state,data) {
          state.url = data;
        }
      }
    }
  }
})
