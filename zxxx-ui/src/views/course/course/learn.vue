<template>
    <div class="card text-main">
        <span style="font-size: 25px;margin: 15px">{{ data.courseName }}</span>
        <span style="font-size: 25px">{{ chapterInfo.chapterTitle }}</span>
        <el-tag round size="large" style="margin-left: 30px;font-size: 16px">讲师：{{ data.teacher }}</el-tag>
        <el-tag type="info" style="margin-left: 50px">类别：{{ courseCategory }}</el-tag>
    </div>
    <div class="main card">
        <div id="player"></div>
        <div class="card chat">
            <div style="height: 500px;" v-if="courseId&&chapterId">
                <el-button @click="closeWebSocket">关闭连接</el-button>
                <el-button @click="reconnectWebSocket">重新连接</el-button>
                <div id="message-container" ref="messageContainer">
                    <div v-for="(msg, index) in messages" :key="index"
                         :class="{ 'message-bubble': true, 'mine': msg.isMine, 'others': !msg.isMine }">
                        <span class="time">{{ msg.time }}</span>
                        <p>{{ msg.text }}</p>
                    </div>
                </div>
                <el-input id="text" type="text" v-model="message" maxlength="30" placeholder="请输入内容" />
                <el-button v-loading="ChatRoomLoading" class="btn-animate btn-animate__vibrate" type="primary"
                           @click="send">发送消息</el-button>
            </div>
        </div>
    </div>
    <div class="chaptersSelect">
        <div class="card chapters">
            <span style="font-size: 21px;font-family: 黑体">章节选择</span>
            <el-table stripe :data="courseData.tableData" style="width: 980px;cursor:pointer" @row-click="jumpToChapter">
                <el-table-column prop="chapterTitle" label="章节标题" width="280"/>
                <el-table-column show-overflow-tooltip prop="chapterDescription" label="章节描述" width="700"/>
                </el-table>
        </div>
        <div style="width: 30px"><!--  占位置的div  --></div>
        <div class="card course-introduction"><span style="font-size: 20px">课程简介</span>
            <p>{{ data.courseDescription }}</p>
        </div>
    </div>
</template>

<script setup lang="ts">
import {ref, onMounted, watch, reactive, toRefs, computed,onBeforeUnmount} from 'vue';
import {useRoute, useRouter} from "vue-router";
import {getCourse} from '@/api/course/course';
import {listChapters, getChapters} from "@/api/course/chapters";
import { ElMessage, ElMessageBox } from 'element-plus';
// 引入西瓜播放器
import "xgplayer/dist/index.min.css";
import Player from 'xgplayer';

const {proxy} = getCurrentInstance();
const {course_category} = proxy.useDict('course_category');
const route = useRoute();
const courseId = ref(null);
const chapterId = ref(null);
const courseCategory = ref(null);
const router = useRouter();
const data = ref({});
const chaptersList = ref([]);
const total = ref(0);
const loading = ref(true);
const videoUrl = ref('');
const chapterInfo = ref({});

const courseData = reactive({
    tableData: [],
})

const courseChapters = reactive({
    queryParams: {
        pageNum: 1,
        pageSize: 10,
        courseId: null,
        chapterTitle: null,
        chapterDescription: null,
        videoUrl: "",
        position: null,
        createdAt: null,
        updatedAt: null
    },
});
const {queryParams} = toRefs(courseChapters);

onMounted(async () => {
    const id = route.query.courseId;
    queryParams.value.courseId = id;
    chapterId.value = route.query.chapterId;
    courseId.value = id;

    // 确保courseId和chapterId有值
    if (courseId.value && chapterId.value) {
        await getCourseDetail(courseId.value);

        // 获取章节列表
        await listChapters(queryParams.value).then(response => {
            courseData.tableData = response.rows;
            console.log(courseData.tableData);
            chaptersList.value = response.rows;
            total.value = response.total;
            loading.value = false;
        });

        // 获取章节视频
        await getChapters(chapterId.value).then(res => {
            chapterInfo.value = res.data;
            videoUrl.value = res.data.videoUrl.replace('https://', '');
            initializePlayer(videoUrl.value);
        });

        courseCategory.value = handleIndexType(data.value.courseCategory);

        // 连接WebSocket
        websocket.value = new WebSocket(`ws://localhost:9800/ws/${courseId.value}+${chapterId.value}+${clientId.value}`);

        // 设置WebSocket回调
        websocket.value.onerror = onWebSocketError;
        websocket.value.onopen = onWebSocketOpen;
        websocket.value.onmessage = onWebSocketMessage;
        websocket.value.onclose = onWebSocketClose;
    }
});


/**
 * 作用：从course_category字典里选出与data对应的label显示
 * 注意：如果这个函数最后返回的是undefined,undefined在模板上是不显示的
 */
const handleIndexType = (data) => {
    return course_category.value.find((item) => {
        return item.value === data;
    })?.label;
};

//跳转到新章节
const jumpToChapter = (row) => {
    // console.log(row.courseId);
    // console.log(row.chapterId);
    router.push(`/study/learn?courseId=${row.courseId}&chapterId=${row.chapterId}`);
}

//获取课程详情
const getCourseDetail = async (courseId) => {
    try {
        const res = await getCourse(courseId);
        data.value = res.data;
    } catch (error) {
    }
};

