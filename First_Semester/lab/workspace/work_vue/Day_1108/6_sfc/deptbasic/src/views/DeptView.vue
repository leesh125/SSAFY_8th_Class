<template>
  <div class="conatiner">
    <h1>부서 관리</h1>
    <dept-list @select-dept="receiveDept" :flag="flag" :deleteFlag="deleteFlag"></dept-list>
    <dept-detail @modify-dept="modifyDept" @delete-dept="deleteDept" :deptno="deptno"></dept-detail>
  </div>
</template>

<script>
  import DeptList from '@/components/DeptList.vue';
  import DeptDetail from '@/components/DeptDetail.vue';

  export default {
    data() {
      return {
        deptno: 10,
        flag: 1,
        deleteFlag: 1,
      }
    },
    components: {
      DeptList, DeptDetail
    },
    methods: {
      receiveDept(deptno) {
        this.deptno = deptno;
      },
      modifyDept() {
        this.flag *= -1;
        console.log(this.flag);
      },
      deleteDept() {
        this.deleteFlag *= -1;
      }
    },
  }
</script>

<style scoped>

</style>