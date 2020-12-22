<template>

        <el-form label-width="80px">
            <el-form-item label="商品名称">
                <el-input v-model="fromData.name"></el-input>
            </el-form-item>
            <el-form-item label="商品描述">
                <el-input v-model="fromData.particulars"></el-input>
            </el-form-item>
            <el-form-item label="商品图片">
                <!-- 商品图片-->
                <commodity-images :image-file="imageFile"></commodity-images>
            </el-form-item>
            <el-form-item label="商品价格">
                <el-input v-model="fromData.price"></el-input>
            </el-form-item>
            <el-form-item label="单位">
                <el-input v-model="fromData.unit"></el-input>
            </el-form-item>
            <el-form-item label="规格">
                <el-input v-model="fromData.specification"></el-input>
            </el-form-item>
            <el-form-item label="生产厂商">
                <el-input v-model="fromData.manufacturer"></el-input>
            </el-form-item>
            <el-form-item label="商品类型">
                <el-select v-model="fromData.comType.id">
                    <el-option value="1">1</el-option>
                    <el-option value="2">2</el-option>
                    <el-option value="3">3</el-option>
                </el-select>
            </el-form-item>
            <!--<el-form-item label="上架时间">
                <el-input v-model="fromData.putawayDate" type="date" placeholder="选择日期"></el-input>
            </el-form-item>-->

        </el-form>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {Commodity, FileInfo, Message} from "@/helper/entity";
    import CommodityImages from "@/components/back/home/Commodity/CommodityImages.vue";
    @Component({
        components: {CommodityImages}
    })
    export default class CommodityEdit extends Vue {
        //商品表单数据, 从父节点传过来的
        @Prop()
        fromData: Commodity;

        @Prop()
        imageFile: FileInfo;

        created() {

        }

        mounted() {

        }
    }
</script>

<style scoped>

</style>
