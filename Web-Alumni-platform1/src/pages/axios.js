import appconfig from '../util/config/application'

axios.defaults.baseURL = appconfig.AXIOSBASERUL;
axios.defaults.timeout = 1000 * 15;
axios.defaults.headers['Content-Type'] = 'application/json';

var loadingInstance;
// http请求拦截器
axios.interceptors.request.use(config => {
    loadingInstance = ELEMENT.Loading.service({
        lock: true,
        text: '网络加速中~~',
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.7)"
    });
    return config;
}, error => {
    loadingInstance.close();
    return Promise.reject(error);
});

// http响应拦截器
axios.interceptors.response.use(data => {
    // 响应成功关闭loading
    loadingInstance.close();
    return data;
}, error => {
    loadingInstance.close();
    return Promise.reject(error);
});

module.exports = axios;