<template>
    <div>
        <el-container>
            <el-header style="position: fixed;width: 100%;z-index: 10;margin-top: -9px;">
                <el-menu :default-active="'1'"
                         mode="horizontal">

                    <el-menu-item><i class="el-icon-house" style="margin-left:90px;" @click="$router.replace('/')"/>首页</el-menu-item>
                    <el-menu-item class="right">
                        <el-image style="width: 55px; height: 50px;" :src="require('@/assets/mcimg/hua.png')"></el-image>
                    </el-menu-item>
                    <el-menu-item class="right" index="8" >关于我们</el-menu-item>
                    <el-menu-item class="right" index="7" >联系客服</el-menu-item>
                    <el-menu-item class="right" index="6">注册</el-menu-item>
                    <el-menu-item class="right" index="5">登录</el-menu-item>
                    <el-menu-item index="3"><i class="el-icon-scissors"></i>每日特价</el-menu-item>
                </el-menu>
            </el-header>

            <el-container>

                <el-row height="" style="margin-top: 50px;">
                    <el-menu :default-active="'1'"  style="margin-top: 30px"
                                 mode="horizontal" >

                        <el-menu-item>
                            <el-image style="width: 100px;margin-left: 100px ;margin-top: -30px" :src="require('@/assets/mcimg/logos.png')"></el-image>
                        </el-menu-item>
                        <el-menu-item>
                            <el-menu-item style="font-size: 25px;margin-left: -50px;margin-top: 5px">购物车</el-menu-item>
                        </el-menu-item>
                        <el-menu-item style="margin-left: 200px;margin-top: -50px">
                        <el-input placeholder="请输入内容"  class="fount">
                            <i slot="prefix" class="el-input__icon el-icon-search"></i>

                            <el-button slot="append">搜索</el-button>
                        </el-input>
                        </el-menu-item>
                        </el-menu>
                </el-row>
            </el-container>
            <el-menu
                    class="el-menu-demo"
                    mode="horizontal"
                    style="margin-left: 110px"
                    active-text-color="#ffd04b">
                <el-menu-item index="1" style="font-size: 20px">全部商品</el-menu-item>
                <el-menu-item index="2" style="font-size: 20px">库存紧张</el-menu-item>

                <div class="zj">
                    已选择商品 总价：
                </div>
                <div style="color: #EA6650;font-size: 20px;margin-left: 1470px;margin-top: -27px">
                    {{zj}}
                    <el-button type="danger" size="small" style="margin-left: 10px" @click="addOrder(da.id,zj)">
                        结算</el-button>
                </div>

            </el-menu>
<div style="margin-left: -150px">
            <el-row >
                <div style="margin-left: 320px;margin-top: 40px" ></div>
                <div style="font-size: 20px;margin-left: 570px;margin-top: -20px">商品信息</div>
                <div style="font-size: 20px;margin-left: 1010px;margin-top: -20px">数量</div>
                <div style="font-size: 20px;margin-left: 1360px;margin-top: -22px">单价</div>
                <div style="font-size: 20px;margin-left: 1555px;margin-top: -27px">操作</div>
            </el-row>

            <el-main>
                <el-col :span="24">
                    <div class="sp" v-for="(da,index) in data" :key="index">
                        <div style="height: 180px">
                            <el-checkbox style="margin-left: 20px;top: -90px" v-model="da.checked" :min="0" @change="zongjia"></el-checkbox>
                                <el-image fit="cover" style="width: 150px;height: 150px; margin-left: 20px;margin-top: 20px" v-if="da.cid.image" :src="'{{$host + da.cid.image}}'" ></el-image>
                                <div style="font-size: 18px;margin-left: 250px;margin-top: -140px;width: 300px;height: 100px;">
                                    <span>{{da.cid.particulars}}</span>
                                </div>

                                <div class="danjia">

                                 </div>
                                <div class="numbers">
                                    <el-input-number v-model="da.number" @change="handleChange" :min="1"></el-input-number>
                                </div>
                            <div class="allmoney">
                                <span>￥{{da.cid.price}}</span>
                            </div>
                            <div class="cz">
                                <el-link type="success">添加至收藏夹</el-link>
                                <br>
                                <el-link type="success" @click="del(da.id)">移除购物车</el-link>
                            </div>
                        </div>
                    </div>
                </el-col>
            </el-main>
