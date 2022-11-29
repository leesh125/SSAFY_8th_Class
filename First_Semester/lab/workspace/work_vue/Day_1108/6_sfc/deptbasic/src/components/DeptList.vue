<template>
  <div class="container">
      <div class="row mt-3">
          <h2 class="bg-primary text-light text-center">부서 목록</h2>
      </div>
      <div class="row">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>부서번호</th>
                    <th>부서명</th>
                    <th>위치</th>
                </tr>            
            </thead>
            <tbody>
              <tr v-if="depts.length==0">
                  <td colspan="3">등록된 부서정보가 없습니다.</td>
              </tr>
              <template v-else>
                <tr v-for="(dept,index) in depts" :key="dept.deptno" @click="pickDept(dept.deptno)"> 
                    <td>{{index}}</td>
                    <td>{{dept.deptno}}</td>
                    <td>{{dept.dname}}</td>
                    <td>{{dept.loc}}</td> 
                </tr>
              </template>
            </tbody>
        </table>
      </div>    
    </div>
</template>

<script>
  import axios from 'axios';
  export default {
    props: {
      flag: {
        type: Number,
        required : false,
        default : -1
      },
      deleteFlag: {
        type: Number,
        required : false,
        default : -1
      },
    },
    data() {
      return {
        depts: [
        
        ],
      }
    },
    methods: {
      // getUsers() {
      //   axios.get('http://localhost:8080/api/depts')
      //   // .then(response=>console.log(response));
      //   .then(({data})=> this.users = data);
      // }
      getDepts() {
        axios.get('http://localhost:8080/api/depts')
        .then(({data})=>this.depts = data);
        // .then(response=>this.depts = response.data);
      },
      pickDept(deptno){
        this.$emit("select-dept",deptno);
      }
    },
    watch: {
      flag() {
        this.getDepts();
      },
      deleteFlag() {
        this.getDepts();
      },
    },
    created() {
      this.getDepts()
    },
  }
</script>

<style scoped>

</style>