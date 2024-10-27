<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程id" prop="courseId">
        <el-input
          v-model="queryParams.courseId"
          placeholder="请输入课程id"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建者id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入创建者用户id"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="选课日期" prop="enrollmentDate">
        <el-date-picker clearable
          v-model="queryParams.enrollmentDate"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择选课日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="章节id" prop="chapterId">
        <el-input
          v-model="queryParams.chapterId"
          placeholder="请输入章节id"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程状态" prop="courseStatus">
        <el-select v-model="queryParams.courseStatus" placeholder="请选择课程状态" clearable>
          <el-option
            v-for="dict in course_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['course:enrollments:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['course:enrollments:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['course:enrollments:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['course:enrollments:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="enrollmentsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="选课id" align="center" prop="enrollmentId" />-->
      <el-table-column label="课程id" align="center" prop="courseId" />
      <el-table-column label="课程名" align="center" prop="courseName" />
<!--      <el-table-column label="创建者用户id" align="center" prop="userId" />-->
      <el-table-column label="选课日期" align="center" prop="enrollmentDate" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.enrollmentDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="章节id" align="center" prop="chapterId" />
      <el-table-column label="课程状态" align="center" prop="courseStatus">
        <template #default="scope">
          <dict-tag :options="course_status" :value="scope.row.courseStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['course:enrollments:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['course:enrollments:remove']">删除</el-button>
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

    <!-- 添加或修改course_enrollments对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="enrollmentsRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程id" prop="courseId">
          <el-input v-model="form.courseId" placeholder="请输入课程id" />
        </el-form-item>
<!--        <el-form-item label="创建者用户id" prop="userId">-->
<!--          <el-input v-model="form.userId" placeholder="请输入创建者用户id" />-->
<!--        </el-form-item>-->
        <el-form-item label="选课日期" prop="enrollmentDate">
          <el-date-picker clearable
            v-model="form.enrollmentDate"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择选课日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="章节id" prop="chapterId">
          <el-input v-model="form.chapterId" placeholder="请输入章节id" />
        </el-form-item>
        <el-form-item label="课程状态" prop="courseStatus">
          <el-radio-group v-model="form.courseStatus">
            <el-radio
              v-for="dict in course_status"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
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

<script setup name="Enrollments">
import { listEnrollments, getEnrollments, delEnrollments, addEnrollments, updateEnrollments } from "@/api/course/enrollments";
import {myListEnrollments} from "../../../api/course/enrollments.js";

const { proxy } = getCurrentInstance();
const { course_status } = proxy.useDict('course_status');

const enrollmentsList = ref([]);
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
    courseId: null,
    userId: null,
    enrollmentDate: null,
    chapterId: null,
    courseStatus: null
  },
  rules: {
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询course_enrollments列表 */
function getList() {
  loading.value = true;
    myListEnrollments(queryParams.value).then(response => {
    enrollmentsList.value = response.rows;
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
    enrollmentId: null,
    courseId: null,
    userId: null,
    enrollmentDate: null,
    chapterId: null,
    courseStatus: null
  };
  proxy.resetForm("enrollmentsRef");
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
  ids.value = selection.map(item => item.enrollmentId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加course_enrollments";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _enrollmentId = row.enrollmentId || ids.value
  getEnrollments(_enrollmentId).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改course_enrollments";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["enrollmentsRef"].validate(valid => {
    if (valid) {
      if (form.value.enrollmentId != null) {
        updateEnrollments(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addEnrollments(form.value).then(response => {
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
  const _enrollmentIds = row.enrollmentId || ids.value;
  proxy.$modal.confirm('是否确认删除course_enrollments编号为"' + _enrollmentIds + '"的数据项？').then(function() {
    return delEnrollments(_enrollmentIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('course/enrollments/export', {
    ...queryParams.value
  }, `enrollments_${new Date().getTime()}.xlsx`)
}

getList();
</script>
