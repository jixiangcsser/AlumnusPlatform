import { conditionalExpression } from "babel-types";

// 交易信息发布平台子模块 必须使用namespaced限定命名空间, 以防止污染全局空间
const forumModule = {
    /** 必须设定namespaced为 true */
    namespaced: true,

    state: {
        pageBean: {
            allPage:0,
            curPage:0,
            list: [],
            
        },
       
    },

    mutations: {},

    actions: {
        // 发布帖子
        publish({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    item.uid = JSON.parse(atob(rootState.access_token.split(".")[0])).user_id;
                    
                   
                    var response = await axios({
                        url: "/api/forum/publishPost",
                        method: 'post',
                        params: item,
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                    if (response.data.code == 200) {
                        //rootState.access_token = response.data.msg;
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
        toIndex({
            state,
            commit,
            rootState
        }, item) {
            console.log("toIndex");
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/forum/toIndex",
                        method: 'get',
                        params: item,
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                    console.log(response.data);
                   
                    if (response.data.code == 200) {
                        //rootState.access_token = response.data.msg;
                        
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
        postUser_img_bs64_url: (state) => {
            return state.postUser_img_bs64_url;
        },
    }
}

module.exports = forumModule;