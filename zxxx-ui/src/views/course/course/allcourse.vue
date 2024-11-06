<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
            <el-form-item label="课程名" prop="courseName">
                <el-input
                    v-model="queryParams.courseName"
                    placeholder="请输入课程名"
                    clearable
                    @keyup.enter="handleQuery"
                />
            </el-form-item>
            <el-form-item label="课程简介" prop="courseDescription">
                <el-input
                    v-model="queryParams.courseDescription"
                    placeholder="请输入课程简介"
                    clearable
                    @keyup.enter="handleQuery"
                />
            </el-form-item>
            <el-form-item label="创建者id" prop="userId">
                <el-input
                    v-model="queryParams.userId"
                    placeholder="请输入创建者id"
                    clearable
                    @keyup.enter="handleQuery"
                />
            </el-form-item>
            <el-form-item label="创建时间" prop="createdAt">
                <el-date-picker clearable
                                v-model="queryParams.createdAt"
                                type="date"
                                value-format="YYYY-MM-DD"
                                placeholder="请选择创建时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="更新时间" prop="updatedAt">
                <el-date-picker clearable
                                v-model="queryParams.updatedAt"
                                type="date"
                                value-format="YYYY-MM-DD"
                                placeholder="请选择更新时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="讲师" prop="teacher">
                <el-input
                    v-model="queryParams.teacher"
                    placeholder="请输入讲师"
                    clearable
                    @keyup.enter="handleQuery"
                />
            </el-form-item>
            <el-form-item label="课程分类" prop="courseCategory">
                <el-select v-model="queryParams.courseCategory" placeholder="请选择课程分类" clearable>
                    <el-option
                        v-for="dict in course_category"
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
                    v-hasPermi="['course:course:add']"
                >新增
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="success"
                    plain
                    icon="Edit"
                    :disabled="single"
                    @click="handleUpdate"
                    v-hasPermi="['course:course:edit']"
                >修改
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="danger"
                    plain
                    icon="Delete"
                    :disabled="multiple"
                    @click="handleDelete"
                    v-hasPermi="['course:course:remove']"
                >删除
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="warning"
                    plain
                    icon="Download"
                    @click="handleExport"
                    v-hasPermi="['course:course:export']"
                >导出
                </el-button>
            </el-col>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center"/>
            <el-table-column label="课程id" align="center" prop="courseId"/>
            <el-table-column label="课程名" align="center" prop="courseName"/>
            <el-table-column label="课程简介" align="center" prop="courseDescription" show-overflow-tooltip/>
            <el-table-column label="创建者id" align="center" prop="userId"/>
            <el-table-column label="创建时间" align="center" prop="createdAt" width="180">
                <template #default="scope">
                    <span>{{ parseTime(scope.row.createdAt, '{y}-{m}-{d}') }}</span>
                </template>
            </el-table-column>
            <el-table-column label="更新时间" align="center" prop="updatedAt" width="180">
                <template #default="scope">
                    <span>{{ parseTime(scope.row.updatedAt, '{y}-{m}-{d}') }}</span>
                </template>
            </el-table-column>
            <el-table-column label="讲师" align="center" prop="teacher"/>
            <el-table-column label="课程分类" align="center" prop="courseCategory">
                <template #default="scope">
                    <dict-tag :options="course_category" :value="scope.row.courseCategory"/>
                </template>
            </el-table-column>
            <el-table-column label="课程封面" align="center" prop="courseImg" show-overflow-tooltip/>
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template #default="scope">
                    <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
                               v-hasPermi="['course:course:edit']">修改
                    </el-button>
                    <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                               v-hasPermi="['course:course:remove']">删除
                    </el-button>
                    <el-button link type="primary" @click="Upload(scope.row)" v-hasPermi="['course:course:add']">
                        上传章节
                    </el-button>
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

        <!-- 添加或修改course对话框 -->
        <el-dialog :title="title" v-model="open" width="500px" append-to-body>
            <el-form ref="courseRef" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="课程名" prop="courseName">
                    <el-input v-model="form.courseName" placeholder="请输入课程名"/>
                </el-form-item>
                <el-form-item label="课程简介" prop="courseDescription">
                    <el-input v-model="form.courseDescription" placeholder="请输入课程简介"/>
                </el-form-item>
                <el-form-item label="创建者id" prop="userId">
                    <el-input v-model="form.userId" placeholder="请输入创建者id"/>
                </el-form-item>
                <el-form-item label="创建时间" prop="createdAt">
                    <el-date-picker clearable
                                    v-model="form.createdAt"
                                    type="date"
                                    value-format="YYYY-MM-DD"
                                    placeholder="请选择创建时间">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="更新时间" prop="updatedAt">
                    <el-date-picker clearable
                                    v-model="form.updatedAt"
                                    type="date"
                                    value-format="YYYY-MM-DD"
                                    placeholder="请选择更新时间">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="讲师" prop="teacher">
                    <el-input v-model="form.teacher" placeholder="请输入讲师"/>
                </el-form-item>
                <el-form-item label="课程分类" prop="courseCategory">
                    <el-radio-group v-model="form.courseCategory">
                        <el-radio
                            v-for="dict in course_category"
                            :key="dict.value"
                            :label="dict.value"
                        >{{ dict.label }}
                        </el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="课程封面" prop="courseImg">
                    <el-tag v-if="data.form.courseImg">已上传</el-tag>
                    <el-upload
                        style="width: 100%;"
                        v-else
                        class="upload-demo"
                        drag
                        multiple
                        :http-request="handleUploadImg"
                        :on-success="handleSuccess"
                        accept="image/*"
                    >
                        <el-icon class="el-icon--upload"><upload-filled /></el-icon>
                        <div class="el-upload__text">
                            将文件拖拽进来 <em>或 点击上传</em>
                        </div>
                        <template #tip>
                            <div class="el-upload__tip">
                                上传图片，最大500kb
                            </div>
                        </template>
                    </el-upload>
                </el-form-item>
            </el-form>
            <template #footer>
                <div class="dialog-footer">
                    <el-button type="primary" @click="submitForm">确 定</el-button>
                    <el-button @click="cancel">取 消</el-button>
                </div>
            </template>
        </el-dialog>


        <!--        添加章节弹框-->
        <el-dialog :title="title" v-model="openupload" width="500px" append-to-body>
            <el-form ref="chaptersRef" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="课程id" prop="courseId">
                    <el-input disabled v-model="form.courseId" placeholder=""/>
                </el-form-item>
                <el-form-item label="章节标题" prop="chapterTitle">
                    <el-input v-model="form.chapterTitle" placeholder="请输入章节标题"/>
                </el-form-item>
                <el-form-item label="章节描述" prop="chapterDescription">
                    <el-input v-model="form.chapterDescription" placeholder="请输入章节描述"/>
                </el-form-item>
                <el-form-item label="视频链接" prop="videoUrl">
                    <el-tag v-if="data.form.videoUrl">已上传</el-tag>
                    <el-upload
                        style="width: 100%;"
                        v-else
                        class="upload-demo"
                        drag
                        multiple
                        accept="video/*"
                        :http-request="handleUpload"
                        :on-success="handleSuccess"
                    >
                        <el-icon class="el-icon--upload"><upload-filled /></el-icon>
                        <div class="el-upload__text">
                            将文件拖拽进来 <em>或 点击上传</em>
                        </div>
                        <template #tip>
                            <div class="el-upload__tip">
                                上传视频文件，最大200MB
                            </div>
                        </template>
                    </el-upload>
                </el-form-item>

                <el-form-item label="章节顺序" prop="position">
                    <el-input v-model="form.position" placeholder="请输入章节顺序"/>
                </el-form-item>
            </el-form>
            <template #footer>
                <div class="dialog-footer">
                    <el-button type="primary" @click="submitupload">确 定</el-button>
                    <el-button @click="cancel">取 消</el-button>
                </div>
            </template>
        </el-dialog>
    </div>
