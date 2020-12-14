import Axios from "axios";

const menus:menu[] = [
    {
        "id": 1,
        "name": "商品管理",
        "icon": "el-icon-folder-opened",
        "url": "/spgl",
        "layer": 1,
        "type": "模块",
        "parent": null,
        "menus": [
            {
                "id": 100,
                "name": "商品资料维护",
                "icon": "el-icon-folder-opened",
                "url": "commodity",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 10000,
                        "name": "商品添加",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10001,
                        "name": "商品修改",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10002,
                        "name": "商品下架",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10003,
                        "name": "商品删除",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10004,
                        "name": "商品上架",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10005,
                        "name": "商品打折",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            },
            {
                "id": 101,
                "name": "商品类型维护",
                "icon": "el-icon-folder-opened",
                "url": "typemaintain",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 10100,
                        "name": "类型添加",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10101,
                        "name": "类型修改",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10102,
                        "name": "类型删除",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10103,
                        "name": "类型搜索",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            },
            {
                "id": 102,
                "name": "商品标签维护",
                "icon": "el-icon-folder-opened",
                "url": "/url",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 10200,
                        "name": "标签添加",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10201,
                        "name": "标签修改",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10202,
                        "name": "标签删除",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 10203,
                        "name": "标签搜索",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            }
        ]
    },
    {
        "id": 2,
        "name": "商户管理",
        "icon": "el-icon-folder-opened",
        "url": "/url",
        "layer": 1,
        "type": "模块",
        "parent": null,
        "menus": [
            {
                "id": 200,
                "name": "商户资料维护",
                "icon": "el-icon-folder-opened",
                "url": "/url",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 20000,
                        "name": "商户查询",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 20001,
                        "name": "商户冻结",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 20002,
                        "name": "商户修改",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 20003,
                        "name": "商户删除",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            },
            {
                "id": 201,
                "name": "商户申请审批",
                "icon": "el-icon-folder-opened",
                "url": "/url",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 20100,
                        "name": "记录查询",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 20101,
                        "name": "审批通过",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 20102,
                        "name": "审批拒绝",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            }
        ]
    },
    {
        "id": 3,
        "name": "仓库管理",
        "icon": "el-icon-folder-opened",
        "url": "/url",
        "layer": 1,
        "type": "模块",
        "parent": null,
        "menus": [
            {
                "id": 300,
                "name": "仓库信息维护",
                "icon": "el-icon-folder-opened",
                "url": "/url",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 30000,
                        "name": "仓库添加",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 30001,
                        "name": "仓库修改",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 30002,
                        "name": "仓库冻结",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 30003,
                        "name": "商品类型分配",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 30004,
                        "name": "商品下限设置",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            }
        ]
    },
    {
        "id": 5,
        "name": "配送管理",
        "icon": "el-icon-folder-opened",
        "url": "/url",
        "layer": 1,
        "type": "模块",
        "parent": null,
        "menus": [
            {
                "id": 400,
                "name": "配送订单管理",
                "icon": "el-icon-folder-opened",
                "url": "/url",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 40000,
                        "name": "采购申请",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 40001,
                        "name": "记录查询",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            },
            {
                "id": 401,
                "name": "断货商品管理",
                "icon": "el-icon-folder-opened",
                "url": "/url",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 40100,
                        "name": "记录查询",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 40101,
                        "name": "审批通过",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    },
                    {
                        "id": 40102,
                        "name": "审批拒绝",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            }
        ]
    },
    {
        "id": 6,
        "name": "统计管理",
        "icon": "el-icon-folder-opened",
        "url": "/url",
        "layer": 1,
        "type": "模块",
        "parent": null,
        "menus": [
            {
                "id": 500,
                "name": "商品信息统计",
                "icon": "el-icon-folder-opened",
                "url": "/url",
                "layer": 2,
                "type": "页面",
                "parent": null,
                "menus": [
                    {
                        "id": 50000,
                        "name": "订单查询",
                        "icon": "el-icon-folder-opened",
                        "url": "/url",
                        "layer": 3,
                        "type": "按钮",
                        "parent": null,
                        "menus": null
                    }
                ]
            }
        ]
    }
]


export type menu = {
    id: number | string;
    name: string;
    icon?: string;
    url: string;
    layer: number | string;
    type: string;
    parent: number | string;
    menus?: menu[];
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