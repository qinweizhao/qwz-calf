<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--部门数据-->
      <el-col :span="3" :xs="24">
        <div class="head-container">
          <el-input
            v-model="name"
            placeholder="请输入部门名称"
            clearable
            size="small"
            prefix-icon="el-icon-search"
            style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container">
          <el-tree
            :data="deptOptions"
            :props="defaultProps"
            :expand-on-click-node="false"
            :filter-node-method="filterNode"
            ref="tree"
            default-expand-all
            @node-click="handleNodeClick"
          />
        </div>
      </el-col>
      <!--用户数据-->
      <el-col :span="21" :xs="24">
        <el-form
          :model="queryParams"
          ref="queryForm"
          :inline="true"
          v-show="showSearch"
          label-width="68px"
        >
          <el-form-item label="用户名称" prop="username">
            <el-input
              v-model="queryParams.username"
              placeholder="请输入用户名称"
              clearable
              size="small"
              style="width: 260px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="创建时间">
            <el-date-picker
              v-model="dateRange"
              size="small"
              style="width: 260px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button
              type="cyan"
              icon="el-icon-search"
              size="small"
              @click="handleQuery"
              >搜索</el-button
            >
            <el-button icon="el-icon-refresh" size="small" @click="resetQuery"
              >重置</el-button
            >
          </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
              type="primary"
              icon="el-icon-plus"
              size="small"
              @click="handleAdd"
              v-hasPermi="['system:user:create']"
              >新增</el-button
            >
          </el-col>
          <right-toolbar
            :showSearch.sync="showSearch"
            @queryTable="getList"
          ></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="userList">
          <el-table-column label="用户编号" align="center" prop="userId" />
          <el-table-column
            label="用户名称"
            align="center"
            prop="username"
            width="120"
            :show-overflow-tooltip="true"
          />
          <el-table-column
            label="用户昵称"
            align="center"
            prop="nickName"
            :show-overflow-tooltip="true"
          />
          <el-table-column
            label="部门"
            align="center"
            prop="deptName"
            :show-overflow-tooltip="true"
          />
          <el-table-column
            label="手机号码"
            align="center"
            prop="phone"
            width="120"
          />
          <el-table-column label="状态" align="center">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.status"
                :active-value="1"
                :inactive-value="0"
                @change="handleStatusChange(scope.row)"
              />
            </template>
          </el-table-column>
          <el-table-column
            label="创建时间"
            align="center"
            prop="createTime"
            width="160"
          >
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.createTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
            align="center"
            width="200"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope">
              <el-button
                size="small"
                type="primary"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:user:update']"
              ></el-button>
              <el-button
                size="small"
                type="primary"
                icon="el-icon-circle-check"
                @click="handleRole(scope.row)"
                v-hasPermi="['system:user:update']"
              ></el-button>
              <el-button
                v-show="scope.row.userId !== 1"
                size="small"
                type="primary"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:user:delete']"
              ></el-button>
            </template>
          </el-table-column>
        </el-table>

        <pagination
          v-show="total > 0"
          :total="total"
          :page.sync="queryParams.current"
          :limit.sync="queryParams.size"
          @pagination="getList"
        />
      </el-col>
    </el-row>

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="昵称" prop="nickName">
              <el-input v-model="form.nickName" placeholder="请输入昵称" />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="电话" prop="phone">
              <el-input
                v-model="form.phone"
                placeholder="请输入电话号码"
                maxlength="11"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-col :span="12">
          <el-form-item
            v-if="form.userId === undefined"
            label="名称"
            prop="username"
          >
            <el-input v-model="form.username" placeholder="请输入用户名" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮箱" prop="email">
            <el-input
              v-model="form.email"
              placeholder="请输入邮箱"
              maxlength="50"
            />
          </el-form-item>
        </el-col>
        <el-row>
          <el-col :span="12">
            <el-form-item label="性别">
              <el-select v-model="form.sex" placeholder="请选择">
                <el-option
                  v-for="dict in sexDictDatas"
                  :key="parseInt(dict.value)"
                  :label="dict.label"
                  :value="parseInt(dict.value)"
                />
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="角色" v-if="form.userId === undefined">
              <el-select v-model="form.roleIds" multiple placeholder="请选择">
                <el-option
                  v-for="item in roleOptions"
                  :key="parseInt(item.roleId)"
                  :label="item.roleName"
                  :value="parseInt(item.roleId)"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="岗位">
              <el-select v-model="form.postIds" multiple placeholder="请选择">
                <el-option
                  v-for="item in postOptions"
                  :key="item.postId"
                  :label="item.name"
                  :value="item.postId"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="部门" prop="deptId">
              <treeselect
                v-model="form.deptId"
                :options="deptOptions"
                :show-count="true"
                placeholder="请选择归属部门"
                :normalizer="normalizer"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="24">
            <el-form-item
              v-if="form.userId === undefined"
              label="密码"
              prop="password"
            >
              <el-input
                v-model="form.password"
                placeholder="请输入用户密码"
                type="password"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 分配角色 -->
    <el-dialog
      title="分配角色"
      :visible.sync="openRole"
      width="500px"
      append-to-body
    >
      <el-form :model="form" label-width="80px">
        <el-form-item label="用户名称">
          <el-input v-model="form.username" :disabled="true" />
        </el-form-item>
        <el-form-item label="用户昵称">
          <el-input v-model="form.nickName" :disabled="true" />
        </el-form-item>
        <el-form-item label="角色">
          <el-select v-model="form.roleIds" multiple placeholder="请选择">
            <el-option
              v-for="item in roleOptions"
              :key="parseInt(item.roleId)"
              :label="item.roleName"
              :value="parseInt(item.roleId)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitRole">确 定</el-button>
        <el-button @click="cancelRole">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  addUser,
  changeUserStatus,
  delUser,
  getUser,
  listUser,
  updateUser,
} from "@/api/system/manage/user";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

