import axios from '../axios'

const actions = {
    // 获取阿里云oss client
    GetAliClient({
        state,
        commit
    }, item) {
        return new Promise(async (on_result, on_error) => {
            try {
                var response = await axios({
                    url: "/api/file_token",
                    method: 'get',
                    headers: {
                        'content-type': 'application/json',
                        'authorization': state.access_token
                    }
                });
                console.log(response.data.code)
                if (response.data.code == 200) {
                    var client = new OSS.Wrapper({
                        accessKeyId: response.data.obj.accessKeyId,//这些keyId等都必须从后台中获取防止被
                        accessKeySecret: response.data.obj.accessKeySecret,
                        stsToken: response.data.obj.securityToken,
                        bucket: item,
                        region: 'oss-cn-beijing'
                    });
                    
                    state.ali_client = client;
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
    }
};

export default actions