<!--角色编辑-->
<template>
    <div>
        <el-tooltip effect="light" v-for="(item,index) in tipData" :key="index" placement="top-start" :content="item.remark">
            <el-tag @close="removeTip(item)" closable style="margin-right: 10px;margin-bottom: 5px">{{ item.name }}</el-tag>
        </el-tooltip>
        <el-divider></el-divider>

        <el-input v-model="searchStr" placeholder="输关键字查找..." clearable>
            <el-button slot="append" icon="el-icon-search" @click="query"></el-button>
        </el-input>
        <!--表格数据-->
        <el-table :data="tableData.list" v-loading="isLoading">
            <el-table-column label="操作" width="80px">
                 <el-button slot-scope="{row}" slot="" type="success" size="mini" round plain @click="addTip(row)">选择</el-button>
            </el-table-column>
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
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Prop, Watch} from "vue-property-decorator";
    import {PageInfo, Role} from "@/helper/entity";
    import {RoleHelper} from "@/helper/back/RoleHelper";

    @Component
    export default class EmpManagementRoleEdit extends Vue {

        @Prop()
        roleData: Role[];

        //标签数据
        tipData: Role[] = [];

        page: number = 1;
        row: number = 10;
        tableData: PageInfo<Role> = {};
        searchStr: string = "";
        isLoading: boolean = false;

        @Watch("roleData", {deep: true})
        wRoleData(value: Role[]) {
            this.tipData = value;
        }

        mounted() {
            this.query();
            this.tipData = this.roleData;
        }

        //移除标签
        removeTip(tag: Role) {
            if (tag.id === 1) {
                this.$notify({title: "提示", message: "你不能操作超级管理员 !", type: "error"})
                return;
            }
            this.roleData.splice(this.roleData.indexOf(tag), 1);
        }

        //添加标签
        addTip(tag: Role) {
            if (this.roleData.find(value => tag.name === value.name && tag.remark === value.remark)) return;
            this.roleData.push(tag);
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


    }
</script>

<style scoped>

</style>