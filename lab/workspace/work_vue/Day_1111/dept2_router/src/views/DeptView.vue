<template>
  <div class="container" id="deptView">
    <h1>부서 관리</h1>
    <dept-list :refresh="refresh"></dept-list>
    <router-view @change-data="refreshData" :refresh="refresh"></router-view>
    <!-- <dept-form v-show="mode == 'register'" @change-data="refreshData"></dept-form>
    <dept-detail :deptno="deptno" @change-data="refreshData" v-show="mode == 'detail'"></dept-detail> -->
  </div>
</template>

<script>
import DeptList from "@/components/DeptList.vue";

export default {
  data() {
    return {
      mode: "register",
      deptno: 0,
      refresh: new Date().getTime(),
    };
  },
  components: {
    DeptList,
  },
  methods: {
    refreshData() {
      this.refresh = new Date().getTime();
      console.log(`refresh reset`);
    },
  },
};
</script>

<style>
</style>