<!--采购申请页面-->
<template>
    <div>
        <!--strip 双行阴影效果属性-->
        <el-table
                border
                :data="purchaseorderAllData"
                style="width: 100%;margin-top: 30px">
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
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    import Axios from "axios";

    @Component
    export default class PurchaseOrder extends Vue {
        //所有订单数据
        purchaseorderAllData = [];


        created() {
            //加载所有未审核订单信息
            this.getpurchaseorderAll();
        }
        //获取审核状态
        getState(state: number): string {
            if (state === -1) return "拒绝";
            if (state === 0) return "未审核";
            if (state === 1) return "通过";
        }


        //获取所有未审核订单信息
        getpurchaseorderAll(){
            Axios({
                method: "post",
                url: "/purchase/querypurchaseorderAll",
            }).then(value => {
                console.log(value.data)
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
</style>
