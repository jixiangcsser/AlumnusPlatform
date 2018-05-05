import cookie from '../../../util/cookie'
import convertimg2bs64 from '../../../util/global/imgresolver'
import appconfig from '../../../util/config/application'

// 用户子模块 必须使用namespaced限定命名空间, 以防止污染全局空间
const userModule = {
    /** 必须设定namespaced为 true */
    namespaced: true,

    state: {
        img_bs64_url: "/static/img/default.jpg",
        isNewUser: true,
        formData: {
            name: '',
            sex: '',
            img: '/static/img/default.jpg',
            nation: '',
            home: '',
            political: '',
            workstation: '',
            job: '',
            undergraduate: '',
            speciality: '',
            date1: '',
            date2: ''
        }
    },

    mutations: {
        changeIsNewUser(state, item) {
            state.isNewUser = item;
        },
        clearInfomation(state) {
            var temp = {
                name: '',
                sex: '',
                img: '/static/img/default.jpg',
                nation: '',
                home: '',
                political: '',
                workstation: '',
                job: '',
                undergraduate: '',
                speciality: '',
                date1: '',
                date2: ''
            };
            for (var prop in temp) {
                if (state.formData.hasOwnProperty(prop)) {
                    state.formData[prop] = temp[prop];
                }
            }
            state.img_bs64_url = "/static/img/default.jpg";
            state.isNewUser = true;
            localStorage.removeItem('user_icon');
        },
        setuserinfocontroller(state, response) {
            for (var prop in response.obj) {
                if (state.formData.hasOwnProperty(prop)) {
                    if (prop == "sex" || prop == "political") {
                        state.formData[prop] = response.obj[prop].toString();
                    } else if (prop == "img") {
                        state.img_bs64_url = response.obj[prop];
                        state.formData[prop] = response.obj[prop];
                    } else if (prop == "date1" || prop == "date2") {
                        state.formData[prop] = new Date(response.obj[prop]).toGMTString();
                    } else {
                        state.formData[prop] = response.obj[prop];
                    }
                }
            }
        }
    },

    actions: {
        // 登陆控制器
        LoginController({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios.post("/api/token", item);
                    if (response.data.code == 200) {
                        cookie.set('access_token', response.data.msg, JSON.parse(atob(response.data.msg.split(".")[0])).timestamp);
                        rootState.access_token = response.data.msg;
                        on_result({
                            code: 200
                        });
                    } else {
                        on_result({
                            code: response.data.code
                        });
                    }
                } catch (error) {
                    console.error(error);
                    on_error({
                        code: 999
                    });
                }
            });
        },
        // 注册控制器
        RegisterController({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios.post("/api/user", item);
                    if (response.data.code == 200) {
                        on_result({
                            code: 200
                        });
                    } else {
                        on_result({
                            code: response.data.code
                        });
                    }
                } catch (error) {
                    console.error(error);
                    on_error({
                        code: 999
                    });
                }
            });
        },
        // 提交个人信息控制器
        SubmitPfoController({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    item.user_id = JSON.parse(atob(rootState.access_token.split(".")[0])).user_id;
                    var response = await axios({
                        url: "/api/userinfo",
                        method: 'post',
                        data: item,
                        headers: {
                            'content-type': 'application/json',
                            'authorization': rootState.access_token
                        }
                    });
                    if (response.data.code == 200) {
                        on_result({
                            code: 200
                        });
                    } else {
                        on_result({
                            code: response.data.code
                        });
                    }
                } catch (error) {
                    console.error(error);
                    on_error({
                        code: 999
                    });
                }
            });
        },

        // 更改用户基本信息控制器
        UpdatePfoController({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    item.user_id = JSON.parse(atob(rootState.access_token.split(".")[0])).user_id;
                    var response = await axios({
                        url: "/api/userinfo",
                        method: 'put',
                        data: item,
                        headers: {
                            'content-type': 'application/json',
                            'authorization': rootState.access_token
                        }
                    });
                    if (response.data.code == 200) {
                        on_result({
                            code: 200
                        });
                    } else {
                        on_result({
                            code: response.data.code
                        });
                    }
                } catch (error) {
                    console.error(error);
                    on_error({
                        code: 999
                    });
                }
            });
        },

        // 修改密码
        UpdatePassWord({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/user",
                        method: 'put',
                        data: item,
                        headers: {
                            'content-type': 'application/json',
                            'authorization': rootState.access_token
                        }
                    });
                    rootState.access_token = "";
                    commit('clearInfomation');
                    if (response.data.code == 200) {
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

        // 判断用户是否存在控制器
        CheckUserExistController({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/user",
                        method: 'get',
                        params: {
                            username: item
                        },
                        headers: {
                            'content-type': 'application/json',
                        }
                    });
                    if (response.data.code == 200) {
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

        // 获取用户基本信息控制器
        GetUserInfoController({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    console.log(JSON.parse(atob(rootState.access_token.split(".")[0])).user_id)
                    var response = await axios({
                        url: "/api/userinfo",
                        method: 'get',
                        params: {
                            id: JSON.parse(atob(rootState.access_token.split(".")[0])).user_id,
                            return_body: item
                        },
                        headers: {
                            'content-type': 'application/json',
                            'authorization': rootState.access_token
                        }
                    });
                    if (response.data.code == 200) {
                        console.log(response.data.code);
                        if (item) {
                            if (localStorage.getItem('user_icon')) {
                                response.data.obj.img = localStorage.getItem('user_icon');
                                console("用户id="+response.data.obj.id);
                            } else {
                                
                                let url = rootState.ali_client.signatureUrl(response.data.obj.id);
                                response.data.obj.img = await convertimg2bs64(url);
                                localStorage.setItem('user_icon', response.data.obj.img);
                            }
                            if (item) {
                                commit('setuserinfocontroller', response.data);
                            }
                        }
                        on_result({
                            code: 200
                        });
                    } else {
                        on_result({
                            code: response.data.code
                        });
                    }
                } catch (error) {
                    console.log(error);

                    
                    on_error({
                        code: 999
                    });
                }
            });
        },
        // 获取用户头像
        GetUserIcon({
            state,
            commit,
            rootState
        }) {
            return new Promise(async (on_result, on_error) => {
                try {
                    if (localStorage.getItem('user_icon')) {
                        state.img_bs64_url = localStorage.getItem('user_icon');
                    } else {//signatureUrl中阿里的包里自带的，atob是将base64编码过得反编码处理，根据用户的id获取到临时的url
                        let url = rootState.ali_client.signatureUrl(JSON.parse(atob(rootState.access_token.split(".")[0])).user_id);
                        state.img_bs64_url = await convertimg2bs64(url);
                        console.log("师傅啊");
                        console.log("测试一下"+state.img_bs64_url);
                        localStorage.setItem('user_icon', state.img_bs64_url);
                    }
                    on_result({
                        code: 200
                    });
                } catch (error) {
                    console.log(error);
                    on_error({
                        code: 999
                    });
                }
            });
        }
    },

    getters: {
        formData: (state) => {
            return state.formData;
        },
        img_bs64_url: (state) => {
            return state.img_bs64_url;
        },
        isNewUser: (state) => {
            return state.isNewUser;
        }
    }
}

module.exports = userModule;