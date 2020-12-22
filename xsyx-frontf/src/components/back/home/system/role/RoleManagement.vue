<!--角色管理-->
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

        <el-button
                plain
                type="success"
                slot="append"
                icon="el-icon-circle-plus"
                style="margin-left: 15px"
                @click="openAdd"
        >添加
        </el-button>

        <el-table
                border
                :data="tableData.list"
                style="width: 100%;margin-top: 30px">
            <el-table-column
                    width="100px"
                    label="角色 ID"
                    prop="id">
            </el-table-column>
            <el-table-column
                    width="250px"
                    label="角色名称"
                    prop="name">
            </el-table-column>
            <el-table-column
                    label="角色备注"
                    prop="remark">
            </el-table-column>
            <el-table-column label="操作" width="180px">
                <template slot-scope="{row}">
                    <el-tooltip effect="dark" content="编辑" placement="top-start">
                        <el-button
                                type="primary"
                                circle
                                icon="el-icon-edit"
                                size="medium"
                                @click="openUpdate(row)"
                        ></el-button>
                    </el-tooltip>

                    <el-tooltip effect="dark" content="删除" placement="top-start">
                        <el-button
                                type="danger"
                                circle
                                icon="el-icon-delete"
                                size="medium"
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
                <role-management-edit :form-data="formData"></role-management-edit>
            </div>

            <div slot="footer" class="dialog-footer">
                <el-button @click="dialog.visible = false">取 消</el-button>
                <!--点击调用修改方法-->
                <el-button type="primary" @click="dialog.success">确 定</el-button>
            </div>
        </el-dialog>

    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";
    import {RoleHelper} from "@/helper/back/RoleHelper";
    import {DialogTemplateData, PageInfo, Role} from "@/helper/entity";
    import RoleManagementEdit from "@/components/back/home/system/role/RoleManagementEdit.vue";
    @Component({
        components: {RoleManagementEdit}
    })
    export default class RoleManagement extends Vue {

        //搜索框数据
        searchStr: string = "";
        //表数据
        tableData: PageInfo<Role> = {};
        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        //表单数据
        formData: Role = {};

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

        //***********************************************************
        //                          查询角色
        //***********************************************************
        //搜索按钮触发
        search() {
            this.page = 1;
            this.query()
        }
        //查询角色
        async query() {
            this.tableData = await RoleHelper.query(this.searchStr,this.page,this.row);
        }

        //***********************************************************
        //                          添加角色
        //***********************************************************
        //打开添加模态框
        openAdd() {
            this.formData = {};
            this.dialog.title = "添加角色";
            this.dialog.visible = true;
            this.dialog.success = async () => {
                //提交
                let message = await RoleHelper.insert(this.formData);
                if (message.flag) {
                    this.$notify({type: "success",title: "消息",message: "添加成功 !"});
                    this.query();
                } else {
                    this.$notify({type: "error",title: "消息",message: message.msg});
                }
                this.dialog.visible = false;
            }
        }

        //打开修改模态框
        openUpdate(role: Role) {
            this.formData = {...role};
            this.dialog.title = "修改角色";
            this.dialog.visible = true;
            this.dialog.success = async () => {
                //提交
                let message = await RoleHelper.update(this.formData);
                if (message.flag) {
                    this.$notify({type: "success",title: "消息",message: "修改成功 !"});
                    this.query();
                } else {
                    this.$notify({type: "error",title: "消息",message: message.msg});
                }
                this.dialog.visible = false;
            }
        }

        //***********************************************************

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

</style>