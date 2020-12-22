
drop database if exists xsyx;
create database xsyx;
use xsyx;

-- 商户表
create table merchants (
        id int PRIMARY key AUTO_INCREMENT comment 'id',
        name varchar(30) comment '商户名称',
        address varchar(100) comment '商户地址',
        phone varchar(20) comment '商户电话',
        longitude float comment '经度',
        latitude float comment '纬度',
        open_time_from datetime comment '营业起始时间',
        open_time_to  datetime comment '营业结束时间',
        remark varchar(200) comment '商户备注',
        state int default 1 comment '商户状态, 0 被冻结, 1正常 , -1删除'
) COMMENT '商户表';


CREATE TABLE user(
        id int PRIMARY key AUTO_INCREMENT COMMENT 'id',
        username VARCHAR(45) COMMENT '用户名',
        password VARCHAR(45) COMMENT '密码',
        head_portrait VARCHAR(45) COMMENT '用户头像',
        phone VARCHAR(45) COMMENT '用户手机号码',
        signature VARCHAR(45) COMMENT '个性签名',
        birthday DATE COMMENT '生日',
        uname VARCHAR(45) COMMENT '姓名',
        sex VARCHAR(45) COMMENT '性别',
        id_card VARCHAR(45) COMMENT '身份证',
        merid int COMMENT '商户id',
        foreign key (merid) references merchants(id),
        last_login_time timestamp default now() comment '最后一次登录时间',
        is_delete int default 0 COMMENT '注销状态, 1注销, 0正常'
) COMMENT '用户表';

-- 商户申请表
create table merchants_apply (
        id int PRIMARY key AUTO_INCREMENT comment 'id',
        user_id int comment '用户id外键',
        FOREIGN key (user_id) REFERENCES user(id),
        name varchar(30) comment '商户名称',
        address varchar(100) comment '商户地址',
        apply_time TIMESTAMP default now() comment '申请时间',
        user_message varchar(100) comment '用户消息',
        state int default 0 comment '审核状态 , 0未审核',
        system_message varchar(100) comment '系统消息',
        is_read int default 0 comment '是否已读'
) comment '商户申请表';

-- 角色表
-- id
-- 角色名称
-- 角色备注
create table role (
        id int PRIMARY key AUTO_INCREMENT comment 'id',
        name varchar(30) comment '角色名称',
        remark varchar(50) comment '角色备注'
) comment '角色表';

-- 员工表

create table employee (
        id int PRIMARY key AUTO_INCREMENT comment 'id',
        name varchar(30) comment '员工姓名',
        password varchar(30) default '123456' comment '登录密码',
        image varchar(50) comment '头像',
        sex varchar(4) comment '性别',
        phone varchar(20) comment '手机号',
        ic_card varchar(25) comment '身份证号码',
        address varchar(50) comment '员工住址',
        email varchar(30) comment '邮箱',
        remark varchar(100) comment '备注',
        last_login_time timestamp default now() comment '最后一次登录日期',
        state int default 1 comment '员工状态, 0冻结, 1正常, -1删除'
)comment '员工表';


-- 菜单功能表
create table menu (
        id int primary key AUTO_INCREMENT comment 'id',
        name varchar(20) comment '菜单名称',
        icon varchar(50) comment '菜单图标',
        url varchar(30) comment '访问路径',
        layer int comment '菜单层级',
        type varchar(10) comment '功能类型',
        parent int default null comment '父级菜单',
        FOREIGN key (parent) REFERENCES menu(id)
) comment '菜单功能表';


-- 权限表
-- id
-- 菜单id 外键
-- 角色id 外键
create table permission (
        id int primary key AUTO_INCREMENT comment 'id',
        menu int comment '菜单',
        foreign key (menu) references menu(id),
        role int comment '角色',
        foreign key (role) references role(id)
) comment '权限表';


-- 员工角色表
-- id
-- 员工id 外键
-- 角色id 外键
create table emprole (
        id int primary key AUTO_INCREMENT comment 'id',
        employee int comment '员工',
        foreign key (employee) references employee(id),
        role int comment '角色',
        foreign key (role) references role(id)
) comment '员工角色表';


-- 商品类型表
create table com_type (
        id int primary key AUTO_INCREMENT comment 'id',
        name varchar(30) COMMENT '类型名称'
) comment '商品类型表';

