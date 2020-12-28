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
                 ><i style="font-size: 15px" class="el-icon-lock"></i>入库
            </div>
        </div>

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
        purchaseorderAllData = [];
        // 获取当前右键点击的订单id
        currentRowIndex: number = 0;

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
        clickTableRow(row, column, event) {
            let menu = document.querySelector("#menu") as any;
            menu.style.display = 'none';
            // console.log(row,column,event)
        }

        // table的右键点击当前行展开右键菜单事件
        rightClick(row, column, event) {

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
