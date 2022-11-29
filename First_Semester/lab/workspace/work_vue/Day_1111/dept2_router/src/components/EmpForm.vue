<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-danger text-light text-center">사원 등록</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="deptno">사원번호</label></th>
            <td>
              <input type="text" name="empno" v-model.lazy="emp.empno" />
            </td>
          </tr>
          <tr>
            <th><label for="ename">사원이름</label></th>
            <td>
              <input type="text" name="ename" id="ename" v-model.lazy="emp.ename" />
            </td>
          </tr>
          <tr>
            <th><label for="job">직무</label></th>
            <td>
              <input type="text" name="job" id="job" v-model.lazy="emp.job" />
            </td>
          </tr>
          <tr>
            <th><label for="mgr">매니저번호</label></th>
            <td>
              <input type="text" name="mgr" id="mgr" v-model.lazy="emp.mgr" />
            </td>
          </tr>
          <tr>
            <th><label for="hiredate">고용일자</label></th>
            <td>
              <input type="text" name="hiredate" id="hiredate" v-model.lazy="emp.hiredate" />
            </td>
          </tr>
          <tr>
            <th><label for="sal">월급여</label></th>
            <td>
              <input type="text" name="sal" id="sal" v-model.lazy="emp.sal" />
            </td>
          </tr>
          <tr>
            <th><label for="comm">커미션</label></th>
            <td>
              <input type="text" name="comm" id="comm" v-model.lazy="emp.comm" />
            </td>
          </tr>
          <tr>
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input type="text" name="deptno" id="deptno" v-model.lazy="emp.deptno" />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="등록" @click="registerEmp" class="btn btn-warning m-1" />
              <input type="reset" value="취소" class="btn btn-info m-1" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<script>
import http from '@/util/http-common'
export default {
  data() {
    return {
      emp: {},
    };
  },
  methods: {
    registerEmp() {
      http.post(`/api/emps`, this.emp).then(() => {
        console.log(`registerEmp success`);
        this.clear();
        this.$router.push("/emp");
      });
    },
    clear() {
      this.emp = {};
    },
  },
};
</script>

<style>

</style>