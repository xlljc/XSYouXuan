/**
 * 表名 :  collect<br/>
 * 表注释 : 收藏表
 */
export interface Collect {
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
export interface ComDiscount {
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
export interface ComImage {
    /**id*/
    id: number;
    /**商品id , 外键*/
    commodity: number;
    /**路径*/
    url: string;
}
/**
 * 表名 :  com_label<br/>
 * 表注释 : 商品标签表
 */
export interface ComLabel {
    /**id*/
    id: number;
    /**标签名称*/
    name: string;
}
/**
 * 表名 :  comments<br/>
 * 表注释 : 用户评价表
 */
export interface Comments {
    /**id*/
    id: string;
    /**评价内容*/
    content: string;
    /**评价时间*/
    comtime: string;
    /**商品id*/
    cid: number;
    /**用户id*/
    uid: number;
    /**评论删除状态, 0未删除, 1已删除*/
    isdelete: number;
}

/**
 * 表名 :  commodity<br/>
 * 表注释 : 商品表
 */
export interface Commodity {
    /**id*/
    id: number;
    /**商品名称*/
    name: string;
    /**商品描述*/
    particulars: string;
    /**商品价格*/
    price: number;
    /**单位*/
    unit: string;
    /**规格*/
    specification: string;
    /**生产厂商*/
    manufacturer: string;
    /**商品类型 , 外键*/
    comType: ComType;
    /**商品上架时间(第一次上架时间)*/
    putawayDate: string;
    /**最新上架时间*/
    newestPutawayDate: string;
    /**商品状态, 0未上架, 1已上架, -1已删除*/
    state: number;
    /**商品折扣表, 扩展列*/
    comDiscount: ComDiscount;
    collects: Collect[];
    commentss: Comments[];
    lookHistorys: LookHistory[];
    purchases: Purchase[];
    shopcars: Shopcar[];
    stars: Star[];
}
/**
 * 表名 :  com_order<br/>
 * 表注释 : 订单表
 */
export interface ComOrder {
    /**id*/
    id: number;
    /**订单状态*/
    ordstate: number;
    /**订单编号*/
    orderNumber: string;
    /**删除状态, 0未删除, 1已删除*/
    isdelete: number;
    /**购物车id*/
    sid: Shopcar;
}
/**
 * 表名 :  com_type<br/>
 * 表注释 : 商品类型表
 */
export interface ComType {
    /**id*/
    id: number;
    /**类型名称*/
    name: string;
    commoditys: Commodity[];
}
/**
 * 表名 :  emp_log<br/>
 * 表注释 : 员工日志表
 */
export interface EmpLog {

