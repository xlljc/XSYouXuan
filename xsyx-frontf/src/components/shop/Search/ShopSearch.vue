<!--商户订单查询-->
<template>
    <div>
        <el-row>
            <el-col :span="10">
                <el-card style="width: 100%" shadow="hover">
                    <!-- 模糊查询-->
                    <el-input
                            style="width: 100%"
                            placeholder="请输入关键字"
                            v-model="searchStr"
                            clearable>
                        <div slot="prepend">
                            <el-tooltip effect="dark" content="订单状态" placement="top-end">
                                <!-- 订单状态 -->
                                <el-select v-model="state" placeholder="订单状态" style="width: 110px;">
                                    <el-option label="全部" :value="null"></el-option>
                                    <el-option label="未收货" :value="0"></el-option>
                                    <el-option label="待提货" :value="1"></el-option>
                                    <el-option label="已提货" :value="2"></el-option>
                                </el-select>
                            </el-tooltip>
                        </div>
                        <!--查询按钮-->
                        <template slot="append">
                            <el-button
                                    slot="append"
                                    icon="el-icon-search"
                                    @click="query">
                                查询
                            </el-button>
                        </template>
                    </el-input>
                </el-card>
            </el-col>
        </el-row>

        <el-row style="margin-top: 15px">
            <el-col :span="24">
                <el-card style="width: 100%;min-height: 400px" shadow="hover">
                    <!--strip 双行阴影效果属性-->
                    <el-table
                            v-loading="isLoading"
                            border
                            :data="tableData.list"
                            style="width: 100%;margin-top: 30px">
                        <el-table-column type="expand">
                            <template slot-scope="{row}">
                                <el-form label-position="left" inline class="demo-table-expand">
                                    <el-form-item label="ID ：">
                                        <span>{{ row.orderNumber }}</span>
                                    </el-form-item>
                                    <el-form-item label="订单状态 ：">
                                        <span>{{ row.ordstate | state }}</span>
                                    </el-form-item>
                                    <el-form-item label="用户昵称 ：">
                                        <span>{{ row.username }}</span>
                                    </el-form-item>
                                    <el-form-item label="用户姓名 ：">
                                        <span>{{ row.uname }}</span>
                                    </el-form-item>
                                    <el-form-item label="商品图片 ：">
                                        <el-image style="height: 100px;width: 150px" :src="$host + row.commodityImage" fit="cover"
                                                  :preview-src-list="[$host + row.commodityImage]" lazy></el-image>
                                    </el-form-item>
                                    <el-form-item label="商品名称 ：">
                                        <span>{{ row.commodityName }}</span>
                                    </el-form-item>
                                    <el-form-item label="商品名称 ：">
                                        <span>{{ row.commodityName }}</span>
                                    </el-form-item>
                                    <el-form-item label="商品类型 ：">
                                        <span>{{ row.typeName }}</span>
                                    </el-form-item>
                                    <el-form-item label="数量 ：">
                                        <span>{{ row.number }}</span>
                                    </el-form-item>
                                    <el-form-item label="总价 ：">
                                        <span>{{ row.totlemoney }}</span>
                                    </el-form-item>
                                    <el-form-item label="用户手机号 ：">
                                        <span>{{ row.phone | phone }}</span>
                                    </el-form-item>
                                    <el-form-item label="收货时间 ：">
                                        <span>{{ row.deliveryTime | date }}</span>
                                    </el-form-item>
                                    <el-form-item label="提货时间 ：">
                                        <span>{{ row.pickUpTime | date }}</span>
                                    </el-form-item>
                                </el-form>
                            </template>
                        </el-table-column>
                        <el-table-column
                                sortable
                                width="150px"
                                label="订单编号"
                                prop="orderNumber">
                        </el-table-column>
                        <el-table-column
                                width="90px"
                                label="订单状态">
                            <div slot-scope="{row}">{{ row.ordstate | state }}</div>
                        </el-table-column>
                        <el-table-column
                                width="120px"
                                label="用户姓名"
                                prop="uname">
                        </el-table-column>
                        <el-table-column
                                label="商品名称">
                            <template slot-scope="{row}">
                                <el-popover trigger="hover" ref="" placement="top">
                                    <el-image style="height: 100px;width: 150px" :src="$host + row.commodityImage" fit="cover"
                                              :preview-src-list="[$host + row.commodityImage]"></el-image>
                                    <el-tag slot="reference" size="medium">{{ row.commodityName }}</el-tag>
                                </el-popover>
                            </template>
                        </el-table-column>
                        <el-table-column
                                sortable
                                width="110px"
                                label="商品数量"
                                prop="number">
                        </el-table-column>
                        <el-table-column
                                width="110px"
                                label="用户手机号">
                            <div slot-scope="{row}">{{ row.phone | phone }}</div>
                        </el-table-column>
                        <el-table-column
                                width="160px"
                                label="收货时间">
                            <div slot-scope="{row}">{{ row.deliveryTime | date }}</div>
                        </el-table-column>
                        <el-table-column
                                width="160px"
                                label="提货时间">
                            <div slot-scope="{row}">{{ row.pickUpTime | date }}</div>
                        </el-table-column>
                    </el-table>

                    <el-pagination
                            @size-change="rowChange"
                            @current-change="pageChange"
                            background
                            :page-sizes="[10, 15, 25, 50]"
                            :page-size="10"
                            layout="total, sizes, prev, pager, next"
                            :total="tableData.total">
                    </el-pagination>
                </el-card>
            </el-col>
        </el-row>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import {ShopHelper} from "@/helper/shop/ShopHelper";
    import {OrderDetails, PageInfo} from "@/helper/entity";
    import Utils from "@/helper/Utils";

    @Component({
        filters: {
            phone: (phone: string) => phone && phone.substring(0,3) + '****' + phone.substring(7),
            idCard: (idCard: string) => idCard && idCard.substring(0,6) + '****' + idCard.substring(10),
            state: (state: number) => {
                if (state === 0) return "未收货";
                if (state === 1) return "待提货";
                if (state === 2) return "已提货";
                return state;
            },
            date: (time: number) => Utils.formatDate(time),

        }
    })
    export default class ShopSearch extends Vue {

        //加载状态
        isLoading = false;
        //查询输入框
        searchStr: string = "";
        //状态
        state: number = null;
        //表数据
        tableData: PageInfo<OrderDetails> = {};
        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        created() {
            this.query();
        }

        async query() {
            this.isLoading = true;
            this.tableData = await ShopHelper.queryOrderDetails(this.searchStr,this.state,this.page,this.row);
            this.isLoading = false;
        }

        mounted() {

        }

        //页面大小改变
        rowChange(val: number) {
            this.row = val;
            this.query();
        }
        //页数改变
        pageChange(val: number) {
            this.page = val;
            this.query();
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
</style>