<template>
    <div>
        <!-- 模糊查询-->
        <el-input
                style="width: 450px"
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

        <el-table
                v-loading="isLoading"
                border
                :data="tableData.list"
                style="width: 100%;margin-top: 30px">
            <el-table-column
                    sortable
                    width="100px"
                    label="ID"
                    prop="id">
            </el-table-column>
            <el-table-column
                    width="200px"
                    label="商户名称"
                    prop="name">
            </el-table-column>
            <el-table-column
                    label="申请人姓名"
                    prop="userId.uname">
            </el-table-column>
            <el-table-column
                    label="商户地址"
                    prop="address">
            </el-table-column>
            <el-table-column
                    width="200px"
                    label="商户电话"
                    prop="userId.phone">
            </el-table-column>
            <el-table-column
                    width="200px"
                    label="申请时间"
                    prop="applyTime">
            </el-table-column>
            <el-table-column
                    label="申请消息"
                    prop="userMessage">
            </el-table-column>

            <el-table-column label="操作" width="180px">
                <template slot-scope="{row}">
                    <el-tooltip effect="dark" content="通过" placement="top-start" v-if="$btnPermissions('审批通过')">
                        <el-button
                                type="primary"
                                circle
                                icon="el-icon-check"
                                size="medium"
                                @click="approval(row.id,true)"
                        ></el-button>
                    </el-tooltip>
                    <el-tooltip effect="dark" content="拒绝" placement="top-start" v-if="$btnPermissions('审批拒绝')">
                        <el-button
                                type="danger"
                                circle
                                icon="el-icon-close"
                                size="medium"
                                @click="approval(row.id,false)"
                        ></el-button>
                    </el-tooltip>

                </template>
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


        <!-- 模态框 -->
        <el-dialog :close-on-click-modal="false"
                   :title="dialog.title"
                   :visible.sync="dialog.visible"
                   width="400px">
            <div>

                <el-form>
                    <el-form-item label="审批消息: ">
                        <el-input v-model="message" maxlength="50" clearable placeholder="请输入审批消息..."></el-input>
                    </el-form-item>
                </el-form>

            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialog.visible = false">取 消</el-button>
                <el-button type="primary" @click="dialog.success">确 定</el-button>
            </div>
        </el-dialog>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import {DialogTemplateData, MerchantsApply as MApply, PageInfo} from "@/helper/entity";
    import {MerchantsHelper} from "@/helper/back/MerchantsHelper";

    @Component
    export default class MerchantsApply extends Vue {

        //加载状态
        isLoading = false;
        //搜索框数据
        searchStr: string = "";
        //表数据
        tableData: PageInfo<MApply> = {};
        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        //模态框
        dialog: DialogTemplateData = {
            title: "",
            visible: false,
            success() {},
        }
        message: string = "";

        mounted() {
            this.query();
        }

        async query() {
            this.isLoading = true;
            this.tableData = await MerchantsHelper.queryApply(this.searchStr, this.page, this.row);
            this.isLoading = false;
            console.log(this.tableData);
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

        approval(id: number,flag: boolean) {
            this.message = "";
            this.dialog.visible = true;
            this.dialog.title = flag ? "审批通过" : "审批拒绝";
            this.dialog.success = async () => {
                let message = await MerchantsHelper.approval(id, flag, this.message);
                if (message.flag) {
                    this.$notify.success({title: "提示", message: "申请通过 !"});
                    this.query();
                } else {
                    this.$notify.error({title: "提示", message: message.msg});
                }
                this.dialog.visible = false;
            }
        }

    }
</script>

<style scoped>

</style>