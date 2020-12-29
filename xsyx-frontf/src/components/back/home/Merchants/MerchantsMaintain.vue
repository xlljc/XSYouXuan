<!-- 商户管理 -->
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
                        v-if="$btnPermissions('商户查询')"
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
                    label="商户 ID"
                    prop="id">
            </el-table-column>
            <el-table-column
                    width="200px"
                    label="商户名称"
                    prop="name">
            </el-table-column>
            <el-table-column
                    width="200px"
                    label="商户地址"
                    prop="address">
            </el-table-column>
            <el-table-column
                    width="200px"
                    label="商户电话"
                    prop="phone">
            </el-table-column>
            <el-table-column
                    label="商户备注"
                    prop="remark">
            </el-table-column>

            <el-table-column label="操作" width="180px">
                <template slot-scope="{row}">
                    <el-tooltip effect="dark" content="编辑" placement="top-start" v-if="$btnPermissions('商户修改')">
                        <el-button
                                type="primary"
                                circle
                                icon="el-icon-edit"
                                size="medium"
                                @click="updateMer(row)"
                        ></el-button>
                    </el-tooltip>

                    <el-popconfirm
                            @confirm="deleteMer(row.id)"
                            confirm-button-text='确定'
                            cancel-button-text='取消'
                            icon="el-icon-info"
                            icon-color="red"
                            title="你确定删除该商户吗？该操作不能取消 !">
                        <el-tooltip slot="reference" effect="dark" content="删除" placement="top-start" v-if="$btnPermissions('商户删除')">
                            <el-button
                                    style="margin-left: 10px"
                                    type="danger"
                                    circle
                                    icon="el-icon-delete"
                                    size="medium"
                            ></el-button>
                        </el-tooltip>
                    </el-popconfirm>

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
                <merchants-maintain-edit ref="formEdit" :form-data="formData"></merchants-maintain-edit>
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
    import {DialogTemplateData, Merchants, PageInfo, Role} from "@/helper/entity";
    import {MerchantsHelper} from "@/helper/back/MerchantsHelper";
    import MerchantsMaintainEdit from "@/components/back/home/Merchants/MerchantsMaintainEdit.vue";
    @Component({
        components: {MerchantsMaintainEdit}
    })
    export default class MerchantsMaintain extends Vue {

        $refs: {
            formEdit: any;
        }

        //加载状态
        isLoading = false;
        //搜索框数据
        searchStr: string = "";
        //表数据
        tableData: PageInfo<Merchants> = {};
        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        //表单数据
        formData: Merchants = {};

        //模态框
        dialog: DialogTemplateData = {
            title: "",
            visible: false,
            success() {},
        }


        created() {
            this.$store.commit('back/url', window.location.href);
            this.query();
        }

        mounted() {

        }

        async query() {
            this.isLoading = true;
            this.tableData = await MerchantsHelper.query(this.searchStr, this.page, this.row);
            this.isLoading = false;
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

        async deleteMer(merId: number) {
            let message = await MerchantsHelper.delete(merId);
            if (message.flag) {
                this.$notify.success({title: "提示",message: "删除成功 !"});
                this.query();
            } else {
                this.$notify.error({title: "提示",message: message.msg});
            }
        }



        updateMer(row: Merchants) {

            this.formData = {...row};
            this.dialog.visible = true;
            this.dialog.title = "修改商户";
            this.dialog.success = async () => {
                if (!await this.$refs.formEdit.validate()) return;
                let message = await MerchantsHelper.update(this.formData);
                if (message.flag) {
                    this.$notify.success({message: "修改成功 !",title: "提示"});
                    this.query();
                } else {
                    this.$notify.error({title: "提示",message: message.msg});
                }
                this.dialog.visible = false;
            }
        }
    }
</script>

<style scoped>

</style>