</template>

<script setup name="Course">
import {listCourse, addChapters ,getCourse, delCourse, addCourse, updateCourse} from "@/api/course/course";

const {proxy} = getCurrentInstance();
const {course_category} = proxy.useDict('course_category');

const courseList = ref([]);
const open = ref(false);
const openupload = ref(false);
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
        courseName: null,
        courseDescription: null,
        userId: null,
        createdAt: null,
        updatedAt: null,
        teacher: null,
        courseCategory: null,
        chapterId: null,
        courseId: null,
        chapterTitle: null,
        chapterDescription: null,
        videoUrl: null,
        position: null,
    },
    rules: {}
});

const {queryParams, form, rules} = toRefs(data);

//上传
import axios from 'axios'

const baseUrl = import.meta.env.SERVER_ADDRESS  // 动态读取环境变量

const fileList = ref([])
// 自定义上传函数
const handleUpload = async (options) => {
    const formData = new FormData()
    formData.append('file', options.file)

    try {
        const response = await axios.post(`${baseUrl}/file/upload`, formData, {
            headers: {'Content-Type': 'multipart/form-data'}
        }).then(res => {
            data.form.videoUrl = res.data
            console.log(data.form.videoUrl)
        })
        options.onSuccess && options.onSuccess(response.data)
    } catch (error) {
        options.onError && options.onError(error)
    }
}
const handleUploadImg = async (options) => {
    const formData = new FormData()
    formData.append('file', options.file)

    try {
        const response = await axios.post(`${baseUrl}/file/upload`, formData, {
            headers: {'Content-Type': 'multipart/form-data'}
        }).then(res => {
            data.form.courseImg = res.data
            console.log(data.form.courseImg)
        })
        options.onSuccess && options.onSuccess(response.data)
    } catch (error) {
        options.onError && options.onError(error)
    }
}
const handleSuccess = (response) => {
    console.log("上传成功"+response)
    ElMessage({
        message: '上传成功',
        type: 'success',
    })
}




