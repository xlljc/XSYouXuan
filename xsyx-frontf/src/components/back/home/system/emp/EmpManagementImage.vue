<!--图片上传组件-->
<template>
    <div>
        <el-upload
                class="avatar-uploader"
                :action="'http://localhost:8080/fileUpload?dir=emp&empId=' + empId"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                name="file">
            <img v-if="imageFile.url" :src="$host + imageFile.url" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Prop} from "vue-property-decorator";
    import {FileInfo, Message} from "@/helper/entity";
    import {EmpHelper} from "@/helper/back/EmpHelper";

    @Component
    export default class CommodityImages extends Vue {
        //图片信息, 从父节点传过来的
        @Prop()
        imageFile: FileInfo;

        //当前员工id, 上传需要获取员工id
        empId = EmpHelper.empId;

        //上传前验证
        beforeAvatarUpload(file: any) {
            const type = file.type === 'image/jpg' || file.type === 'image/png' || file.type === 'image/gif';
            const isLt5M = file.size / 1024 / 1024 < 5;
            if (!type)
                this.$message.error('上传图片只能是 JPG 或 PNG 获取 GIF 格式!');
            if (!isLt5M)
                this.$message.error('上传图片大小不能超过 5MB!');
            return type && isLt5M;
        }

        //上传成功调用
        handleAvatarSuccess(res: Message, files: FileInfo[]) {
            this.imageFile.url = res.msg;
        }

        created() {

        }

        mounted() {

        }
    }
</script>

<style>

</style>