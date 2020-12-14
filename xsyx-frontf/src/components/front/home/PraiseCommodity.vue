<template>
    <div class="xsyx-block">
        <el-row>
            <div class="xsyx-flag" style="background-color: #FF2951"></div>
            <label style="font-size: 20px;color: #FF2951;display: inline">特别好评</label>
            <el-link style="float: right">更多商品 >></el-link>
            <div class="xsyx-line"></div><br>
        </el-row>

        <el-row>
            <div class="xsys-commodity-box">
                <commodity v-for="item in 10" :key="item"></commodity>
            </div>
        </el-row>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import Commodity from "@/components/front/home/Commodity.vue";
    @Component({
        components: {Commodity}
    })
    export default class PraiseCommodity extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>