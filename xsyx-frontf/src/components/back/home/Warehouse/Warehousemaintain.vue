<!--仓库信息维护页面-->
<template>
    <div>
        <!-- 模糊查询-->
        <el-input
                style="width: 300px"
                placeholder="请输入仓库名"
                v-model="input"
                clearable>
        </el-input>
        <el-button
                type="primary"
                slot="append"
                icon="el-icon-search"
                @click="MohuqueryWarehouse"
        >查询
        </el-button>
        <el-button
                type="success"
                slot="append"
                icon="el-icon-circle-plus"

        >添加
        </el-button>
        <!--strip 双行阴影效果属性-->
        <el-table
                border
                :data="tableData.rows"
                style="width: 100%;margin-top: 30px"
                @row-click="clickTableRow"
                v-loading="loading"
                highlight-current-row
                @row-contextmenu="rightClick">
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="仓库ID：">
                            <span>{{ props.row.warid }}</span>
                        </el-form-item>
                        <el-form-item label="仓库名称：">
                            <span>{{ props.row.warname }}</span>
                        </el-form-item>
                        <el-form-item label="仓库类型：">
                            <span>{{ props.row.wartype }}</span>
                        </el-form-item>
                        <el-form-item label="仓库容量：">
                            <span>{{ props.row.warcapacity }}</span>
                        </el-form-item>
                        <el-form-item label="仓库地址：">
                            <span>{{ props.row.waraddress }}</span>
                        </el-form-item>
                        <el-form-item label="仓库状态：">
                            <span>{{ getState(props.row.warstate) }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="仓库名"
                    prop="warname">
            </el-table-column>
            <el-table-column
                    label="仓库类型"
                    prop="wartype">
            </el-table-column>
            <el-table-column
                    label="仓库容量(剩余)"
                    prop="warcapacity">
            </el-table-column>


            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-tooltip class="item" effect="dark" content="修改仓库" placement="top-start">
                        <el-button
                                type="primary"
                                circle
                                icon="el-icon-edit"
                                size="medium"
                                @click="queryCommodityTypedetails(scope.$index, scope.row)"></el-button>
                    </el-tooltip>
                    <el-tooltip class="item" effect="dark" content="删除仓库" placement="top-start">
                        <el-button
                                type="danger"
                                circle
                                icon="el-icon-delete"
                                size="medium"
                                @click="deleteCommodityType(scope.$index, scope.row)"></el-button>
                    </el-tooltip>
                </template>
            </el-table-column>
        </el-table>
        <!--右键显示菜单-->
        <div id="menu">
            <div class="menu"
                 @click="openquerywarehousemotaikuang"
            ><i style="font-size: 15px" class="el-icon-lock"></i>查看仓库存储
            </div>
            <div class="menu"
                 @click="donjie"><i style="font-size: 15px" class="el-icon-lock"></i>冻结仓库</div>
            <div class="menu"
                 @click="opencaigoumotaikuang"><i style="font-size: 15px" class="el-icon-lock"></i>采购
            </div>
            <div class="menu"
                 @click="openzhuankumotaikuang"
            ><i style="font-size: 15px" class="el-icon-lock"></i>转库
            </div>
        </div>

        <div id="menu1">
            <div class="menu"
                 @click="jiedon"
            ><i style="font-size: 15px" class="el-icon-lock"></i>解冻
            </div>
        </div>
        <!--分页-->
        <el-pagination
                @size-change="rowsChange"
                @current-change="pageChange"
                :current-page="newpage"
                :page-sizes="[5, 10, 15, 20]"
                :page-size="5"
                layout="total, sizes, prev, pager, next, jumper"
                :total="tableData.total">
        </el-pagination>
        <!--仓库存储情况的模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="仓库存储情况"
                   :visible.sync="querywarehousemotaikuang">
            <el-table
                    border
                    :data="warehousestoragetableData"
                    style="width: 100%;margin-top: 30px">
                <el-table-column type="expand">
                    <template slot-scope="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                            <el-form-item label="仓库名：">
                                <span>{{ props.row.warname }}</span>
                            </el-form-item>
                            <el-form-item label="商品数量：">
                                <span>{{ props.row.number }}</span>
                            </el-form-item>
                            <el-form-item label="商品规格：">
                                <span>{{ props.row.specification }}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                        label="商品id"
                        prop="id">
                </el-table-column>
                <el-table-column
                        label="商品名称"
                        prop="name">
                </el-table-column>
            </el-table>

            <div slot="footer" class="dialog-footer">
                <el-button @click="querywarehousemotaikuang = false">取 消</el-button>
                <el-button type="primary" @click="querywarehousemotaikuang = false">确 定</el-button>
            </div>
        </el-dialog>
        <!--转库的模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="转库"
                   :visible.sync="zhuankumotaikuang">
            <el-table
                    border
                    :data="warehousestoragetableData"
                    style="width: 100%;margin-top: 30px">
                <el-table-column type="expand">
                    <template slot-scope="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                            <el-form-item label="仓库id：">
                                <span>{{ props.row.warid }}</span>
                            </el-form-item>
                            <el-form-item label="仓库名：">
                                <span>{{ props.row.warname }}</span>
                            </el-form-item>
                            <el-form-item label="商品数量：">
                                <span>{{ props.row.number }}</span>
                            </el-form-item>
                            <el-form-item label="商品规格：">
                                <span>{{ props.row.specification }}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                        label="商品id"
                        prop="id">
                </el-table-column>
                <el-table-column
                        label="商品名称"
                        prop="name">
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">

                        <el-button
                                type="primary"
                                size="medium"
                                @click="openselectwarehouse(scope.$index, scope.row)">转库
                        </el-button>

                    </template>
                </el-table-column>
            </el-table>

            <div slot="footer" class="dialog-footer">
                <el-button @click="zhuankumotaikuang = false">取 消</el-button>
                <el-button type="primary" @click="zhuankumotaikuang = false">确 定</el-button>
            </div>
        </el-dialog>
        <!--选择仓库的模态框-->
        <el-dialog
                :close-on-click-modal="false"
                :show-close="false"
                title="选择仓库"
                :visible.sync="selectwarehousemotaikuang">
            <el-form label-width="80px">
                <el-form-item label="仓库名:">
                    <el-select v-model="warehouseid" @change="warehousechange">
                        <el-option value="0" label="---请选择---"></el-option>
                        <el-option :value="ck.warid" :label="ck.warname" v-for="ck in warehouseAll" :key="ck.warid"
                                   :index="ck.warid"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="商品数量:">
                    <el-input style="width: 200px"
                              placeholder="请输入商品数量"
                              v-model="shopsum"
                              @change="getshopron"
                              clearable></el-input>
                </el-form-item>
                <el-form-item label="商品占位:">
                    <span>{{this.shopron}}</span>
                </el-form-item>
                <el-form-item label="仓库容量:">
                    <span>{{this.warehouseron}}</span>
                </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="cleanselectwarehouse">取 消</el-button>
                <el-button type="primary" @click="zhuanku">确 定</el-button>
            </div>
        </el-dialog>
        <!--采购模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="采购"
                   :visible.sync="caigoumotaikuang">
            <span>采购商品：</span>
            <el-table
                    border
                    :data="shoptableData.rows"
                    style="width: 100%;margin-top: 30px">
                <el-table-column type="expand">
                    <template slot-scope="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                            <el-form-item label="商品价格：">
                                <span>{{ props.row.price }}</span>
                            </el-form-item>
                            <el-form-item label="单位：">
                                <span>{{ props.row.unit }}</span>
                            </el-form-item>
                            <el-form-item label="规格：">
                                <span>{{ props.row.specification }}</span>
                            </el-form-item>
                            <el-form-item label="生产厂商：">
                                <span>{{ props.row.manufacturer }}</span>
                            </el-form-item>
                            <el-form-item label="商品类型：">
                                <span>{{ props.row.comType.name }}</span>
                            </el-form-item>
                            <el-form-item label="商品状态:">
                                <span>{{ getState(props.row.state) }}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                        label="商品 ID"
                        prop="id">
                </el-table-column>
                <el-table-column
                        label="商品名称"
                        prop="name">
                </el-table-column>
                <el-table-column
                        label="商品图片"
                        prop="image">
                    <template slot-scope="props">
                        <el-image fit="cover" :src="$host+props.row.image" :preview-src-list="[$host+props.row.image]"
                                  style="width: 100px;height: 50px"></el-image>
                    </template>
                </el-table-column>
                <el-table-column
                        label="描述"
                        prop="particulars">
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                                type="primary"
                                size="medium"
                                @click="opencaigousummotaikuang(scope.$index, scope.row)">采购
                        </el-button>
                    </template>
                </el-table-column>

            </el-table>
            <!--分页-->
            <el-pagination
                    @size-change="rowsChange1"
                    @current-change="pageChange1"
                    :current-page="newpage1"
                    :page-sizes="[5, 10, 15, 20]"
                    :page-size="5"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="shoptableData.total">
            </el-pagination>
            <span>采购单：</span>
            <!--采购添加的表-->
            <el-table
                    border
                    v-model="PurchaseLinShiData"
                    :data="PurchaseLinShiData"
                    style="width: 100%;margin-top: 30px">
                <el-table-column type="expand">
                    <template slot-scope="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                            <el-form-item label="商品价格：">
                                <span>{{ props.row.price }}</span>
                            </el-form-item>
                            <el-form-item label="商品规格：">
                                <span>{{ props.row.specification }}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                        label="商品id"
                        prop="id">
                </el-table-column>
                <el-table-column
                        label="商品名称"
                        prop="name">
                </el-table-column>
                <el-table-column
                        label="采购数量"
                        prop="caigousum">
                </el-table-column>
            </el-table>
            <div style="float: right">
            <span>总价：<a style="color:red;">{{this.PurchaseLinShiShopZon}}</a></span>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click="cleanPurchaseLinShi">取 消</el-button>
                <el-button type="primary" @click="openCaiGouBeiZhu">确 定</el-button>
            </div>
        </el-dialog>

        <!--点击采购弹出输入数量的模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="输入采购数量"
                   :visible.sync="caigousummotaikuang">
                <el-input
                        style="width: 300px"
                        placeholder="---请输入---"
                        v-model="caigousum"
                        clearable>
                </el-input>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary"  @click="tianjiacaigou">确 定</el-button>
            </div>
        </el-dialog>
        <!--点击确定采购按钮弹出申请人写备注的模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="备注"
                   :visible.sync="caigoubeizhu">
            <el-input
                    style="width: 300px"
                    placeholder="---请输入---"
                    v-model="beizhu"
                    clearable>
            </el-input>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="SubmitCaiGou">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";
    import {Commodity as Com, Employee, Warehouse} from "@/helper/entity";
    import {EmpHelper} from "@/helper/back/EmpHelper";

    //声明 分页类型
    export interface PageInfo {
        //这个{}可以换成返回的对象类型
        rows?: Warehouse[];
        total?: number;
        //后面自己加
    }

    @Component
    export default class Warehousemaintain extends Vue {
        /*延迟表格加载*/
        loading: boolean = true;

        //添加模态框的状态
        addmotaikuang = false;
        //修改模态框的状态
        updatemotaikuang = false;
        //查看仓库存储信息模态框的状态
        querywarehousemotaikuang = false;
        //转库模态框状态
        zhuankumotaikuang = false;
        //选择仓库的模态框状态
        selectwarehousemotaikuang = false;
        //采购模态框
        caigoumotaikuang = false;
        //采购数量模态框
        caigousummotaikuang=false;
        //采购人备注模态框状态
        caigoubeizhu=false;
        //搜索框的变量
        input: string = "";

        //仓库数据
        tableData: PageInfo = {};
        //仓库存储商品数据
        warehousestoragetableData: any[] = []
        //所有仓库数据
        warehouseAll: any[] = []

        //商品数据(包括图片)
        shoptableData: PageInfo = {};

        //仓库分页------
        //当前页数
        newpage: number = 1;
        //分页页码的值
        page: number = 1;
        //分页一页多少行的值
        rows: number = 5;
        //采购商品分页-----
        newpage1: number = 1;
        //分页页码的值
        page1: number = 1;
        //分页一页多少行的值
        rows1: number = 5;

        // 获取当前右键点击的仓库id
        currentRowIndex: number = 0;

        //点击转库 选择仓库界面的变量
        //仓库名（id）
        warehouseid: string = "0";
        //商品数量
        shopsum: number = 0;
        //商品总占位
        shopron: number = 0;
        //仓库容量
        warehouseron: number = 0;
        //拿到的商品信息 用来做判断
        warehousestorage: any = {};

        //采购------
        //采购数量的变量
        caigousum :number =0;
        //提交采购时 采购人备注的变量
        beizhu : string="";
        //点击采购 弹出采购数量框 获取这个商品的值
        caigoushop : any = {};
        //所有临时采购表的数据
        PurchaseLinShiData: any[] = [];
        //所有临时采购表的商品总价
        PurchaseLinShiShopZon : number =0


        //登录用户实体
        empInfo: Employee = {};

        async created() {
            this.$store.commit('back/url', window.location.href);
            //获取登录信息
            this.empInfo = await EmpHelper.getEmp();
            //加载所有仓库信息
            this.getWarehouseAll();
            //加载采购框的所有商品信息
            this.getCommodityAll();
            //加载临时采购表的数据
            this.getPurchaseLinShiAll()
            /*EmpHelper.empId*/

            //延迟表格加载
            setTimeout(() => {
                this.loading = false;
            }, 1000)
        }


        //获取仓库状态
        getState(state: number): string {
            if (state === 1) return "正常";
            if (state === 0) return "冻结";
        }

        //获取商品总容量
        getshopron() {
            this.shopron = this.warehousestorage.specification * this.shopsum;
        }

        //获取采购模态框 里的所有商品数据
        getCommodityAll() {
            //console.log("getCommodityAll")
            let params = new URLSearchParams();
            params.append("name", "")
            params.append("state", "全部")
            params.append("page", this.page1.toString())
            params.append("rows", this.rows1.toString())
            Axios({
                method: "post",
                url: "/commodity/queryCommodityAll",
                data: params
            }).then(value => {
                //console.log(value.data)
                this.shoptableData = value.data;
            })
        }

        //获取所有临时采购表里的数据
        getPurchaseLinShiAll(){
            Axios({
                method: "post",
                url: "/purchase/queryPurchaseLinShiAll",
            }).then(value => {
                //console.log(value.data)
                this.PurchaseLinShiData = value.data;
            })
        }

        //***********************************************************
        //                      右键菜单部分
        //***********************************************************
        // table的左键点击关闭右键菜单事件
        clickTableRow(row: any, column: any, event: any) {
            let menu = document.querySelector("#menu") as any;
            menu.style.display = 'none';
            // console.log(row,column,event)
            let menu1 = document.querySelector("#menu1") as any;
            menu1.style.display = 'none';
        }

        // table的右键点击当前行展开右键菜单事件
        rightClick(row: any, column: any, event: any) {
            if (row.warstate===1){
                let menu = document.querySelector("#menu") as any;
                event.preventDefault();
                //获取我们自定义的右键菜单
                //console.log(menu)

                // 根据事件对象中鼠标点击的位置，进行定位
                menu.style.left = event.clientX + 'px';
                menu.style.top = event.clientY + 'px';
                // 改变自定义菜单的隐藏与显示
                menu.style.display = 'block';
                //console.log(row,column);

                // 获取当前右键点击table 获取当前行的id值下标
                this.tableData.rows.forEach((item, index) => {
                    if (item.warname === row.warname) {
                        this.currentRowIndex = item.warid;
                        return false;
                    }
                })
            }else {
                let menu = document.querySelector("#menu1") as any;
                event.preventDefault();
                //获取我们自定义的右键菜单
                //console.log(menu)

                // 根据事件对象中鼠标点击的位置，进行定位
                menu.style.left = event.clientX + 'px';
                menu.style.top = event.clientY + 'px';
                // 改变自定义菜单的隐藏与显示
                menu.style.display = 'block';
                //console.log(row,column);

                // 获取当前右键点击table 获取当前行的id值下标
                this.tableData.rows.forEach((item, index) => {
                    if (item.warname === row.warname) {
                        this.currentRowIndex = item.warid;
                        return false;
                    }
                })
            }

        }

        //***********************************************************
        //                      分页部分
        //***********************************************************
        /*点击换条数的按钮*/
        rowsChange(val: number) {
            //修改条数的值
            this.rows = val;
            this.getWarehouseAll();
        }

        //点击分页页数按钮
        pageChange(val: number) {
            //修改页数的值
            this.page = val;
            this.getWarehouseAll();
        }

        //*********************采购商品分页*******************************
        /*点击换条数的按钮*/
        rowsChange1(val: number) {
            //修改条数的值
            this.rows1 = val;
            this.getCommodityAll();

        }

        //点击分页页数按钮
        pageChange1(val: number) {
            //修改页数的值
            this.page1 = val;
            this.getCommodityAll();
        }

        //***********************************************************
        //                      仓库查询部分
        //***********************************************************
        //页面打开 查询所有仓库信息
        getWarehouseAll() {
            let params = new URLSearchParams();
            params.append("warname", this.input);
            params.append("page", this.page.toString());
            params.append("rows", this.rows.toString());
            Axios({
                method: "post",
                url: "/warehouse/queryWarehouseAll",
                data: params
            }).then(value => {
                /*console.log(value.data)*/
                this.tableData = value.data;
            })
        }

        //点击查询按钮 模糊查询仓库信息
        MohuqueryWarehouse() {
            this.getWarehouseAll();
        }

        //根据仓库id 查询仓库存储信息的方法
        querywarehousestorage() {
            let params = new URLSearchParams();
            params.append("id", this.currentRowIndex.toString());
            //查询数据
            Axios({
                method: "post",
                url: "/warehouse/queryWareHouseStorageAll",
                data: params
            }).then(value => {
                //console.log(value.data)
                this.warehousestoragetableData = value.data;
            })
        }

        /* 右键点击查看仓库存储情况 打开模态框 并查询数据*/
        openquerywarehousemotaikuang() {
            this.querywarehousemotaikuang = true;
            this.querywarehousestorage();
        }

        //***********************************************************
        //                      仓库转库部分
        //***********************************************************
        /* 右键点击查打开转库模态框 并查询仓库商品信息*/
        openzhuankumotaikuang() {
            this.zhuankumotaikuang = true;
            this.querywarehousestorage();
        }

        /* 点击转库 打开选择仓库的模态框*/
        openselectwarehouse(index: number, row: any) {
            this.selectwarehousemotaikuang = true;
            //给下拉框赋值 所有的仓库  查询所有仓库的数据
            Axios({
                method: "post",
                url: "/warehouse/warehouseAll"
            }).then(value => {
                this.warehouseAll = value.data;
            })
            //获取当前商品的信息 （用来做判断）
            this.warehousestorage = row;

        }

        //转库下拉框值改变触发事件
        warehousechange() {
            /*  console.log(this.warehousestorage.warid)
              console.log(this.warehouseid)
              console.log(typeof this.warehousestorage.warid,typeof this.warehouseid)
              console.log(this.warehousestorage.warid===this.warehouseid)*/
            //判断不能选择原本仓库
            if (this.warehousestorage.warid.toString() === this.warehouseid.toString()) {
                alert("不能选择原本仓库,请重新选择")
                this.warehouseid = "0";
                this.warehouseron = 0;
            }
            //让容量 随着仓库更改而更改
            for (let i = 0; i < this.warehouseAll.length; i++) {
                if (this.warehouseAll[i].warid.toString() === this.warehouseid.toString()) {
                    this.warehouseron = this.warehouseAll[i].warcapacity
                }
            }
        }

        //选择仓库模态框关闭时 清除数据
        cleanselectwarehouse() {
            this.selectwarehousemotaikuang = false;
            //仓库名（id）
            this.warehouseid = "0";
            //商品数量
            this.shopsum = 0;
            //商品总占位
            this.shopron = 0;
            //仓库容量
            this.warehouseron = 0;
        }

        //点击确定转库按钮
        zhuanku() {
            //拿到点击转库的商品的数据
            //console.log(this.warehousestorage)
            /*//判断变量
            let a=0;*/
            //判断是否选择仓库
            if (this.warehouseid === "0") {
                alert("请选择仓库")
                return;
            }

            //判断输入的商品数量是否超过拥有的量
            if (this.shopsum > this.warehousestorage.number) {
                alert("所选商品数量不足，已为您选择最大值")
                this.shopsum = this.warehousestorage.number;
                //计算商品总容量
                this.getshopron();
                return;
            }
            //判断商品总量是否超过仓库容量
            if (this.shopron > this.warehouseron) {
                alert("仓库容量不足，请重新选择")
                return;
            } else {
                let params = new URLSearchParams();
                //商品id
                params.append("commodityid", this.warehousestorage.id);
                //商品原本数量
                params.append("yuannumber", this.warehousestorage.number);
                //商品占位量
                params.append("shopron", this.shopron.toString());
                //转出仓库id
                params.append("chuwarid", this.warehousestorage.warid);
                //转入仓库id
                params.append("ruwarid", this.warehouseid.toString());
                //商品转出的数量
                params.append("chunumber", this.shopsum.toString());
                //查询数据
                Axios({
                    method: "post",
                    url: "/warehouse/zhuanku",
                    data: params
                }).then(value => {
                    //关闭选择仓库页面
                    this.cleanselectwarehouse()
                    //刷新仓库存储信息
                    this.querywarehousestorage();
                    //刷新显示仓库信息页面
                    this.getWarehouseAll();
                    alert("转库成功")
                    /*this.warehousestoragetableData = value.data;*/
                })
            }


        }

        //***********************************************************
        //                      采购部分
        //***********************************************************
        //右键采购 打开采购模态框
        opencaigoumotaikuang() {
            //console.log(this.empInfo)
            //alert(EmpHelper.empId)
            //清除临时采购表数据
            this.cleanPurchaseLinShi();
            this.caigoumotaikuang = true;
        }

        //点击商品旁边的采购按钮 弹出输入采购数量模态框
        opencaigousummotaikuang(index: number, row: any){
            //拿到商品数据
            this.caigoushop=row;

            this.caigousummotaikuang=true;
        }

        //给临时订单表加数据
        tianjiacaigou(){
            //获取这个商品的数据
            //alert(this.caigoushop.id)
            //获取采购多少数量
            //alert(this.caigousum);
            let params = new URLSearchParams();
            params.append("commodityid", this.caigoushop.id);
            params.append("caigousum", this.caigousum.toString());
            //添加
            Axios({
                method: "post",
                url: "/purchase/addLinShiPurchase",
                data: params
            }).then(value => {
                //console.log(value)
                alert(value.data.msg)
                //计算所有临时采购表里的商品的总价
                this.getPurchaseLinShiShopZon();
                //刷新临时订单表
                this.getPurchaseLinShiAll();
            })
            //关闭选择数量模态框
            this.caigousummotaikuang=false;
        }

        //计算所有临时采购表里的商品的总价
        getPurchaseLinShiShopZon(){
            Axios({
                method: "post",
                url: "/purchase/getLinShiPurchaseShopZon",
            }).then(value => {
                //alert(value.data)
                //console.log("value : ",value.data)
                this.PurchaseLinShiShopZon=value.data
            })
        }

        //点击取消采购模态框 清除采购临时表的数据
        cleanPurchaseLinShi(){
            //关闭模态框
            this.caigoumotaikuang = false
            //清除表格数据
            Axios({
                method: "post",
                url: "/purchase/cleanPurchaseLinShi"
            }).then(value => {
                //console.log(value)
                //alert(value.data.msg)
                //刷新临时采购表数据
                this.getPurchaseLinShiAll();
                //刷新临时采购表总价的值
                this.PurchaseLinShiShopZon=0;
            })
        }

        //点击确定采购按钮弹出申请人写备注的模态框
        openCaiGouBeiZhu(){
            this.caigoubeizhu=true;
        }

        //点击备注页面的确定按钮 提交采购申请
        SubmitCaiGou(){
            let params = new URLSearchParams();
            params.append("applicant",EmpHelper.empId);
            params.append("applicantremarks",this.beizhu);
            //添加
            Axios({
                method: "post",
                url: "/purchase/addCaiGou",
                data: params
            }).then(value => {
                //console.log(value)
                alert(value.data.msg)
                //临时采购表数据 在点击采购或者点击取消后就会清除
                //关闭备注模态框
                this.caigoubeizhu=false;
                //关闭采购模态框
                this.caigoumotaikuang=false;
            })
        }

        //冻结仓库
        donjie(){
            let params = new URLSearchParams();
            params.append("warid",this.currentRowIndex.toString());
            params.append("warstate","0");
            //添加
            Axios({
                method: "post",
                url: "/warehouse/donjieOrjiedon",
                data: params
            }).then(value => {
                //console.log(value)
                alert(value.data.msg)
                //关闭右键菜单
                let menu = document.querySelector("#menu") as any;
                menu.style.display = 'none';
                let menu1 = document.querySelector("#menu1") as any;
                menu1.style.display = 'none';
                //刷新显示仓库信息页面
                this.getWarehouseAll();
            })
        }
        //解冻仓库
        jiedon(){
            let params = new URLSearchParams();
            params.append("warid",this.currentRowIndex.toString());
            params.append("warstate","1");
            //添加
            Axios({
                method: "post",
                url: "/warehouse/donjieOrjiedon",
                data: params
            }).then(value => {
                //console.log(value)
                alert(value.data.msg)
                //关闭右键菜单
                let menu = document.querySelector("#menu") as any;
                menu.style.display = 'none';
                let menu1 = document.querySelector("#menu1") as any;
                menu1.style.display = 'none';
                //刷新显示仓库信息页面
                this.getWarehouseAll();
            })
        }



        queryCommodityLabledetails() {

        }

        deleteCommodityLable() {

        }
    }
</script>

<style scoped>
    /*table拉开的样式 ↓*/
    .demo-table-expand {
        font-size: 0;
    }

    .demo-table-expand label {
        width: 90px;
        color: #99a9bf;
    }

    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }

    /*table拉开的样式 ↑*/

    #menu {
        width: 120px;

        overflow: hidden; /*隐藏溢出的元素*/
        box-shadow: 0 1px 1px #888, 1px 0 1px #ccc;
        position: absolute;
        display: none;
        background: #ffffff;
        z-index: 10;
    }

    #menu1 {
        width: 120px;

        overflow: hidden; /*隐藏溢出的元素*/
        box-shadow: 0 1px 1px #888, 1px 0 1px #ccc;
        position: absolute;
        display: none;
        background: #ffffff;
        z-index: 10;
    }

    .menu {
        width: 125px;
        height: 25px;
        line-height: 25px;
        text-indent: 10px;
        cursor: pointer;
    }

    .menu:hover {
        color: deeppink;
        text-decoration: underline;
    }
</style>
