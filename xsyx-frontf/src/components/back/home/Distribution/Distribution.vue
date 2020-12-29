<!--配送管理页面-->
<template>
    <div> <!--strip 双行阴影效果属性-->
        <el-table
                border
                :data="orderAllData"
                style="width: 100%;margin-top: 30px"
                v-loading="loading"
                highlight-current-row
        >
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="商品id：">
                            <span>{{ props.row.id1 }}</span>
                        </el-form-item>
                        <el-form-item label="商品名：">
                            <span>{{ props.row.name }}</span>
                        </el-form-item>
                        <el-form-item label="商品规格：">
                            <span>{{ props.row.specification }}</span>
                        </el-form-item>
                        <el-form-item label="商品数量：">
                            <span>{{ props.row.number }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="订单编号"
                    prop="ordernumber">
            </el-table-column>
            <el-table-column label="订单状态">
                <template slot-scope="props">
                    <span>{{ getState(props.row.ordstate) }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">

                    <el-button
                            type="primary"
                            size="medium"
                            @click="openpeison(scope.$index, scope.row)"
                            v-if="$btnPermissions('配送')">>配送
                    </el-button>

                </template>
            </el-table-column>
        </el-table>

        <!--配送选择仓库模态框-->
        <el-dialog
                :close-on-click-modal="false"
                :show-close="false"
                title="选择仓库"
                :visible.sync="selectwarehousemotaikuang">
            <el-form label-width="80px">
                <el-form-item label="仓库名:">
                    <el-select v-model="warehouseid" @change="warehousechange">
                        <el-option value="0" label="---请选择---"></el-option>
                        <el-option :value="ck.warid" :label="ck.warname" v-for="ck in warehouseAll" :key="ck.warid"
                                   :index="ck.warid"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="需求数量:">
                    <span>{{this.xuqiushopsum}}</span>
                </el-form-item>
                <el-form-item label="商品总量:">
                    <span>{{this.shopsum}}</span>
                </el-form-item>

            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="selectwarehousemotaikuang=false">取 消</el-button>
                <el-button type="primary" @click="peison">确认配送</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";

    @Component
    export default class Distribution extends Vue {
        /*延迟表格加载*/
        loading: boolean = true;
        //所有订单数据
        orderAllData: any[] = [];

        //配送模态框
        peisonmotaikuang = false;

        //选择仓库的模态框状态
        selectwarehousemotaikuang = false;
        //仓库名（id）
        warehouseid: string = "0";
        //所有仓库数据
        warehouseAll: any[] = []
        //订单需求商品数量
        xuqiushopsum : number = 0;
        //商品拥有数
        shopsum : number = 0;
        //获取点击配送的商品的id
        shop :any = {};
        created() {
            this.$store.commit('back/url', window.location.href);
            //查询所有的订单信息
            this.getorderAll();
            //延迟表格加载
            setTimeout(() => {
                this.loading = false;
            }, 1000)
        }

        //查询所有的订单信息
        getorderAll() {
            Axios({
                method: "post",
                url: "/peison/peisonAll",
            }).then(value => {
                //console.log(value.data)
                this.orderAllData = value.data;
            })
        }

        //点击配送按钮  查询所有拥有这个商品的仓库的数据  给下拉框赋值
        openpeison(index: number, row: any) {
            //alert(row.ordstate)
            if (row.ordstate!=="0"){
                this.$message({
                    type: 'error',
                    message: "请选择待发货的订单×"
                });
                return;
            }

            this.selectwarehousemotaikuang = true;
            //给商品 赋值 后面修改仓库商品数量要用
            this.shop=row;
            //订单需求商品数量
            this.xuqiushopsum=row.number;
            //alert(row.id1)
            //给下拉框赋值  查询所有拥有这个商品的仓库的数据
            let params = new URLSearchParams();
            params.append("shopid", row.id1)
            Axios({
                method: "post",
                url: "/peison/warehouseAllByshopid",
                data: params
            }).then(value => {
                this.warehouseAll = value.data;
            })
        }

        //转库下拉框值改变触发事件
        warehousechange() {
            if(this.warehouseid==="0"){
                this.shopsum=0;
            }
            //让商品总量 随着仓库更改而更改  this.shopsum
           //alert(this.warehouseid)
            //商品id
            //alert(this.shopid)
            //根据仓库id 查询这个仓库里的这个商品的数量
            let params = new URLSearchParams();
            params.append("warid",this.warehouseid)
            params.append("shopid",this.shop.id1.toString())
            Axios({
                method: "post",
                url: "/peison/querywarehouseshopsum",
                data: params
            }).then(value => {
                this.shopsum = value.data;
            })
        }
        //点击确认配送
        peison(){
            //拿到仓库id
            //this.warehouseid
            //拿到商品id
            //this.shop.id1.toString()
            //拿到配送数量
            //this.xuqiushopsum
            //商品规格
            //订单id
            //如果仓库id为0 提示选择仓库
            if(this.warehouseid==="0"){
                this.$message({
                    type: 'error',
                    message: "请选择仓库"
                });
                return
            }
            //如果配送数量小于仓库数量 就可以配送
            if (this.xuqiushopsum<=this.shopsum){
                let params = new URLSearchParams();
                params.append("warid",this.warehouseid)
                params.append("shopid",this.shop.id1.toString())
                params.append("xuqiushopsum",this.xuqiushopsum.toString())
                params.append("guige",this.shop.specification.toString())
                params.append("ddid",this.shop.ordernumber.toString())
                Axios({
                    method: "post",
                    url: "/peison/querenpeison",
                    data: params
                }).then(value => {
                    this.$message({
                        type: 'success',
                        message: value.data.msg
                    });
                    //this.shopsum = value.data;
                    //关闭选择配送仓库模态框
                    this.selectwarehousemotaikuang=false
                    //刷新配送管理页面
                    this.getorderAll();
                })
            }else {
                this.$message({
                    type: 'error',
                    message: "仓库商品数量不足×"
                });
            }

        }

        //获取订单状态
        getState(state: string): string {
            if (state === "0") return "待发货";
            if (state === "1") return "待收货";
            if (state === "2") return "已收货";
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
