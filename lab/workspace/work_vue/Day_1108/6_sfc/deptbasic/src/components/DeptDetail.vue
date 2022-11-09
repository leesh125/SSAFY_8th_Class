<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">{{deptno}}부서 조회 with emps</h2>
    </div>
    
    <table class="table">
      <tbody>
        <tr>
          <th><label for="deptno">부서번호</label></th>
          <td><input type="text" name="deptno" id="deptno" v-model="dept.deptno" readonly="readonly" /></td>
        </tr>
        <tr>
          <th><label for="dname">부서이름</label></th>
          <td><input type="text" name="dname" id="dname" v-model="dept.dname"/></td>
        </tr>
        <tr>
          <th><label for="loc">지역</label></th>
          <td><input type="text" name="loc" id="loc" v-model="dept.loc" /></td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="2">
            <input type="submit" @click="updateDept(dept)" value="수정" />
            <input type="submit" @click="deleteDept(deptno)" v-bind:disabled="dept.emps != 0" value="삭제" />
            <input type="reset" value="취소" />
          </td>
        </tr>
      </tfoot>
    </table>
		
    
    <table class="table table-striped table-hover">
      <thead>
        <tr>
          <th>사원번호</th>
          <th>사원이름</th>
          <th>직무</th>
          <th>월급여</th>
          <th>삭제여부</th>
          <th></th>
        </tr>			
      </thead>
          <tbody>
            <tr v-if="dept.emps==null || dept.emps.length == 0">
                <td colspan="3">등록된 사원정보가 없습니다.</td>
            </tr>
            <template v-else>
              <tr v-for="emp in dept.emps" :key="emp.empno" >
                <td>{{emp.empno }}</td>
                <td>{{emp.ename }}</td>
                <td>{{emp.job }}</td>
                <td>{{emp.sal }}</td>
                <td><input type="checkbox" v-model="checkedUsers" :value="emp.empno" ></td>
              </tr>
            </template>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="5">
                <input type="submit" @click="deleteUsers()" value="삭제" />
                <input type="reset" value="취소"/>
              </td>
            </tr>
          </tfoot>
      </table>
    </div>
</template>

<script>
  import axios from "axios"
  export default {
    props: {
      deptno: {
        type: Number,
        required : false,
        default : 10
      },
    },
    data() {
        return {
          dept: [

          ],
          checkedUsers: [

          ],
        }
      },
      methods: {
        // getUsers() {
        //   axios.get('http://localhost:8080/api/depts')
        //   // .then(response=>console.log(response));
        //   .then(({data})=> this.users = data);
        // }
        getEmps() {
          axios.get(`http://localhost:8080/api/depts/${this.deptno}/emps`)
          .then(response=>{
            this.dept = response.data;
            console.log(this.dept);
          });
        },
        updateDept(dept) {
          axios.put(`http://localhost:8080/api/depts/${dept.deptno}`,{
            "deptno": `${dept.deptno}`,
            "dname": `${dept.dname}`,
            "emps": this.dept.emps,
            "loc": `${dept.loc}`
          })
          .then(response=>{
            console.log(response.data);
            this.$emit("modify-dept");
          });
        },
        deleteDept(deptno){
          axios.delete(`http://localhost:8080/api/depts/${deptno}`)
          .then(response=>{
            console.log(response);
            this.$emit("delete-dept");
          });
        },
        deleteUsers(){
          axios.delete(`http://localhost:8080/api/emps/${this.checkedUsers}`)
          .then(response=>{
            console.log(response);
            this.getEmps();
          });
        }
      },
      watch: {
        deptno() {
          this.getEmps();
        },
      },
      created() {
        
        this.getEmps()
      },
  }
</script>

<style scoped>

</style>