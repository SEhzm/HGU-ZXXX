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
            <el-form-item label="章节标题" prop="chapterTitle">
                <el-input
                    v-model="queryParams.chapterTitle"
                    placeholder="请输入章节标题"
                    clearable
                    @keyup.enter="handleQuery"
                />
            </el-form-item>
            <el-form-item label="章节描述" prop="chapterDescription">
                <el-input
                    v-model="queryParams.chapterDescription"
                    placeholder="请输入章节描述"
                    clearable
                    @keyup.enter="handleQuery"
                />
            </el-form-item>
            <el-form-item label="视频链接" prop="videoUrl">
                <el-input
                    v-model="queryParams.videoUrl"
                    placeholder="请输入视频链接"
                    clearable
                    @keyup.enter="handleQuery"
                />
            </el-form-item>
            <el-form-item label="章节顺序" prop="position">
                <el-input
                    v-model="queryParams.position"
                    placeholder="请输入章节顺序"
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
                    v-hasPermi="['course:chapters:add']"
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
                    v-hasPermi="['course:chapters:edit']"
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
                    v-hasPermi="['course:chapters:remove']"
                >删除
                </el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="warning"
                    plain
                    icon="Download"
                    @click="handleExport"
                    v-hasPermi="['course:chapters:export']"
                >导出
                </el-button>
            </el-col>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="chaptersList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center"/>
            <el-table-column label="章节id" align="center" prop="chapterId"/>
            <el-table-column label="课程id" align="center" prop="courseId"/>
            <el-table-column label="章节标题" align="center" prop="chapterTitle"/>
            <el-table-column label="章节描述" align="center" prop="chapterDescription" show-overflow-tooltip/>
            <el-table-column label="视频链接" align="center" prop="videoUrl" show-overflow-tooltip/>

            <el-table-column label="章节顺序" align="center" prop="position"/>
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
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template #default="scope">
                    <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
                               v-hasPermi="['course:chapters:edit']">修改
                    </el-button>
                    <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                               v-hasPermi="['course:chapters:remove']">删除
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

        <!-- 添加或修改course_chapters对话框 -->
        <el-dialog :title="title" v-model="open" width="500px" append-to-body>
            <el-form ref="chaptersRef" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="课程id" prop="courseId">
                    <el-input v-model="form.courseId" placeholder="请输入课程id"/>
                </el-form-item>
                <el-form-item label="章节标题" prop="chapterTitle">
                    <el-input v-model="form.chapterTitle" placeholder="请输入章节标题"/>
                </el-form-item>
                <el-form-item label="章节描述" prop="chapterDescription">
                    <el-input v-model="form.chapterDescription" placeholder="请输入章节描述"/>
                </el-form-item>

                <el-form-item label="视频文件" prop="videoUrl">
                    <el-tag v-if="data.form.videoUrl">已上传</el-tag>
                    <el-upload
                        v-else
                        class="upload-demo"
                        drag
                        action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
                        multiple
                        :http-request="handleUpload"
                        :on-success="handleSuccess"
                    >
                        <el-icon class="el-icon--upload"><upload-filled /></el-icon>
                        <div class="el-upload__text">
                            Drop file here or <em>click to upload</em>
                        </div>
                        <template #tip>
                            <div class="el-upload__tip">
                                上传mp4文件，最大200MB
                            </div>
                        </template>
                    </el-upload>
                </el-form-item>
                <!--                <el-form-item label="视频链接" prop="videoUrl">-->
                <!--                    <el-input v-model="form.videoUrl" placeholder="请输入视频链接"/>-->
                <!--                </el-form-item>-->
                <el-form-item label="章节顺序" prop="position">
                    <el-input v-model="form.position" placeholder="请输入章节顺序"/>
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

<script setup name="Chapters">
import {listChapters, getChapters, delChapters, addChapters, updateChapters} from "@/api/course/chapters";
import {ElMessage} from 'element-plus'

const {proxy} = getCurrentInstance();

const chaptersList = ref([]);
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
        chapterTitle: null,
        chapterDescription: null,
        videoUrl: null,
        position: null,
        createdAt: null,
        updatedAt: null
    },
    rules: {}
});

const {queryParams, form, rules} = toRefs(data);
//上传
import axios from 'axios'

const baseUrl = 'http://localhost:9800'  // 动态读取环境变量

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
const handleSuccess = (response) => {
    console.log("上传成功"+response)
    ElMessage({
        message: '上传成功',
        type: 'success',
    })
}


/** 查询course_chapters列表 */
function getList() {
    loading.value = true;
    listChapters(queryParams.value).then(response => {
        chaptersList.value = response.rows;
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
        chapterId: null,
        courseId: null,
        chapterTitle: null,
        chapterDescription: null,
        videoUrl: null,
        position: null,
        createdAt: null,
        updatedAt: null
    };
    proxy.resetForm("chaptersRef");
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
    ids.value = selection.map(item => item.chapterId);
    single.value = selection.length != 1;
    multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
    reset();
    open.value = true;
    title.value = "添加course_chapters";
}

/** 修改按钮操作 */
function handleUpdate(row) {
    reset();
    const _chapterId = row.chapterId || ids.value
    getChapters(_chapterId).then(response => {
        form.value = response.data;
        open.value = true;
        title.value = "修改course_chapters";
    });
}

/** 提交按钮 */
function submitForm() {
    proxy.$refs["chaptersRef"].validate(valid => {
        if (valid) {
            if (form.value.chapterId != null) {
                updateChapters(form.value).then(response => {
                    proxy.$modal.msgSuccess("修改成功");
                    open.value = false;
                    getList();
                });
            } else {
                addChapters(form.value).then(response => {
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
    const _chapterIds = row.chapterId || ids.value;
    proxy.$modal.confirm('是否确认删除course_chapters编号为"' + _chapterIds + '"的数据项？').then(function () {
        return delChapters(_chapterIds);
    }).then(() => {
        getList();
        proxy.$modal.msgSuccess("删除成功");
    }).catch(() => {
    });
}

/** 导出按钮操作 */
function handleExport() {
    proxy.download('course/chapters/export', {
        ...queryParams.value
    }, `chapters_${new Date().getTime()}.xlsx`)
}

getList();
</script>
