<template>
    <div class="xsyx-block">
        <el-row>
            <div class="xsyx-flag" style="background-color: #FCAE03"></div>
            <label style="font-size: 20px;color: #FCAE03;display: inline">特价商品</label>
            <el-link style="float: right">更多特价 >></el-link>
            <div class="xsyx-line"></div><br>
        </el-row>

        <el-row>
            <div class="commodity-box">
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
                <div class="commodity-item">
                    <div class="commodity-content">222</div>
                </div>
            </div>
        </el-row>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class SpecialOffer extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>
    .commodity-box {

    }
    .commodity-item {
        border: 1px solid #ffffff00;
        float: left;
        width: calc(100% / 5 - 2px);
        min-width: 200px;
        height: 300px;
        /*background-color: #6c6c6c;*/
        text-align: center;
        padding-top: 10px;
    }
    .commodity-item:hover {
        border-color: #67C23A;
    }
    .commodity-content {
        cursor: pointer;
        width: 200px;
        height: 280px;
        background-color: #F5F7FA;
        border-radius: 4px;
        margin: 0 auto;
    }
</style>