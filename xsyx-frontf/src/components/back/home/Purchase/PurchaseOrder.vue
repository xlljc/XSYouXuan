<!--采购申请页面-->
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
                        <el-form-item label="申请人备注：">
                            <span>{{ props.row.applicantremarks }}</span>
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
                 @click="openDinDanXiangQing"><i style="font-size: 15px" class="el-icon-lock"></i>查询订单详情
            </div>
        </div>


        <!--订单详情模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="订单详情审核页面"
                   :visible.sync="ddmotaikuang">
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
            <span style="float: right">总价：<a style="color:red;">{{this.CaiGouShopZon}}</a></span>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="openShenHeBeiZhu">审核</el-button>

            </div>
        </el-dialog>

        <!--点击审核按钮弹出审核人写备注的模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="备注"
                   :visible.sync="shenhebeizhu">
            <el-input
                    style="width: 300px"
                    placeholder="---请输入---"
                    v-model="beizhu"
                    clearable>
            </el-input>
            <div slot="footer" class="dialog-footer">
                <el-button type="danger" @click="refuse">拒绝</el-button>
                 <el-button type="primary" @click="agree">同意</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    import Axios from "axios";
    import {EmpHelper} from "@/helper/back/EmpHelper";

    @Component
    export default class PurchaseOrder extends Vue {
        /*延迟表格加载*/
        loading: boolean = true;
        //订单详情模态框状态
        ddmotaikuang: boolean = false;

        //所有订单数据
        purchaseorderAllData: any[] = [];
        //根据订单id查询所有采购商品数据
        caigouAllData: any = [];
        // 获取当前右键点击的订单id
        currentRowIndex: number = 0;
        //订单所有采购商品总价
        CaiGouShopZon: number = 0;

        //审核人备注模态框状态
        shenhebeizhu=false;
        //提交审核时 审核人备注的变量
        beizhu : string="";

        created() {
            this.$store.commit('back/url', window.location.href);
            //加载所有未审核订单信息
            this.getpurchaseorderAll();

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
                    this.currentRowIndex = item.orderid;
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
        }

        //***********************************************************
        //                      显示所有未审核订单部分
        //***********************************************************

        //获取所有未审核订单信息
        getpurchaseorderAll() {
            Axios({
                method: "post",
                url: "/purchase/querypurchaseorderAll",
            }).then(value => {
                //console.log(value.data)
                this.purchaseorderAllData = value.data;
            })
        }

        //右键查看订单详情打开模态框
        openDinDanXiangQing() {
            //清除总价数据
            this.CaiGouShopZon = 0;

            this.ddmotaikuang = true;
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
                //计算这个订单的总价
                for (let i = 0; i < this.caigouAllData.length; i++) {
                    //alert(this.caigouAllData[i].commoditysum)
                    this.CaiGouShopZon += this.caigouAllData[i].commoditysum * this.caigouAllData[i].price;
                }

            })
        }

        //关闭订单详情页面
        closeDinDanXiangQing() {
            this.ddmotaikuang = false
        }
        //打开审核人备注模态框
        openShenHeBeiZhu(){
            this.shenhebeizhu=true;
        }

        //点击同意 通过申请
        agree(){
            //获取当前用户id  做审核人
            console.log(EmpHelper.empId)
            //获取订单id
            console.log(this.currentRowIndex)
            //传一个表示同意的参数 1 修改状态

            //获取审批人备注
            console.log(this.beizhu)
            let params = new URLSearchParams();
            params.append("orderid",this.currentRowIndex.toString());
            params.append("approvedby",EmpHelper.empId);
            params.append("state","1");
            params.append("approvedbyremarks",this.beizhu);

            //提交审核
            Axios({
                method: "post",
                url: "/purchase/shenHe",
                data: params
            }).then(value => {
                //console.log(value)
                alert(value.data.msg)
                //临时采购表数据 在点击采购或者点击取消后就会清除
                //关闭备注模态框
                //this.caigoubeizhu=false;
                //关闭采购模态框
                //this.caigoumotaikuang=false;
            })

        }
        //点击拒绝 不通过申请
        refuse(){

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
