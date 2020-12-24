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
        menusList: [],
        menusLoading: true,
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
        menusLoading(state): boolean {
          return state.menusLoading;
        },
        menuList(state): Menu[] {
          return state.menusList;
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
          let list: Menu[] = [];
          function method(menus: Menu[]): void {
            for (let menu of menus) {
              list.push({
                id: menu.id,
                layer: menu.layer,
                name: menu.name,
                icon: menu.icon,
                parent: {...menu.parent},
                type: menu.type,
                url: menu.url
              });
              if (menu.menus) method(menu.menus);
            }
          }
          method(data);
          //平铺菜单属性
          state.menusList = list;
        },
        menusLoading(state, data) {
          state.menusLoading = data;
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