watch(videoUrl, (newUrl) => {
    if (newUrl) {
        initializePlayer(newUrl);
    }
});
//西瓜视频播放器
const initializePlayer = (url) => {
    const player = new Player({
        id: 'player',
        url: `http://${url}`,
        width: 1000,
        height: 525,
        autoplay: false,
        poster: `${data.value.courseImg}`, // 封面图
        lang: "zh-cn", // 设置中文
        lastPlayTime: 0, // 视频起播时间（单位：秒）
        lastPlayTimeHideDelay: 5, // 提示文字展示时长（单位：秒）
        closeVideoClick: false, // true - 禁止pc端单击暂停，反之
        closeVideoTouch: true, // true - 禁止移动端单击暂停，反之
        fluid: true, // 填满屏幕
        loop: false, // 循环播放
        pip: true,
        volume: 0.5, // 音量 0 -  1
        playbackRate: [2, 1.5, 1.25, 1, 0.75, 0.5], // 传入倍速可选数组
        rotateFullscreen: true,
    });
};

/**
 * 下方是聊天室的完整代码
 */

interface Message {
    text: string;
    isMine: boolean;
    time: string;
}
interface WebSocketData {
    type: string;
    message?: string;
    count?: number;
}

const websocket = ref<WebSocket | null>(null);
const clientId = ref<string>(Math.random().toString(36).substr(2)); //随机值
const message = ref<string>('');
const messages = ref<Message[]>([]);
const userId = ref<string>('');

const ChatRoomLoading = ref<boolean>(false);
const messageContainer = ref<HTMLElement | null>(null); // 引用消息容器


// 连接发生错误的回调方法
const onWebSocketError = () => {
    messages.value.push({ text: 'error', isMine: false, time: getCurrentTime() });
};

// 连接成功建立的回调方法
const onWebSocketOpen = () => {
    scrollToBottom();
    messages.value.push({ text: '连接成功', isMine: false, time: getCurrentTime() });
};

// 接收到消息的回调方法
const onWebSocketMessage = (event: MessageEvent) => {
    try {
        const data: WebSocketData = JSON.parse(event.data);
        if (data.type === 'serverMessage' && data.message) {
            messages.value.push({ text: data.message, isMine: false, time: getCurrentTime() });
        } else if (data.type === 'clientMessage' && data.message) {
            const isMine = data.userId === userId.value;
            const userMessage = `${data.message}`;
            messages.value.push({ text: userMessage, isMine, time: getCurrentTime() });
        } else {
            console.error('未知的消息类型:', data);
        }
    } catch (error) {
        console.error('解析消息失败:', event.data, error);
        messages.value.push({ text: '解析消息失败', isMine: false, time: getCurrentTime() });
    }
};

// 连接关闭的回调方法
const onWebSocketClose = () => {
    messages.value.push({ text: '连接已关闭', isMine: false, time: getCurrentTime() });
};

// 发送消息
const send = async () => {
    ChatRoomLoading.value = true;
    if (websocket.value && websocket.value.readyState === WebSocket.OPEN) {
        if (message.value.trim() !== '') {
            websocket.value.send(JSON.stringify({
                type: 'clientMessage',
                message: message.value,
                userId: userId.value,
                time: getCurrentTime()
            }));
            message.value = ''; // 清空输入框
            scrollToBottom(); // 滚动到最底部
        } else {
            ElMessageBox.alert('请输入内容', '🫡', {
                confirmButtonText: 'OK',
            });
        }
        ChatRoomLoading.value = false;
    } else {
        ElMessageBox.alert('🫡请点击重新连接', '连接未打开', {
            confirmButtonText: 'OK',
        });
        ChatRoomLoading.value = false;
    }
};

// 关闭连接
const closeWebSocket = () => {
    if (websocket.value && websocket.value.readyState === WebSocket.OPEN) {
        websocket.value.close();
    }
};

// 重新连接
const reconnectWebSocket = () => {
    if (!websocket.value || websocket.value.readyState !== WebSocket.CONNECTING) {
        websocket.value = new WebSocket(`ws://localhost:9800/ws/${clientId.value}`);
        websocket.value.onerror = onWebSocketError;
        websocket.value.onopen = onWebSocketOpen;
        websocket.value.onmessage = onWebSocketMessage;
        websocket.value.onclose = onWebSocketClose;
    }
};

// 获取当前时间
const getCurrentTime = (): string => {
    const now = new Date();
    const year = now.getFullYear();
    const month = String(now.getMonth() + 1).padStart(2, '0');
    const day = String(now.getDate()).padStart(2, '0');
    const hours = String(now.getHours()).padStart(2, '0');
    const minutes = String(now.getMinutes()).padStart(2, '0');
    const seconds = String(now.getSeconds()).padStart(2, '0');

    return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
};

// 滚动到最底部
const scrollToBottom = () => {
    if (messageContainer.value) {
        setTimeout(() => {
            messageContainer.value?.scrollTo({
                top: messageContainer.value.scrollHeight,
                behavior: 'smooth',
            });
        }, 20);
    }
};

// 监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接
onBeforeUnmount(() => {
    closeWebSocket();
});

onMounted(() => {
    if (websocket.value) {
        websocket.value.onerror = onWebSocketError;
        websocket.value.onopen = onWebSocketOpen;
        websocket.value.onmessage = onWebSocketMessage;
        websocket.value.onclose = onWebSocketClose;
    }
});
</script>
<style scoped>
@import "@/assets/styles/chatRoomCss.scss";
@media (min-width: 601px) {
    #player {
        width: 1000px;
        height: 591px;
    }

    .text-main {
        margin: 20px 50px;
    }

    .main {
        display: flex;
        align-items: flex-start;
        width: 1000px;
        margin: 20px 50px;
    }

    .chat {
        width: 400px;
        position: absolute;
        margin-left: 1020px;
    }

    .chaptersSelect {
        display: table;
        margin: 20px 50px;
        width: 1430px
    }

    .chapters {
        display: table-cell;
        height: 200px;
        width: 1000px;

    }

    .course-introduction {
        display: table-cell;
        width: 500px;
    }
}
</style>
