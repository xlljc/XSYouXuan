
/**
 * 表名:  collect<br/>
 * 表注释: 收藏表
 */
export interface Collect {
    /**id*/
    id?: number;
    /**收藏时间*/
    coltime?: string;
    /**商品id*/
    cid?: Commodity;

    [key: string]: any;
}

/**
 * 表名:  com_discount<br/>
 * 表注释: 商品折扣表
 */
export interface ComDiscount {
    /**id*/
    id?: number;
    /**商品id*/
    commodity?: number;
    /**起始时间*/
    startTime?: string;
    /**结束时间*/
    Date?: string;
    /**折率 , 0 - 10之间*/
    discount?: number;
    /**备注*/
    remark?: string;

    [key: string]: any;
}

/**
 * 表名:  com_image<br/>
 * 表注释: 商品图片表
 */
export interface ComImage {
    /**id*/
    id?: number;
    /**商品id , 外键*/
    commodity?: number;
    /**路径*/
    url?: string;

    [key: string]: any;
}

/**
 * 表名:  com_label<br/>
 * 表注释: 商品标签表
 */
export interface ComLabel {
    /**id*/
    id?: number;
    /**标签名称*/
    name?: string;

    [key: string]: any;
}

/**
 * 表名:  comments<br/>
 * 表注释: 用户评价表
 */
export interface Comments {
    /**id*/
    id?: number;
    /**评价内容*/
    content?: string;
    /**评价时间*/
    comtime?: string;
    /**商品id*/
    cid?: number;
    /**用户id*/
    uid?: number;
    /**评论删除状态, 0未删除, 1已删除*/
    isdelete?: number;

    [key: string]: any;
}

/**
 * 表名:  commodity<br/>
 * 表注释: 商品表
 */
export interface Commodity {
    /**id*/
    id?: number;
    /**商品名称*/
    name?: string;
    /**商品描述*/
    particulars?: string;
    /**商品图片*/
    image?: string;
    /**商品价格*/
    price?: number;
    /**单位*/
    unit?: string;
    /**规格*/
    specification?: string;
    /**生产厂商*/
    manufacturer?: string;
    /**商品类型 , 外键*/
    comType?: ComType;
    /**商品上架时间(第一次上架时间)*/
    putawayDate?: string;
    /**最新上架时间*/
    newestPutawayDate?: string;
    /**商品状态, 0未上架, 1已上架, -1已删除*/
    state?: number;
    /**商品折扣表, 扩展列*/
    comDiscount?: ComDiscount;
    collects?: Collect[];
    commentss?: Comments[];
    lookHistorys?: LookHistory[];
    purchases?: Purchase[];
    shopcars?: Shopcar[];
    stars?: Star[];

    [key: string]: any;
}

/**
 * 表名:  com_order<br/>
 * 表注释: 订单表
 */
export interface ComOrder {
    /**id*/
    id?: number;
    /**订单状态*/
    ordstate?: number;
    /**订单编号*/
    orderNumber?: string;
    /**删除状态, 0未删除, 1已删除*/
    isdelete?: number;
    /**购物车id*/
    sid?: Shopcar;

    [key: string]: any;
}

/**
 * 表名:  com_type<br/>
 * 表注释: 商品类型表
 */
export interface ComType {
    /**id*/
    id?: number;
    /**类型名称*/
    name?: string;
    commoditys?: Commodity[];

    [key: string]: any;
}

/**
 * 表名:  emp_log<br/>
 * 表注释: 员工日志表
 */
export interface EmpLog {

    /**id*/
    id?: number;
    /**员工,外键*/
    emp?: Employee;
    /**日志内容*/
    content?: string;
    /**附加数据, 可选*/
    data?: string;
    /**时间*/
    time?: string;

    [key: string]: any;
}

/**
 * 表名:  employee<br/>
 * 表注释: 员工表
 */
