<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      v-show="showSearch"
      :inline="true"
    >
      <el-form-item label="角色名称" prop="keyword">
        <el-input
          v-model="queryParams.keyword"
          placeholder="请输入角色名称"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="dateRange"
          size="small"
          style="width: 240px"
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
          v-hasPermi="['system:role:create']"
          >新增</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roleList">
      <el-table-column
        label="角色编号"
        align="center"
        prop="roleId"
        width="180"
      />
      <el-table-column
        label="角色名称"
        align="center"
        prop="roleName"
        :show-overflow-tooltip="true"
        width="180"
      />
      <el-table-column
        label="角色标识"
        align="center"
        prop="code"
        :show-overflow-tooltip="true"
        width="180"
      />
      <el-table-column
        label="显示顺序"
        align="center"
        prop="sort"
        width="180"
      />
      <el-table-column label="状态" align="center" width="100">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.status"
            :active-value="1"
            :inactive-value="0"
            @change="handleStatusChange(scope.row)"
          ></el-switch>
        </template>
      </el-table-column>

      <el-table-column
        label="创建人"
        align="center"
        prop="createBy"
        :show-overflow-tooltip="true"
        width="180"
      />

      <el-table-column
        label="创建时间"
        align="center"
        prop="createTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="更新时间"
        align="center"
        prop="updateTime"
        width="180"
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
          <!-- 修改 -->
          <el-button
            size="small"
            type="primary"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:role:update']"
          ></el-button>
          <!-- 分配 -->
          <el-button
            size="small"
            type="primary"
            icon="el-icon-circle-check"
            @click="handleMenu(scope.row)"
            v-hasPermi="['system:role:update']"
          ></el-button>
          <!-- 删除 -->
          <el-button
            v-show="scope.row.userId !== 1"
            size="small"
            type="primary"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:role:delete']"
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

    <!-- 添加或修改角色配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="角色名称" prop="name">
          <el-input v-model="form.roleName" placeholder="请输入角色名称" />
        </el-form-item>
        <el-form-item label="角色标识" prop="code">
          <el-input v-model="form.code" placeholder="请输入角色标识" />
        </el-form-item>
        <el-form-item label="角色顺序" prop="sort">
          <el-input-number
            v-model="form.sort"
            controls-position="right"
            :min="0"
          />
        </el-form-item>
        <el-form-item label="描述">
          <el-input
            v-model="form.description"
            type="textarea"
            placeholder="请输入内容"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 分配角色的菜单权限对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="openMenu"
      width="500px"
      append-to-body
    >
      <el-form :model="form" label-width="80px">
        <el-form-item label="角色名称">
          <el-input v-model="form.roleName" :disabled="true" />
        </el-form-item>
        <el-form-item label="角色标识">
          <el-input v-model="form.code" :disabled="true" />
        </el-form-item>
        <el-form-item label="菜单权限">
          <el-checkbox
            v-model="menuExpand"
            @change="handleCheckedTreeExpand($event, 'menu')"
            >展开/折叠</el-checkbox
          >
          <el-checkbox
            v-model="menuNodeAll"
            @change="handleCheckedTreeNodeAll($event, 'menu')"
            >全选/全不选</el-checkbox
          >
          <el-tree
            class="tree-border"
            :data="menuOptions"
            show-checkbox
            ref="menu"
            node-key="menuId"
            :check-strictly="form.menuCheckStrictly"
            empty-text="加载中，请稍后"
            :props="defaultProps"
          ></el-tree>
        </el-form-item>
        <el-form-item label="权限范围">
          <el-select v-model="form.dataScope">
            <el-option
              v-for="item in dataScopeDictDatas"
              :key="parseInt(item.value)"
              :label="item.label"
              :value="parseInt(item.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          label="数据权限"
          v-show="form.dataScope === SysDataScopeEnum.DEPT_CUSTOM"
        >
          <el-checkbox
            :checked="!form.deptCheckStrictly"
            @change="handleCheckedTreeConnect($event, 'dept')"
            >父子联动</el-checkbox
          >
          <el-checkbox
            v-model="deptExpand"
            @change="handleCheckedTreeExpand($event, 'dept')"
            >展开/折叠</el-checkbox
          >
          <el-checkbox
            v-model="deptNodeAll"
            @change="handleCheckedTreeNodeAll($event, 'dept')"
            >全选/全不选</el-checkbox
          >
          <el-tree
            class="tree-border"
            :data="deptOptions"
            show-checkbox
            default-expand-all
            ref="dept"
            node-key="deptId"
            :check-strictly="form.deptCheckStrictly"
            empty-text="加载中，请稍后"
            :props="deptProps"
          ></el-tree>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitMenu">确 定</el-button>
        <el-button @click="cancelMenu">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  addRole,
  changeRoleStatus,
  delRole,
  getRole,
  listRole,
  updateByole,
} from "@/api/system/manage/role";
import { listSimpleMenus } from "@/api/system/manage/menu";
import {
  updateByolePermission,
  listRoleMenus,
} from "@/api/system/manage/permission";
import { listSimpleDepts } from "@/api/system/manage/dept";
import { SysCommonStatusEnum, SysDataScopeEnum } from "@/utils/constants";
import { DICT_TYPE, getDictDataLabel, getDictDatas } from "@/utils/dict";

