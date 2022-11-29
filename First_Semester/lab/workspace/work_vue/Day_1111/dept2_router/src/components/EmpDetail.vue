<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-info text-light text-center">사원 상세조회</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="empno">사원번호</label></th>
            <td>
              <input type="text" name="empno" id="empno" v-model.lazy="emp.empno"
                :readonly="emp != null && emp.empno" />
            </td>
          </tr>
          <tr>
            <th><label for="ename">사원이름</label></th>
            <td>
              <input type="text" name="ename" id="ename" v-model="emp.ename" />
            </td>
          </tr>
          <tr>
            <th><label for="job">직무</label></th>
            <td>
              <input type="text" name="job" id="job" v-model="emp.job" />
            </td>
          </tr>
          <tr>
            <th><label for="mgr">매니저번호</label></th>
            <td>
              <input type="text" name="mgr" id="mgr" v-model="emp.mgr" />
            </td>
          </tr>
          <tr>
            <th><label for="hiredate">고용일자</label></th>
            <td>
              <input type="text" name="hiredate" id="hiredate" v-model="emp.hiredate" />
            </td>
          </tr>
          <tr>
            <th><label for="sal">월급여</label></th>
            <td>
              <input type="text" name="sal" id="sal" v-model="emp.sal" />
            </td>
          </tr>
          <tr>
            <th><label for="comm">커미션</label></th>
            <td>
              <input type="text" name="comm" id="comm" v-model="emp.comm" />
            </td>
          </tr>
          <tr>
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input type="text" name="deptno" id="deptno" v-model="emp.deptno" />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="수정" @click="modifyEmp" class="btn btn-warning m-1" />
              <input type="button" value="삭제" v-if="!emp.emps || emp.emps.length == 0" @click="removeEmp(emp.empno)"
                class="btn btn-dark m-1" />
              <input type="reset" value="취소" class="btn btn-info m-1" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>

    <!-- <form method="post" class="row">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>사원번호</th>
            <th>사원이름</th>
            <th>직무</th>
            <th>월급여</th>
            <th></th>
          </tr>
        </thead>
        <template v-if="dept.emps != null && dept.emps.length > 0">
          <tbody>
            <tr v-for="emp in dept.emps" :key="emp.empno">
              <td>{{ emp.empno }}</td>
              <td>{{ emp.ename }}</td>
              <td>{{ emp.job }}</td>
              <td>{{ emp.sal }}</td>
              <td>
                <input type="checkbox" name="empno" :value="emp.empno" v-model="empnoList" />
              </td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="5">
                <input type="button" value="삭제" @click="removeEmps" class="btn btn-dark m-1" />
                <input type="reset" value="취소" class="btn btn-info m-1" />
              </td>
            </tr>
          </tfoot>
        </template>
        <tbody v-else>
          <tr>
            <td colspan="5">배치된 사원이 없습니다.</td>
          </tr>
        </tbody>
      </table>
    </form> -->
  </div>
</template>

<script>
import http from "@/util/http-common"

export default {
  props: ['empno'],
  data() {
    return {
      emp: {}
    };
  },
  methods: {
    getEmp() {
      if (this.empno == 0) return;
      http
        .get(`/api/emps/${this.empno}`)
        .then(({ data }) => (this.emp = data));
    },
    removeEmp(empno) {
      http
        .delete(`/api/emps?empno=${empno}`)
        .then((status) => {
          console.log(`removeEmp success : ${status}`);
          this.clear();
          this.$router.push("/emp");
        });
    },
    // getEmps() {
    //   http
    //     .get(`/api/emps?deptno=${this.dept.deptno}`)
    //     .then(({ data }) => {
    //       this.dept.emps = data;
    //       this.empnoList = [];
    //     });
    // },
    modifyEmp() {
      http
        .put(`/api/emps/${this.emp.empno}`, this.emp)
        .then(() => {
          console.log(`modifyEmp success`);
          this.clear();
          this.$router.push("/emp");
        });
    },
    // removeEmp() {
    //   http
    //     .delete(`/api/depts/${this.dept.deptno}`)
    //     .then(() => {
    //       console.log(`removeDept success`);
    //       this.clear();
    //       this.$router.push('/dept');
    //     });
    // },
    // registerDept() {
    //   http
    //     .post(`/api/depts`, this.dept).then(() => {
    //       console.log(`registerDept success`);
    //       this.$emit("change-data", "detail");
    //     });
    // },
    clear() {
      this.emp = {};
    },
  },
  watch: {
    empno() {
      this.getEmp();
    },
  },
  created() {
    this.getEmp();
  },
};
</script>

<style>

</style>