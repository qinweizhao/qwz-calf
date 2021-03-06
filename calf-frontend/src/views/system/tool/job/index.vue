<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      :inline="true"
      v-show="showSearch"
    >
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="请选择状态"
          clearable
          size="small"
        >
          <el-option
            v-for="dict in this.getDictDatas(DICT_TYPE.INF_JOB_STATUS)"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="BeanName" prop="handlerName" >
        <el-input
          v-model="queryParams.handlerName"
          placeholder="请输入BeanName"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:job:create']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <!-- v-hasPermi="['system:job:query']" -->
        <el-button
          type="info"
          icon="el-icon-s-operation"
          size="small"
          @click="handleJobLog"
          >执行日志</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="jobList">
      <el-table-column label="编号" align="center" prop="jobId" width="100" />
      <el-table-column label="名称" align="center" prop="name" width="180px" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <span>{{
            getDictDataLabel(DICT_TYPE.INF_JOB_STATUS, scope.row.status)
          }}</span>
        </template> </el-table-column
      >>
      <el-table-column label="BeanName" align="center" prop="handlerName" width="220px" />
      <el-table-column
        label="执行参数"
        align="center"
        prop="handlerParam"
      />
      <el-table-column
        label="CRON 表达式"
        align="center"
        width="180px"
        prop="cronExpression"
      />
      <el-table-column
        label="操作"
        align="center"
        width="400px"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <!-- 详细 v-hasPermi="['system:job:query']" -->
          <el-button
            size="small"
            type="primary"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['system:job:query']"
          ></el-button>
          <!-- 执行日志  v-hasPermi="['system:job:query']" -->
          <el-button
            size="small"
            icon="el-icon-s-operation"
            @click="handleJobLog(scope.row)"
            v-hasPermi="['system:job:query']"
          ></el-button>
          <!-- 修改  v-hasPermi="['system:job:update']" -->
          <el-button
            size="small"
            type="primary"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:job:update']"
          ></el-button>
          <!-- 开启 v-hasPermi="['system:job:update']"  v-if="scope.row.status === InfJobStatusEnum.STOP"-->
          <el-button
            size="small"
            type="primary"
            icon="el-icon-check"
            @click="handleChangeStatus(scope.row, true)"
            v-if="scope.row.status === InfJobStatusEnum.STOP"
            v-hasPermi="['system:job:update']"
            ></el-button
          >
          <!-- 暂停 v-hasPermi="['system:job:update']" v-if="scope.row.status === InfJobStatusEnum.NORMAL" -->
          <el-button
            size="small"
            type="primary"
            icon="el-icon-close"
            @click="handleChangeStatus(scope.row, false)"
            v-if="scope.row.status === InfJobStatusEnum.NORMAL"
            v-hasPermi="['system:job:update']"
            ></el-button
          >
          <!-- 执行 v-hasPermi="['system:job:trigger']" -->
          <el-button
            size="small"
            type="primary"
            icon="el-icon-caret-right"
            @click="handleRun(scope.row)"
            v-if="scope.row.status === InfJobStatusEnum.INIT"
            v-hasPermi="['system:job:trigger']"
            ></el-button
          >
          <!-- 删除 -->
          <el-button
            size="small"
            type="primary"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:job:delete']"
            ></el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.current"
      :limit.sync="queryParams.size"
      @pagination="getList"
    />
    <!-- 添加或修改定时任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="任务名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入任务名称" />
        </el-form-item>
        <el-form-item label="BeanName" prop="handlerName">
          <el-input
            v-model="form.handlerName"
            placeholder="请输入BeanName"
            v-bind:readonly="form.id !== undefined"
          />
        </el-form-item>
        <el-form-item label="执行参数" prop="handlerParam">
          <el-input
            v-model="form.handlerParam"
            placeholder="请输入执行参数"
          />
        </el-form-item>
        <el-form-item label="CRON 表达式" prop="cronExpression">
          <el-input
            v-model="form.cronExpression"
            placeholder="请输入CRON 表达式"
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 任务日志详细 -->
    <el-dialog
      title="任务详细"
      :visible.sync="openView"
      width="700px"
      append-to-body
    >
      <el-form ref="form" :model="form" label-width="200px" size="small">
        <el-row>
          <el-col :span="24">
            <el-form-item label="编号：">{{ form.jobId }}</el-form-item>
            <el-form-item label="名称：">{{ form.name }}</el-form-item>
            <el-form-item label="状态：">{{
              getDictDataLabel(DICT_TYPE.INF_JOB_STATUS, form.status)
            }}</el-form-item>
            <el-form-item label="BeanName：">{{
              form.handlerName
            }}</el-form-item>
            <el-form-item label="执行参数：">{{
              form.handlerParam
            }}</el-form-item>
            <el-form-item label="cron表达式：">{{
              form.cronExpression
            }}</el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="openView = false">关 闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listJob,
  getJob,
  delJob,
  addJob,
  updateJob,
  exportJob,
  runJob,
  updateJobStatus,
} from "@/api/system/tool/job";
import { InfJobStatusEnum } from "@/utils/constants";

