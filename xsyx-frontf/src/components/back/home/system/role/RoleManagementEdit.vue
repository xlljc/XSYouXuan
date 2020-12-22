<template>
    <el-form label-width="90px" status-icon :model="formData" ref="form" :rules="rules">
        <el-form-item label="角色名称: " prop="name">
            <el-input v-model="formData.name" maxlength="15" clearable placeholder="请输入角色名称"></el-input>
        </el-form-item>
        <el-form-item label="角色备注: " prop="remark">
            <el-input v-model="formData.remark" type="textarea" maxlength="100" placeholder="请输入角色备注"></el-input>
        </el-form-item>
    </el-form>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {Role, ValidateRules} from "@/helper/entity";

    @Component
    export default class RoleManagementEdit extends Vue {

        @Prop()
        formData: Role;

        rules: ValidateRules = {
            name: [{
                required: true,
                message: "角色名不能为空 !"
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