<template>

        <el-form label-width="80px">
            <el-container>
                <el-col :span="12">
                    <el-form-item label="员工姓名: ">
                        <el-input v-model="fromData.name" maxlength="15" clearable placeholder="请输入姓名"></el-input>
                    </el-form-item>
                    <el-form-item label="员工头像: ">
                        <!-- 商品图片-->
                        <emp-management-image :image-file="imageFile"></emp-management-image>
                    </el-form-item>
                    <el-form-item label="员工性别: ">
                        <el-radio v-model="fromData.sex" label="男" value="男" border></el-radio>
                        <el-radio v-model="fromData.sex" label="女" value="女" border></el-radio>
                    </el-form-item>
                    <el-form-item label="手机号: ">
                        <el-input v-model="fromData.phone" maxlength="20" clearable placeholder="请输入手机号"></el-input>
                    </el-form-item>
                </el-col>

                <el-col :span="12">
                    <el-form-item label="身份证: ">
                        <el-input v-model="fromData.icCard" maxlength="20" clearable placeholder="请输入身份证"></el-input>
                    </el-form-item>
                    <el-form-item label="员工住址: ">
                        <el-input v-model="fromData.address" maxlength="30" clearable placeholder="请输入地址"></el-input>
                    </el-form-item>
                    <el-form-item label="员工邮箱: ">
                        <el-autocomplete v-model="fromData.email" :maxlength="30" clearable
                                         :fetch-suggestions="emailFetch"
                                         placeholder="请输入邮箱"
                                         :trigger-on-focus="false"
                                         style="width: 100%"></el-autocomplete>
                    </el-form-item>
                    <el-form-item label="员工备注: ">
                        <el-input v-model="fromData.remark" maxlength="100" type="textarea" placeholder="请输入备注"></el-input>
                    </el-form-item>
                </el-col>
            </el-container>

        </el-form>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {Employee, FileInfo} from "@/helper/entity";
    import EmpManagementImage from "@/components/back/home/system/emp/EmpManagementImage.vue";
    @Component({
        components: {EmpManagementImage}
    })
    export default class EmpManagementEdit extends Vue {

        //商品表单数据, 从父节点传过来的
        @Prop()
        fromData: Employee;

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

        validate(): boolean {
            return false;
        }

    }
</script>

<style>

</style>