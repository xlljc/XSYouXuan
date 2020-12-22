<!-- 员工管理 -->
<template>
    <div>
        <!-- 模糊查询-->
        <el-input
            style="width: 600px"
            placeholder="请输入用户名或手机号"
            v-model="searchStr"
            clearable>
            <div slot="prepend">
                <el-tooltip effect="dark" content="冻结状态" placement="top-end">
                    <!-- 冻结状态-->
                    <el-select v-model="searchSate" placeholder="状态" style="width: 90px;">
                        <el-option label="全部" :value="null"></el-option>
                        <el-option label="激活" value="1"></el-option>
                        <el-option label="冻结" value="0"></el-option>
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
                    slot="append"
                    icon="el-icon-search"
                    @click="query">
                    查询
                </el-button>
            </template>
        </el-input>

        <el-button
                plain
                type="success"
                slot="append"
                icon="el-icon-circle-plus"
                style="margin-left: 15px"
                @click="openAdd"
        >添加
        </el-button>

        <!--strip 双行阴影效果属性-->
        <el-table
                border
                :data="tableData.list"
                style="width: 100%;margin-top: 30px">
            <el-table-column type="expand">
                <template slot-scope="{row}">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="用ID ：">
                            <span>{{ row.id }}</span>
                        </el-form-item>
                        <el-form-item label="用户名 ：">
                            <span>{{ row.name }}</span>
                        </el-form-item>
                        <el-form-item label="头像 ：">
                            <el-image style="height: 100px;width: 135px" :preview-src-list="[$host + row.image]" :src="$host + row.image" fit="cover"></el-image>
                        </el-form-item>
                        <el-form-item label="性别 ：">
                            <span>{{ row.sex }}</span>
                        </el-form-item>
                        <el-form-item label="手机号 ：">
                            <span>{{ row.phone }}</span>
                        </el-form-item>
                        <el-form-item label="身份证号码 ：">
                            <span>{{ row.idCard }}</span>
                        </el-form-item>
                        <el-form-item label="员工住址 ：">
                            <span>{{ row.address }}</span>
                        </el-form-item>
                        <el-form-item label="邮箱 ：">
                            <span>{{ row.email }}</span>
                        </el-form-item>
                        <el-form-item label="备注 ：">
                            <span>{{ row.remark }}</span>
                        </el-form-item>
                        <el-form-item label="最后上线日期 ：">
                            <span>{{ row.lastLoginTime }}</span>
                        </el-form-item>
                        <el-form-item label="状态 ：">
                            <span>{{ getState(row.state) }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    width="50px"
                    label="ID"
                    prop="id">
            </el-table-column>
            <el-table-column
                    width="140px"
                    label="姓名"
                    prop="name">
            </el-table-column>
            <el-table-column
                    width="65px"
                    label="性别"
                    prop="sex">
            </el-table-column>
            <el-table-column
                    label="头像"
                    prop="sex">
                <template slot-scope="{row}">
                     <el-image  style="height: 60px;width: 90px" :src="$host + row.image" fit="cover"></el-image>
                </template>
            </el-table-column>
            <el-table-column
                    width="140px"
                    label="手机号"
                    prop="phone">
            </el-table-column>
            <el-table-column
                    label="邮箱"
                    prop="email">
            </el-table-column>


            <el-table-column label="操作">
                <template slot-scope="{row}">
                    <el-tooltip effect="dark" content="编辑" placement="top-start">
                        <el-button
                                type="primary"
                                circle
                                icon="el-icon-edit"
                                size="medium"
                                @click="openUpdate(row)"
                        ></el-button>
                    </el-tooltip>
                    <el-tooltip effect="dark" content="冻结" placement="top-start">
                        <!-- el-icon-video-play -->
                        <el-button
                                type="warning"
                                circle
                                icon="el-icon-video-pause"
                                size="medium"
                                @click="openFreezeValidation(row.id)"
                        ></el-button>

                    </el-tooltip>
                    <el-tooltip effect="dark" content="删除" placement="top-start">
                        <el-button
                                type="danger"
                                circle
                                icon="el-icon-delete"
                                size="medium"

                        ></el-button>
                    </el-tooltip>

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

        <!-- 添加功能模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="员工添加"
                   :visible.sync="addmotaikuang">
            <!-- 商品编辑组件, 传入data值, 传入图片列表 -->
            <emp-management-edit :from-data="fromData" :image-file="imageFile"></emp-management-edit>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addmotaikuang = false">取 消</el-button>
                <!--点击调用添加方法-->
                <el-button type="primary" @click="submitAddEmp">确 定</el-button>
            </div>
        </el-dialog>

        <!-- 修改功能模态框-->
        <el-dialog :close-on-click-modal="false"
                   title="员工修改"
                   :visible.sync="updatemotaikuang">
            <!-- 商品编辑组件, 传入data值, 传入图片列表 -->
            <emp-management-edit :from-data="fromData" :image-file="imageFile"></emp-management-edit>
            <div slot="footer" class="dialog-footer">
                <el-button @click="updatemotaikuang = false">取 消</el-button>
                <!--点击调用修改方法-->
                <el-button type="primary" @click="submitUpdateEmp">确 定</el-button>
            </div>
        </el-dialog>

        <!-- 冻结员工 -->
        <el-dialog :close-on-click-modal="false"
                   title="身份验证"
                   :visible.sync="freezeyanzheng">
            <div>
                <p>你正在操作敏感数据, 请输入你的登录密码以确保是你本人操作 !</p>
                <el-input v-model="freezeYzPassword" type="password" clearable show-password></el-input>
            </div>

            <div slot="footer" class="dialog-footer">
                <el-button @click="freezeyanzheng = false">取 消</el-button>
                <!--点击调用修改方法-->
                <el-button type="primary" @click="freezeEmp()">确 定</el-button>
            </div>
        </el-dialog>

        <!-- 删除员工 -->
        <el-dialog :close-on-click-modal="false"
                   title="身份验证"
                   :visible.sync="freezeyanzheng">
            <div>
                <p>你正在操作敏感数据, 请输入你的登录密码以确保是你本人操作 !</p>
                <el-input v-model="freezeYzPassword" type="password" clearable show-password></el-input>
            </div>

            <div slot="footer" class="dialog-footer">
                <el-button @click="freezeyanzheng = false">取 消</el-button>
                <!--点击调用修改方法-->
                <el-button type="primary" @click="deleteEmp()">确 定</el-button>
            </div>
        </el-dialog>

    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";
    import {Employee, FileInfo, PageInfo} from "@/helper/entity";
    import TestYzm from "@/components/shop/TestYzm.vue";
    import {EmpHelper} from "@/helper/back/EmpHelper";
    import EmpManagementEdit from "@/components/back/home/system/emp/EmpManagementEdit.vue";

    function getEmptyEmp(): Employee {
        return {sex: "男"}
    }

    @Component({
        components: {EmpManagementEdit, TestYzm}
    })
    export default class EmpManagement extends Vue {
        //查询输入框
        searchStr: string = "";
        //性别
        searchSex: string = null;
        //状态
        searchSate: string = "1";
        //表数据
        tableData: PageInfo<Employee> = {};
        //当前页数
        page: number = 1;
        //每页条数
        row: number = 10;

        //添加员工表单模态框是否打开
        addmotaikuang: boolean = false;
        //修改员工表单模态框是否打开
        updatemotaikuang: boolean = false;
        //表单数据
        fromData: Employee = getEmptyEmp();
        //表单图片
        imageFile: FileInfo = {url: null};

        //冻结验证模态框
        freezeyanzheng: boolean = false;
        //冻结的员工Id
        selectEmpId: number = 0;
        //冻结验证密码
        freezeYzPassword: string = "";

        //删除员工验证模态框
        deleteyanzheng: boolean = true;
        //删除验证密码
        deleteYzPassword: string = "";

        created() {
            this.$store.commit('back/url', window.location.href);
            this.query();
        }

        //获取状态
        getState(state: number): string {
            if (state === -1) return "已删除";
            if (state === 0) return "已冻结";
            if (state === 1) return "已激活";
        }

        //***********************************************************
        //                          查询员工
        //***********************************************************

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
        /**
         * 查询员工
         */
        query() {
            EmpHelper.query(this.searchStr,this.searchSex,this.searchSate,this.page,this.row).then(value => {
                this.tableData = value;
                console.log(value);
            })
        }

        //***********************************************************
        //                          添加员工
        //***********************************************************

        /**
         * 打开添加员工窗口
         */
        openAdd() {
            this.fromData = getEmptyEmp();
            this.imageFile = {url: null};
            this.addmotaikuang = true;
        }

        //提交添加
        submitAddEmp() {
            let empInfo = {...this.fromData};
            empInfo.image = this.imageFile.url;
            EmpHelper.addEmp(empInfo).then(value => {
                if (value.flag) {
                    this.$notify.success({
                        title: "提示",
                        message: "添加成功!",
                    });
                    this.query();
                    this.addmotaikuang = false;
                } else {
                    this.$notify.error({
                        title: "提示",
                        message: value.msg,
                    });
                }
            });
        }

        //***********************************************************
        //                          修改员工
        //***********************************************************
        //打开修改方法
        openUpdate(data: Employee) {
            this.fromData = {...data};
            this.imageFile = {url: this.fromData.image};
            this.updatemotaikuang = true;
        }
        //提交修改
        submitUpdateEmp() {
            let empInfo = {...this.fromData};
            empInfo.image = this.imageFile.url;
            EmpHelper.updateEmp(empInfo).then(value => {
                if (value.flag) {
                    this.$notify.success({
                        title: "提示",
                        message: "修改成功!",
                    });
                    this.query();
                    this.updatemotaikuang = false;
                } else {
                    this.$notify.error({
                        title: "提示",
                        message: value.msg,
                    });
                }
            });
        }

        //***********************************************************
        //                          冻结员工
        //***********************************************************
        //打开验证
        openFreezeValidation(empId: number) {
            this.selectEmpId = empId;
            this.freezeyanzheng = true;
        }
        //冻结员工
        freezeEmp() {
            //先验证操作
            EmpHelper.validation(this.freezeYzPassword).then(value => {
                if (value.flag) {
                    this.$notify.success({
                        title: "提示",
                        message: value.msg,
                    });
                    //再冻结
                    EmpHelper.freezeEmp(this.selectEmpId).then(value => {
                        if (value.flag) {
                            this.$notify.success({
                                title: "提示",
                                message: "冻结成功",
                            });
                            this.query();
                        } else {
                            this.$notify.error({
                                title: "提示",
                                message: value.msg,
                            });
                        }
                    });
                } else {
                    this.$notify.error({
                        title: "提示",
                        message: value.msg,
                    });
                }
                this.freezeYzPassword = "";
                this.freezeyanzheng = false;
            })
        }

        //***********************************************************
        //                          删除员工
        //***********************************************************
        //打开验证
        openDeleteValidation(empId: number) {
            this.selectEmpId = empId;
            this.freezeyanzheng = true;
        }
        //删除员工
        deleteEmp() {
            //先验证操作
            EmpHelper.validation(this.deleteYzPassword).then(value => {
                if (value.flag) {
                    this.$notify.success({
                        title: "提示",
                        message: value.msg,
                    });
                    //再冻结
                    EmpHelper.deleteEmp(this.selectEmpId).then(value => {
                        if (value.flag) {
                            this.$notify.success({
                                title: "提示",
                                message: "删除成功",
                            });
                            this.query();
                        } else {
                            this.$notify.error({
                                title: "提示",
                                message: value.msg,
                            });
                        }
                    });
                } else {
                    this.$notify.error({
                        title: "提示",
                        message: value.msg,
                    });
                }
                this.deleteYzPassword = "";
                this.deleteyanzheng = false;
            })
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