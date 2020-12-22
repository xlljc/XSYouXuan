<template>
    <el-form label-width="110px" status-icon :model="formData" ref="form" :rules="rules">
        <el-container>
            <el-col :span="12">
                <el-form-item label="员工姓名: " prop="name">
                    <el-input v-model="formData.name" maxlength="15" clearable placeholder="请输入姓名"></el-input>
                </el-form-item>
                <el-form-item label="员工头像: ">
                    <!-- 商品图片-->
                    <emp-management-image :image-file="imageFile"></emp-management-image>
                </el-form-item>
                <el-form-item label="员工性别: ">
                    <el-radio v-model="formData.sex" label="男" value="男" border></el-radio>
                    <el-radio v-model="formData.sex" label="女" value="女" border></el-radio>
                </el-form-item>
                <el-form-item label="手机号: " prop="phone">
                    <el-input v-model="formData.phone" maxlength="20" clearable placeholder="请输入手机号"></el-input>
                </el-form-item>
            </el-col>

            <el-col :span="12">
                <el-form-item label="身份证: " prop="icCard">
                    <el-input v-model="formData.icCard" maxlength="20" clearable placeholder="请输入身份证"></el-input>
                </el-form-item>
                <el-form-item label="员工住址: " prop="address">
                    <el-input v-model="formData.address" maxlength="30" clearable placeholder="请输入地址"></el-input>
                </el-form-item>
                <el-form-item label="员工邮箱: " prop="email">
                    <el-autocomplete v-model="formData.email" :maxlength="30" clearable
                                     :fetch-suggestions="emailFetch"
                                     placeholder="请输入邮箱"
                                     :trigger-on-focus="false"
                                     style="width: 100%"></el-autocomplete>
                </el-form-item>
                <el-form-item label="员工备注: ">
                    <el-input v-model="formData.remark" maxlength="100" type="textarea" placeholder="请输入备注"></el-input>
                </el-form-item>
            </el-col>
        </el-container>

    </el-form>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {Employee, FileInfo, ValidateRules} from "@/helper/entity";
    import EmpManagementImage from "@/components/back/home/system/emp/EmpManagementImage.vue";
    @Component({
        components: {EmpManagementImage}
    })
    export default class EmpManagementEdit extends Vue {

        //验证执行
        rules: ValidateRules = {
            name: [{
                pattern: /^[\u4e00-\u9fa5]{2,4}$/,
                message: "请输入2-4位长度的汉字 !",
                required: true,
                trigger: "blur"
            }],
            phone: [{
                pattern: /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/,
                message: "请输正确的手机号 !",
                required: true,
                trigger: "blur"
            }],
            icCard: [{
                pattern: /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/,
                message: "请输正确身份证号码 !",
                required: true,
                trigger: "blur"
            }],
            address: [{
                message: "地址不能为空 !",
                required: true,
                trigger: "blur"
            }],
            email: [{
                type: "email",
                message: "请输入正确的邮箱 !",
                required: true,
                trigger: "blur"
            }]
        }

        //商品表单数据, 从父节点传过来的
        @Prop()
        formData: Employee;

        @Prop()
        imageFile: FileInfo;

        created() {

        }

        //邮箱提示
        emailFetch(str: string, cb: (data: {}[]) => void) {
            //不符合邮箱
            if (!/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/.test(str)) {
                let list = [
                    {value: str + "@qq.com"},
                    {value: str + "@163.com"},
                    {value: str + "@sina.com"},
                    {value: str + "@sohu.com"},
                    {value: str + "@126.com"},
                    {value: str + "@21cn.com"},
                    {value: str + "@263.net"},
                    {value: str + "@yahoo.com"},
                    {value: str + "@yahoo.com.cn"},
                ];
                cb(list);
            } else {
                cb([]);
            }
        }

        //触发验证
        async validate() {
            return new Promise<boolean>(resolve => (this.$refs.form as any).validate((value: boolean) => resolve(value)));
        }

    }
</script>

<style>

</style>