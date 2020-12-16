<template>
    <div>
        <el-upload
                ref="upload"
                class="avatar-uploader"
                action="http://localhost:8080/fileUpload?empId=1"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                name="file">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from "vue-property-decorator";
    import {Message} from "@/helper/entity";

    @Component
    export default class TestYzm extends Vue {
        file: any = null;
        imageUrl: string = null;
        $refs: {
            upload: any;
        };

        handleAvatarSuccess(res:Message, file:any) {
            this.
            this.$slots
            if (res.flag) {
                this.imageUrl = "http://localhost:8080" + res.msg;
                console.log(this.imageUrl);
                this.$message.success("上传成功!");
            } else {
                this.$message.error(res.msg);
            }
        }
        beforeAvatarUpload(file:any) {
            const ispng = file.type === 'image/png';
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!ispng) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
            }
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return ispng && isLt2M;
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