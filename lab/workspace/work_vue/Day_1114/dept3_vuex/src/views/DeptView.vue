<template>
  <div class="container" id="deptView">
    <h1>부서 관리</h1>
    <dept-list></dept-list>
    <router-view></router-view>
  </div>
</template>

<script>
import DeptList from "@/components/DeptList.vue";

export default {
  components: {
    DeptList,
  },
};
</script>

<style></style>