/** 查询course列表 */
function getList() {
    loading.value = true;
    listCourse(queryParams.value).then(response => {
        courseList.value = response.rows;
        total.value = response.total;
        loading.value = false;
    });
}

// 取消按钮
function cancel() {
    openupload.value = false
    open.value = false;
    reset();
}

// 表单重置
function reset() {
    form.value = {
        courseId: null,
        courseName: null,
        courseDescription: null,
        userId: null,
        createdAt: null,
        updatedAt: null,
        teacher: null,
        courseCategory: null,
        courseImg: null
    };
    proxy.resetForm("courseRef");
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
    ids.value = selection.map(item => item.courseId);
    single.value = selection.length != 1;
    multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
    reset();
    open.value = true;
    title.value = "添加course";
}

/** 修改按钮操作 */
function handleUpdate(row) {
    reset();
    const _courseId = row.courseId || ids.value
    getCourse(_courseId).then(response => {
        form.value = response.data;
        open.value = true;
        title.value = "修改course";
    });
}

/** 提交按钮 */
function submitForm() {
    proxy.$refs["courseRef"].validate(valid => {
        if (valid) {
            if (form.value.courseId != null) {
                updateCourse(form.value).then(response => {
                    proxy.$modal.msgSuccess("修改成功");
                    open.value = false;
                    getList();
                });
            } else {
                addCourse(form.value).then(response => {
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
    const _courseIds = row.courseId || ids.value;
    proxy.$modal.confirm('是否确认删除course编号为"' + _courseIds + '"的数据项？').then(function () {
        return delCourse(_courseIds);
    }).then(() => {
        getList();
        proxy.$modal.msgSuccess("删除成功");
    }).catch(() => {
    });
}

/** 上传章节按钮操作 */
function Upload(row) {
    reset();
    // console.log(row);
    openupload.value = true;
    this.form.courseId = row.courseId;
}

/** 上传章节弹框的提交按钮 */
function submitupload() {
    // console.log(form.value)
    addChapters(form.value).then(response => {
        proxy.$modal.msgSuccess("新增成功");
        openupload.value = false;
        getList();
    });
}


/** 导出按钮操作 */
function handleExport() {
    proxy.download('course/course/export', {
        ...queryParams.value
    }, `course_${new Date().getTime()}.xlsx`)
}

getList();
</script>
