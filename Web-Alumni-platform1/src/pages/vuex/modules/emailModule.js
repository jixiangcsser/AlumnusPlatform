// 邮件子模块 必须使用namespaced限定命名空间, 以防止污染全局空间
const emailModule = {
    /** 必须设定namespaced为 true */
    namespaced: true,

    state: {},

    mutations: {},

    actions: {
        // 验证验证码邮件
        VerifyCodeEmail({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios({
                        url: "/api/check_code",
                        method: 'get',
                        params: item,
                        headers: {
                            'content-type': 'application/json',
                        }
                    });
                    if (response.data.code == 200) {
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
                    on_error({
                        code: 999
                    });
                }
            });
        },

        // 发送验证码邮件
        SendCodeEmail({
            state,
            commit,
            rootState
        }, item) {
            return new Promise(async (on_result, on_error) => {
                try {
                    var response = await axios.post("/api/check_code", {
                        user_name: item
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
    },

    getters: {}
}

module.exports = emailModule;