-- 商品表
-- 商品下架会立刻下架
-- 预览图默认以第一张作为封面
-- 而商品上架则会根据最新上架时间来上架
create table commodity (
        id int primary key AUTO_INCREMENT comment 'id',
        name varchar(50) comment '商品名称',
        particulars text comment '商品描述',
        image varchar(100) comment '商品图片',
        price float comment '商品价格',
        unit varchar(5) comment '单位',
        specification varchar(20) comment '规格',
        manufacturer varchar(30) comment '生产厂商',
        com_type int comment '商品类型 , 外键',
        foreign key (com_type) references com_type(id),
        putaway_date date comment '商品上架时间(第一次上架时间)',
        newest_putaway_date datetime comment '最新上架时间',
        state int default 0 comment '商品状态, 0未上架, 1已上架, -1已删除'
) comment '商品表';

-- 商品图片表
create table com_image (
        id int primary key AUTO_INCREMENT comment 'id',
        commodity int comment '商品id , 外键',
        url varchar(100) comment '路径'
) comment '商品图片表';


-- 商品折扣表
create table com_discount (
        id int primary key AUTO_INCREMENT comment 'id',
        commodity int comment '商品id , 外键',
        start_time datetime comment '起始时间',
        end_time datetime comment '结束时间',
        discount float comment '折率 , 0 - 10之间',
        remark varchar(100) comment '备注'
) comment '商品折扣表';


-- 商品标签表
create table com_label (
        id int primary key AUTO_INCREMENT comment 'id',
        name varchar(20) comment '标签名称'
) comment '商品标签表';


#仓库管理-----------------------------------------------------------------------
#仓库表
CREATE TABLE warehouse (
        #仓库编号
        warid  INT COMMENT '仓库编号' AUTO_INCREMENT PRIMARY KEY,
        #仓库名
        warname VARCHAR(50) COMMENT '仓库名',
        #仓库类型
        wartype VARCHAR(50) COMMENT '仓库类型',
        #仓库容量
        warcapacity INT COMMENT '仓库容量',
        #仓库地址
        waraddress VARCHAR(50) COMMENT '仓库地址',
        longitude float comment '经度',
        latitude float comment '纬度',
        #仓库状态（正常or冻结）
        warstate int default 1 COMMENT '仓库状态, 0冻结, 1正常'
) COMMENT '仓库表';


#采购订单表
CREATE TABLE purchaseorder(
        #订单id
        orderid INT COMMENT '订单id' AUTO_INCREMENT PRIMARY KEY,
        #申请人
        applicant int COMMENT '申请人',
        foreign key (applicant) references employee(id),
        #申请人备注
        applicantremarks VARCHAR(50) COMMENT '申请人备注',
        #审批人
        approvedby int COMMENT '审批人',
        foreign key (approvedby) references employee(id),
        #状态（未审核，通过，拒绝）  点击审核后 状态改变 操作时间也改变
        state int default 0 COMMENT '状态, 0未审核，1通过，-1拒绝',
        #审核人备注
        approvedbyremarks VARCHAR(50) COMMENT '审核人备注',
        #操作时间
        operationtime timestamp default now() COMMENT '操作时间'
)COMMENT '采购订单表';


#商品存储表
#（商品资料表只是资料而已，这个是我们有些什么货，
#有一个字段表示这个商品是那个仓库的，可以存在多个名字一样的商品但仓库不同）
#字段和商品资料表差不多

#采购管理-----------------------------------------------------------------------
#采购表（采购申请记录）
CREATE TABLE purchase(
        #记录编号
        id INT COMMENT '记录编号' AUTO_INCREMENT PRIMARY KEY,
        #订单id
        orderid INT COMMENT '订单id',
        #商品id
        commodityid INT COMMENT '商品id',
        #商品名
        commodityname VARCHAR(50) COMMENT '商品名',
        #商品价格  （可以在点击这个商品的时候提示商品资料表的推荐进货价格）
        price FLOAT COMMENT '商品价格',
        #商品数量
        commoditysum INT COMMENT '商品数量',

        #采购订单表外键
        FOREIGN KEY (orderid) REFERENCES purchaseorder(orderid),
        #商品id外键
        foreign key (commodityid) references commodity(id)

)COMMENT '采购表（采购申请记录）';


CREATE TABLE shopcar(
        id int PRIMARY key AUTO_INCREMENT COMMENT 'id',
        number int COMMENT '数量',
        jointime TIMESTAMP DEFAULT NOW() COMMENT '加入购物车时间',
        totalprice FLOAT COMMENT '总价',
        cid int COMMENT '商品id',
        foreign key (cid) references commodity(id),
        uid int COMMENT '用户id',
        foreign key (uid) references user(id)
)COMMENT '购物车表';


