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
       <!-- 上架状态-->
        <el-select v-model="zhuangtai">
            <el-option value="全部">全部</el-option>
            <el-option value="上架">上架</el-option>
            <el-option value="下架">下架</el-option>
        </el-select>
        <el-button
                type="primary"
                slot="append"
                icon="el-icon-search"
                @click="MohuqueryCommodity"
        >查询
        </el-button>
        <el-button
                type="success"
                slot="append"
                icon="el-icon-circle-plus"
                @click="openAddCommodity"
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
                        <el-form-item label="商品名称：">
                            <span>{{ props.row.name }}</span>
                        </el-form-item>
                        <el-form-item label="商品描述：">
                            <span>{{ props.row.particulars }}</span>
                        </el-form-item>
                        <el-form-item label="商品图片：">
                            <el-image fit="cover" :src="$host+props.row.image" :preview-src-list="[$host+props.row.image]" style="width: 100px;height: 50px"></el-image>
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
                            <span>{{ props.row.comType.id }}</span>
                        </el-form-item>
                        <el-form-item label="商品上架时间(第一次上架时间)：">
                            <span>{{ props.row.putawayDate }}</span>
                        </el-form-item>
                        <el-form-item label="最新上架时间：">
                            <span>{{ props.row.newestPutawayDate }}</span>
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
                <template slot-scope="props">
                    <el-image fit="cover" :src="$host+props.row.image" :preview-src-list="[$host+props.row.image]" style="width: 100px;height: 50px"></el-image>
                </template>
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

        <!-- 添加功能模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="商品添加"
                   :visible.sync="addmotaikuang">
            <!-- 商品编辑组件, 传入data值, 传入图片列表 -->
            <commodity-edit :from-data="fromData" :image-file="imageFile"></commodity-edit>

            <div slot="footer" class="dialog-footer">
                <el-button @click="addmotaikuang = false">取 消</el-button>
                <!--点击调用添加方法-->
                <el-button type="primary" @click="submitAddCommodity">确 定</el-button>
            </div>
        </el-dialog>

        <!-- 修改功能模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="商品修改"
                   :visible.sync="updatemotaikuang">
            <!-- 商品编辑组件, 传入data值, 传入图片列表 -->
            <commodity-edit :from-data="fromData" :image-file="imageFile"></commodity-edit>

            <div slot="footer" class="dialog-footer">
                <el-button @click="updatemotaikuang = false">取 消</el-button>
                <!--点击调用添加方法-->
                <el-button type="primary" @click="updateCommodity">确 定</el-button>
            </div>
        </el-dialog>

    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";
    import Axios from "axios";
    import {ComDiscount, Commodity as Com, FileInfo, Message} from "@/helper/entity";
    import CommodityEdit from "@/components/back/home/Commodity/CommodityEdit.vue";
    import {EmpHelper} from "@/helper/back/EmpHelper";

    /**
     * 创建一个空的商品对象
     * 这里的Com是Commodity类型的别名, 因为Commodity类型会与当前组件类名冲突
     */
    function createEmptyCommodity(): Com {
        return {comType: {}, comDiscount: {}};
    }

    /**
     * 创建一个空的文件信息
     */
    function createEmptyFileInfo(): FileInfo {
        return {url: null};
    }

    //声明 分页类型
    export interface PageInfo {
        //这个{}可以换成返回的对象类型
        rows?: Commodity[];
        total?: number;
        //后面自己加
    }

    @Component({
        components: {CommodityEdit}
    })
    export default class Commodity extends Vue {

        //添加模态框的状态
        addmotaikuang =false;
        //修改模态框的状态
        updatemotaikuang = false;
        //搜索框的变量
        input:string="";
        //状态框的变量
        zhuangtai:string="上架";
        //商品数据(包括图片)
        tableData: PageInfo = {};


        //修改 和 添加模态框的变量
        fromData: Com = createEmptyCommodity();
        //图片信息, 路径在url
        imageFile: FileInfo = createEmptyFileInfo();


        //当前页数
        newpage:number=1;
        //分页页码的值
        page:number=1;
        //分页一页多少行的值
        rows:number=5;

        created() {
            this.$store.commit('back/url', window.location.href);

            //加载所有商品信息
            this.getCommodityAll();
            //获取登录信息
            /*EmpHelper.getEmp().then(value => {
                console.log(value);
            })*/
        }

        /*点击换条数的按钮*/
        rowsChange(val:number) {
            //修改条数的值
            this.rows=val;
            this.getCommodityAll();
        }
        //点击分页页数按钮
        pageChange(val:number) {
            //修改页数的值
            this.page=val;
            this.getCommodityAll();
        }

        //***********************************************************
        //                      商品添加部分
        //***********************************************************
        //打开添加商品模态框方法
        openAddCommodity() {
            //打开模态框
            this.addmotaikuang = true;
            //设置fromData的值, 这个就是传到模态框表单里面的值, 这里是添加, 创建一个空的商品对象
            //清空数据
            this.fromData = createEmptyCommodity();
            //设置图片
            this.imageFile = createEmptyFileInfo();
        }
        //提交添加的商品信息方法
        submitAddCommodity() {
            //关闭模态框
            this.addmotaikuang = false;
            //执行提交操作
            let params = new URLSearchParams();
            params.append("name",this.fromData.name)
            params.append("particulars",this.fromData.particulars)
            params.append("image",this.imageFile.url)
            params.append("price",this.fromData.price.toString())
            params.append("unit",this.fromData.unit)
            params.append("specification",this.fromData.specification)
            params.append("manufacturer",this.fromData.manufacturer)
            params.append("comtype",this.fromData.comType.id.toString())
            this.$axios.post("/commodity/addCommodity",params).then(function (result) {
                alert(result.data)

                //关闭模态框
                this.addmotaikuang=false;
                //刷新页面
                this.getCommodityAll();
            })
        }

        //***********************************************************
        //                      商品查询部分
        //***********************************************************
        //页面打开 查询所有商品信息
        getCommodityAll(){
            console.log("getCommodityAll")
            let params = new URLSearchParams();
            params.append("name",this.input)
            params.append("state",this.zhuangtai)
            params.append("page",this.page.toString())
            params.append("rows",this.rows.toString())
            Axios({
                method: "post",
                url: "/commodity/queryCommodityAll",
                data: params
            }).then(value => {
                console.log(value.data)
                this.tableData=value.data;
            })

        }

        //点击查询按钮 模糊查询商品信息
        MohuqueryCommodity(){
            this.getCommodityAll();
        }



        //获取选中的商品的详情
        queryCommoditydetails(index: number, row: Commodity) {

            //打开修改模态框
            this.updatemotaikuang = true;

        }

        //点击模态框确定按钮  修改商品信息方法 (未写)
        updateCommodity() {
            Axios.get("/commodity/queryAll").then(value => {
                alert(value.data);
            })
        }

        //删除商品信息方法 （未写）
        deleteCommodity(index: number, row: {}) {
            /*alert(index)
            alert(row.address)*/
            this.$confirm('此操作将下架商品, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
                center: true
            }).then(() => {
                //执行删除操作
                Axios.get("/commodity/delete").then(value => {
                    console.log(value.data)
                })

                this.$message({
                    type: 'success',
                    message: '下架成功!'
                });
            }).catch(() => {
                this.$message({
                    type: 'error',
                    message: '已取消下架'
                });
            });

        }

        //关闭模态框的方法 清除模态框的数据
        closeMoTaiKuANG(){

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
