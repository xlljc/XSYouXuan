<template>
    <el-form label-width="110px" status-icon :model="formData" ref="form" :rules="rules">
        <el-container>
            <el-col :span="12">
                <el-form-item label="昵称: " prop="username">
                    <el-input v-model="formData.username" maxlength="20" clearable placeholder="请输入昵称"></el-input>
                </el-form-item>
                <el-form-item label="头像: ">
                    <!-- 头像 -->
                    <customer-maintain-image :image-file="imageFile"></customer-maintain-image>
                </el-form-item>
                <el-form-item label="真实姓名: " prop="uname">
                    <el-input v-model="formData.uname" maxlength="4" clearable placeholder="真实姓名"></el-input>
                </el-form-item>
                <el-form-item label="身份证: " prop="idCard">
                    <el-input v-model="formData.idCard" maxlength="20" clearable placeholder="请输入身份证"></el-input>
                </el-form-item>
            </el-col>

            <el-col :span="12">
                <el-form-item label="性别: ">
                    <el-radio v-model="formData.sex" label="男" value="男" border></el-radio>
                    <el-radio v-model="formData.sex" label="女" value="女" border></el-radio>
                </el-form-item>
                <el-form-item label="手机号: " prop="phone">
                    <el-input v-model="formData.phone" maxlength="20" clearable placeholder="请输入手机号"></el-input>
                </el-form-item>
                <el-form-item label="个性签名: " prop="signature">
                    <el-input v-model="formData.signature" maxlength="30" clearable placeholder="个性签名"></el-input>
                </el-form-item>

            </el-col>

        </el-container>

    </el-form>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {FileInfo, User, ValidateRules} from "@/helper/entity";
    import CustomerMaintainImage from "@/components/back/home/Customer/CustomerMaintainImage.vue";
    @Component({
        components: {CustomerMaintainImage}
    })
    export default class CustomerMaintainEdit extends Vue {


        //验证执行
        rules: ValidateRules = {
            username: [{
                validator: (rule, value, callback) => {
                    if (value.length < 2) callback(new Error("昵称长度至少为2 !"));
                    else callback();
                },
                required: true,
                trigger: "blur"
            }],
            uname: [{
                pattern: /^\s{0}$|^[\u4e00-\u9fa5]{2,4}$/,
                message: "请输入2-4位长度的汉字 !",
                trigger: "blur"
            }],
            idCard: [{
                pattern: /^\s{0}$|^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/,
                message: "请输正确身份证号码 !",
                trigger: "blur"
            }],
            phone: [{
                pattern: /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/,
                message: "请输正确的手机号 !",
                required: true,
                trigger: "blur"
            }],
        }

        //商品表单数据, 从父节点传过来的
        @Prop()
        formData: User;

        @Prop()
        imageFile: FileInfo;

        created() {

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