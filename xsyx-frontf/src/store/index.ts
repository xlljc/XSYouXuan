import Vue from 'vue'
import Vuex from 'vuex'
import {Menu, MenuTree} from "@/helper/entity";

Vue.use(Vuex)


const store = new Vuex.Store({
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {

    'back': {
      namespaced: true,
      state: {
        url: "",
        menus: [],
        menuTrees: [],
      },
      getters: {
        /**
         * 获取url
         * @param state
         */
        url(state) {
          return state.url;
        },
        /**
         * 获取菜单
         * @param state
         */
        menus(state): Menu[] {
          return state.menus;
        },
        menuTrees(state): MenuTree[] {
          return state.menuTrees;
        }
      },
      mutations: {
        /**
         * 设置url
         * @param state
         * @param data
         */
        url(state, data) {
          state.url = data;
        },
        /**
         * 设置menus
         * @param state
         * @param data
         */
        menus(state, data) {
          state.menus = data;
        },
        menuTrees(state, data) {
          state.menuTrees = data;
        }
      }
    }
  }
})

/**
 * 静态根仓库
 */
export class RootStore {
  static readonly store = store;
}

export default store;