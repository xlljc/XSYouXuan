<template>
    <div>
        <el-container>
            <el-menu :default-active="'1'"
                     mode="horizontal" style="width: 1500px">
                <el-menu-item>代付款</el-menu-item>
                <el-menu-item style="cursor: default">|</el-menu-item>
                <el-menu-item>代发货</el-menu-item>
                <el-menu-item style="cursor: default">|</el-menu-item>
                <el-menu-item>待评价</el-menu-item>
                <el-menu-item style="cursor: default">|</el-menu-item>
                <el-menu-item>退款</el-menu-item>
            </el-menu>
        </el-container>

            <el-row>
                <div style="font-size: 20px;margin-left: 0px;margin-top: 20px;margin-left: 150px">宝贝</div>
                <div style="font-size: 20px;margin-left: 300px;margin-top: -20px;margin-left: 360px">单价</div>
                <div style="font-size: 20px;margin-left: 450px;margin-top: -23px;margin-left: 550px">数量</div>
                <div style="font-size: 20px;margin-left: 600px;margin-top: -24px;margin-left: 750px">实际付款</div>
                <div style="font-size: 20px;margin-left: 750px;margin-top: -24px;margin-left: 950px">操作</div>
            </el-row>


        <el-main>
            <el-col>
                <div class="sp" v-for="(da,index) in data" :key="index">
                    <div style="height: 150px" >
                        <el-checkbox style="margin-left: 20px;top: -100px" v-model="da.checked"></el-checkbox>
                        <el-image fit="cover" style="width: 120px;height: 120px;margin-top: 30px" :src="require('@/assets/mcimg/logos.png')"></el-image>
                        <div class="guige">
                            <span>订单号：{{da.orderNumber}}</span><br><br>
                            <span>商品名字：{{da.sid.cid.name}}</span>
                        </div>

                        <div class="danjia">
                            ￥{{da.sid.cid.price}}
                        </div>
                        <div class="numbers">
                            {{da.sid.number}}
                        </div>
                        <div class="allmoney">
                            {{da.totlemoney}}
                        </div>
                        <div class="cz">
                            <el-link type="success" @click="addlove(da.sid.cid.id)">添加至收藏夹</el-link>
                            <br><br>
                            <el-link type="success" >再次购买</el-link>
                        </div>
                    </div>
                </div>
            </el-col>
        </el-main>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    import Axios from "axios";

    import {Collect, ComOrder, ComOrder as scs} from '@/helper/entity'


    interface MyShopcar extends scs {
        checked: boolean;
    }

    @Component
    export default class Dingdan extends Vue {
        da:ComOrder={}
        da1:Collect={}
        data:MyShopcar[] =[];

        getcomorderData(){
            Axios({
                method: 'get',
                url: '/ord/query'
            }).then(value => {

                let temp = value.data as MyShopcar[];
                for (let i of temp) {
                    i.checked = false;
                }
                this.data=temp;
            })
        }

        //加入收藏夹
        addlove(id: number){

            let data = new URLSearchParams();
            data.append("cid",id.toString());

            Axios({
                method:'post',
                url:'/collect/add',
                data:data

            }).then(value => {

                this.da1 = value.data;
                alert("添加成功")

            })
        }




        created() {
            this.getcomorderData();
        }

        mounted() {

        }
    }
</script>

<style scoped>

    .sp{
        width: 1090px;
        border-radius: 4px;
        border: 1px solid #CCCCCC;

        /*box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);*/
        margin-left: -20px;
        background-color: #FCFCFC;
    }
    .guige{
        font-size: 15px;
        margin-left: 160px;

        width: 150px;
        height: 100px;
        margin-top: -100px;

    }
    .danjia{
        font-size: 18px;
        margin-left: 360px;
        width: 150px;
        height: 50px;
        margin-top: -80px;
    }
    .numbers{
        font-size: 18px;
        width: 150px;
        height: 50px;
        margin-top: -48px;
        margin-left: 560px;
    }
    .allmoney{
        font-size: 18px;
        margin-top: -50px;
        margin-left: 780px;
        width: 150px;
        height: 50px;
    }
    .cz{
        font-size: 18px;
        margin-top: -65px;
        margin-left: 940px;
        width: 150px;
        height: 50px;
    }
</style>