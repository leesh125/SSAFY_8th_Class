<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">사원 목록</h2>
    </div>
    <div class="row">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>번호</th>
            <th>사원번호</th>
            <th>이름</th>
            <th>직무</th>
            <th>월급여</th>
            <th>부서번호</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="emps.length == 0">
            <td colspan="6">등록된 사용자 정보가 없습니다.</td>
          </tr>
          <template v-else>
            <tr v-for="(emp, index) in emps" :key="emp.empno" @click="pickemp(emp.empno)">
              <td>{{ index + 1 }}</td>
              <td>{{ emp.empno }}</td>
              <td>{{ emp.ename }}</td>
              <td>{{ emp.job }}</td>
              <td>{{ emp.sal }}</td>
              <td>{{ emp.deptno }}</td>
            </tr>
          </template>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="6">
              <div class="btn btn-success text-center" @click="changeForm">
                등록
              </div>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  data() {
    return {
      emps: [],
    };
  },
  props: {
    refresh: {
      type: Number,
      default: 0,
    },
  },
  methods: {
    getEmps() {
      http.get('/api/emps').then(({ data }) => {
        this.emps = data;
      });
    },
    pickemp(empno) {
      this.$router.push(`/emp/detail/${empno}`);
    },
    changeForm() {
      this.$router.push('/emp/regForm');
    },
  },
  created() {
    this.getEmps();
  },
  watch: {
    refresh() {
      this.getEmps();
    },
    $route(to) {
      if (to.path == '/emp') {
        console.log("getEmp ...")
        this.getEmps();
      }
    }
  },
};
</script>

<style scoped>

</style>