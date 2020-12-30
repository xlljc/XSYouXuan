<!--商户收货-->
<template>
    <div>
        <el-row>
            <el-col :span="12">
                <el-card shadow="hover">
                    <!-- 模糊查询-->
                    <el-input
                            style="width: 65%;margin-right: 10px"
                            placeholder="请输入关键字"
                            v-model="searchStr"
                            clearable>
                        <template slot="append">
                            <el-button
                                    slot="append"
                                    icon="el-icon-search"
                                    @click="query">
                                查询
                            </el-button>
                        </template>
                    </el-input>

                    <!--收货按钮-->

                    <el-button icon="el-icon-suitcase" type="primary" plain @click="openDialog">确认收货</el-button>
                </el-card>
            </el-col>
        </el-row>

        <el-row style="margin-top: 15px">
            <el-col :span="24">
                <el-card style="width: 100%;min-height: 400px" shadow="hover">
                    <!--strip 双行阴影效果属性-->
                    <el-table
                            @selection-change="checkChange"
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
                                type="selection"
                                width="55">
                        </el-table-column>
                        <el-table-column
                                sortable
                                label="订单编号"
                                prop="orderNumber">
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
                                label="用户手机号">
                            <div slot-scope="{row}">{{ row.phone | phone }}</div>
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

        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="300px">
                <span>您目前已选中{{ selectRows.length }}条记录, 你确定收货吗 ?</span>
              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="shouHuo">确 定</el-button>
              </span>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Utils from "@/helper/Utils";
    import {OrderDetails, PageInfo, User} from "@/helper/entity";
    import {ShopHelper} from "@/helper/shop/ShopHelper";

    @Component({
        filters: {
            phone: (phone: string) => phone && phone.substring(0,3) + '****' + phone.substring(7),
            idCard: (idCard: string) => idCard && idCard.substring(0,6) + '****' + idCard.substring(10),
            state: (state: number) => {
                if (state === 1) return "未收货";
                if (state === 2) return "待提货";
                if (state === 3) return "已提货";
                return state;
            },
            date: (time: number) => Utils.formatDate(time),
        }
    })
    export default class ShopShouhuo extends Vue {
        //加载状态
        isLoading = false;
        //查询输入框
        searchStr: string = "";
        //表数据
        tableData: PageInfo<OrderDetails> = {};
        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        //选中的行
        selectRows: OrderDetails[] = [];

        dialogVisible: boolean = false;

        created() {
            this.query();
        }

        async query() {
            this.isLoading = true;
            this.tableData = await ShopHelper.queryOrderDetails(this.searchStr,1,this.page,this.row);
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


        checkChange(row: OrderDetails[]) {
            this.selectRows = [...row];
        }

        openDialog() {
            if (this.selectRows.length === 0) {
                this.$notify.error({title: "提示",message: "请至少选择一行 !"});
                return;
            }
            this.dialogVisible = true;
        }

        //提交收货
        async shouHuo() {
            let ids: number[] = [];
            this.selectRows.forEach(value => ids.push(value.id));
            let message = await ShopHelper.shouHuo(ids);
            if (message.flag) {
                this.$notify.success({title: "提示",message: "收货成功!"});
                this.query();
            } else {
                this.$notify.error({title: "提示",message: message.msg});
            }
            this.dialogVisible = false;
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