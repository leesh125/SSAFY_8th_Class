import Vue from 'vue'
import Vuex from 'vuex'
import Constant from '../common/Constant.js'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    depts : []
  },
  mutations: {
    [Constant.SET_DEPTS](state,payload) {
      state.depts = payload;
    }
  },
  actions: {
    [Constant.GET_DEPTS](context) {
      http.get('/api/depts').then(({ data }) => {
        // commit
        context.commit(Constant.SET_DEPTS, data);
      });
    }
  },
})