CREATE TABLE comments(
        id int PRIMARY key AUTO_INCREMENT COMMENT 'id',
        content VARCHAR(200) COMMENT '评价内容',
        comtime TIMESTAMP DEFAULT NOW() COMMENT '评价时间',
        cid int COMMENT '商品id',
        foreign key (cid) references commodity(id),
        uid int COMMENT '用户id',
        foreign key (uid) references user(id),
        isdelete int default 0 COMMENT '评论删除状态, 0未删除, 1已删除'
)COMMENT '用户评价表';


CREATE TABLE star (
        id int primary key auto_increment comment 'id',
        uid int COMMENT '用户id',
        foreign key (uid) references user(id),
        cid int COMMENT '商品id',
        foreign key (cid) references commodity(id),
        count float comment '星星数量'
) COMMENT '评星表';

CREATE TABLE collect(
        id int PRIMARY key AUTO_INCREMENT COMMENT 'id',
        coltime	TIMESTAMP DEFAULT NOW() COMMENT '收藏时间' ,
        cid int COMMENT '商品id',
        foreign key (cid) references commodity(id)
)COMMENT '收藏表';

CREATE TABLE com_order(
        id int PRIMARY key AUTO_INCREMENT COMMENT 'id',
        ordstate int COMMENT '订单状态',
        order_number VARCHAR(45) COMMENT '订单编号',
        isdelete int default 0 COMMENT '删除状态, 0未删除, 1已删除',
        sid int COMMENT '购物车id',
        foreign key (sid) references shopcar(id)
)COMMENT '订单表';




CREATE TABLE information(
        id int PRIMARY key AUTO_INCREMENT COMMENT 'id',
        content VARCHAR(45) COMMENT '聊天信息',
        sendtime TIMESTAMP DEFAULT NOW() COMMENT '发送时间',
        uid int COMMENT '发件人id',
        foreign key (uid) references user(id),
        userid int COMMENT '收件人id',
        foreign key (userid) references user(id),
        infstate int COMMENT '消息接收状态',
        is_read int default 0 comment '是否已读, 1已读, 0未读'
)COMMENT '用户交流表';


CREATE TABLE pickup(
        id int PRIMARY key AUTO_INCREMENT COMMENT 'id',
        address VARCHAR(45) COMMENT '收货地址',
        phone varchar(25) comment '收货电话',
        ptime TIMESTAMP DEFAULT NOW() COMMENT '收货时间',
        pstate int default 0 COMMENT '收货状态, 0未发货, 1送货中, 2未领取, 3已领取',
        uid int COMMENT '用户id'
)COMMENT '收货表';

-- 收货门店表
create table pickup_merchants(
        id int primary key auto_increment comment 'id',
        user int comment '用户,外键',
        foreign key (user) references user(id),
        merchant int comment '收货商户',
        foreign key (merchant) references merchants(id),
        remark varchar(100) comment '备注',
        create_time timestamp default now() comment '创建时间'
) comment '收货门店表(收货地址)';

-- 用户日志表
create table user_log (
        id int primary key auto_increment comment 'id',
        user int comment '用户,外键',
        foreign key (user) references user(id),
        content varchar(100) comment '日志内容',
        data varchar(500) comment '附加数据, 可选',
        time timestamp default now() comment '时间'
) comment '用户日志表';

-- 员工日志表
create table emp_log (
        id int primary key auto_increment comment 'id',
        emp int comment '员工,外键',
        foreign key (emp) references employee(id),
        content varchar(100) comment '日志内容',
        data varchar(500) comment '附加数据, 可选',
        time timestamp default now() comment '时间'
) comment '员工日志表';

-- 商户日志表
create table mer_log (
        id int primary key auto_increment comment 'id',
        emp int comment '用户,外键',
        foreign key (emp) references user(id),
        content varchar(100) comment '日志内容',
        data varchar(500) comment '附加数据, 可选',
        time timestamp default now() comment '时间'
) comment '商户日志表';

-- 用户搜索记录表
create table search_record (
        id int primary key auto_increment comment 'id',
        user int comment '用户,外键',
        foreign key (user) references user(id),
        content varchar(50) comment '搜索内容',
        time timestamp default now() comment '搜索时间'
) comment '用户搜索记录表';

