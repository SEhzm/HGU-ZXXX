<template>
  <div class="dashboard-container">
    <div class="details">
      <div class="details-title">
        <span class="course_courseName">
          {{ courseName }}
        </span>
        <el-tag class="course_typeName">
          {{ typeName }}
        </el-tag>
        <el-tag class="course_evaluate">
          {{ evaluate }}
        </el-tag>
      </div>

      <el-row :gutter="20" class="mt-5 details-video">
        <el-col :xs="24" :span="17">
          <div class="player-container">
            <VideoPlayer :key="videoKey" :url="videoImg" :poster="videopic" />
          </div>
        </el-col>
        <el-col :xs="24" :span="7">
          <el-card>
            <template #header>
              <div class="flex-x-between">
                <div class="flex-y-center">章节目录</div>
              </div>
            </template>

            <el-scrollbar style="height: 300px">
              <div
                v-for="(item, index) in detailsList"
                :key="index"
                class="flex-y-center py-3 text-color"
                :class="{ active_class: activeIndex === index }"
                @click="defScrollbar(item, index)"
              >
                <el-icon class="text-sm">
                  <video-play />
                </el-icon>
                <el-text
                  truncated
                  class="!mx-2 flex-1 !text-xs !text-[var(--el-text-color-secondary)]"
                >
                  {{ item.chapterTitle }}
                </el-text>
                <el-icon class="text-sm">
                  <View />
                </el-icon>
                {{ item.chapterView }}
              </div>
            </el-scrollbar>
          </el-card>
        </el-col>
      </el-row>
    </div>

    <div shadow="never" class="tabs">
      <el-tabs v-model="activeName">
        <el-tab-pane label="课程详情" name="first">
          <div class="course-desc">{{ courseDesc }}</div>
        </el-tab-pane>
        <el-tab-pane label="评价" name="second">{{ courseE }}</el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script setup lang="ts">
defineOptions({
  name: "Details",
  inheritAttrs: false,
});
import { VideoPlayer } from "@/components/VideoPlayer";
import { useRoute } from "vue-router";
import CourseAPI, { StudyCourseDetailsVO, StudyCourseVO } from "@/api/course";

const courseName = ref("软件工程概论");
const typeName = ref("项目管理");
const evaluate = ref("好评率99%");

const courseDesc = ref("课程详情介绍数据");
const courseE = ref("好评率99%");

const activeName = ref("first");

const activeIndex = ref(0);

const videoKey = ref(0);
const videoImg = ref("https://co-code.cn/videos/estimate-tool.mp4");
const videopic = ref("");

const routeParam = ref<StudyCourseVO>();

const defParam = reactive({
  id: 1,
  name: "软件工程概论",
  courseTypeName: "项目管理",
});

// 课程详情列表
const detailsList = ref<StudyCourseDetailsVO[]>();

const route = useRoute();

// 章节目录点击
function defScrollbar(item: StudyCourseDetailsVO, index: number) {
  activeIndex.value = index;
  videoImg.value = item.videoAddress;
  courseDesc.value = item.courseDetails;
  courseE.value = item.chapterEvaluate;
  // 执行接口修改浏览量
  detailsList.value[index].chapterView += 1;
  CourseAPI.updateCourseDetailsView(item.id);
  videopic.value = routeParam.value.img;
  videoKey.value += 1;
}

/** 查询课程详情信息 */
function detailsListQuery(courseId: number) {
  console.log(courseId);
  CourseAPI.getCourseDetails(courseId)
    .then((data) => {
      detailsList.value = data;

      if (data.length > 0) {
        videoImg.value = data[0].videoAddress;
        courseDesc.value = data[0].courseDetails;
        courseE.value = data[0].chapterEvaluate;
      } else {
        videoImg.value =
          "http://power-api.cretinzp.com:8000/girls/35/6pvpk8fcs3tjojpq.jpg";
        courseDesc.value = "暂时没有详情";
        courseE.value = "暂无评价";
      }
    })
    .finally(() => {});
}

function initQuery(param: StudyCourseVO) {
  routeParam.value = param;
  courseName.value = routeParam.value.name;
  typeName.value = routeParam.value.courseTypeName;
  videopic.value = routeParam.value.img;

  detailsListQuery(routeParam.value.id);
  videoKey.value += 1;
}

onBeforeUpdate(() => {
  console.log("这是请求的信息", routeParam.value.id, "---", route.query.id);
  if (
    route.query.id != undefined &&
    routeParam.value.id + "" != route.query.id
  ) {
    console.log("更新信息");
    initQuery(route.query);
  }
});

onMounted(() => {
  console.log("每次打开页面都会调用方法", route.query);
  if (route.query.id != undefined) {
    initQuery(route.query);
  } else {
    initQuery(defParam);
  }
});
</script>

<style lang="scss" scoped>
.dashboard-container {
  position: relative;
  padding: 24px;
}

.details {
  margin-top: -10px;
  background: #fff;
  border: 1px solid #dddfe7;
  margin-bottom: 15px;
}

.details-title {
  height: 50px;
  align-items: center;
  padding-top: 13px;
  box-shadow: 0px 1px 0px 0px #e9eaef;
}

.course_courseName {
  width: 144px;
  height: 24px;
  font-weight: 600;
  font-size: 24px;
  color: rgba(0, 0, 0, 0.85);
  line-height: 24px;
  margin: 24px;
}

.course_typeName {
  margin-right: 10px;
  color: #1966e0;
  font-weight: 600;
  cursor: pointer;
}

.course_evaluate {
  background: #ffe2b0;
  font-family:
    PingFangSC,
    PingFang SC;
  font-weight: 500;
  color: #5d3b00;
}

.details-video {
  height: 437px;
}

.details-video img {
  margin-top: -10px;
  padding-left: 10px;
  padding-bottom: 10px;
}

.flex-1 {
  cursor: pointer;
}

.el-card__body {
  padding-right: 50px;
}

.tabs {
  padding-left: 30px;
  border: 1px solid #e0e2e9;
  height: 320px;
  background-color: #fff;
}

.text-color {
  color: #55aaff;
  padding-right: 13px;
  padding-left: 10px;
  border-radius: 10px;
}

.active_class {
  background: #ffe4be;
}

.player-container {
  width: 100%;
  /* 设置宽度 */
  height: 100%;
  /* 设置高度 */
  background: #55aaff;
}

.course-desc {
  white-space: pre-wrap;
  /* 保留空格和换行 */
}
</style>