    /**id*/
    id: number;
    /**员工,外键*/
    emp: Employee;
    /**日志内容*/
    content: string;
    /**附加数据, 可选*/
    data: string;
    /**时间*/
    time: string;
}
/**
 * 表名 :  employee<br/>
 * 表注释 : 员工表
 */
export interface Employee {
    /**id*/
    id: number;
    /**员工姓名*/
    name: string;
    /**登录密码*/
    password: string;
    /**头像*/
    image: string;
    /**性别*/
    sex: string;
    /**手机号*/
    phone: string;
    /**身份证号码*/
    icCard: string;
    /**员工住址*/
    address: string;
    /**邮箱*/
    email: string;
    /**备注*/
    remark: string;
    /**最后一次登录日期*/
    lastLoginTime: string;
    /**员工状态, 0冻结, 1正常, -1删除*/
    state: number;
    empLogs: EmpLog[];
    purchaseorders: Purchaseorder[];
}
/**
 * 表名 :  emprole<br/>
 * 表注释 : 员工角色表
 */
export interface Emprole {
    /**id*/
    id: number;
    /**员工*/
    employee: number;
    /**角色*/
    role: number;
}
/**
 * 表名 :  information<br/>
 * 表注释 : 用户交流表
 */
export interface Information {
    /**id*/
    id: number;
    /**聊天信息*/
    content: string;
    /**发送时间*/
    sendtime: string;
    /**发件人id*/
    uid: User;
    /**收件人id*/
    userid: number;
    /**消息接收状态*/
    infstate: number;
    /**是否已读, 1已读, 0未读*/
    isRead: number;
}
/**
 * 表名 :  look_history<br/>
 * 表注释 : 用户浏览历史表
 */
export interface LookHistory {
    /**id*/
    id: number;
    /**用户, 外键*/
    user: User;
    /**浏览商品, 外键*/
    cid: Commodity;
    /**浏览时间*/
    time: string;
}
/**
 * 表名 :  menu<br/>
 * 表注释 : 菜单功能表
 */
export interface Menu {
    /**id*/
    id: number;
    /**菜单名称*/
    name: string;
    /**菜单图标*/
    icon: string;
    /**访问路径*/
    url: string;
    /**菜单层级*/
    layer: number;
    /**功能类型*/
    type: string;
    /**父级菜单*/
    parent: Menu;
    menus: Menu[];
}
/**
 * 表名 :  merchants<br/>
 * 表注释 : 商户表
 */
export interface Merchants {
    /**id*/
    id: number;
    /**商户名称*/
    name: string;
    /**商户地址*/
    address: string;
    /**商户电话*/
    phone: string;
    /**经度*/
    longitude: number;
    /**纬度*/
    latitude: number;
    /**营业起始时间*/
    openTimeFrom: string;
    /**营业结束时间*/
    openTimeTo: string;
    /**商户备注*/
    remark: string;
    /**商户状态, 0 被冻结, 1正常 , -1删除*/
    state: number;
    pickupMerchantss: PickupMerchants;
    users: User;
}
/**
 * 表名 :  merchants_apply<br/>
 * 表注释 : 商户申请表
 */
export interface MerchantsApply {
    /**id*/
    id: number;
    /**用户id外键*/
    userId: User;
    /**商户名称*/
    name: string;
    /**商户地址*/
    address: string;
    /**申请时间*/
    applyTime: string;
    /**用户消息*/
    userMessage: string;
    /**审核状态 , 0未审核*/
    state: string;
    /**系统消息*/
    systemMessage: string;
    /**是否已读*/
    isRead: number;
}

/**
 * 表名 :  mer_log<br/>
 * 表注释 : 商户日志表
 */
export interface MerLog {
    /**id*/
    id: number;
    /**用户,外键*/
    emp: User;
    /**日志内容*/
    content: string;
    /**附加数据, 可选*/
    data: string;
    /**时间*/
    time: string;
}
/**
 * 表名 :  permission<br/>
 * 表注释 : 权限表
 */
export interface Permission {
    /**id*/
    id: number;
    /**菜单*/
    menu: number;
    /**角色*/
    role: number;
}
/**
 * 表名 :  pickup<br/>
 * 表注释 : 收货表
 */
export interface Pickup {
    /**id*/
    id: number;
    /**收货地址*/
    address: string;
    /**收货电话*/
    phone: string;
    /**收货时间*/
    ptime: string;
    /**收货状态, 0未发货, 1送货中, 2未领取, 3已领取*/
    pstate: number;
    /**用户id*/
    uid: number;
}
/**
 * 表名 :  pickup_merchants<br/>
 * 表注释 : 收货门店表(收货地址)
 */
export interface PickupMerchants {
    /**id*/
    id: number;
    /**用户,外键*/
    user: User;
    /**收货商户*/
    merchant: Merchants;
    /**备注*/
    remark: string;
    /**创建时间*/
    createTime: string;
}
/**
 * 表名 :  purchase<br/>
 * 表注释 : 采购表（采购申请记录）
 */
export interface Purchase {
    /**记录编号*/
    id: number;
    /**订单id*/
    orderid: Purchaseorder;
    /**商品id*/
    commodityid: Commodity;
    /**商品名*/
    commodityname: string;
    /**商品价格*/
    price: number;
    /**商品数量*/
    commoditysum: number;
}
/**
 * 表名 :  purchaseorder<br/>
 * 表注释 : 采购订单表
 */
export interface Purchaseorder {
    /**订单id*/
    orderid: number;
    /**申请人*/
    applicant: Employee;
    /**申请人备注*/
    applicantremarks: string;
    /**审批人*/
    approvedby: Employee;
    /**状态, 0未审核，1通过，-1拒绝*/
    state: number;
    /**审核人备注*/
    approvedbyremarks: string;
    /**操作时间*/
    operationtime: string;
    purchases: Purchase[];
}
/**
 * 表名 :  role<br/>
 * 表注释 : 角色表
 */
export interface Role {
    /**id*/
    id: number;
    /**角色名称*/
    name: string;
    /**角色备注*/
    remark: string;
}
/**
 * 表名 :  search_record<br/>
 * 表注释 : 用户搜索记录表
 */
export interface SearchRecord {
    /**id*/
    id: number;
    /**用户,外键*/
    user: User;
    /**搜索内容*/
    content: string;
    /**搜索时间*/
    time: string;
}
/**
 * 表名 :  shopcar<br/>
 * 表注释 : 购物车表
 */
export interface Shopcar {
    /**id*/
    id: number;
    /**数量*/
    number: number;
    /**加入购物车时间*/
    jointime: string;
    /**总价*/
    totalprice: number;
    /**商品id*/
    cid: Commodity;
    /**用户id*/
    uid: User;
    comOrders: ComOrder[];
}
/**
 * 表名 :  star<br/>
 * 表注释 : 评星表
 */
export interface Star {
    /**id*/
    id: number;
    /**用户id*/
    uid: User;
    /**商品id*/
    cid: Commodity;
    /**星星数量*/
    count: number;
}
/**
 * 表名 :  user<br/>
 * 表注释 : 用户表
 */
export interface User {
    /**id*/
    id: number;
    /**用户名*/
    username: string;
    /**密码*/
    password: string;
    /**用户头像*/
    headPortrait: string;
    /**用户手机号码*/
    phone: string;
    /**个性签名*/
    signature: string;
    /**生日*/
    birthday: string;
    /**姓名*/
    uname: string;
    /**性别*/
    sex: string;
    /**身份证*/
    idCard: string;
    /**商户id*/
    merid: Merchants;
    /**最后一次登录时间*/
    lastLoginTime: string;
    /**注销状态, 1注销, 0正常*/
    isDelete: number;
    commentss: Comments[];
    informations: Information[];
    lookHistorys: LookHistory[];
    merLogs: MerLog[];
    merchantsApplys: MerchantsApply[];
    pickupMerchantss: PickupMerchants[];
    searchRecords: SearchRecord[];
    shopcars: Shopcar[];
    stars: Star[];
    userLogs: UserLog[];
}
/**
 * 表名 :  user_log<br/>
 * 表注释 : 用户日志表
 */
export interface UserLog {
    /**id*/
    id: number;
    /**用户,外键*/
    user: User;
    /**日志内容*/
    content: string;
    /**附加数据, 可选*/
    data: string;
    /**时间*/
    time: string;
}
/**
 * 表名 :  warehouse<br/>
 * 表注释 : 仓库表
 */
export interface Warehouse {
    /**仓库编号*/
    warid: number;
    /**仓库名*/
    warname: string;
    /**仓库类型*/
    wartype: string;
    /**仓库容量*/
    warcapacity: number;
    /**仓库地址*/
    waraddress: string;
    /**经度*/
    longitude: number;
    /**纬度*/
    latitude: number;
    /**仓库状态, 0冻结, 1正常*/
    warstate: number;
}
/**
 * 后台返回前端的消息,包含一个flag和msg消息
 * 通常用于前台请求后台操作,后台返回是否成功
 *
 * 用于Controller层的返回值
 */
export interface Message {
    /**该操作是执行否成功*/
    flag: boolean;
    /**操作返回的消息, 该消息可以是字符串, 对象等*/
    msg: any;
}