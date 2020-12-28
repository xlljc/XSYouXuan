<template>
    <div style="height: 300px;background-color: #421D32;padding: 35px">
        <el-container>

            <el-col :span="8" class="column">
                <p class="title">附加功能</p>
                <div class="segmentation"></div>

                <p class="item">我们的产品</p>
                <p class="item">我们的队伍</p>
                <p class="item">博客</p>
                <p class="item">加入我们</p>
            </el-col>

            <el-col :span="8" class="column">
                <p class="title">联络人</p>
                <div class="segmentation"></div>
                <div class="text-box">
                    <div>长沙 2020</div>
                    <div>湖南</div>
                    <div>长沙</div>
                </div>
                <p class="tel">+12345678912</p>
                <p class="item">1911159016@qq.com</p>
            </el-col>

            <el-col :span="8" class="column">
                <p class="title">订阅新闻</p>
                <div class="segmentation"></div>

                <input class="input" placeholder="请输入邮箱..."/>

                <button class="button">订阅</button>
            </el-col>

        </el-container>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class HomeFooter extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>
    .column {
        margin-left: 80px;
        color: #ffffff;
    }
    .title {
        font-size: 19px;
        font-weight: bold;
    }
    .segmentation {
        width: 30px;
        height: 6px;
        background-color: #5daf34;
        border-radius: 3px;
    }
    .item {
        cursor: pointer;
        font-size: 16px;
        transition: color linear 0.2s;
    }
    .item:hover {
        color: #8A8D94;
    }
    .tel {
        font-size: 15px;
        color: #8A8D94;
    }
    .text-box {
        margin-top: 5px;
        margin-bottom: 5px;
    }
    .text-box > * {
        color: #8A8D94;
        font-size: 15px;
    }

    .input {
        margin-top: 8px;
        margin-bottom: 5px;
        outline: none;
        background-color: rgba(0,0,0,0);
        border: 1px solid rgba(255,255,255,0.3);
        border-radius: 2em;
        transition: all linear 0.2s;
        height: 35px;
        width: 200px;
        padding-left: 17px;
        color: white;
        font-size: 15px;
    }
    .input:focus {
        border: 1px solid white;
    }

    .button {
        margin-top: 30px;
        outline: none;
        background-color: rgba(0,0,0,0);
        height: 35px;
        width: 200px;
        transition: all linear 0.2s;
        border: 1px solid rgba(255,255,255,0.3);
        background-color: white;
        font-size: 15px;
        color: #421D32;
        border-radius: 2em;
    }

    .button:hover {
        color: #ffffff;
        background-color: rgba(0,0,0,0);
    }

</style>