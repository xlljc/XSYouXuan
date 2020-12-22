<!--仓库信息维护页面-->
<template>
    <div>
    <!-- 模糊查询-->
    <el-input
            style="width: 300px"
            placeholder="请输入仓库名"
            v-model="input"
            clearable>
    </el-input>
    <el-button
            type="primary"
            slot="append"
            icon="el-icon-search"
            @click="MohuqueryWarehouse"
    >查询
    </el-button>
    <el-button
            type="success"
            slot="append"
            icon="el-icon-circle-plus"

    >添加
    </el-button>
    <!--strip 双行阴影效果属性-->
    <el-table
            border
            :data="tableData.rows"
            style="width: 100%;margin-top: 30px">
        <el-table-column type="expand">
            <template slot-scope="props">
                <el-form label-position="left" inline class="demo-table-expand">
                    <el-form-item label="仓库ID：">
                        <span>{{ props.row.warid }}</span>
                    </el-form-item>
                    <el-form-item label="仓库名称：">
                        <span>{{ props.row.warname }}</span>
                    </el-form-item>
                    <el-form-item label="仓库类型：">
                        <span>{{ props.row.wartype }}</span>
                    </el-form-item>
                    <el-form-item label="仓库容量：">
                        <span>{{ props.row.warcapacity }}</span>
                    </el-form-item>
                    <el-form-item label="仓库地址：">
                        <span>{{ props.row.waraddress }}</span>
                    </el-form-item>
                    <el-form-item label="仓库状态：">
                        <span>{{ getState(props.row.warstate) }}</span>
                    </el-form-item>
                </el-form>
            </template>
        </el-table-column>
        <el-table-column
                label="仓库名"
                prop="warname">
        </el-table-column>
        <el-table-column
                label="仓库类型"
                prop="wartype">
        </el-table-column>
        <el-table-column
                label="仓库容量(剩余)"
                prop="warcapacity">
        </el-table-column>


        <el-table-column label="操作">
            <template slot-scope="scope">
                <el-button
                        type="primary"
                        circle
                        icon="el-icon-edit"
                        size="medium"
                        @click="queryCommodityTypedetails(scope.$index, scope.row)"></el-button>
                <el-button
                        type="danger"
                        circle
                        icon="el-icon-delete"
                        size="medium"
                        @click="deleteCommodityType(scope.$index, scope.row)"></el-button>
            </template>
        </el-table-column>
    </el-table>
        <!--分页-->
        <el-pagination
                @size-change="rowsChange"
                @current-change="pageChange"
                :current-page="newpage"
                :page-sizes="[5, 10, 15, 20]"
                :page-size="5"
                layout="total, sizes, prev, pager, next, jumper"
                :total="tableData.total">
        </el-pagination>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";
    import {Warehouse} from "@/helper/entity";

    //声明 分页类型
    export interface PageInfo {
        //这个{}可以换成返回的对象类型
        rows?: Warehouse[];
        total?: number;
        //后面自己加
    }

    @Component
    export default class Warehousemaintain extends Vue {
        //添加模态框的状态
        addmotaikuang =false;
        //修改模态框的状态
        updatemotaikuang = false;
        //搜索框的变量
        input:string="";
        //仓库数据
        tableData: PageInfo = {};


        //当前页数
        newpage:number=1;
        //分页页码的值
        page:number=1;
        //分页一页多少行的值
        rows:number=5;


        created() {
            this.$store.commit('back/url', window.location.href);

            //加载所有仓库信息
            this.getWarehouseAll();

            //获取登录信息
            /*EmpHelper.getEmp().then(value => {
                console.log(value);
            })*/
        }

        //获取仓库状态
        getState(state: number): string {
            if (state === 1) return "正常";
            if (state === 0) return "冻结";
        }


        //***********************************************************
        //                      分页部分
        //***********************************************************
        /*点击换条数的按钮*/
        rowsChange(val:number) {
            //修改条数的值
            this.rows=val;
            this.getWarehouseAll();
        }
        //点击分页页数按钮
        pageChange(val:number) {
            //修改页数的值
            this.page=val;
            this.getWarehouseAll();
        }


        //***********************************************************
        //                      仓库查询部分
        //***********************************************************
        //页面打开 查询所有仓库信息
        getWarehouseAll(){
            let params = new URLSearchParams();
            params.append("warname",this.input);
            params.append("page",this.page.toString());
            params.append("rows",this.rows.toString());
            Axios({
                method: "post",
                url: "/warehouse/queryWarehouseAll",
                data: params
            }).then(value => {
                 /*console.log(value.data)*/
                this.tableData=value.data;
            })
        }

        //点击查询按钮 模糊查询仓库信息
        MohuqueryWarehouse(){
            this.getWarehouseAll();
        }



        queryCommodityLabledetails(){

        }

        deleteCommodityLable(){

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

    /*table拉开的样式 ↑*/
</style>
