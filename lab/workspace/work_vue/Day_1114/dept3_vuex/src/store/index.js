import Vue from 'vue'
import Vuex from 'vuex'
import Constant from '@/common/Constant.js'
import restApi from "@/util/http-common.js";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    depts: [],
    dept: {}
  },
  getters: {
    depts: state => {
      // return state.depts;
      return state.depts.filter(item=>item.deptno>20);
    }
  },
  mutations: {
    [Constant.SET_DEPTS](state,payload) {
      state.depts = payload;
    },
    [Constant.SET_DEPT](state,payload) {
      state.dept = payload;
    }
  },
  actions: {
    [Constant.GET_DEPTS](context){
      return restApi.get("/api/depts").then(({ data }) => {
        // commit
        context.commit(Constant.SET_DEPTS, data);
      });
    },
    [Constant.REGISTER_DEPT](context,payload) {
      return restApi.post(`/api/depts`, payload).then(() => console.log(`store action ${Constant.REGISTER_DEPT}`));
    },
    [Constant.GET_DEPT](context,payload) {
      return restApi.get(`/api/depts/${payload}/emps`).then(({ data }) => context.commit(Constant.SET_DEPT,data));
    },[Constant.MODIFY_DEPT](context,dept) {
      return restApi.put(`/api/depts/${dept.dept.deptno}`, dept).then(() => console.log(`store action ${Constant.MODIFY_DEPT}`));
    },
  },
})
