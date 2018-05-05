const forumUserModule = {
    /** 必须设定namespaced为 true */
    namespaced: true,

    state: {
        pageBean: {
            allPage:0,
            curPage:0,
            list: [],
            uid:""
        },
       
    },

    mutations: {},

    actions: {
       
        toIndex({
            state,
            commit,
            rootState
        }, item) {
            console.log("toIndex");
            return new Promise(async (on_result, on_error) => {
               
                try {
                   
                    item.uid = JSON.parse(atob(rootState.access_token.split(".")[0])).user_id;
                   
                    var response = await axios({
                        url: "/api/forumUser/toIndex",
                        method: 'get',
                        params: item,
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                    console.log(response.data);
                   
                    if (response.data.code == 200) {
                        state.pageBean = response.data.obj;//把从后台传来的pageBean传给前台的变量

                        on_result({
                            code: 200
                        });
                    } else {
                        on_result({
                            code: response.data.code
                        });
                    }
                } catch (error) {
                    on_error({
                        code: 999
                    });
                }
            });
        },    
    },

    getters: {
        pageBean: (state) => {
            return state.pageBean;
        },
    }
}

module.exports = forumUserModule;