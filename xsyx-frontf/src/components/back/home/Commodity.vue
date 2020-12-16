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
                @click="addmotaikuang = true"
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
                        <el-form-item label="商品名称：">
                            <span>{{ props.row.name }}</span>
                        </el-form-item>
                        <el-form-item label="商品描述：">
                            <span>{{ props.row.particulars }}</span>
                        </el-form-item>
                        <el-form-item label="商品图片：">
                            <el-image fit="cover" :src="require('@/assets/'+props.row.image)" :preview-src-list="[require('@/assets/'+props.row.image)]" style="width: 100px;height: 50px"></el-image>
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
                <template slot-scope="props">
                    <el-image fit="cover" :src="require('@/assets/'+props.row.image)" :preview-src-list="[require('@/assets/'+props.row.image)]" style="width: 100px;height: 50px"></el-image>
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
        <el-pagination
                background
                layout="prev, pager, next"
                :total="1000">
        </el-pagination>

        <!-- 添加功能模态框-->
        <el-dialog :show-close="false"
                   :before-close="handleClose"
                   title="商品添加" :visible.sync="addmotaikuang">

            <el-form label-width="80px">
                <el-form-item label="商品名称">
                    <el-input v-model="name"></el-input>
                </el-form-item>
                <el-form-item label="商品描述">
                    <el-input v-model="particulars"></el-input>
                </el-form-item>
                <el-form-item label="商品图片">
                    <el-upload
                            action="#"
                            list-type="picture-card"
                            :auto-upload="false">
                        <i slot="default" class="el-icon-plus"></i>
                        <div slot="file" slot-scope="{file}">
                            <img
                                    class="el-upload-list__item-thumbnail"
                                    :src="file.url" alt=""
                            >
                            <span class="el-upload-list__item-actions">
        <span
                class="el-upload-list__item-preview"
                @click="handlePictureCardPreview(file)"
        >
          <i class="el-icon-zoom-in"></i>
        </span>


        <span
                v-if="!disabled"
                class="el-upload-list__item-delete"
                @click="handleRemove(file)"
        >
          <i class="el-icon-delete"></i>
        </span>
      </span>
                        </div>
                    </el-upload>
                   <!--全屏放大图片-->
                    <el-dialog :visible.sync="dialogVisible">
                        <img width="100%" :src="dialogImageUrl" alt="">
                    </el-dialog>
                </el-form-item>
                <el-form-item label="商品价格">
                    <el-input v-model="price"></el-input>
                </el-form-item>
                <el-form-item label="单位">
                    <el-input v-model="unit"></el-input>
                </el-form-item>
                <el-form-item label="规格">
                    <el-input v-model="specification"></el-input>
                </el-form-item>
                <el-form-item label="生产厂商">
                    <el-input v-model="manufacturer"></el-input>
                </el-form-item>
                <el-form-item label="商品类型">
                    <el-select v-model="comtype">
                        <el-option value="1">1</el-option>
                        <el-option value="2">2</el-option>
                        <el-option value="3">3</el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="上架时间">
                    <el-date-picker v-model="putawaydate" type="date" placeholder="选择日期"></el-date-picker>
                </el-form-item>

            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="closeMoTaiKuANG">取 消</el-button>
                <el-button type="primary" @click="addCommodity">确 定</el-button>
            </div>
        </el-dialog>

        <!-- 修改功能模态框-->
        <el-dialog :show-close="false"
                   :before-close="handleClose"
                   title="商品修改" :visible.sync="updatemotaikuang">

            <el-form label-width="80px">
                <el-form-item label="商品ID">
                    <el-input v-model="id" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="商品名称">
                    <el-input v-model="name"></el-input>
                </el-form-item>
                <el-form-item label="商品描述">
                    <el-input v-model="particulars"></el-input>
                </el-form-item>
                <el-form-item label="商品图片">
                    <el-image fit="cover" :src="image" style="width: 100px;height: 50px"></el-image>

                </el-form-item>
                <el-form-item label="商品价格">
                    <el-input v-model="price"></el-input>
                </el-form-item>
                <el-form-item label="单位">
                    <el-input v-model="unit"></el-input>
                </el-form-item>
                <el-form-item label="规格">
                    <el-input v-model="specification"></el-input>
                </el-form-item>
                <el-form-item label="生产厂商">
                    <el-input v-model="manufacturer"></el-input>
                </el-form-item>
                <el-form-item label="商品类型">
                    <el-select v-model="comtype"></el-select>
                </el-form-item>
                <el-form-item label="上架时间">
                    <el-date-picker v-model="putawaydate" type="date" placeholder="选择日期"></el-date-picker>
                </el-form-item>

            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="closeMoTaiKuANG">取 消</el-button>
                <el-button type="primary" @click="closeMoTaiKuANG">确 定</el-button>
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
        particulars: string;
        image: string;
        price: number | string;
        unit: string;
        specification: string;
        manufacturer: string;
        comtype: number | string;
        putawaydate: string;
        newestputawaydate: string;
        state: string;
    }
    @Component
    export default class Commodity extends Vue {
       /* 添加模态框的图片的变量 ↓*/
        dialogImageUrl= '';
        dialogVisible= false;

        disabled= false;

        handleRemove(file) {
            console.log(file);

            /*file.abort();
            file.clearFiles()*/
            //图片名字
            /*alert(file.name)*/
        }
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        }

        /* 添加模态框的图片的变量 ↑*/

        //添加模态框的状态
        addmotaikuang =false;
        //修改模态框的状态
        updatemotaikuang = false;
        //搜索框的变量
        input:string="";
        //状态框的变量
        zhuangtai:string="上架";
        //修改 和 添加模态框的变量
        id: string = "";
        name: string = "";
        particulars: string = "";
        image: string = "";
        price: number | string="";
        unit: string = "";
        specification: string = "";
        manufacturer: string = "";
        comtype: number | string="";
        putawaydate: string = "";
        //商品数据
        tableData: commodity[] = [{
            id: 1,
            name: "胖达荣荣",
            particulars: "从小一个人长大",
            image: require('@/assets/touxiang.jpg'),
            price: 20.1,
            unit: "单位",
            specification: "规格",
            manufacturer: "福利院",
            comtype: "孤儿",
            putawaydate: "2020-01-01",
            newestputawaydate: "2020-01-01",
            state: "上架",
        },{
            id: 1,
            name: "胖达荣荣",
            particulars: "从小一个人长大",
            image: require('@/assets/slide-2.jpg'),
            price: 20.1,
            unit: "单位",
            specification: "规格",
            manufacturer: "福利院",
            comtype: "孤儿",
            putawaydate: "2020-01-01",
            newestputawaydate: "2020-01-01",
            state: "上架",
        }]

        created() {
            this.$store.commit('back/url', window.location.href);

            let data = new URLSearchParams();
            data.append("name",this.input);
            data.append("state",this.zhuangtai);
            //查询所有商品资料信息
            Axios({
                method: "post",
                url: "/commodity/MoHuqueryAll",
                data: data
            }).then(value => {
                this.tableData=value.data
            })
        }
        //点击查询按钮 模糊查询商品信息
        MohuqueryCommodity(){
            let data = new URLSearchParams();
            data.append("name",this.input);
            data.append("state",this.zhuangtai);
            //查询所有商品资料信息
            Axios({
                method: "post",
                url: "/commodity/MoHuqueryAll",
                data: data
            }).then(value => {
                this.tableData=value.data
            })
        }
        //添加商品信息方法
        addCommodity(){
            /*获取模态框的值*/
            console.log("1"+this.name)
            console.log("2"+this.particulars)
            console.log("3"+this.image)
            console.log("4"+this.price)
            console.log("5"+this.unit)
            console.log("6"+this.specification)
            console.log("7"+this.manufacturer)
            console.log("8"+this.comtype)
            console.log("9"+this.putawaydate)

            this.closeMoTaiKuANG()
        }
        //获取选中的商品的详情
        queryCommoditydetails(index: number, row: Commodity) {
            //设置模态框变量
            this.id=row.id;
            this.name=row.name;
            this.particulars=row.particulars;
            this.image= require('@/assets/'+row.image);
            this.price=row.price;
            this.unit=row.unit;
            this.specification=row.specification;
            this.manufacturer=row.manufacturer;
            this.comtype=row.comtype;

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


        //点击模态框外 提示信息 限制关闭
        handleClose(done) {
            this.$confirm('请点击取消按钮关闭')
        }
        //关闭模态框的方法 清除模态框的数据
        closeMoTaiKuANG(){
            this.id="";
            this.name="";
            this.particulars="";
            this.image= "";
            this.price="";
            this.unit="";
            this.specification="";
            this.manufacturer="";
            this.comtype="";

            this.updatemotaikuang = false;
            this.addmotaikuang = false;
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