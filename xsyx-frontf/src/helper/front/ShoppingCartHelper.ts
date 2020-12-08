/**
 * 死的数据
 */
const data: ShoppingData[] = [
    {
        name: "西红柿",
        count: 2,
        image: require('@/assets/logo.png'),
        price: 1.5
    },
    {
        name: "西蓝花",
        count: 3,
        image: require('@/assets/logo.png'),
        price: 2.5
    },
    {
        name: "西蓝花",
        count: 3,
        image: require('@/assets/logo.png'),
        price: 2.5
    }
];

export type ShoppingData = {
    name: string;
    image: unknown;
    count: number;
    price: number;
};


/**
 * 购物车Service
 */
export class ShoppingCartHelper {

    /**
     * 获取当前用户的购物车数据
     */
    getShoppingData(): Promise<ShoppingData[]> {
        return new Promise<ShoppingData[]>(resolve => {
            setTimeout(() => {
                resolve(data);
            },2000);
        });
    }
}

