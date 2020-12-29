<!--商品添加修改模态框-->
<template>

        <el-form label-width="80px" status-icon :model="fromData" ref="form" :rules="rules">
            <el-form-item label="商品名称" prop="name">
                <el-input v-model="fromData.name"></el-input>
            </el-form-item>
            <el-form-item label="商品描述" prop="particulars">
                <el-input v-model="fromData.particulars"></el-input>
            </el-form-item>
            <el-form-item label="商品图片">
                <!-- 商品图片-->
                <commodity-images :image-file="imageFile"></commodity-images>
            </el-form-item>
            <el-form-item label="商品价格" prop="price">
                <el-input  v-model="fromData.price"></el-input >
            </el-form-item>
            <el-form-item label="单位" prop="unit">
                <el-input v-model="fromData.unit"></el-input>
            </el-form-item>
            <el-form-item label="规格" prop="specification">
                <el-input v-model="fromData.specification"></el-input>
            </el-form-item>
            <el-form-item label="生产厂商" prop="manufacturer">
                <el-input v-model="fromData.manufacturer"></el-input>
            </el-form-item>
            <el-form-item label="商品类型" prop="comType.id">
                <el-select v-model="fromData.comType.id">
                    <el-option :value="type.id" :label="type.name" v-for="type in comtype" :key="type.id" :index="type.id"></el-option>
                </el-select>
            </el-form-item>
            <!--<el-form-item label="上架时间">
                <el-input v-model="fromData.putawayDate" type="date" placeholder="选择日期"></el-input>
            </el-form-item>-->

        </el-form>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {Commodity, FileInfo, Message, ValidateRules} from "@/helper/entity";
    import CommodityImages from "@/components/back/home/Commodity/CommodityImages.vue";
    import Axios from "axios";
    @Component({
        components: {CommodityImages}
    })
    export default class CommodityEdit extends Vue {
        //验证执行
        rules: ValidateRules = {
            name: [{
                message: "商品名不能为空 !",
                required: true,
                trigger: "blur"
            }],
            particulars: [{
                message: "商品描述不能为空 !",
                required: true,
                trigger: "blur"
            }],
            price: [{
                message: "商品价格不能为空 !",
                required: true,
                trigger: "blur"
            }],
            unit: [{
                message: "单位不能为空 !",
                required: true,
                trigger: "blur"
            }],
            specification: [{
                message: "规格不能为空 !",
                required: true,
                trigger: "blur"
            }],
            manufacturer: [{
                message: "生产厂商不能为空 !",
                required: true,
                trigger: "blur"
            }],
            'comType.id': [{
                message: "商品类型不能为空 !",
                required: true,
                trigger: "blur"
            }],
        }

        //商品表单数据, 从父节点传过来的
        @Prop()
        fromData: Commodity;

        @Prop()
        imageFile: FileInfo;


        //商品类型数据
        comtype = {};

        created() {
            //加载所有商品类型信息
            this.getCommodityTypeAll();
        }
        //查询所有商品类型信息
        getCommodityTypeAll(){
            Axios({
                method: "post",
                url: "/commodity/queryAlltype"
            }).then(value => {
                //console.log(value.data)
                this.comtype=value.data;
            })
        }
        mounted() {

        }
        //触发验证
        async validate() {
            return new Promise<boolean>(resolve => {
                (this.$refs.form as any).validate((value: boolean) => {
                    resolve(value);
                })
            });
        }
    }
</script>

<style scoped>

</style>