import { listSimpleDepts } from "@/api/system/manage/dept";
import { listSimplePosts } from "@/api/system/manage/post";

import { SysCommonStatusEnum } from "@/utils/constants";
import { DICT_TYPE, getDictDatas } from "@/utils/dict";
import { assignUserRole, listUserRoles } from "@/api/system/manage/permission";
import { listSimpleRoles } from "@/api/system/manage/role";

export default {
  name: "User",
  components: { Treeselect },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 用户表格数据
      userList: null,
      // 弹出层标题
      title: "",
      // 部门树选项
      deptOptions: undefined,
      // 是否显示弹出层
      open: false,
      // 部门名称
      name: undefined,
      // 默认密码
      initPassword: undefined,
      // 日期范围
      dateRange: [],
      // 状态数据字典
      statusOptions: [],
      // 性别状态字典
      sexOptions: [],
      // 岗位选项
      postOptions: [],
      // 角色选项
      roleOptions: [],
      // 表单参数
      form: {},
      defaultProps: {
        children: "children",
        label: "name",
      },
      // 查询参数
      queryParams: {
        current: 1,
        size: 10,
        username: undefined,
        deptId: undefined,
      },
      // 表单校验
      rules: {
        username: [
          { required: true, message: "用户名称不能为空", trigger: "blur" },
        ],
        nickName: [
          { required: true, message: "用户昵称不能为空", trigger: "blur" },
        ],
        password: [
          { required: true, message: "用户密码不能为空", trigger: "blur" },
        ],
        email: [
          {
            type: "email",
            message: "'请输入正确的邮箱地址",
            trigger: ["blur", "change"],
          },
        ],
        phone: [
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur",
          },
        ],
      },
      // 是否显示弹出层（角色权限）
      openRole: false,

      // 枚举
      SysCommonStatusEnum: SysCommonStatusEnum,
      // 数据字典
      statusDictDatas: getDictDatas(DICT_TYPE.SYS_COMMON_STATUS),
      sexDictDatas: getDictDatas(DICT_TYPE.SYS_USER_SEX),
    };
  },
  watch: {
    // 根据名称筛选部门树
    name(val) {
      this.$refs.tree.filter(val);
    },
  },
  created() {
    this.getList();
    this.getTreeselect();
    //this.getkey("sys.user.init-password").then(response => {
    //  this.initPassword = response.msg;
    //});
  },
  methods: {
    /** 查询用户列表 */
    getList() {
      this.loading = true;
      listUser(
        this.addDateRange(this.queryParams, [
          this.dateRange[0] ? this.dateRange[0] + " 00:00:00" : undefined,
          this.dateRange[1] ? this.dateRange[1] + " 23:59:59" : undefined,
        ])
      ).then((response) => {
        this.userList = response.data.records;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 查询部门下拉树结构 + 岗位下拉 */
    getTreeselect() {
      listSimpleDepts().then((response) => {
        // 处理 deptOptions 参数
        this.deptOptions = [];
        this.deptOptions.push(...this.handleTree(response.data, "deptId"));
      });
      // listSimplePosts().then((response) => {
      //   // 处理 postOptions 参数
      //   this.postOptions = [];
      //   this.postOptions.push(...response.data);
      // });
      listSimpleRoles().then((response) => {
        // 处理 roleOptions 参数
        this.roleOptions = [];
        this.roleOptions.push(...response.data);
      });
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data) {
      this.queryParams.deptId = data.deptId;
      this.getList();
    },
    // 用户状态修改
    handleStatusChange(row) {
      let text = row.status === SysCommonStatusEnum.ENABLE ? "启用" : "停用";
      this.$confirm(
        '确认要"' + text + '""' + row.username + '"用户吗?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(function () {
          return changeUserStatus(row.userId, row.status);
        })
        .then(() => {
          this.msgSuccess(text + "成功");
        })
        .catch(function () {
          row.status =
            row.status === SysCommonStatusEnum.ENABLE
              ? SysCommonStatusEnum.DISABLE
              : SysCommonStatusEnum.ENABLE;
        });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 取消按钮（角色权限）
    cancelRole() {
      this.openRole = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        userId: undefined,
        deptId: undefined,
        username: undefined,
        nickName: undefined,
        password: undefined,
        phone: undefined,
        email: undefined,
        sex: undefined,
        remark: undefined,
        postIds: [],
        roleIds: [],
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.current = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      // 获得下拉数据
      this.getTreeselect();
      // 打开表单，并设置初始化
      this.open = true;
      this.title = "添加用户";
      this.form.password = this.initPassword;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getTreeselect();
      const id = row.userId;
      getUser(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户";
        this.form.password = "";
      });
      listSimplePosts().then((response) => {
        // 处理 postOptions 参数
        this.postOptions = [];
        this.postOptions.push(...response.data);
      });
    },
    /** 分配用户角色操作 */
    handleRole(row) {
      this.reset();
      // 处理了 form 的用户 username 和 nickName 的展示
      this.form.userId = row.userId;
      // 处理了 form 的用户 username 和 nickName 的展示
      this.form.username = row.username;
      this.form.nickName = row.nickName;
      // 打开弹窗
      this.openRole = true;
      // 获得角色列表
      listSimpleRoles().then((response) => {
        // 处理 roleOptions 参数
        this.roleOptions = [];
        this.roleOptions.push(...response.data);
      });
      // 获得用户所属的角色 Id 集合
      listUserRoles(row.userId).then((response) => {
        // 设置选中
        this.form.roleIds = response.data;
      });
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.userId !== undefined) {
            updateUser(this.form).then((response) => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUser(this.form).then((response) => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 提交按钮（角色权限） */
    submitRole: function () {
      if (this.form.userId !== undefined) {
        assignUserRole({
          userId: this.form.userId,
          roleIds: this.form.roleIds,
        }).then((response) => {
          this.msgSuccess("分配角色成功");
          this.openRole = false;
          this.getList();
        });
      }
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.userId || this.ids;
      this.$confirm('是否确认删除用户编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return delUser(ids);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        });
    },
    // 格式化部门的下拉框
    normalizer(node) {
      return {
        id: node.deptId,
        label: node.name,
        children: node.children,
      };
    },
  },
};
</script>
<style>
</style>
