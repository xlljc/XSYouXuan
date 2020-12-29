<template>
    <el-form label-width="90px" status-icon :model="formData" ref="form" :rules="rules">
        <el-form-item label="商户名称: " prop="name">
            <el-input v-model="formData.name" maxlength="15" clearable placeholder="请输入商户名称"></el-input>
        </el-form-item>
        <el-form-item label="商户地址: " prop="address">
            <el-input v-model="formData.address" maxlength="50" clearable placeholder="请输入商户地址"></el-input>
        </el-form-item>
        <el-form-item label="商户电话: " prop="phone">
            <el-input v-model="formData.phone" maxlength="15" clearable placeholder="请输入商户电话"></el-input>
        </el-form-item>
        <el-form-item label="商户备注: " prop="remark">
            <el-input v-model="formData.remark" type="textarea" maxlength="100" placeholder="请输入商户备注"></el-input>
        </el-form-item>
    </el-form>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {Merchants, ValidateRules} from "@/helper/entity";

    @Component
    export default class MerchantsMaintainEdit extends Vue {

        @Prop()
        formData: Merchants;

        rules: ValidateRules = {
            name: [{
                required: true,
                validator: (rule, value, callback) => {
                    if (value.length <= 15 && value.length >= 2) callback();
                    else callback(new Error("商户名称长度为2-15位 !"));
                },
                trigger: "blur"
            }],
            address: [{
                required: true,
                message: "地址不能为空 !",
                trigger: "blur"
            }],
            phone: [{
                required: true,
                pattern: /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/,
                message: "请输正确的手机号 !",
                trigger: "blur"
            }]
        }

        created() {

        }

        mounted() {

        }

        //触发验证
        async validate() {
            return new Promise<boolean>(resolve => (this.$refs.form as any).validate((value: boolean) => resolve(value)));
        }
    }
</script>

<style scoped>

</style>