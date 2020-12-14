<template>
    <div class="xsyx-block">
        <el-row>
            <div class="xsyx-flag" style="background-color: #2CAEF8"></div>
            <label style="font-size: 20px;color: #2CAEF8;display: inline">热门分类</label>
            <el-link style="float: right">更多分类 >></el-link>
            <div class="xsyx-line"></div><br>
        </el-row>
        <el-row>
            <div class="type-box">
                <div class="type-item">
                    <div class="type-content">111</div>
                </div>
                <div class="type-item">
                    <div class="type-content">222</div>
                </div>
                <div class="type-item">
                    <div class="type-content">333</div>
                </div>
                <div class="type-item">
                    <div class="type-content">444</div>
                </div>
                <div class="type-item">
                    <div class="type-content">555</div>
                </div>
                <div class="type-item">
                    <div class="type-content">666</div>
                </div>
                <div class="type-item">
                    <div class="type-content">777</div>
                </div>
                <div class="type-item">
                    <div class="type-content">888</div>
                </div>
                <div class="type-item">
                    <div class="type-content">999</div>
                </div>
                <div class="type-item">
                    <div class="type-content">000</div>
                </div>
            </div>
        </el-row>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class HotTypes extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>
    .type-box {

    }
    .type-item {
        float: left;
        width: calc(100% / 10);
        min-width: 100px;
        height: 100px;
        /*background-color: #6c6c6c;*/
        text-align: center;
        padding-top: 10px;
    }
    .type-content {
        cursor: pointer;
        width: 100px;
        height: 100px;
        background-color: #F5F7FA;
        border-radius: 4px;
        margin: 0 auto;
    }
</style>