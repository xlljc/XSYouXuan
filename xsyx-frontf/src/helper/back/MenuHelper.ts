import Axios from "axios";
import {Menu, MenuTree} from "@/helper/entity";
import {EmpHelper} from "@/helper/back/EmpHelper";
import {RootStore} from "@/store";
import {RootRouter} from "@/router";

function toMenuTree(menus: Menu[]): MenuTree[] {
    let menuTrees: MenuTree[] = [];
    for (let menu of menus) {
        menuTrees.push({
            id: menu.id,
            label: menu.name,
            children: menu.menus ? toMenuTree(menu.menus) : undefined
        })
    }
    return menuTrees;
}


export class MenuHelper {

    static getMenuData(): Promise<Menu[]> {
        return new Promise<Menu[]>(resolve => {
            //先到store里面看看有没有值
            if (RootStore.store.getters["back/menusLoading"] === false) {
                resolve(RootStore.store.getters["back/menus"]);
            } else {
                //后台异步获取菜单
                let params = new URLSearchParams();
                params.set("id", EmpHelper.empId);
                Axios.post("/emp/queryMenus", params).then(value => {
                    //将值设置到vuex中
                    RootStore.store.commit('back/menus', value.data);
                    //菜单加载完成
                    RootStore.store.commit("back/menusLoading", false);

                    resolve(value.data);
                })
            }
        });
    }


    /**
     * 返回当前用户是否可以访问指定菜单页面
     * @param path
     */
    static canToMenuPage(path: string): boolean {
        if (path === "/") return true;
        if (RootStore.store.getters["back/menusLoading"]) return false;
        let menuList: Menu[] = RootStore.store.getters["back/menuList"];
        for (let menu of menuList) {
            if (menu.layer === 2 && path === menu.url) return true;
        }
        return false;
    }

    /**
     * 返回当前操作者是否有使用按钮的权限
     * @param name
     */
    static hasBtnPermissions(name: string): boolean {
        if (RootStore.store.getters["back/menusLoading"]) return false;
        let path = RootRouter.router.currentRoute.path;
        path = path.substring(path.lastIndexOf("/"));
        let menuList: Menu[] = RootStore.store.getters["back/menuList"];
        for (let menu of menuList) {
            if (menu.layer === 2 && menu.url === path) {
                let temp = menu.menus;
                if (!temp) continue;
                for (let i of temp) {
                    if (i.name === name) return true;
                }
            }
        }
        return false;
    }

}