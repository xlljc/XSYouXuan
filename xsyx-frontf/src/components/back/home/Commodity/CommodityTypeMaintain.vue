<!--商品类型维护页面-->
<template>
    <div>
        <!-- 模糊查询-->
        <el-input
                style="width: 300px"
                placeholder="请输入商品类型名"
                v-model="input"
                clearable>
        </el-input>
        <el-button
                type="primary"
                slot="append"
                icon="el-icon-search"

        >查询
        </el-button>
        <el-button
                type="success"
                slot="append"
                icon="el-icon-circle-plus"
                @click="addmotaikuang=true"
                v-if="$btnPermissions('类型添加')"
        >添加
        </el-button>
        <!--strip 双行阴影效果属性-->
        <el-table
                border
                :data="tableData"
                style="width: 100%;margin-top: 30px">
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="类型ID：">
                            <span>{{ props.row.id }}</span>
                        </el-form-item>
                        <el-form-item label="类型名称：">
                            <span>{{ props.row.name }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="类型ID"
                    prop="id">
            </el-table-column>
            <el-table-column
                    label="类型名称"
                    prop="name">
            </el-table-column>


            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-tooltip class="item" effect="dark" content="修改类型" placement="top-start">
                    <el-button
                            type="primary"
                            circle
                            icon="el-icon-edit"
                            size="medium"
                            @click="openupdateCommodityType(scope.$index, scope.row)"
                            v-if="$btnPermissions('类型修改')"></el-button>
                    </el-tooltip>
                        <el-button
                            type="danger"
                            circle
                            icon="el-icon-delete"
                            size="medium"
                            @click="deleteCommodityType(scope.$index, scope.row)"
                            v-if="$btnPermissions('类型删除')"></el-button>
                </template>
            </el-table-column>
        </el-table>
        <!--添加模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="添加"
                   :visible.sync="addmotaikuang">
            <el-input
                    style="width: 300px"
                    placeholder="---请输入类型---"
                    v-model="typename"
                    clearable>
            </el-input>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="addCommodityType">确 定</el-button>
            </div>
        </el-dialog>
        <!--修改模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="修改"
                   :visible.sync="updatemotaikuang">
            <el-input
                    style="width: 300px"
                    placeholder="---请输入类型---"
                    v-model="typename"
                    clearable>
            </el-input>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="updateCommodityType">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";
    import {Commodity as Com} from "@/helper/entity";


    @Component
    export default class CommodityTypeMaintain extends Vue {

        created() {
            this.$store.commit('back/url', window.location.href);

            //加载所有商品类型信息
            this.getCommodityTypeAll();

            //获取登录信息
            /*EmpHelper.getEmp().then(value => {
                console.log(value);
            })*/
        }

        //搜索框的值
        input="";
        /*商品类型数据*/
        tableData: any[]=[];
        //添加模态框
        addmotaikuang=false;
        updatemotaikuang=false;
        //类型添加的值
        typename:string="";
        //修改的类型id
        typeid : number = 0;

        //***********************************************************
        //                      商品类型查询部分
        //***********************************************************
        //页面打开 查询所有商品类型信息
        getCommodityTypeAll(){
            Axios({
                method: "post",
                url: "/commodity/queryAlltype"
            }).then(value => {
               /* console.log(value.data)*/
                this.tableData=value.data;

            })
        }
        //***********************************************************
        //                      商品类型添加部分
        //***********************************************************
        //打开添加模态框
        /*openaddCommodityType(){

        }*/
        //添加类型
        addCommodityType(){
            //alert(this.typename)
            let params = new URLSearchParams();
            params.append("name",this.typename);
            //添加
            Axios({
                method: "post",
                url: "/commodity/addCommodityType",
                data: params
            }).then(value => {
                //console.log(value)
                this.$message({
                    type: 'success',
                    message: value.data.msg
                });
                //关闭模态框
                this.addmotaikuang=false;
                //刷新页面
                this.getCommodityTypeAll();
            })
        }

        //***********************************************************
        //                      商品类型修改部分
        //***********************************************************
        //打开修改模态框
        openupdateCommodityType(index: number, row: any){
            this.updatemotaikuang=true;
            //获取id
            this.typeid=row.id
            //alert(row.id)
            //赋值
            this.typename=row.name;
        }
        //提交修改
        updateCommodityType(){
            let params = new URLSearchParams();
            params.append("id",  this.typeid.toString());
            params.append("name",this.typename);
            //修改
            Axios({
                method: "post",
                url: "/commodity/updateCommodityType",
                data: params
            }).then(value => {
                //console.log(value)
                this.$message({
                    type: 'success',
                    message: value.data.msg
                });
                //关闭模态框
                this.updatemotaikuang=false;
                //刷新页面
                this.getCommodityTypeAll();
            })
        }

        //***********************************************************
        //                      商品类型删除部分
        //***********************************************************

        deleteCommodityType(index: number, row: any){
            this.$confirm('此操作将删除类型, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
                center: true
            }).then(() => {
                let params = new URLSearchParams();
                params.append("id",row.id.toString())
                //执行删除操作
                this.$axios.post("/commodity/deleteType",params)
                    .then((result)=> {
                        if (result.data.flag===true){
                            this.$message({
                                type: 'success',
                                message: "删除成功√"
                            });
                        }
                        //刷新页面
                        this.getCommodityTypeAll();
                    }).catch((msg) => {
                    this.$message({
                        type: 'error',
                        message: "删除失败×"
                    });
                });


            }).catch(() => {
                this.$message({
                    type: 'error',
                    message: '已取消删除'
                });
            });
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
