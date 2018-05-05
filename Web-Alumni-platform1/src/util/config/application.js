import server_config from '../../../config'

//如果浏览器不支持includes()方法，做降级处理
if (!String.prototype.includes) {
    String.prototype.includes = function (search, start) {
        'use strict';
        if (typeof start !== 'number') {
            start = 0;
        }

        if (start + search.length > this.length) {
            return false;
        } else {
            return this.indexOf(search, start) !== -1;
        }
    };
}
var axiosBaseURL = "";

if (window.location.href.includes("localhost")) {
    axiosBaseURL = 'http://localhost:9090';
} else {
    axiosBaseURL = 'http://47.94.229.48:80';
}


var appconfig = {
    AXIOSBASERUL: axiosBaseURL
}

module.exports = appconfig;