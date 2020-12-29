<!--配送管理页面-->
<template>
<div> <!--strip 双行阴影效果属性-->
    <el-table
            border
            :data="orderAllData"
            style="width: 100%;margin-top: 30px"
            v-loading="loading"
            highlight-current-row
            >
        <el-table-column type="expand">
            <template slot-scope="props">
                <el-form label-position="left" inline class="demo-table-expand">
                    <el-form-item label="商品id：">
                        <span>{{ props.row.applicantremarks }}</span>
                    </el-form-item>
                    <el-form-item label="商品名：">
                        <span>{{ props.row.operationtime }}</span>
                    </el-form-item>
                    <el-form-item label="商品规格：">
                        <span>{{ props.row.operationtime }}</span>
                    </el-form-item>
                    <el-form-item label="商品数量：">
                        <span>{{ props.row.operationtime }}</span>
                    </el-form-item>
                </el-form>
            </template>
        </el-table-column>
        <el-table-column
                label="订单id"
                prop="orderid">
        </el-table-column>
        <el-table-column label="订单状态">
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
    export default class Distribution extends Vue {

        //所有订单数据
        orderAllData: any[] = [];

        created() {
            this.$store.commit('back/url', window.location.href);
        }
        //查询所有的订单信息
        getorderAll() {
            Axios({
                method: "post",
                url: "/purchase/queryorderAll",
            }).then(value => {
                //console.log(value.data)
                this.orderAllData = value.data;
            })
        }


        //获取订单状态
        getState(state: number): string {
            if (state === null) return "待发货";
            if (state === 1) return "待收货";
            if (state === 2) return "已收货";
        }
    }
</script>

<style scoped>

</style>
