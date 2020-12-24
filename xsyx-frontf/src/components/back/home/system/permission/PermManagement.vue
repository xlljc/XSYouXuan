<!--权限-->
<template>
    <div>
        <el-col :span="12">
            <el-input v-model="searchStr" placeholder="输关键字查找..." clearable>
                <el-button slot="append" icon="el-icon-search" @click="query"></el-button>
            </el-input>
            <!--表格数据-->
            <el-table :data="tableData.list"
                      v-loading="isLoading"
                      highlight-current-row
                      @current-change="selectRow">
                <el-table-column prop="id" label="ID" sortable></el-table-column>
                <el-table-column prop="name" label="角色名"></el-table-column>
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

        <el-col :span="12">
            <el-tree
                    :data="$store.getters['back/menuTrees']"
                    show-checkbox
                    default-expand-all
                    node-key="id"
                    ref="tree"
                    highlight-current>
            </el-tree>
        </el-col>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import {PageInfo, Role} from "@/helper/entity";
    import {RoleHelper} from "@/helper/back/RoleHelper";

    @Component
    export default class PermManagement extends Vue {

        page: number = 1;
        row: number = 10;
        tableData: PageInfo<Role> = {};
        searchStr: string = "";
        isLoading: boolean = false;

        load() {
            console.log("666")
            let getter = this.$store.getters["back/menus"];
            console.log(getter)
            console.log(this.$store.getters["back/menuTrees"])
        }

        created() {
            this.$store.commit('back/url', window.location.href);
            this.query();
        }

        async query() {
            this.isLoading = true;
            this.tableData = await RoleHelper.query(this.searchStr,this.page,this.row);
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
        //选中一行
        selectRow(row: Role) {
            console.log(row);
        }
    }
</script>

<style scoped>

</style>