import Axios from "axios";
import {Menu, MenuTree} from "@/helper/entity";
import {EmpHelper} from "@/helper/back/EmpHelper";
import {RootStore} from "@/store";

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

    getMenuData(): Promise<Menu[]> {
        return new Promise<Menu[]>(resolve => {
            //let data = new URLSearchParams();
            //data.append("name","111");
            //后台异步获取菜单
            let params = new URLSearchParams();
            params.set("id",EmpHelper.empId);
            Axios.post("/emp/queryMenus",params).then(value => {
                //将值设置到vuex中
                RootStore.store.commit('back/menus', value.data);
                //设置菜单树
                RootStore.store.commit("back/menuTrees", toMenuTree(value.data));

                resolve(value.data);
            })
        });
    }

}