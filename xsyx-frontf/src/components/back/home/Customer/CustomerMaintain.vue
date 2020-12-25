<template>
    <div>
        <!-- 模糊查询-->
        <el-input
                style="width: 600px"
                placeholder="请输入关键字"
                v-model="searchStr"
                clearable>
            <div slot="prepend">
                <el-tooltip effect="dark" content="性别" placement="top-end">
                    <!-- 性别-->
                    <el-select v-model="searchSex" placeholder="性别" style="width: 90px">
                        <el-option label="全部" :value="null"></el-option>
                        <el-option label="男" value="男"></el-option>
                        <el-option label="女" value="女"></el-option>
                    </el-select>
                </el-tooltip>
            </div>
            <template slot="append">
                <el-button
                        v-if="$btnPermissions('客户查询')"
                        slot="append"
                        icon="el-icon-search"
                        @click="query">
                    查询
                </el-button>
            </template>
        </el-input>

        <el-pagination
                @size-change="rowChange"
                @current-change="pageChange"
                background
                :page-sizes="[10, 15, 25, 50]"
                :page-size="10"
                layout="total, sizes, prev, pager, next"
                :total="tableData.total">
        </el-pagination>

        <!--模态框-->
        <el-dialog :close-on-click-modal="false"
                   :title="dialog.title"
                   :visible.sync="dialog.visible">
            <div>

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
    import {DialogTemplateData, PageInfo, User} from "@/helper/entity";

    @Component
    export default class CustomerMaintain extends Vue {

        //加载状态
        isLoading = false;
        //查询输入框
        searchStr: string = "";
        //性别
        searchSex: string = null;
        //表数据
        tableData: PageInfo<User> = {};
        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        //选中的行
        selectRow: User = {};

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

        //查询方法
        async query() {
            this.isLoading = true;
            
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