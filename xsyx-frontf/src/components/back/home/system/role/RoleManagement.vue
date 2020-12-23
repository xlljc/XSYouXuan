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
                v-loading="isLoading"
                border
                :data="tableData.list"
                style="width: 100%;margin-top: 30px">
            <el-table-column
                    sortable
                    width="100px"
                    label="角色 ID"
                    prop="id">
            </el-table-column>
            <el-table-column
                    width="200px"
                    label="角色名称"
                    prop="name">
            </el-table-column>

            <el-table-column
                    label="拥有人数"
                    width="180">
                <template slot-scope="{row}">
                    <el-popover trigger="hover" ref="" placement="top" @show="row.empData === undefined && loadEmp(row)">
                        <div v-loading="row.empData === undefined">
                            <el-table :data="row.empData" height="250">
                                <el-table-column label="id" prop="id"/>
                                <el-table-column label="姓名" prop="name"/>
                                <el-table-column label="头像">
                                    <template slot-scope="{row}">
                                        <el-image  style="height: 30px;width: 45px" :src="$host + row.image" fit="cover"
                                        :preview-src-list="[$host + row.image]"></el-image>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </div>
                        <el-tag slot="reference" size="medium">人数 : {{ row.hasEmpCount }}</el-tag>
                    </el-popover>
                </template>
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

                    <el-popconfirm
                            @confirm="deleteRole(row.id)"
                            confirm-button-text='确定'
                            cancel-button-text='取消'
                            icon="el-icon-info"
                            icon-color="red"
                            title="你确定删除该角色吗？该操作不能取消 !">
                        <el-tooltip slot="reference" effect="dark" content="删除" placement="top-start">
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
                <role-management-edit ref="formEdit" :form-data="formData"></role-management-edit>
            </div>

            <div slot="footer" class="dialog-footer">
                <el-button @click="dialog.visible = false">取 消</el-button>
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

        //加载状态
        isLoading = false;
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

        //查询角色
        async query() {
            this.isLoading = true;
            this.tableData = await RoleHelper.query(this.searchStr,this.page,this.row);
            this.isLoading = false;
        }

        //打开添加模态框
        openAdd() {
            this.formData = {};
            this.dialog.title = "添加角色";
            this.dialog.visible = true;
            this.dialog.success = async () => {
                let formEdit = this.$refs["formEdit"] as any;
                if(!await formEdit.validate()) return;
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

        async deleteRole(id: number) {
            console.log(id)
            let message = await RoleHelper.delete(id);
            if (message.flag) {
                this.$notify({type: "success",title: "消息",message: "删除成功 !"});
                this.query();
            } else {
                this.$notify({type: "error",title: "消息",message: message.msg});
            }
        }

        async loadEmp(row: Role) {
            this.$set(row,"empData",await RoleHelper.getEmpsByRoleId(row.id));

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