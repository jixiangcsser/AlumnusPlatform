import state from './state'
import mutations from './mutations'
import getters from './getters'
import actions from './actions'
import forumUserModule from './modules/forumUserModule'
import userModule from './modules/userModule'
import emailModule from './modules/emailModule'
import forumModule from './modules/forumModule'
export default new Vuex.Store({
    namespaced: true,
    state,
    mutations,
    getters,
    actions,
    modules: {
        userModule: userModule,
        emailModule: emailModule,
        forumModule:forumModule,
        forumUserModule:forumUserModule
    }
})