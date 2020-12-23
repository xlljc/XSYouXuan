

/**
 * 静态工具类
 */
export default class Utils {

    /** 弧度制转角度制 */
    public static toDegrees(angRad: number): number {
        return 180 * angRad / Math.PI;
    }

    /** 角度制转弧度制 */
    public static toRadians(angDeg: number): number {
        return angDeg * Math.PI / 180;
    }

    /** 返回一个区间内的随机小数 */
    public static randRange(min: number, max: number): number {
        if (min > max)
            return Math.random() * (min - max) + max;
        return Math.random() * (max - min) + min;
    }

    /** 返回一个区间内的随机整数 */
    public static randRangeInt(min: number, max: number): number {
        if (min > max)
            return Math.floor(Math.random() * (min - max + 1) + max);
        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    /** 循环拼接一个相同字符串 */
    public static loopStr(str: string, num: number): string {
        let s = "";
        for (let i = 0; i < num; i++) s += str;
        return s;
    }

    /**
     * 拼接 URLSearchParams 对象
     * @param urlSearchParams
     * @param obj
     * @param keys
     */
    public static format<T>(urlSearchParams: URLSearchParams, obj: T, ...keys: (keyof T)[]): URLSearchParams {
        if (keys.length > 0) {
            for (let key of keys) {
                let temp = obj[key];
                if (temp !== undefined && temp !== null) {
                    urlSearchParams.append(key.toString(), temp.toString());
                }
            }
        } else {
            for (let key in obj) urlSearchParams.append(key, obj[key].toString());
        }
        return urlSearchParams;
    }

    /**
     * 从数组中移除项
     * @param list 数组
     * @param item
     */
    public static arrayRemove<T>(list: T[], ...item: any): T[] {
        for (let i of item) list.splice(list.indexOf(i), 1);
        return list;
    }
}