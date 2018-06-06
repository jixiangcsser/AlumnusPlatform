import axios from '../../pages/axios'

// 将http get请求获得的头像转成base64字符串
const wangEditorHeadImg = async function (url) {
    try {
        let response = await axios({
            url: url,
            method: 'get',
            responseType: 'blob'
        });
        return url ;
        
    } catch (e) {
        
        return "/static/img/default.jpg";
    }
}

module.exports = wangEditorHeadImg;