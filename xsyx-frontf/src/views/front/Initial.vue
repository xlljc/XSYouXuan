<template>
    <div>
        <div style="margin-top: 90px; width: 1600px;margin-left: -5px">
            <el-menu :default-active="'1'" :src="require('@/assets/mcimg/16.png')"
                     mode="horizontal"  style="width: 1100px;height: 200px;">
                <el-menu-item>
                    <div class="block"><el-avatar :size="50" :src="require('@/assets/mcimg/16.png')"></el-avatar></div>
                </el-menu-item>
                <el-menu-item>嘤嘤嘤(里面也加入账号)</el-menu-item>

                <el-menu-item class="right" >我的收获地址</el-menu-item>
                <el-menu-item class="right" >我的积分折扣</el-menu-item>
            </el-menu>

            <el-menu :default-active="'1'"
                     mode="horizontal" style="width: 900px">
                <el-menu-item>代付款</el-menu-item>
                <el-menu-item style="cursor: default">|</el-menu-item>
                <el-menu-item>代发货</el-menu-item>
                <el-menu-item style="cursor: default">|</el-menu-item>
                <el-menu-item>待评价</el-menu-item>
                <el-menu-item style="cursor: default">|</el-menu-item>
                <el-menu-item>退款</el-menu-item>
            </el-menu>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Initial extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>