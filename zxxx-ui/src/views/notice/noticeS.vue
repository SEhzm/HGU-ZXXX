<template>
    <div style="margin-left: 20px">
        <el-table :data="noticeList" style="width: 100%; cursor: pointer;font-size: 17px"
                  :row-style="{ height: '80px' }" @row-click="openDig">
            <el-table-column prop="" label="" min-width="100"></el-table-column>
            <el-table-column prop="" label="" min-width="5">◉</el-table-column>
            <el-table-column prop="noticeTitle" label="公告/通知标题" min-width="300"/>
            <el-table-column show-overflow-tooltip prop="create_time" label="时间" min-width="200">
                <template #default="scope">
                    <span>{{ parseTime(scope.row.create_time, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
                </template>
            </el-table-column>
        </el-table>
        <div class="pagination-container">
            <pagination
                v-show="total > 0"
                layout="prev, pager, next"
                background
                :total="total"
                v-model:page="queryParams.pageNum"
                v-model:limit="queryParams.pageSize"
                @pagination="handlePagination"
            />
        </div>
    </div>

    <el-dialog :title="'公告详情'" v-model="open" width="1380px" append-to-body class="notice">
        <h2 style="text-align: center">{{ form.noticeTitle }} <el-tag size="large" style="margin-left: 10px;font-size: 17px">{{ form.noticeType === '1' ? '通知' : '公告' }}</el-tag></h2>
        <br>
        <p style="text-align: center"><span>发布时间：{{ parseTime(form.create_time, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
            <span style="margin-left: 25px">作者：{{ form.create_by }}</span></p>
        <br><br>
        <p v-html="form.noticeContent" style="text-indent: 2em"></p>
        <el-button @click="open= false" class="dialog-footer">关 闭</el-button>
    </el-dialog>
</template>

<script setup>
import {ref, onMounted, reactive, toRefs} from 'vue';
import {listNotice} from '@/api/notice/notice.js';
import {parseTime} from '../../utils/ruoyi.js';

const open = ref(false);
const total = ref(0);
const data = reactive({
    form: {},
    queryParams: {
        pageNum: 1,
        pageSize: 8
    },
});
const {queryParams, form} = toRefs(data);
const noticeList = ref([]);

const handlePagination = () => {
    listNotice(queryParams.value).then(res => {
        noticeList.value = res.rows;
        total.value = res.total;
    });
};
const openDig = (row) => {
    open.value = true;
    form.value = row;
    console.log(form)
}

onMounted(() => {
    handlePagination();
});
</script>

<style scoped>
.dialog-footer {
    font-size: 20px;
    width: 100%;
    height: 50px;
}

.notice {
    display: flex;
    justify-content: center;
}

.el-table__body {
    border-spacing: 0px 6px !important;
}

:deep .el-table, .el-table__expanded-cell {
    background-color: transparent;
}

.pagination-container {
    display: flex;
    justify-content: center;
    margin-top: 10px;
}
</style>
