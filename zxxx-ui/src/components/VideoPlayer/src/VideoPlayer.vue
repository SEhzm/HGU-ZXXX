<template>
  <div ref="videoEl" style="width: 100%; height: 100%"></div>
</template>

<script setup lang="ts">
import Player from "xgplayer";
import {nextTick, onBeforeUnmount, onMounted, ref, unref, watch} from "vue";
import "xgplayer/dist/index.min.css";

const props = defineProps({
  url: {
    type: String,
    default: "",
    required: true,
  },
  poster: {
    type: String,
    default: "",
  },
  width: {
    type: String,
    default: "100%",
  },
  height: {
    type: String,
    default: "100%",
  },
});

const playerRef = ref<Player>();

const videoEl = ref<HTMLDivElement>();

const intiPlayer = () => {
  if (!unref(videoEl)) return;
  new Player({
    autoplay: false,
    ...props,
    el: unref(videoEl),
  });
};

onMounted(() => {
  intiPlayer();
});

watch(
  () => props,
  async (newProps) => {
    await nextTick();
    if (newProps) {
      unref(playerRef)?.setConfig(newProps);
    }
  },
  {
    deep: true,
  }
);

onBeforeUnmount(() => {
  unref(playerRef)?.destroy();
});

defineExpose({
  playerExpose: () => unref(playerRef),
});
</script>
