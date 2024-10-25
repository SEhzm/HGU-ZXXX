<template>
  <div class="app-container">
    <!-- 首行搜索功能 -->

    <el-row type="flex" class="search-container" justify="center">
      <el-col :span="14">
        <div class="search">
          <el-input
            placeholder="请输入"
            v-model="queryKeyName"
            @keyup.enter="courseListQuery(queryKeyName)"
          />
          <el-button type="primary" @click="courseListQuery(queryKeyName)">
            <i-ep-search />
            搜索
          </el-button>
        </div>

        <div class="category-buttons">
          分类
          <el-tag
            class="category-tag"
            @click.native="tagClick(category.name)"
            v-for="category in typeList"
            :key="category"
          >
            {{ category.name }}
          </el-tag>
        </div>
      </el-col>
    </el-row>

    <!-- 数据卡片 -->
    <div>
      {{ typeName }}
      <el-row :gutter="24">
        <el-col :xs="24" :sm="12" :lg="6" v-for="course in courseList">
          <div class="data-card" @click.native="studyDataClick(course)">
            <img :src="course.img" width="100%" height="170" />
            <div class="data-card-text">
              <div class="text-name">{{ course.name }}</div>
              <div>
                <el-tag class="category-tag">
                  {{ course.courseTypeName }}
                </el-tag>
                <el-tag class="category-tag back">
                  好评率{{ course.courseEvaluate }}
                </el-tag>
              </div>
              <div class="text-date">{{ course.createTime }}</div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script setup lang="ts">
defineOptions({
  name: "Show",
  inheritAttrs: false,
});

import CourseAPI, { CourseTypeVO, StudyCourseVO } from "@/api/course";
import DictAPI, { DictPageQuery } from "@/api/dict";
import router from "@/router";

// 课程类型列表
const typeList = ref<CourseTypeVO[]>();

// 课程列表数据
const courseList = ref<StudyCourseVO[]>();

// 字典课程分类参数
const queryParams = reactive<DictPageQuery>({
  pageNum: 1,
  pageSize: 10,
  typeCode: "course",
});

// 当前展示课程列表类型
const typeName = ref("全部");

// 查询条件信息
const queryKeyName = ref("");

function tagClick(tagName: string) {
  queryKeyName.value = "";
  CourseAPI.getCourseList(tagName, null)
    .then((data: StudyCourseVO[] | undefined) => {
      courseList.value = data;
    })
    .finally(() => {
      if (tagName === "") {
        typeName.value = "全部";
      } else {
        typeName.value = tagName;
      }
    });
}

function studyDataClick(course: StudyCourseVO) {
  // console.log("这是点击的课程信息", JSON.stringify(course));
  router.push({
    name: "Details",
    query: {
      id: course.id,
      name: course.name,
      courseTypeName: course.courseTypeName,
      img: course.img,
    },
  });
}

/** 查询课程类型 */
function typeListQuery() {
  DictAPI.getPage(queryParams).then((data) => {
    typeList.value = data.list[0].dictItems;
  });
}

/** 查询课程列表 */
function courseListQuery(queryKeyName: string) {
  CourseAPI.getCourseList(null, queryKeyName)
    .then((data: StudyCourseVO[] | undefined) => {
      if (data?.length === 0) {
        open(queryKeyName);
      }
      courseList.value = data;
    })
    .finally(() => {
      if (queryKeyName === "") {
        typeName.value = "全部";
      } else {
        typeName.value = "";
      }
    });
}

function open(queryKeyName: string) {
  ElNotification({
    title: "Info",
    message: "不存在【" + queryKeyName + "】课程名字的课程",
    type: "info",
  });
}

onMounted(() => {
  typeListQuery();
  courseListQuery(queryKeyName.value);
});
</script>

<style lang="scss" scoped>
.search-container {
  align-content: center;
  height: 110px;
  padding-bottom: 20px;
}

.search {
  display: flex;
  /* 使用Flexbox布局 */
  align-items: center;
  /* 垂直居中 */
  justify-content: center;
  /* 水平居中 */
}

.category-buttons {
  margin-top: 14px;
  height: 16px;
  font-weight: 500;
  font-size: 12px;
}

.category-tag {
  margin-right: 10px;
  color: #1966e0;
  font-weight: 600;
  cursor: pointer;
}

.data-card {
  background: #ffffff;
  border-radius: 2px;
  border: 1px solid #e9e9e9;
  margin-bottom: 24px;
  // height: 200px;
}

.data-card-text {
  margin-left: 24px;
}

.data-card-text div {
  margin-top: 10px;
}

.text-name {
  font-weight: 550;
}

.text-date {
  font-size: 12px;
  color: rgba(0, 0, 0, 0.45);
  margin-bottom: 20px;
}

.back {
  background: #ffe2b0;
  font-family:
    PingFangSC,
    PingFang SC;
  font-weight: 500;
  color: #5d3b00;
}
</style>
