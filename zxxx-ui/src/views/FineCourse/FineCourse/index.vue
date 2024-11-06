<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="128px">
      <el-form-item label="精品课的课程id" prop="findCourseId">
        <el-input
          v-model="queryParams.findCourseId"
          placeholder="请输入精品课的课程id"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['FineCourse:FineCourse:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['FineCourse:FineCourse:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['FineCourse:FineCourse:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['FineCourse:FineCourse:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="FineCourseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="fineId" />
      <el-table-column label="精品课的课程id" align="center" prop="findCourseId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['FineCourse:FineCourse:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['FineCourse:FineCourse:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改精品课的课程id对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="FineCourseRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="精品课的课程id" prop="findCourseId">
          <el-input v-model="form.findCourseId" placeholder="请输入精品课的课程id" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="FineCourse">
import { listFineCourse, getFineCourse, delFineCourse, addFineCourse, updateFineCourse } from "@/api/FineCourse/FineCourse";

const { proxy } = getCurrentInstance();

const FineCourseList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    findCourseId: null
  },
  rules: {
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询精品课的课程id列表 */
function getList() {
  loading.value = true;
  listFineCourse(queryParams.value).then(response => {
    FineCourseList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    fineId: null,
    findCourseId: null
  };
  proxy.resetForm("FineCourseRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.fineId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加精品课的课程id";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _fineId = row.fineId || ids.value
  getFineCourse(_fineId).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改精品课的课程id";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["FineCourseRef"].validate(valid => {
    if (valid) {
      if (form.value.fineId != null) {
        updateFineCourse(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addFineCourse(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _fineIds = row.fineId || ids.value;
  proxy.$modal.confirm('是否确认删除精品课的课程id编号为"' + _fineIds + '"的数据项？').then(function() {
    return delFineCourse(_fineIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('FineCourse/FineCourse/export', {
    ...queryParams.value
  }, `FineCourse_${new Date().getTime()}.xlsx`)
}

getList();
</script>
