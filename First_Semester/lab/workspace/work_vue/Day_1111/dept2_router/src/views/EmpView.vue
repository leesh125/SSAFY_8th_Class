<template>
  <div class="container" id="empView">
    <h1>사원 관리</h1>
    <emp-list></emp-list>
    <router-view @change-data="refreshData" :refresh="refresh"></router-view>
  </div>
</template>

<script>
import EmpList from "@/components/EmpList.vue";

export default {
  data() {
    return {
      mode: "register",
      deptno: 0,
      refresh: new Date().getTime(),
    };
  },
  components: {
    EmpList,
  },
  methods: {
    refreshData() {
      this.refresh = new Date().getTime();
      console.log(`refresh reset`);
    },
  },
}

</script>

<style>
</style>