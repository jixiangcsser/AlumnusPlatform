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
        post:{
            pid:'',
            title:'',
            content:'',
            publishTime:'',
            replyTime:'',//
            replyCount:'',//回复的个数
            likeCount:'',//点赞的个数
            scanCount:'',//浏览的个数
            imgUrl:'',
            user:{
                userName:'',
            } ,
            liked:''
        },
        replyList:[],
        hotUsersList:[],
        RecentUsersList:[],
        MessageList:{},
        
       
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
        },//去到帖子的主页
        toIndex({
            state,
            commit,
            rootState
        }, item) {
            console.log(item.curPage);
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
        getPostContent({//把当前回复的信息取出来。
            state,
            commit,
            rootState
        }, item) {
           var uid=JSON.parse(atob(rootState.access_token.split(".")[0])).user_id;
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/forum/publishPost",
                        method: 'get',
                        params: {
                            pid:item.pid,
                            uid:uid
                        },
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                    console.log("what happen")
                    var response1=await axios({
                        url: "/api/forum/reply",
                        method: 'get',
                        params: item,
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
        
                    if (response.data.code == 200 && response1.data.code == 200) {
                        state.post = response.data.obj;//把从后台传来的pageBean传给前台的变量
                        state.replyList=response1.data.obj
                       
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
        reply({//点击回贴后的动作
            state,
            commit,
            rootState
        }, item) {
            
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/forum/reply",
                        method: 'post',
                        params: {
                            content:item.content,
                            user_id:item.user_id,
                            post_id:item.post_id
                        },
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                   
                    if (response.data.code == 200) {//成功之后，刷新页面
                        //rootState.access_token = response.data.msg
                        
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
         //传图片到后台
         upload({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    console.log("传图片到后台")
                    console.log(item.data);
                    
                   
                    var response = await axios({
                        url: "/wangEditor/upload",
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
        },//去到帖子的主页
        
        getHotUserList({//点击回贴后的动作
            state,
            commit,
            rootState
        }, item) {
            console.log("dogdog")
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/forum/hotUsers",
                        method: 'get',
                        params: {
                            count:item.count
                        },
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                   
                    state.hotUsersList=response.data.obj;
                    if (response.data.code == 200) {//成功之后，刷新页面
                        //rootState.access_token = response.data.msg
                        
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
        getRecentUserList({//点击回贴后的动作
            state,
            commit
        }, item) {
            console.log("dogdog")
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/forum/recentUsers",
                        method: 'get',
                        params: {
                            count:item.count
                        },
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                    console.log("反回的数据");
                    console.log(response.data);
                    state.RecentUsersList=response.data.obj;
                    if (response.data.code == 200) {//成功之后，刷新页面
                        //rootState.access_token = response.data.msg
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
        getMessageContent({//把当前回复的信息取出来。
            state,
            commit,
            rootState
        }, item) {
            item.uid = JSON.parse(atob(rootState.access_token.split(".")[0])).user_id;
            console.log("aaaaaaaaaa")
            console.log(item.uid)
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/forum/getMessage",
                        method: 'get',
                        params: {
                            uid:item.uid
                        },
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                   
                    if (response.data.code == 200 ) {
                        state.MessageList=response.data.obj;
                        
                       /* for(var key in response.data.obj){
                            console.log(key);
                            console.log(response.data.obj[key])
                        }*/
                            
                       
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
        addClickCount({//把当前回复的信息取出来。
            state,
            commit,
            rootState
        }, item) {
            item.uid = JSON.parse(atob(rootState.access_token.split(".")[0])).user_id;
          
          
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/forum/publishPost/ajaxClickLike",
                        method: 'get',
                        params: {
                            pid:item.pid,
                            uid:item.uid
                        },
                        headers: {
                            'content-type': 'application/json', //我们把数据传输成json数据，直接设置就可以
                        }
                    });
                    console.log("wwwwwwwwwwww");
                    if (response.data.code == 200 ) {    
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
        post:(state)=>{
            return state.post;
        },
        replyList:(state)=>{
            return state.replyList;
        },
        hotUsers:(state)=>{
            return state.hotUsersList;
        },
        recentUsers:(state)=>{
            return state.RecentUsersList
        },
        MessageList:(state)=>{
            return state.MessageList;
        }

    }
}

module.exports = forumModule;