export interface Employee {
    /**id*/
    id?: number;
    /**员工姓名*/
    name?: string;
    /**登录密码*/
    password?: string;
    /**头像*/
    image?: string;
    /**性别*/
    sex?: string;
    /**手机号*/
    phone?: string;
    /**身份证号码*/
    icCard?: string;
    /**员工住址*/
    address?: string;
    /**邮箱*/
    email?: string;
    /**备注*/
    remark?: string;
    /**最后一次登录日期*/
    lastLoginTime?: string;
    /**员工状态, 0冻结, 1正常, -1删除*/
    state?: number;
    empLogs?: EmpLog[];
    purchaseorders?: Purchaseorder[];

    [key: string]: any;
}

/**
 * 表名:  emprole<br/>
 * 表注释: 员工角色表
 */
export interface Emprole {
    /**id*/
    id?: number;
    /**员工*/
    employee?: number;
    /**角色*/
    role?: number;

    [key: string]: any;
}

/**
 * 表名:  information<br/>
 * 表注释: 用户交流表
 */
export interface Information {
    /**id*/
    id?: number;
    /**聊天信息*/
    content?: string;
    /**发送时间*/
    sendtime?: string;
    /**发件人id*/
    uid?: User;
    /**收件人id*/
    userid?: number;
    /**消息接收状态*/
    infstate?: number;
    /**是否已读, 1已读, 0未读*/
    isRead?: number;

    [key: string]: any;
}

/**
 * 表名:  look_history<br/>
 * 表注释: 用户浏览历史表
 */
export interface LookHistory {
    /**id*/
    id?: number;
    /**用户, 外键*/
    user?: User;
    /**浏览商品, 外键*/
    cid?: Commodity;
    /**浏览时间*/
    time?: string;

    [key: string]: any;
}

/**
 * 表名:  menu<br/>
 * 表注释: 菜单功能表
 */
export interface Menu {
    /**id*/
    id?: number;
    /**菜单名称*/
    name?: string;
    /**菜单图标*/
    icon?: string;
    /**访问路径*/
    url?: string;
    /**菜单层级*/
    layer?: number;
    /**功能类型*/
    type?: string;
    /**父级菜单*/
    parent?: Menu;
    menus?: Menu[];

    [key: string]: any;
}

/**
 * 表名:  merchants<br/>
 * 表注释: 商户表
 */
export interface Merchants {
    /**id*/
    id?: number;
    /**商户名称*/
    name?: string;
    /**商户地址*/
    address?: string;
    /**商户电话*/
    phone?: string;
    /**经度*/
    longitude?: number;
    /**纬度*/
    latitude?: number;
    /**营业起始时间*/
    openTimeFrom?: string;
    /**营业结束时间*/
    openTimeTo?: string;
    /**商户备注*/
    remark?: string;
    /**商户状态, 0 被冻结, 1正常 , -1删除*/
    state?: number;
    pickupMerchantss?: PickupMerchants;
    users?: User;

    [key: string]: any;
}

/**
 * 表名:  merchants_apply<br/>
 * 表注释: 商户申请表
 */
export interface MerchantsApply {
    /**id*/
    id?: number;
    /**用户id外键*/
    userId?: User;
    /**商户名称*/
    name?: string;
    /**商户地址*/
    address?: string;
    /**申请时间*/
    applyTime?: string;
    /**用户消息*/
    userMessage?: string;
    /**审核状态 , 0未审核*/
    state?: string;
    /**系统消息*/
    systemMessage?: string;
    /**是否已读*/
    isRead?: number;

    [key: string]: any;
}

/**
 * 表名:  mer_log<br/>
 * 表注释: 商户日志表
 */
export interface MerLog {
    /**id*/
    id?: number;
    /**用户,外键*/
    emp?: User;
    /**日志内容*/
    content?: string;
    /**附加数据, 可选*/
    data?: string;
    /**时间*/
    time?: string;

    [key: string]: any;
}

/**
 * 表名:  permission<br/>
 * 表注释: 权限表
 */
export interface Permission {
    /**id*/
    id?: number;
    /**菜单*/
    menu?: number;
    /**角色*/
    role?: number;

    [key: string]: any;
}

/**
 * 表名:  pickup<br/>
 * 表注释: 收货表
 */
export interface Pickup {
    /**id*/
    id?: number;
    /**收货地址*/
    address?: string;
    /**收货电话*/
    phone?: string;
    /**收货时间*/
    ptime?: string;
    /**收货状态, 0未发货, 1送货中, 2未领取, 3已领取*/
    pstate?: number;
    /**用户id*/
    uid?: number;

