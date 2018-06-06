import axios from '../../pages/axios'

// 将http get请求获得的头像转成base64字符串
const convertimg2bs64 = async function (url) {
    try {
        let response = await axios({
            url: url,
            method: 'get',
            responseType: 'blob'
        });
        var blob = response.data;
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onloadend = () => resolve(reader.result);
            reader.onerror = reject;
            reader.readAsDataURL(blob);
        });
    } catch (e) {
        console.log("出个错呀")
        return "/static/img/default.jpg";
    }
}

module.exports = convertimg2bs64;