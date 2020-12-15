<template>
    <div class="xsyx-commodity-item">
        <div class="xsyx-commodity-content">
            <el-badge :value="'NEW'" type="success" class="badge"/>
            <div class="image-box">
                <el-image :src="image" fit="cover" class="image"></el-image>
            </div>
            <el-row style="height: 52px">
                <div class="title">西红柿</div>
            </el-row>
            <el-row>
                <div class="type">素菜</div>
            </el-row>
            <el-row>
                <el-button class="add-to-car" type="success" round plain>加入购物车</el-button>
                <div class="price">
                    <span class="discount">￥2.0</span>
                    <span class="discount-price"> ￥1.5</span>
                    <span> / 斤</span>
                </div>
            </el-row>
        </div>
    </div>

</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Commodity extends Vue {

        image = require('@/assets/xhs.jpg');

        created() {

        }

        mounted() {

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