    [key: string]: any;
}

/**
 * 表名:  pickup_merchants<br/>
 * 表注释: 收货门店表(收货地址)
 */
export interface PickupMerchants {
    /**id*/
    id?: number;
    /**用户,外键*/
    user?: User;
    /**收货商户*/
    merchant?: Merchants;
    /**备注*/
    remark?: string;
    /**创建时间*/
    createTime?: string;

    [key: string]: any;
}

/**
 * 表名:  purchase<br/>
 * 表注释: 采购表（采购申请记录）
 */
export interface Purchase {
    /**记录编号*/
    id?: number;
    /**订单id*/
    orderid?: Purchaseorder;
    /**商品id*/
    commodityid?: Commodity;
    /**商品名*/
    commodityname?: string;
    /**商品价格*/
    price?: number;
    /**商品数量*/
    commoditysum?: number;

    [key: string]: any;
}

/**
 * 表名:  purchaseorder<br/>
 * 表注释: 采购订单表
 */
export interface Purchaseorder {
    /**订单id*/
    orderid?: number;
    /**申请人*/
    applicant?: Employee;
    /**申请人备注*/
    applicantremarks?: string;
    /**审批人*/
    approvedby?: Employee;
    /**状态, 0未审核，1通过，-1拒绝*/
    state?: number;
    /**审核人备注*/
    approvedbyremarks?: string;
    /**操作时间*/
    operationtime?: string;
    purchases?: Purchase[];

    [key: string]: any;
}

/**
 * 表名:  role<br/>
 * 表注释: 角色表
 */
export interface Role {
    /**id*/
    id?: number;
    /**角色名称*/
    name?: string;
    /**角色备注*/
    remark?: string;
    /**拥有该角色的员工数量*/
    hasEmpCount?: number;
    [key: string]: any;
}

/**
 * 表名:  search_record<br/>
 * 表注释: 用户搜索记录表
 */
export interface SearchRecord {
    /**id*/
    id?: number;
    /**用户,外键*/
    user?: User;
    /**搜索内容*/
    content?: string;
    /**搜索时间*/
    time?: string;

    [key: string]: any;
}

/**
 * 表名:  shopcar<br/>
 * 表注释: 购物车表
 */
export interface Shopcar {
    /**id*/
    id?: number;
    /**数量*/
    number?: number;
    /**加入购物车时间*/
    jointime?: string;
    /**总价*/
    totalprice?: number;
    /**商品id*/
    cid?: Commodity;
    /**用户id*/
    uid?: User;
    comOrders?: ComOrder[];

    [key: string]: any;
}

/**
 * 表名:  star<br/>
 * 表注释: 评星表
 */
export interface Star {
    /**id*/
    id?: number;
    /**用户id*/
    uid?: User;
    /**商品id*/
    cid?: Commodity;
    /**星星数量*/
    count?: number;

    [key: string]: any;
}

/**
 * 表名:  user<br/>
 * 表注释: 用户表
 */
export interface User {
    /**id*/
    id?: number;
    /**用户名*/
    username?: string;
    /**密码*/
    password?: string;
    /**用户头像*/
    headPortrait?: string;
    /**用户手机号码*/
    phone?: string;
    /**个性签名*/
    signature?: string;
    /**生日*/
    birthday?: string;
    /**姓名*/
    uname?: string;
    /**性别*/
    sex?: string;
    /**身份证*/
    idCard?: string;
    /**商户id*/
    merid?: Merchants;
    /**最后一次登录时间*/
    lastLoginTime?: string;
    /**注销状态, 1注销, 0正常*/
    isDelete?: number;
    commentss?: Comments[];
    informations?: Information[];
    lookHistorys?: LookHistory[];
    merLogs?: MerLog[];
    merchantsApplys?: MerchantsApply[];
    pickupMerchantss?: PickupMerchants[];
    searchRecords?: SearchRecord[];
    shopcars?: Shopcar[];
    stars?: Star[];
    userLogs?: UserLog[];

    [key: string]: any;
}

/**
 * 表名:  user_log<br/>
 * 表注释: 用户日志表
 */
