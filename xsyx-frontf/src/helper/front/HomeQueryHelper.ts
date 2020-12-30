/**
 * 死的数据
 */
import Axios from "axios";
import {Commodity, PageInfo} from "@/helper/entity";

const data: QueryData[] = [
    { "value": "三全鲜食（北新泾店）" },
    { "value": "Hot honey 首尔炸鸡（仙霞路）" },
    { "value": "新旺角茶餐厅" },
    { "value": "泷千家(天山西路店)" },
    { "value": "胖仙女纸杯蛋糕（上海凌空店）" },
    { "value": "贡茶" },
    { "value": "豪大大香鸡排超级奶爸" },
    { "value": "茶芝兰（奶茶，手抓饼）" },
    { "value": "十二泷町" },
    { "value": "星移浓缩咖啡" },
    { "value": "阿姨奶茶/豪大大"},
    { "value": "新麦甜四季甜品炸鸡" },
    { "value": "Monica摩托主题咖啡店" },
    { "value": "浮生若茶（凌空soho店）" },
    { "value": "NONO JUICE  鲜榨果汁" },
    { "value": "CoCo都可(北新泾店）" },
    { "value": "快乐柠檬（神州智慧店）" },
    { "value": "Merci Paul cafe" },
    { "value": "猫山王（西郊百联店）" },
    { "value": "枪会山" },
    { "value": "纵食" },
    { "value": "钱记" },
    { "value": "壹杯加" },
    { "value": "唦哇嘀咖" },
    { "value": "爱茜茜里(西郊百联)" },
    { "value": "爱茜茜里(近铁广场)" },
    { "value": "鲜果榨汁（金沙江路和美广店）" },
    { "value": "开心丽果（缤谷店）" },
    { "value": "超级鸡车（丰庄路店）" },
    { "value": "妙生活果园（北新泾店）" },
    { "value": "香宜度麻辣香锅" },
    { "value": "凡仔汉堡（老真北路店）" },
    { "value": "港式小铺" },
    { "value": "蜀香源麻辣香锅（剑河路店）" },
    { "value": "北京饺子馆" },
    { "value": "饭典*新简餐（凌空SOHO店）" },
    { "value": "焦耳·川式快餐（金钟路店）" },
    { "value": "动力鸡车" },
    { "value": "浏阳蒸菜" },
    { "value": "四海游龙（天山西路店）" },
    { "value": "樱花食堂（凌空店）" },
    { "value": "壹分米客家传统调制米粉(天山店)" },
    { "value": "福荣祥烧腊（平溪路店）" },
    { "value": "速记黄焖鸡米饭" },
    { "value": "红辣椒麻辣烫" },
    { "value": "(小杨生煎)西郊百联餐厅" },
    { "value": "阳阳麻辣烫" },
    { "value": "南拳妈妈龙虾盖浇饭" }
];

const hotData: HotQueryData[] = [
    { value: '白菜' },
    { value: '橙子' },
    { value: '薯片' },
    { value: '苹果' },
    { value: '香蕉' }
];

/**
 * 查询结果类型
 */
export type QueryData = {
    value: string;
}

/**
 * 热搜类型
 */
export type HotQueryData = {
    value: string;
}

export class HomeQueryHelper {

    /**
     * 提示查询
     * @param str 需要查询的字符串
     */
    async queryPrompt(str: string): Promise<QueryData[]> {

        if (!str) return [];
        let params = new URLSearchParams();
        params.append("str", str);
        let data: Commodity[] = (await Axios.post("/commodity/searchTips", params)).data;
        let list: QueryData[] = [];
        data.forEach(value => list.push({value: value.name}));
        return list;
    }

    /**
     * 搜索商品
     * @param str
     * @param page
     * @param row
     */
    async searchCom(str: string,page: number,row: number): Promise<PageInfo<Commodity>> {
        let params = new URLSearchParams();
        params.append("str",str);
        params.append("page",page.toString());
        params.append("row",row.toString());
        return (await Axios.post("/commodity/search",params)).data;
    }

    /**
     * 获取热搜数据
     */
    getHotQuery(): Promise<HotQueryData[]> {
        return new Promise<HotQueryData[]>(resolve => {
            Axios.get("/commodity/queryHotSearch").then(value => {
                resolve(value.data);
            })
        });
    }

}