export default {
  name: "Job",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 定时任务表格数据
      jobList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示详细弹出层
      openView: false,
      // 状态字典
      statusOptions: [],
      // 查询参数
      queryParams: {
        current: 1,
        size: 10,
        name: undefined,
        status: undefined,
        handlerName: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "任务名称不能为空", trigger: "blur" },
        ],
        handlerName: [
          { required: true, message: "BeanName不能为空", trigger: "blur" },
        ],
        cronExpression: [
          { required: true, message: "CRON 表达式不能为空", trigger: "blur" },
        ],
        retryCount: [
          { required: true, message: "重试次数不能为空", trigger: "blur" },
        ],
        retryInterval: [
          { required: true, message: "重试间隔不能为空", trigger: "blur" },
        ],
      },
      nextTimes: [], // 后续执行时间

      // 枚举
      InfJobStatusEnum: InfJobStatusEnum,
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询定时任务列表 */
    getList() {
      this.loading = true;
      listJob(this.queryParams).then((response) => {
        this.jobList = response.data.records;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
        jobId: undefined,
        name: undefined,
        handlerName: undefined,
        handlerParam: undefined,
        cronExpression: undefined,
        retryCount: undefined,
        retryInterval: undefined,
        monitorTimeout: undefined,
      };
      this.nextTimes = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.current = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 立即执行一次 **/
    handleRun(row) {
      this.$confirm('确认要立即执行一次"' + row.name + '"任务吗?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return runJob(row.jobId);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("执行成功");
        });
    },
    /** 任务详细信息 */
    handleView(row) {
      getJob(row.jobId).then((response) => {
        this.form = response.data;
        this.openView = true;
      });
    },
    /** 任务日志列表查询 */
    handleJobLog(row) {
      if (row.jobId) {
        this.$router.push({
          path: "/job/log",
          query: {
            jobId: row.jobId,
          },
        });
      } else {
        this.$router.push("/job/log");
      }
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加任务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const jobId = row.jobId;
      getJob(jobId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改任务";
      });
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.jobId !== undefined) {
            updateJob(this.form).then((response) => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addJob(this.form).then((response) => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.jobId;
      this.$confirm(
        '是否确认删除定时任务编号为"' + ids + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(function () {
          return delJob(ids);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        });
    },
    /** 更新状态操作 */
    handleChangeStatus(row, open) {
      const id = row.jobId;
      let status = open ? InfJobStatusEnum.NORMAL : InfJobStatusEnum.STOP;
      let statusStr = open ? "开启" : "关闭";
      this.$confirm(
        "是否确认" + statusStr + '定时任务编号为"' + id + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(function () {
          return updateJobStatus(id, status);
        })
        .then(() => {
          this.getList();
          this.msgSuccess(statusStr + "成功");
        });
    },
  },
};
</script>
