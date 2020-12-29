<template>
    <el-upload
            class="avatar-uploader"
            action="http://localhost:8080/fileUpload?empId=1"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
            name="file">
        <img v-if="imageUrl" :src="'http://localhost:8080/' + imageUrl" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import {Message} from "@/helper/entity";

    @Component
    export default class FileLoadDemo extends Vue {
        imageUrl: string = null;

        /**
         * 成功上传的回调函数
         */
        handleAvatarSuccess(data: Message) {
            console.log(data)
            if (data.flag) {
                this.imageUrl = data.msg;
                this.$message.success(data.msg);
            } else {
                this.$message.error(data.msg);
            }

        }

        beforeAvatarUpload(file: any) {
            //const isJPG = file.type === 'image';
            const isLt2M = file.size / 1024 / 1024 < 2;

            /*if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
            }*/
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isLt2M;
        }

        created() {

        }

        mounted() {

        }
    }
</script>

<style>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }
    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>