<template>
    <div class="xsyx-block">
        <el-row>
            <div class="xsyx-flag" style="background-color: #2CAEF8"></div>
            <label style="font-size: 20px;color: #2CAEF8;display: inline">热门分类</label>
            <el-link style="float: right">更多分类 >></el-link>
            <div class="xsyx-line"></div><br>
        </el-row>
        <el-row>
            <div class="xsyx-type-box">
                <commodity-type v-for="item in 10" :key="item"></commodity-type>
            </div>
        </el-row>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import CommodityType from "@/components/front/home/CommodityType.vue";
    @Component({
        components: {CommodityType}
    })
    export default class HotTypes extends Vue {

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>