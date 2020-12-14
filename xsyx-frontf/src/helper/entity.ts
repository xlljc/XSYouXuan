/**
 * 表名 :  collect<br/>
 * 表注释 : 收藏表
 */
export class Collect {
    /**id*/
    id: number;
    /**收藏时间*/
    coltime: string;
    /**商品id*/
    cid: Commodity;
}

/**
 * 表名 :  com_discount<br/>
 * 表注释 : 商品折扣表
 */
export class ComDiscount {
    /**id*/
    id: number;
    /**商品id*/
    commodity: number;
    /**起始时间*/
    startTime: string;
    /**结束时间*/
    Date: string;
    /**折率 , 0 - 10之间*/
    discount: number;
    /**备注*/
    remark: string;
}

/**
 * 表名 :  com_image<br/>
 * 表注释 : 商品图片表
 */
export class ComImage {
    /**id*/
    id: number;
    /**商品id , 外键*/
    commodity: number;
    /**路径*/
    url: string;
}







export class Commodity {

}