-- 用户浏览历史表
create table look_history (
        id int primary key auto_increment comment 'id',
        user int comment '用户, 外键',
        foreign key (user) references user(id),
        cid int comment '浏览商品, 外键',
        foreign key (cid) references commodity(id),
        time timestamp default now() comment '浏览时间'
) comment '用户浏览历史表';



-- select * from emp_log;
-- select * from user_log;


-- **************************************************** 数据部分 **************************************************

-- ***************
-- 用户部分
-- ***************
insert into user values (null,'小明','123456789',null,'15273289100','哈哈哈',null,'明明','男',null,null,default,default);
insert into user values (null,'小张','111111111',null,'15273289101','哈哈哈',null,'张某','男',null,null,default,default);

-- ***************
-- 后台菜单 , 父级菜单id + 当前id(两位)
-- ***************
-- 模块部分
insert into menu VALUE (1,'商品管理','el-icon-folder-opened','/url',1,'模块',null);
insert into menu VALUE (2,'商户管理','el-icon-folder-opened','/url',1,'模块',null);
insert into menu VALUE (3,'仓库管理','el-icon-folder-opened','/url',1,'模块',null);
insert into menu VALUE (4,'采购管理','el-icon-folder-opened','/url',1,'模块',null);
insert into menu VALUE (5,'配送管理','el-icon-folder-opened','/url',1,'模块',null);
insert into menu VALUE (6,'统计管理','el-icon-folder-opened','/url',1,'模块',null);
-- 页面部分(这里列出了所有的,写不完的可以删掉)
insert into menu values (100,'商品资料维护','el-icon-folder-opened','/url',2,'页面',1);
insert into menu values (101,'商品类型维护','el-icon-folder-opened','/url',2,'页面',1);
insert into menu values (102,'商品标签维护','el-icon-folder-opened','/url',2,'页面',1);

insert into menu values (200,'商户资料维护','el-icon-folder-opened','/url',2,'页面',2);
insert into menu values (201,'商户申请审批','el-icon-folder-opened','/url',2,'页面',2);

insert into menu values (300,'仓库信息维护','el-icon-folder-opened','/url',2,'页面',3);

insert into menu values (301,'商品采购申请','el-icon-folder-opened','/url',2,'页面',4);
insert into menu values (302,'商品采购审批','el-icon-folder-opened','/url',2,'页面',4);

insert into menu values (400,'配送订单管理','el-icon-folder-opened','/url',2,'页面',5);
insert into menu values (401,'断货商品管理','el-icon-folder-opened','/url',2,'页面',5);

insert into menu values (500,'商品信息统计','el-icon-folder-opened','/url',2,'页面',6);
insert into menu values (501,'商户信息统计','el-icon-folder-opened','/url',2,'页面',6);
insert into menu values (502,'仓库信息统计','el-icon-folder-opened','/url',2,'页面',6);

