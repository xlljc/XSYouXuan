<!--商品资料维护页面-->
<template>
    <div>
   <!-- 模糊查询-->
        <el-input
                style="width: 300px"
                placeholder="请输入内容"
                v-model="input"
                clearable>
        </el-input>
        <el-button
                type="primary"
                slot="append"
                icon="el-icon-search"
                >查询</el-button>
        <el-button
                type="success"
                slot="append"
                icon="el-icon-circle-plus"
                >添加</el-button>
    <!--strip 双行阴影效果属性-->
    <el-table
            border
            :data="tableData"
            style="width: 100%;margin-top: 30px">
        <el-table-column type="expand">
            <template slot-scope="props">
                <el-form label-position="left" inline class="demo-table-expand">
                    <el-form-item label="商品名称：">
                        <span>{{ props.row.name }}</span>
                    </el-form-item>
                    <el-form-item label="商品描述：">
                        <span>{{ props.row.particulars }}</span>
                    </el-form-item>
                    <el-form-item label="商品图片：">
                        <span>{{ props.row.image }}</span>
                    </el-form-item>
                    <el-form-item label="商品价格：">
                        <span>{{ props.row.price }}</span>
                    </el-form-item>
                    <el-form-item label="单位：">
                        <span>{{ props.row.unit }}</span>
                    </el-form-item>
                    <el-form-item label="规格：">
                        <span>{{ props.row.specification }}</span>
                    </el-form-item>
                    <el-form-item label="生产厂商：">
                        <span>{{ props.row.manufacturer }}</span>
                    </el-form-item>
                    <el-form-item label="商品类型：">
                        <span>{{ props.row.comtype }}</span>
                    </el-form-item>
                    <el-form-item label="商品上架时间(第一次上架时间)：">
                        <span>{{ props.row.putawaydate }}</span>
                    </el-form-item>
                    <el-form-item label="最新上架时间：">
                        <span>{{ props.row.newestputawaydate }}</span>
                    </el-form-item>
                    <el-form-item label="商品状态, 0未上架, 1已上架, -1已删除：">
                        <span>{{ props.row.state }}</span>
                    </el-form-item>
                </el-form>
            </template>
        </el-table-column>
        <el-table-column
                label="商品 ID"
                prop="id">
        </el-table-column>
        <el-table-column
                label="商品名称"
                prop="name">
        </el-table-column>
        <el-table-column
                label="商品图片"
                prop="image">
        </el-table-column>
        <el-table-column
                label="描述"
                prop="particulars">
        </el-table-column>

        <el-table-column label="操作">
            <template slot-scope="scope">
                <el-button
                        type="primary"
                        circle
                        icon="el-icon-edit"
                        size="medium"
                        @click="queryCommoditydetails(scope.$index, scope.row)"></el-button>
                <el-button
                        type="danger"
                        circle
                        icon="el-icon-delete"
                        size="medium"
                        @click="deleteCommodity(scope.$index, scope.row)"></el-button>
            </template>
        </el-table-column>
    </el-table>

        <el-dialog title="商品修改" :visible.sync="updatemotaikuang">

            <el-form label-width="80px">
                <el-form-item label="ID">
                    <el-input v-model="input"  :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="名字">
                    <el-input v-model="input"></el-input>
                </el-form-item>
                <el-form-item label="生日">
                    <!--<el-input v-model="editbirthday"></el-input>-->
                    <el-date-picker v-model="input" type="date" placeholder="选择日期">
                    </el-date-picker>

                </el-form-item>
                <el-form-item label="工资">
                    <el-input oninput="value=value.replace(/[^\d]/g,'')" v-model="input"></el-input>
                </el-form-item>

            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="updatemotaikuang = false">取 消</el-button>
                <el-button type="primary" @click="updatemotaikuang = false">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";

    export type commodity = {
        id: number | string;
        name: string;
        particulars :string;
        image :string;
        price : number ;
        unit :string;
        specification :string;
        manufacturer :string;
        comtype :number | string;
        putawaydate : string;
        newestputawaydate :string;
        state:string;
    }
    @Component
    export default class Commodity extends Vue {
        //修改模态框的状态
        updatemotaikuang =false;

        //输入框的变量
        input : string="";
        //商品数据
        tableData : commodity[] = [{
            id: 1,
            name: "胖达荣荣",
            particulars :"从小一个人长大",
            image :"1.jpg",
            price : 20.1 ,
            unit :"单位",
            specification :"规格",
            manufacturer :"福利院",
            comtype :"孤儿",
            putawaydate : "2020.21.23",
            newestputawaydate :"2020.21.23",
            state:"上架",
        }]

        created() {
            this.$store.commit('back/url', window.location.href);
        }

        //添加商品信息方法

        //获取选中的商品的详情
        queryCommoditydetails(index: number,row: {}){
            //打开模态框
            this.updatemotaikuang=true;
            console.log(row)
        }
        //点击模态框确定按钮  修改商品信息方法
        updateCommodity(){
            Axios.get("commodity/queryAll").then(value => {
               alert(value.data);
            })
        }
        //删除商品信息方法
        deleteCommodity(index: number,row: {}){
            /*alert(index)
            alert(row.address)*/
            this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
                center: true
            }).then(() => {
                //执行删除操作
                Axios.get("/commodity/queryAll").then(value => {
                    console.log(value.data)
                })

                this.$message({
                    type: 'success',
                    message: '删除成功!'
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