export interface UserLog {
    /**id*/
    id?: number;
    /**用户,外键*/
    user?: User;
    /**日志内容*/
    content?: string;
    /**附加数据, 可选*/
    data?: string;
    /**时间*/
    time?: string;

    [key: string]: any;
}

/**
 * 表名:  warehouse<br/>
 * 表注释: 仓库表
 */
export interface Warehouse {
    /**仓库编号*/
    warid?: number;
    /**仓库名*/
    warname?: string;
    /**仓库类型*/
    wartype?: string;
    /**仓库容量*/
    warcapacity?: number;
    /**仓库地址*/
    waraddress?: string;
    /**经度*/
    longitude?: number;
    /**纬度*/
    latitude?: number;
    /**仓库状态, 0冻结, 1正常*/
    warstate?: number;

    [key: string]: any;
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

    [key: string]: any;
}

/**
 * 分页显示存储对象
 */
export interface PageInfo<T> {
    /**数据总条数*/
    total?: number;
    /**结果集*/
    list?: T[];
    /**当前页数*/
    pageNum?: number;
    /**每页显示条数*/
    pageSize?: number;
    /**当前页的数量*/
    size?: number;
    /**当前页面第一个元素在数据库中的行号*/
    startRow?: number;
    /**当前页面最后一个元素在数据库中的行号*/
    endRow?: number;
    /**总页数*/
    pages?: number;
    /**前一页*/
    prePage?: number;
    /**下一页*/
    nextPage?: number;
    /**是否为第一页*/
    isFirstPage?: boolean;
    /**是否为最后一页*/
    isLastPage?: boolean;
    /**是否有前一页*/
    hasPreviousPage?: boolean;
    /**是否有下一页*/
    hasNextPage?: boolean;
    /**导航页码数*/
    navigatePages?: number;
    /**所有导航页号*/
    navigatepageNums?: number[];
    /**导航条上的第一页*/
    navigateFirstPage?: number;
    /**导航条上的最后一页*/
    navigateLastPage?: number;

    [key: string]: any;
}

/**
 * 文件列表文件对象
 */
export interface FileInfo {
    /**文件名称*/
    name?: string;
    /**文件访问地址*/
    url: string;
    /**事件状态*/
    status?: string;
    /**文件id*/
    uid?: number;

    [key: string]: any;
}

/**
 * 表单数据验证对象
 */
export interface ValidateRules {
    [key: string]: {
        //验证回调函数
        validator?: (rule: any, value: string, callback: (error?: Error) => void) => void;
        //是否非空
        required?: boolean;
        //验证类型
        type?: string;
        //错误消息
        message?: string;
        //触发类型
        trigger?: string | 'change' | 'blur';
        //正则表达式验证
        pattern?: RegExp;
        [key: string]: any;
    } [];
}

/**
 * 模态框模板数据
 */
export interface DialogTemplateData {
    //模态框标题
    title: string;
    //显示状态
    visible: boolean;
    //点击确定按钮
    success?: Function;
    //点击返回按钮
    cancel?: Function;

    [key: string]: any;
}

/**
 * 菜单树节点
 */
export interface MenuTree {
    //菜单id
    id?: number;
    //菜单显示文本
    label?: string;
    //嵌套菜单
    children?: MenuTree[];

    [key: string]: any;
}

/**
 * 衍生类, 商品订单详情类
 */
export interface OrderDetails {
    id?: number;
    orderNumber?: string;
    ordstate?: number;
    totlemoney?: number;
    commodityName?: string;
    commodityImage?: string;
    typeName?: string;
    number?: string;
    username?: string;
    uname?: string;
    phone?: string;
    deliveryTime?: string;
    pickUpTime?: string;
    merid?: number;
    merName?: string;
    address?: string;
    merPhone?: string;

    [key: string]: any;
}

/**
 * 商户统计实体类
 */
export interface ShopStatisticalType {
    comIncome?: { value: number; name: string }[];
    tiHuoCount?: number;
    yesterdayIncome?: number;
    shouHuoCount?: number;
    sum?: number;
    timeIncome?: { date: string; value: number }[];

    [key: string]: any;
}