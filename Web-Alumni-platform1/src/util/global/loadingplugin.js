// 该loading插件里的方法请谨慎使用，因为在axios.js中已经设置了所有请求默认开启遮罩
// 使用方法: 直接在组件的方法中使用this.controlFullscreen or this.serviceFullscreen,如同原生函数一般
exports.install = function (Vue, options) {
    // 根据传入的时间参数直接开启 Loading
    Vue.prototype.controlFullscreen = function (text, time) {
        var self = this;
        return new Promise(function (resolve) {
            const loading = self.$loading({
                lock: true,
                text: text,
                spinner: "el-icon-loading",
                background: "rgba(0, 0, 0, 0.7)"
            });
            setTimeout(() => {
                loading.close();
                resolve();
            }, time);
        });
    }

    // 以服务的方式调用的 Loading
    Vue.prototype.serviceFullscreen = function (text) {
        return ELEMENT.Loading.service({
            lock: true,
            text: text,
            spinner: "el-icon-loading",
            background: "rgba(0, 0, 0, 0.7)"
        });
    };

    // 关闭以服务的方式调用的 Loading
    Vue.prototype.serviceCloseFullscreen = function (loadingInstance, time) {
        return new Promise(function (resolve) {
            setTimeout(() => {
                loadingInstance.close();
                resolve();
            }, time);
        });
    };
};