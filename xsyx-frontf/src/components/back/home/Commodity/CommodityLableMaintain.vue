<!--商品标签维护页面-->
<template>
    <div>
        <!-- 模糊查询-->
        <el-input
                style="width: 300px"
                placeholder="请输入商品标签名"
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
                        <el-form-item label="标签ID：">
                            <span>{{ props.row.id }}</span>
                        </el-form-item>
                        <el-form-item label="标签名称：">
                            <span>{{ props.row.name }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="标签ID"
                    prop="id">
            </el-table-column>
            <el-table-column
                    label="标签名称"
                    prop="name">
            </el-table-column>


            <el-table-column label="操作">
                <template>
                    <el-button
                            type="primary"
                            circle
                            icon="el-icon-edit"
                            size="medium"
                            ></el-button>
                    <el-button
                            type="danger"
                            circle
                            icon="el-icon-delete"
                            size="medium"
                            ></el-button>
                </template>
            </el-table-column>
        </el-table>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    import Axios from "axios";


    @Component
    export default class CommodityTypeMaintain extends Vue {

        created() {
            this.$store.commit('back/url', window.location.href);

            //加载所有商品类型信息
            this.getCommodityLableAll();

            //获取登录信息
            /*EmpHelper.getEmp().then(value => {
                console.log(value);
            })*/
        }

        //搜索框的值
        input="";
        /*商品标签数据*/
        tableData: any[]=[];

        //***********************************************************
        //                      商品标签查询部分
        //***********************************************************
        //页面打开 查询所有商品标签信息
        getCommodityLableAll(){
            Axios({
                method: "post",
                url: "/commodity/queryAlllabel"
            }).then(value => {
               /* console.log(value.data)*/
                this.tableData=value.data;

            })
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