</div>
        </el-container>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";
    import {UserHelper} from "@/helper/front/UserHelper";
    import {MenuHelper} from "@/helper/back/MenuHelper";
    import {Shopcar, Shopcar as sc} from '@/helper/entity'
    import {Message} from "element-ui";
    import {SOURCE_FORMAT_TYPED_ARRAY} from "echarts/lib/util/types";

    let hp = new MenuHelper();
    // export type data = {
    //     number: number|string;
    //     jointime:string;
    //     totalprice:string;
    //     name:string;
    //     particulars:string;
    //     image:string;
    // }

    interface MyShopcar extends sc {
        checked: boolean;
    }

    @Component
    export default class Shopcars extends Vue {
        da:Shopcar={};
        state:number =1
        checkAll: false;
        name='';
        number=1;
        price:number=0
        selectId:number[] = [];
        zj=0;
        ordstate=0;
        checked:boolean=false
        data:MyShopcar[] =[];
        ordid:number=0;
        isdelete:number=0;


        handleChange(value: number) {
            this.zongjia()
        }


        getShopcarData(){

            Axios({
                method: 'get',
                url: '/shopcar/queryshopbyuid?uid=' + UserHelper.userId
            }).then(value => {

                let temp = value.data as MyShopcar[];
                for (let i of temp) {
                    i.checked = false;
                }
                this.data=temp;
            })
        }   

        zongjia(){
            this.zj=0;
            for (let i of this.data) {
                if (i.checked) {
                    this.zj += i.number * i.cid.price;
                }
            }
        }



        del(id :number){

            this.$confirm('是否移除购物车?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(()=>{
                let params = new URLSearchParams();
                 // params.append("id",id);

                Axios({
                    method:'post',
                    url: '/shopcar/del?id='+id,
                }) .then((result) => {
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    this.getShopcarData();
                }).catch(function (error) {
                    alert(error)
                })
            })
        }

        //加入订单

        addOrder(){
            this.data.forEach(value => {
                if (value.checked) this.da = value;
            })

            let data = new URLSearchParams();
            //data.append("id",this.cid);
            this.isdelete=this.da.number;
            data.append("sid",this.da.id.toString());
            data.append("totlemoney",this.isdelete.toString());
            data.append("isdelete",this.zj.toString())
            Axios({
                method:'post',
                url:'/ord/addord',
                data:data
            }).then((result) => {
                if (result.data.flag === false) alert(result.data.msg);
                this.ordid=result.data.msg;
                this.updateord()
                this.ycgwc()
                alert("购买成功")
            })
        }

        //移除购物车
        ycgwc(){
            let params = new URLSearchParams();
            params.append("state",this.state.toString());


            Axios({
                method:'post',
                url:'/shopcar/update/'+this.da.id
            }).then((result) => {

                if (result.data.flag === false) alert(result.data.msg);
            })
        }

        //添加到订单
        updateord(){
            let params = new URLSearchParams();
            params.append("ordstate",this.ordstate.toString())
            params.append("isdelete",this.zj.toString());
            Axios({
                method:'post',
                url:'/ord/upd/'+this.ordid,
                params:params
            }).then((result) => {
                if (result.data.flag === false) alert(result.data.msg);
            })

        }

        created(){
            this.getShopcarData();
        }

    }
</script>

<style scoped>
    .right {
        float: right !important;
    }
    .fount{
        margin-left: 1300px;
        width: 300px;
    }
    .zj{
        margin-left: 1300px;
        font-size: 20px;
        margin-top: 40px;
        width:200px;
    }
    .sp{
        width: 1400px;
        border-radius: 4px;
        border: 1px solid #FAF3F4;

        /*box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);*/
        margin-left: 300px;
        /*background-color: #FDF4F2;*/

    }

    .danjia{
        font-size: 18px;
        margin-left: 790px;
        width: 150px;
        height: 50px;
        margin-top: -100px;
    }
    .numbers{
        width: 150px;
        height: 50px;
        margin-top: -10px;
        margin-left: 630px;
    }
    .allmoney{
        font-size: 18px;
        margin-top: -50px;
        margin-left: 1040px;
        width: 150px;
        height: 50px;
    }
    .cz{
        font-size: 18px;
        margin-top: -50px;
        margin-left: 1240px;
        width: 150px;
        height: 50px;
    }
</style>