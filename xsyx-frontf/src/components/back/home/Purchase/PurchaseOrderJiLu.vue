<!--采购审批记录页面-->
<template>
    <div>
        <!--strip 双行阴影效果属性-->
        <el-table
                border
                :data="purchaseorderAllData"
                style="width: 100%;margin-top: 30px"
                @row-click="clickTableRow"
                v-loading="loading"
                highlight-current-row
                @row-contextmenu="rightClick">
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="审核人：">
                            <span>{{ props.row.approvedby }}</span>
                        </el-form-item>
                        <el-form-item label="审核人备注：">
                            <span>{{ props.row.applicantremarks }}</span>
                        </el-form-item>
                        <el-form-item label="申请人备注：">
                            <span>{{ props.row.approvedbyremarks }}</span>
                        </el-form-item>
                        <el-form-item label="操作时间：">
                            <span>{{ props.row.operationtime }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="订单id"
                    prop="orderid">
            </el-table-column>
            <el-table-column
                    label="申请人"
                    prop="applicant">
            </el-table-column>
            <el-table-column label="状态">
                <template slot-scope="props">
                    <span>{{ getState(props.row.state) }}</span>
                </template>
            </el-table-column>
        </el-table>
        <!--右键显示菜单-->
        <div id="menu">
            <div class="menu"
                 @click="openRuKu"
                 v-if="$btnPermissions('入库')">
                <i style="font-size: 15px" class="el-icon-lock"></i>入库
            </div>
        </div>

        <!--订单详情模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="入库"
                   :visible.sync="rukumotaikuang">
            <!--采购商品的表-->
            <el-table
                    border
                    :data="caigouAllData"
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
                        prop="commodityid">
                </el-table-column>
                <el-table-column
                        label="商品名称"
                        prop="commodityname">
                </el-table-column>
                <el-table-column
                        label="采购数量"
                        prop="commoditysum">
                </el-table-column>
            </el-table>

            <div slot="footer" class="dialog-footer">
                <el-button type="primary"  @click="openselectwarehouse">入库</el-button>

            </div>
        </el-dialog>

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

                <el-form-item label="商品占位:">
                    <span>{{this.shopron}}</span>
                </el-form-item>
                <el-form-item label="仓库容量:">
                    <span>{{this.warehouseron}}</span>
                </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="selectwarehousemotaikuang=false">取 消</el-button>
                <el-button type="primary" @click="ruke">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    import Axios from "axios";

    @Component
    export default class PurchaseOrder extends Vue {
        /*延迟表格加载*/
        loading: boolean = true;

        //所有订单记录数据
        purchaseorderAllData : any = [];
        // 获取当前右键点击的订单id
        currentRowIndex: number = 0;
        // 获取当前右键点击的订单状态
        ddzt: number=0;
        //入库模态框
        rukumotaikuang: boolean = false;
        //选择仓库的模态框状态
        selectwarehousemotaikuang = false;
        //所有仓库数据
        warehouseAll: any[] = []
        //仓库名（id）
        warehouseid: string = "0";
        //仓库容量
        warehouseron: number = 0;
        //商品总占位
        shopron: number = 0;
        //根据订单id查询所有采购商品数据
        caigouAllData: any = [];
        created() {
            this.$store.commit('back/url', window.location.href);
            //加载所有不是未审核订单信息
            this.getpurchaseorderAllnowei();

            //延迟表格加载
            setTimeout(() => {
                this.loading = false;
            }, 1000)
        }

        //***********************************************************
        //                      右键菜单部分
        //***********************************************************
        // table的左键点击关闭右键菜单事件
        clickTableRow(row: any, column: any, event: any) {
            let menu = document.querySelector("#menu") as any;
            menu.style.display = 'none';
            // console.log(row,column,event)
        }

        // table的右键点击当前行展开右键菜单事件
        rightClick(row: any, column: any, event: any) {

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
            this.purchaseorderAllData.forEach((item, index) => {

                if (item.orderid === row.orderid) {
                    //订单id
                    this.currentRowIndex = item.orderid;
                    //订单状态
                    this.ddzt=item.state
                    return false;
                }
            })
        }

        //获取审核状态
        getState(state: number): string {
            if (state === -1) return "拒绝";
            if (state === 0) return "未审核";
            if (state === 1) return "采购中";
            if (state === 2) return "采购完成";
            if (state === 3) return "已入库";
        }

        //***********************************************************
        //                      显示所有不是未审核订单部分
        //***********************************************************

        //获取所有不是未审核订单信息
        getpurchaseorderAllnowei() {
            Axios({
                method: "post",
                url: "/purchase/purchaseorderAllnowei",
            }).then(value => {
                //console.log(value.data)
                this.purchaseorderAllData = value.data;
            })
        }

        //右键入库打开模态框
        openRuKu(index: number, row: any) {
            //判断是否已经采购完成
            if (this.ddzt!==2){
                this.$message({
                    type: 'error',
                    message: "采购未完成"
                });
            }else {
                //查看订单详情
                this.rukumotaikuang = true;
                //根据订单id 查询所有采购商品
                let params = new URLSearchParams();
                params.append("orderid", this.currentRowIndex.toString())
                Axios({
                    method: "post",
                    url: "/purchase/querycaigouAll",
                    data: params
                }).then(value => {
                    //console.log(value.data)
                    this.caigouAllData = value.data;
                })
            }

        }

        /* 点击转库 打开选择仓库的模态框*/
        openselectwarehouse() {
            this.selectwarehousemotaikuang = true;
            //清除商品总容量
            this.shopron=0;
            //计算这个订单的商品的总容量
            this.getshopron();

            //给下拉框赋值 所有的仓库  查询所有仓库的数据
            Axios({
                method: "post",
                url: "/warehouse/warehouseAll"
            }).then(value => {
                this.warehouseAll = value.data;
            })

        }
        //转库下拉框值改变触发事件
        warehousechange() {
            //让容量 随着仓库更改而更改
            for (let i = 0; i < this.warehouseAll.length; i++) {
                if (this.warehouseAll[i].warid.toString() === this.warehouseid.toString()) {
                    this.warehouseron = this.warehouseAll[i].warcapacity
                }
            }
        }
        //获取商品总容量
        getshopron() {

            for (let i=0;i<this.caigouAllData.length;i++){
                this.shopron+=this.caigouAllData[i].commoditysum*this.caigouAllData[i].specification
            }

        }

        //点击确认入库
        ruke(){
            //判断有没有选择仓库
            if (this.warehouseid === "0") {
                this.$message({
                    type: 'error',
                    message: "请选择仓库"
                });
                return;
            }
            //商品总容量小于仓库 可以入库
            if (this.shopron<this.warehouseron){

                let params = new URLSearchParams();
                //拿到仓库id
                params.append("warehouseid", this.warehouseid)
                //拿到这个订单id
                params.append("orderid", this.currentRowIndex.toString())
                Axios({
                    method: "post",
                    url: "/purchase/ruku",
                    data: params
                }).then(value => {
                    this.$message({
                        type: 'success',
                        message: value.data.msg
                    });
                    //关闭选择仓库模态框
                    this.selectwarehousemotaikuang = false;
                    //关闭入库模态框
                    this.rukumotaikuang = false;
                    //刷新表格数据
                    this.getpurchaseorderAllnowei()
                })

                //修改订单状态为已入库
            }else {
                this.$message({
                    type: 'error',
                    message: "仓库容量不足"
                });
            }
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
