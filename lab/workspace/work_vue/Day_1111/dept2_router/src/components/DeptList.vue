<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">부서 목록</h2>
    </div>
    <div class="row">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>번호</th>
            <th>부서번호</th>
            <th>부서이름</th>
            <th>위치</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="depts.length == 0">
            <td colspan="4">등록된 사용자 정보가 없습니다.</td>
          </tr>
          <template v-else>
            <tr
              v-for="(dept, index) in depts"
              :key="dept.deptno"
              @click="pickDept(dept.deptno)"
            >
              <td>{{ index + 1 }}</td>
              <td>{{ dept.deptno }}</td>
              <td>{{ dept.dname }}</td>
              <td>{{ dept.loc }}</td>
            </tr>
          </template>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="4">
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
      depts: [],
    };
  },
  props: {
    refresh: {
      type: Number,
      default: 0,
    },
  },
  methods: {
    getDepts() {
      
      http.get('/api/depts').then(({ data }) => {
        this.depts = data;
      });
    },
    pickDept(deptno) {
      this.$router.push(`/dept/detail/${deptno}`);
    },
    changeForm() {
      this.$router.push('/dept/regForm');
    },
  },
  created() {
    this.getDepts();
  },
  watch: {
    refresh() {
      this.getDepts();
    },
    $route(to) {
      if (to.path == '/dept') {
        console.log("getDept ...")
        this.getDepts();
      }
    }
  },
};
</script>

<style scoped>
</style>