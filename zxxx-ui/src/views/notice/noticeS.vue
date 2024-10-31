<template>
1

</template>

<script setup>
import {ref, onMounted, watch, reactive, toRefs, computed,onBeforeUnmount} from 'vue';
import { listNotice } from '@/api/notice/notice.js'
listNotice()
</script>


<style scoped>


</style>