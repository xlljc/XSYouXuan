<template>
    <div>
        <el-container>

            <el-row height="" style="margin-top: 50px;">
                <el-menu :default-active="'1'"
                         mode="horizontal" >
                    <el-menu-item>
                        <el-image style="width: 100px;margin-top: -30px" :src="require('@/assets/mcimg/logos.png')"></el-image>
                    </el-menu-item>
                    <el-menu-item>
                        <el-menu-item style="font-size: 30px;margin-left: -50px">收藏夹</el-menu-item>
                    </el-menu-item>
                    <el-menu-item style="margin-left: 500px;">
                        <el-input placeholder="请输入内容"  class="fount">
                            <i slot="prefix" class="el-input__icon el-icon-search"></i>
                            <el-button slot="append">搜索</el-button>
                        </el-input>
                    </el-menu-item>
                </el-menu>
            </el-row>
        </el-container>
        <div class="xsyx-commodity-item">
            <div class="xsyx-commodity-content">
                <el-badge :value="'NEW'" type="success" class="badge"/>
                <div class="image-box">
                    <el-image :src="image" fit="cover" class="image"></el-image>
                </div>
                <el-row style="height: 52px">
                    <div class="title">{{sp.cid.name}}</div>
                </el-row>
                <el-row>
                    <div class="type">素菜</div>
                </el-row>
                <el-row>
                    <el-button class="add-to-car" type="success" round plain>加入购物车</el-button>
                    <div class="price">
                        <span class="discount"></span>
                        <span class="discount-price"> ￥{{sp.cid.price}}</span>
                        <span> / 斤</span>
                    </div>
                </el-row>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Axios from "axios";
    import {Collect, Commodity} from "@/helper/entity";
    @Component
    export default class Mylove extends Vue {
        image = require('@/assets/xhs.jpg');

        sp : Collect = {};

        querySc(){
            Axios({
                method:'get',
                url:'/collect/query'
            }).then(value => {
                this.sp = value.data[0];
                console.log(this.sp);
            })
        }
        created() {
            this.querySc()
        }

    }
</script>

<style scoped>
    .badge {
        position: absolute;
        z-index: 1;
        margin-left: 60px;
    }
    .image-box {
        width: 200px;
        height: 180px;
        overflow: hidden;
    }
    .image {
        cursor: pointer;
        height: 180px;
        transition: all 0.2s linear;
    }
    .image:hover {
        transform: scale(1.2,1.2);
    }
    .title {
        cursor: pointer;
        line-height: 24px;
        font-size: 19px;
        margin-bottom: 5px;
        font-weight: bold;
        color: #342828;
        transition: color 0.2s linear;
    }
    .title:hover {
        color: #ADAAAA;
    }
    .type {
        cursor: pointer;
        color: #4F4F4F;
        margin: 5px 0;
        transition: color 0.2s linear;
    }
    .type:hover {
        color: #ADAAAD;
    }
    .price {
        line-height: 36px;
        font-size: 16px;
    }
    .discount {
        font-size: 13px;
        color: #8A8D94;
        text-decoration:line-through;
    }
    .discount-price {
        font-weight: bold;
    }
    .add-to-car {
        position: absolute;
        transform: translate(-50%,0);
        opacity: 0;
        transition: all 0.3s linear;
    }
    .xsyx-commodity-item:hover .add-to-car {
        opacity: 1;
    }
</style>