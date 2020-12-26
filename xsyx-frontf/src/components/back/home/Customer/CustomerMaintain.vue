<template>
    <div>
        <!-- 模糊查询-->
        <el-input
                style="width: 600px"
                placeholder="请输入关键字"
                v-model="searchStr"
                clearable>
            <div slot="prepend">
                <el-tooltip effect="dark" content="实名认证状态" placement="top-end">
                    <!-- 是否实名认证 -->
                    <el-select v-model="isRealName" placeholder="是否实名认证" style="width: 110px;">
                        <el-option label="全部" :value="null"></el-option>
                        <el-option label="已认证" value="1"></el-option>
                        <el-option label="未认证" value="0"></el-option>
                    </el-select>
                </el-tooltip>
                <el-tooltip effect="dark" content="性别" placement="top-start">
                    <!-- 性别-->
                    <el-select v-model="searchSex" placeholder="性别"  style="width: 90px;margin-left: 20px;border-left: 1px solid #DCDFE6">
                        <el-option label="全部" :value="null"></el-option>
                        <el-option label="男" value="男"></el-option>
                        <el-option label="女" value="女"></el-option>
                    </el-select>
                </el-tooltip>
            </div>
            <template slot="append">
                <el-button
                        v-if="$btnPermissions('客户查询')"
                        slot="append"
                        icon="el-icon-search"
                        @click="query">
                    查询
                </el-button>
            </template>
        </el-input>

        <!--strip 双行阴影效果属性-->
        <el-table
                v-loading="isLoading"
                border
                :data="tableData.list"
                style="width: 100%;margin-top: 30px">
            <el-table-column type="expand">
                <template slot-scope="{row}">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="ID ：">
                            <span>{{ row.id }}</span>
                        </el-form-item>
                        <el-form-item label="用户名 ：">
                            <span>{{ row.username }}</span>
                        </el-form-item>
                        <el-form-item label="头像 ：">
                            <el-image style="height: 100px;width: 135px" :preview-src-list="[$host + row.headPortrait]" :src="$host + row.headPortrait" fit="cover">
                                <el-image slot="error" style="margin-top: -8px" :src="require('@/assets/user/user-default.jpg')" fit="cover"></el-image>
                            </el-image>
                        </el-form-item>
                        <el-form-item label="用户手机号码 ：">
                            <span>{{ row.phone | phone }}</span>
                        </el-form-item>
                        <el-form-item label="个性签名 ：">
                            <span>{{ row.signature }}</span>
                        </el-form-item>
                        <el-form-item label="生日 ：">
                            <span>{{ row.birthday }}</span>
                        </el-form-item>
                        <el-form-item label="真实姓名 ：">
                            <span>{{ row.uname }}</span>
                        </el-form-item>
                        <el-form-item label="性别 ：">
                            <span>{{ row.sex }}</span>
                        </el-form-item>
                        <el-form-item label="身份证 ：">
                            <span>{{ row.idCard | idCard }}</span>
                        </el-form-item>
                        <el-form-item label="最后上线日期 ：">
                            <span>{{ row.lastLoginTime }}</span>
                        </el-form-item>
                        <el-form-item label="实名认证状态 ：">
                            <span>{{ row.idCard === null ? '未认证' : '已认证' }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    sortable
                    width="70px"
                    label="ID"
                    prop="id">
            </el-table-column>
            <el-table-column
                    width="140px"
                    label="用户名"
                    prop="username">
            </el-table-column>
            <el-table-column
                    width="120"
                    label="头像">
                <template slot-scope="{row}">
                    <el-image  style="height: 60px;width: 90px" :src="$host + row.headPortrait" fit="cover"
                               :preview-src-list="[$host + row.headPortrait]">
                        <el-image slot="error" style="margin-top: -8px" :src="require('@/assets/user/user-default.jpg')" fit="cover"></el-image>
                    </el-image>
                </template>
            </el-table-column>
            <el-table-column
                    width="65px"
                    label="性别"
                    prop="sex">
            </el-table-column>
            <el-table-column
                    width="120px"
                    label="手机号">
                <template slot-scope="{row}">
                    {{ row.phone | phone }}
                </template>
            </el-table-column>
            <el-table-column
                    width="100px"
                    label="真实姓名"
                    prop="uname">
            </el-table-column>
            <el-table-column
                    width="190px"
                    label="身份证">
                <template slot-scope="{row}">
                    {{row.idCard | idCard}}
                </template>
            </el-table-column>


            <el-table-column label="操作">
                <template slot-scope="{row}">
                    <!--修改客户-->
                    <el-tooltip effect="dark" content="编辑" placement="top-start"
                                v-if="$btnPermissions('客户修改')">
                        <el-button
                                type="primary"
                                circle
                                icon="el-icon-edit"
                                size="medium"
                                @click="openUpdate(row)"
                        ></el-button>
                    </el-tooltip>
                    <!--删除客户-->
                    <el-popconfirm
                            @confirm="deleteUser(row.id)"
                            confirm-button-text='确定'
                            cancel-button-text='取消'
                            icon="el-icon-info"
                            icon-color="red"
                            title="你确定删除该客户吗？该操作不能取消 !">
                        <el-tooltip slot="reference" effect="dark" content="删除" placement="top-start"
                                    v-if="$btnPermissions('客户删除')">
                            <el-button
                                    style="margin-left: 10px"
                                    type="danger"
                                    circle
                                    icon="el-icon-delete"
                                    size="medium">
                            </el-button>
                        </el-tooltip>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                @size-change="rowChange"
                @current-change="pageChange"
                background
                :page-sizes="[10, 15, 25, 50]"
                :page-size="10"
                layout="total, sizes, prev, pager, next"
                :total="tableData.total">
        </el-pagination>

        <!--模态框-->
        <el-dialog :close-on-click-modal="false"
                   :title="dialog.title"
                   :visible.sync="dialog.visible">

            <customer-maintain-edit ref="editBox"  :form-data="formData" :image-file="imageFile"></customer-maintain-edit>

            <div slot="footer" class="dialog-footer">
                <el-button @click="dialog.visible = false">取 消</el-button>
                <el-button type="primary" @click="dialog.success">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import {DialogTemplateData, FileInfo, PageInfo, User} from "@/helper/entity";
    import {CustomerHelper} from "@/helper/back/CustomerHelper";
    import CustomerMaintainEdit from "@/components/back/home/Customer/CustomerMaintainEdit.vue";

    function getEmptyUser(): User {
        return {
            username: "",
            uname: "",
            headPortrait: "",
            phone: "",
            signature: "",
            sex: "男",
            idCard: ""
        }
    }

    @Component({
        components: {CustomerMaintainEdit},
        filters: {
            phone: (phone: string) => phone && phone.substring(0,3) + '****' + phone.substring(7),
            idCard: (idCard: string) => idCard && idCard.substring(0,6) + '****' + idCard.substring(10)
        }
    })
    export default class CustomerMaintain extends Vue {

        //加载状态
        isLoading = false;
        //查询输入框
        searchStr: string = "";
        //性别
        searchSex: string = null;
        //是否实名认证
        isRealName: number = null;
        //表数据
        tableData: PageInfo<User> = {};
        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        //选中的行
        selectRow: User = {};

        //模态框
        dialog: DialogTemplateData = {
            title: "",
            visible: false,
            success() {},
        }
        //表单数据
        formData: User = {};
        //表单图片
        imageFile: FileInfo = {url: null};

        created() {
            this.$store.commit('back/url', window.location.href);
            this.query();
        }

        mounted() {

        }

        //查询方法
        async query() {
            this.isLoading = true;
            this.tableData = await CustomerHelper.search(this.searchStr,this.searchSex,this.isRealName,this.page,this.row);
            this.isLoading = false;
        }

        //修改
        openUpdate(row: User) {
            this.formData = {...row};
            this.imageFile = {url: this.formData.headPortrait};
            this.dialog.visible = true;
            this.dialog.title = "修改客户";
            this.dialog.success = async () => {
                this.formData.headPortrait = this.imageFile.url;
                console.log(this.formData);
                if (!await (this.$refs.editBox as any).validate()) return;
                let message = await CustomerHelper.update(this.formData);
                if (message.flag) {
                    this.$notify.success({title: "提示",message: "修改成功 !"});
                    this.query();
                } else {
                    this.$notify.error({title: "提示",message: message.msg});
                }
                this.dialog.visible = false;
            }
        }

        //删除
        async deleteUser(userId: number) {
            let message = await CustomerHelper.delete(userId);
            if (message.flag) {
                this.$notify.success({title: "提示",message: "删除成功 !"});
                this.query();
            } else {
                this.$notify.error({title: "提示",message: message.msg});
            }
        }

        //页面大小改变
        rowChange(val: number) {
            this.row = val;
            this.query();
        }
        //页数改变
        pageChange(val: number) {
            this.page = val;
            this.query();
        }

    }
</script>

<style scoped>
    /*table拉开的样式 ↓*/
    .demo-table-expand {
        font-size: 0;
    }

    .demo-table-expand label {
        width: 90px;
        color: #99a9bf;
    }

    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }
</style>