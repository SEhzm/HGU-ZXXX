<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="98px">
      <el-form-item label="轮播图课程id" prop="CaruCourseId">
        <el-input
          v-model="queryParams.CaruCourseId"
          placeholder="请输入轮播图课程id"
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
          v-hasPermi="['CaruCourse:CaruCourse:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['CaruCourse:CaruCourse:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['CaruCourse:CaruCourse:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['CaruCourse:CaruCourse:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="CaruCourseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="caruId" />
      <el-table-column label="轮播图课程id" align="center" prop="caruCourseId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['CaruCourse:CaruCourse:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['CaruCourse:CaruCourse:remove']">删除</el-button>
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

    <!-- 添加或修改首页轮播图展示的课程id对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="CaruCourseRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="轮播图课程id" prop="CaruCourseId">
          <el-input v-model="form.CaruCourseId" placeholder="请输入轮播图课程id" />
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

<script setup name="CaruCourse">
import { listCaruCourse, getCaruCourse, delCaruCourse, addCaruCourse, updateCaruCourse } from "@/api/CaruCourse/CaruCourse";

const { proxy } = getCurrentInstance();

const CaruCourseList = ref([]);
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
    CaruCourseId: null
  },
  rules: {
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询首页轮播图展示的课程id列表 */
function getList() {
  loading.value = true;
  listCaruCourse(queryParams.value).then(response => {
    CaruCourseList.value = response.rows;
      console.log(CaruCourseList)
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
    caruId: null,
    CaruCourseId: null
  };
  proxy.resetForm("CaruCourseRef");
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
  ids.value = selection.map(item => item.caruId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加首页轮播图展示的课程id";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _caruId = row.caruId || ids.value
  getCaruCourse(_caruId).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改首页轮播图展示的课程id";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["CaruCourseRef"].validate(valid => {
    if (valid) {
      if (form.value.caruId != null) {
        updateCaruCourse(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addCaruCourse(form.value).then(response => {
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
  const _caruIds = row.caruId || ids.value;
  proxy.$modal.confirm('是否确认删除首页轮播图展示的课程id编号为"' + _caruIds + '"的数据项？').then(function() {
    return delCaruCourse(_caruIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('CaruCourse/CaruCourse/export', {
    ...queryParams.value
  }, `CaruCourse_${new Date().getTime()}.xlsx`)
}

getList();
</script>
