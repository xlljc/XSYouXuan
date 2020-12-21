<template>
    <div>
        <el-upload
                class="avatar-uploader"
                action="http://localhost:8080/fileUpload?empId=1"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                name="file">
            <img v-if="imageUrl" :src="$host + imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>

        <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :file-list="fileList"
                list-type="picture">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
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
        fileList= [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}]


        handleAvatarSuccess(res:Message, file:any) {
            if (res.flag) {
                this.imageUrl = res.msg;
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
            console.log(this.$host)
        }

        mounted() {

        }
        handleRemove(file: any, fileList: any) {
            console.log(file, fileList);
        }
        handlePreview(file: any) {
            console.log(file);
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