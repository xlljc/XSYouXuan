<!--权限-->
<template>
    <div>
        <el-col :span="16">
            <el-input v-model="searchStr" placeholder="输关键字查找..." clearable style="width: 350px">
                <el-button slot="append" icon="el-icon-search" @click="query"></el-button>
            </el-input>
            <!--表格数据-->
            <el-table :data="tableData.list"
                      v-loading="isLoading"
                      highlight-current-row
                      @current-change="selectRow">
                <el-table-column width="100" prop="id" label="ID" sortable></el-table-column>
                <el-table-column width="200" prop="name" label="角色名"></el-table-column>
                <el-table-column prop="remark" label="备注"></el-table-column>
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
        </el-col>

        <!-- 树节点 -->
        <el-col :span="8">
            <div style="padding-left: 25px">
                <el-row>
                    <el-button icon="el-icon-key" type="primary" plain style="margin-right: 8px" @click="authorization">授权</el-button>
                    <el-input style="width: 210px;"
                            placeholder="输入关键字进行过滤"
                            v-model="filterText"
                            clearable>
                    </el-input>
                </el-row>
                <el-divider></el-divider>
                <el-tree
                        v-loading="$store.getters['back/menusLoading'] || treeLoading"
                        :data="$store.getters['back/menus']"
                        show-checkbox
                        node-key="id"
                        ref="tree"
                        :filter-node-method="filterTree"
                        :props="{
                            children: 'menus',
                            label: 'name',
                            id: 'id'
                        }"
                        highlight-current>
                </el-tree>
            </div>
        </el-col>

        <!-- 冻结员工 -->
        <el-dialog :close-on-click-modal="false"
                   title="身份验证"
                   :visible.sync="yanzheng"
                   width="300px">
            <div>
                <p>修改权限: 你正在操作敏感数据, 请输入你的登录密码以确保是你本人操作 !</p>
                <el-input v-model="yanzhengPassword" type="password" clearable show-password></el-input>
            </div>

            <div slot="footer" class="dialog-footer">
                <el-button @click="yanzheng = false">取 消</el-button>
                <!--点击调用修改方法-->
                <el-button type="primary" @click="yanzhengsf">确 定</el-button>
            </div>
        </el-dialog>

    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";
    import {Menu, PageInfo, Role} from "@/helper/entity";
    import {RoleHelper} from "@/helper/back/RoleHelper";
    import Utils from "@/helper/Utils";
    import {EmpHelper} from "@/helper/back/EmpHelper";

    type checkData = {
        checkedNodes: Menu[];
        checkedKeys: number[];
        halfCheckedKeys: number[];
        halfCheckedNodes: Menu[];
    }

    @Component
    export default class PermManagement extends Vue {

        page: number = 1;
        row: number = 10;
        tableData: PageInfo<Role> = {};
        searchStr: string = "";
        isLoading: boolean = false;
        treeLoading: boolean = false;

        selectRowData: Role = null;

        //选项原数据
        oldSelectData: number[] = [];

        yanzheng: boolean = false;
        yanzhengPassword: string = "";

        //过滤节点输入框
        filterText: string = "";

        //监听输入框变化, 调用过滤方法
        @Watch("filterText")
        wFilterText(val: string) {
            (this.$refs["tree"] as any).filter(val);
        }

        //过滤树方法
        filterTree(value: string, data: any) {
            if (!value) return true;
            return data.name.indexOf(value) !== -1;
        }

        created() {
            this.$store.commit('back/url', window.location.href);
            this.query();
        }

        mounted() {

        }

        //查询角色方法
        async query() {
            this.selectRowData = null;
            this.isLoading = true;
            this.tableData = await RoleHelper.query(this.searchStr, this.page, this.row);
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

        initSelectData() {
            let tree = this.$refs["tree"] as any;
            //获取选中(3级菜单)
            let selectTree: Menu[] = tree.getCheckedNodes();
            selectTree = selectTree.filter(value => value.layer === 3);
            //加到初始选中
            this.oldSelectData = [];
            selectTree.forEach(value => this.oldSelectData.push(value.id));
        }

        //选中一行
        async selectRow(row: Role) {
            this.selectRowData = row;
            this.treeLoading = true;
            let list = await RoleHelper.getMenus(row.id);

            //设置选中
            let tree = this.$refs["tree"] as any;
            tree.setCheckedNodes(list);

            this.initSelectData();

            this.treeLoading = false;
        }

        //授权
        async authorization() {
            if (!this.selectRowData) {
                this.$notify({type: "error",message: "请选择一个角色 !",title: "提示"})
                return;
            }
            //身份验证
            this.yanzheng = true;
        }

        //授权提交
        async yanzhengsf() {
            let message = await EmpHelper.validation(this.yanzhengPassword);
            if (message.flag) {
                this.$notify.success({title: "提示", message: message.msg,});

                let tree = this.$refs["tree"] as any;
                //获取选中
                let selectTree: Menu[] = tree.getCheckedNodes();
                //留下3级节点
                selectTree = selectTree.filter(value => value.layer === 3);
                let listIds: number[] = [];
                //新增id
                let newSelectData: number[] = [];
                //移除id
                let removeSelectData: number[] = [];
                //新增的项
                selectTree.forEach(value => {
                    listIds.push(value.id);
                    if (this.oldSelectData.indexOf(value.id) === -1)
                        if (newSelectData.indexOf(value.id) === -1) newSelectData.push(value.id);
                })
                //移除的项
                this.oldSelectData.forEach(value => {
                    if (listIds.indexOf(value) === -1)
                        if (removeSelectData.indexOf(value) === -1) removeSelectData.push(value);
                })
                //提交
                message = await RoleHelper.authorization(newSelectData, removeSelectData, this.selectRowData.id);
                if (message.flag) {
                    this.$notify.success({title: "提示", message: "授权成功 !",});
                } else {
                    this.$notify.error({title: "提示", message: message.msg,});
                }
                this.initSelectData();
            } else {
                this.$notify.error({title: "提示", message: message.msg,});
            }
            this.yanzheng = false;
            this.yanzhengPassword = "";
        }
    }
</script>

<style scoped>

</style>