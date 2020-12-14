import Axios from "axios";

const menus:menu[] = [{
    index: 1,
    name: '处理中心',
    icon: 'el-icon-goods'
}, {
    index: 2,
    name: '我的工作台',
    icon: 'el-icon-setting',
    children: [{
        index: "2-1",
        name: '选项一'
    }, {
        index: "2-2",
        name: '选项二'
    }, {
        index: "2-3",
        name: '选项三'
    }]
}, {
    index: 3,
    name: '消息中心',
    icon: 'el-icon-phone'
}, {
    index: 4,
    name: '订单管理',
    icon: 'el-icon-news'
}]


export type menu = {
    index: number | string;
    name: string;
    icon?: string;
    children?: menu[];
}

export class MenuHelper {

    getMenuData(): Promise<menu[]> {
        return new Promise<menu[]>(resolve => {
            setTimeout(() => {
                //后台异步获取菜单

                resolve(menus);
            },1000)
        });
    }

}