export default {
  name: "Role",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 角色表格数据
      roleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示弹出层（菜单权限）
      openMenu: false,
      menuExpand: false,
      menuNodeAll: false,
      deptExpand: true,
      deptNodeAll: false,
      // 日期范围
      dateRange: [],
      // 菜单列表
      menuOptions: [],
      // 部门列表
      deptOptions: [], // 部门属性结构
      depts: [], // 部门列表
      // 查询参数
      queryParams: {
        current: 1,
        size: 10,
        queryParams: undefined,
      },
      // 表单参数
      form: {},
      defaultProps: {
        label: "name",
        children: "children",
      },
      deptProps: {
        label: "name",
        children: "children",
      },
      // 表单校验
      rules: {
        roleName: [
          { required: true, message: "角色名称不能为空", trigger: "blur" },
        ],
        code: [
          { required: true, message: "角色标识不能为空", trigger: "blur" },
        ],
        sort: [
          { required: true, message: "角色顺序不能为空", trigger: "blur" },
        ],
      },

      // 枚举
      SysCommonStatusEnum: SysCommonStatusEnum,
      SysDataScopeEnum: SysDataScopeEnum,
      // 数据字典
      roleTypeDictDatas: getDictDatas(DICT_TYPE.SYS_ROLE_TYPE),
      statusDictDatas: getDictDatas(DICT_TYPE.SYS_COMMON_STATUS),
      dataScopeDictDatas: getDictDatas(DICT_TYPE.SYS_DATA_SCOPE),
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询角色列表 */
    getList() {
      this.loading = true;
      listRole(
        this.addDateRange(this.queryParams, [
          this.dateRange[0] ? this.dateRange[0] + " 00:00:00" : undefined,
          this.dateRange[1] ? this.dateRange[1] + " 23:59:59" : undefined,
        ])
      ).then((response) => {
        this.roleList = response.data.records;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    // 角色状态修改
    handleStatusChange(row) {
      // 此时，row 已经变成目标状态了，所以可以直接提交请求和提示
      let text = row.status === SysCommonStatusEnum.ENABLE ? "启用" : "停用";
      this.$confirm('确认要"' + text + '""' + row.name + '"角色吗?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return changeRoleStatus(row.id, row.status);
        })
        .then(() => {
          this.msgSuccess(text + "成功");
        })
        .catch(function () {
          // 异常时，需要将 row.status 状态重置回之前的
          row.status =
            row.status === SysCommonStatusEnum.ENABLE
              ? SysCommonStatusEnum.DISABLE
              : SysCommonStatusEnum.ENABLE;
        });
    },
    // 角色类型字典翻译
    typeFormat(row, column) {
      return getDictDataLabel(DICT_TYPE.SYS_ROLE_TYPE, row.type);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 取消按钮（菜单权限）
    cancelMenu() {
      this.openMenu = false;
      this.reset();
    },
    // 表单重置
    reset() {
      if (this.$refs.menu !== undefined) {
        this.$refs.menu.setCheckedKeys([]);
      }
      this.menuExpand = false;
      this.menuNodeAll = false;
      this.deptExpand = true;
      this.deptNodeAll = false;
      this.form = {
        roleId: undefined,
        roleName: undefined,
        code: undefined,
        sort: 0,
        deptIds: [],
        menuIds: [],
        dataScope: undefined,
        description: undefined,
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
    // 树权限（展开/折叠）
    handleCheckedTreeExpand(value, type) {
      if (type === "menu") {
        let treeList = this.menuOptions;
        for (let i = 0; i < treeList.length; i++) {
          this.$refs.menu.store.nodesMap[treeList[i].menuId].expanded = value;
        }
      } else if (type === "dept") {
        let treeList = this.deptOptions;
        for (let i = 0; i < treeList.length; i++) {
          this.$refs.dept.store.nodesMap[treeList[i].deptId].expanded = value;
        }
      }
    },
    // 树权限（全选/全不选）
    handleCheckedTreeNodeAll(value, type) {
      if (type === "menu") {
        this.$refs.menu.setCheckedNodes(value ? this.menuOptions : []);
      } else if (type === "dept") {
        // this.$refs.dept.setCheckedNodes(value ? this.deptOptions: []);
        this.$refs.dept.setCheckedNodes(value ? this.depts : []);
      }
    },
    // 树权限（父子联动）
    handleCheckedTreeConnect(value, type) {
      if (type === "menu") {
        this.form.menuCheckStrictly = value;
      } else if (type === "dept") {
        this.form.deptCheckStrictly = !value;
      }
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加角色";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      console.log(row.roleId);
      this.reset();
      getRole(row.roleId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改角色";
      });
    },
    /** 分配菜单权限操作 */
    handleMenu(row) {
      this.reset();
      const roleId = row.roleId;
      // 处理了 form 的角色 roleName 和 code 的展示
      this.form.roleId = roleId;
      this.form.roleName = row.roleName;
      this.form.code = row.code;
      // 打开弹窗
      this.openMenu = true;
      // 菜单权限
      // 获得菜单列表
      listSimpleMenus().then((response) => {
        // 处理 menuOptions 参数
        this.menuOptions = [];
        this.menuOptions.push(...this.handleTree(response.data, "menuId"));
      });
      // 获得角色拥有的菜单集合
      listRoleMenus(roleId).then((response) => {
        // 设置为严格，避免设置父节点自动选中子节点，解决半选中问题
        this.form.menuCheckStrictly = true;
        // 设置选中
        this.$refs.menu.setCheckedKeys(response.data);
        // 设置为非严格，继续使用半选中
        this.form.menuCheckStrictly = false;
      });
      // 数据权限
      // 获得部门列表
      listSimpleDepts().then((response) => {
        // 处理 deptOptions 参数
        this.deptOptions = [];
        this.deptOptions.push(...this.handleTree(response.data, "deptId"));
        this.depts = response.data;
        // this.deptIds = response.data.map(x => x.id);
        // 获得角色拥有的数据权限
        getRole(row.roleId).then((response) => {
          this.form.dataScope = response.data.dataScope;
          this.$refs.dept.setCheckedKeys(response.data.deptIds, false);
        });
      });
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.roleId !== undefined) {
            updateByole(this.form).then((response) => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRole(this.form).then((response) => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 提交按钮（权限分配） */
    submitMenu: function () {
      if (this.form.roleId !== undefined) {
        updateByolePermission({
          roleId: this.form.roleId,
          dataScope: this.form.dataScope,
          deptIds:
            this.form.dataScope !== SysDataScopeEnum.DEPT_CUSTOM
              ? []
              : this.$refs.dept.getCheckedKeys(),
          menuIds: [
            ...this.$refs.menu.getCheckedKeys(),
            ...this.$refs.menu.getHalfCheckedKeys(),
          ],
        }).then((response) => {
          this.msgSuccess("修改成功");
          this.openMenu = false;
          this.getList();
        });
      }
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.roleId || this.ids;
      this.$confirm('是否确认删除角色编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return delRole(ids);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        });
    },
  },
};
</script>