-- 按钮部分(这里只是基本,自行调整)
-- 商品资料维护
insert into menu values (10000,'商品添加','el-icon-folder-opened','/url',3,'按钮',100);
insert into menu values (10001,'商品修改','el-icon-folder-opened','/url',3,'按钮',100);
insert into menu values (10002,'商品下架','el-icon-folder-opened','/url',3,'按钮',100);
insert into menu values (10003,'商品删除','el-icon-folder-opened','/url',3,'按钮',100);
insert into menu values (10004,'商品上架','el-icon-folder-opened','/url',3,'按钮',100);
insert into menu values (10005,'商品打折','el-icon-folder-opened','/url',3,'按钮',100);
-- 商品类型维护
insert into menu values (10100,'类型添加','el-icon-folder-opened','/url',3,'按钮',101);
insert into menu values (10101,'类型修改','el-icon-folder-opened','/url',3,'按钮',101);
insert into menu values (10102,'类型删除','el-icon-folder-opened','/url',3,'按钮',101);
insert into menu values (10103,'类型搜索','el-icon-folder-opened','/url',3,'按钮',101);
-- 商品标签维护
insert into menu values (10200,'标签添加','el-icon-folder-opened','/url',3,'按钮',102);
insert into menu values (10201,'标签修改','el-icon-folder-opened','/url',3,'按钮',102);
insert into menu values (10202,'标签删除','el-icon-folder-opened','/url',3,'按钮',102);
insert into menu values (10203,'标签搜索','el-icon-folder-opened','/url',3,'按钮',102);
-- 商户资料维护
insert into menu values (20000,'商户查询','el-icon-folder-opened','/url',3,'按钮',200);
insert into menu values (20001,'商户冻结','el-icon-folder-opened','/url',3,'按钮',200);
insert into menu values (20002,'商户修改','el-icon-folder-opened','/url',3,'按钮',200);
insert into menu values (20003,'商户删除','el-icon-folder-opened','/url',3,'按钮',200);
-- 商户申请审批
insert into menu values (20100,'记录查询','el-icon-folder-opened','/url',3,'按钮',201);
insert into menu values (20101,'审批通过','el-icon-folder-opened','/url',3,'按钮',201);
insert into menu values (20102,'审批拒绝','el-icon-folder-opened','/url',3,'按钮',201);
-- 仓库信息维护
insert into menu values (30000,'仓库添加','el-icon-folder-opened','/url',3,'按钮',300);
insert into menu values (30001,'仓库修改','el-icon-folder-opened','/url',3,'按钮',300);
insert into menu values (30002,'仓库冻结','el-icon-folder-opened','/url',3,'按钮',300);
insert into menu values (30003,'商品类型分配','el-icon-folder-opened','/url',3,'按钮',300);
insert into menu values (30004,'商品下限设置','el-icon-folder-opened','/url',3,'按钮',300);
-- 商品采购申请
insert into menu values (40000,'采购申请','el-icon-folder-opened','/url',3,'按钮',400);
insert into menu values (40001,'记录查询','el-icon-folder-opened','/url',3,'按钮',400);
-- 商品采购审批
insert into menu values (40100,'记录查询','el-icon-folder-opened','/url',3,'按钮',401);
insert into menu values (40101,'审批通过','el-icon-folder-opened','/url',3,'按钮',401);
insert into menu values (40102,'审批拒绝','el-icon-folder-opened','/url',3,'按钮',401);
-- 配送订单管理
insert into menu values (50000,'订单查询','el-icon-folder-opened','/url',3,'按钮',500);
-- 断货商品管理
-- insert into menu values (50100,'???','el-icon-folder-opened','/url',3,'按钮',501);
-- 商品信息统计
-- insert into menu values (60000,'???','el-icon-folder-opened','/url',3,'按钮',600);
-- 商户信息统计
-- insert into menu values (60100,'???','el-icon-folder-opened','/url',3,'按钮',601);
-- 仓库信息统计
-- insert into menu values (60200,'???','el-icon-folder-opened','/url',3,'按钮',602);


-- ***************
-- 角色部分
-- ***************
insert into role values (1,'超级管理员','该角色拥有最高权限');
insert into role values (2,'商品管理员','负责管理商品');
insert into role values (3,'商户管理员','负责管理商户');

-- ***************
-- 员工部分
-- ***************
insert into employee values (null,'张三',default,null,'男','15273289100','430321200110179999','湖南湘潭','1911159016@qq.com','备注',null,default);
insert into employee values (null,'李四',default,null,'男','15273289101','430321200110179998','湖南长沙','1911159017@qq.com','备注',null,default);

-- ***************
-- 权限部分
-- ***************
insert into permission values (null,10000,2);
insert into permission values (null,10001,2);
insert into permission values (null,10002,2);
insert into permission values (null,10003,2);
insert into permission values (null,10004,2);
insert into permission values (null,10005,2);
insert into permission values (null,10100,2);
insert into permission values (null,10101,2);
insert into permission values (null,10102,2);
insert into permission values (null,10103,2);
insert into permission values (null,10200,2);
insert into permission values (null,10201,2);
insert into permission values (null,10202,2);
insert into permission values (null,10203,2);

insert into permission values (null,20000,3);
insert into permission values (null,20001,3);
insert into permission values (null,20002,3);
insert into permission values (null,20003,3);
insert into permission values (null,20100,3);
insert into permission values (null,20101,3);
insert into permission values (null,20102,3);



-- ***************
-- 员工角色
-- ***************
insert into emprole value (null,1,1);
insert into emprole value (null,2,2);

-- ***************
-- 商品类型
-- ***************
insert com_type values (1,'蔬菜');
insert com_type values (2,'水果');
insert com_type values (3,'熟食');

-- ***************
-- 商品
-- ***************
insert into commodity(id, name, particulars,image, price, unit, specification, manufacturer, com_type, putaway_date, newest_putaway_date, state)
values (null,'西红柿','西红柿的描述','',2,'斤','斤','话农兄弟',1,default,default,default);
