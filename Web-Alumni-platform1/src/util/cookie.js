export default {
    set(name, val, expire) {
        let exdate = new Date();
        exdate.setTime(expire);
        window.document.cookie = name + "=" + val + ";expires=" + exdate.toGMTString();
    },
    get(name) {
        if (window.document.cookie.length > 0) {
            var c_start = window.document.cookie.indexOf(name + "=");
            if (c_start != -1) {
                c_start = c_start + name.length + 1;
                var c_end = window.document.cookie.indexOf(";", c_start);
                if (c_end == -1) c_end = window.document.cookie.length;
                return window.document.cookie.substring(c_start, c_end);
            }
        }
        return "";
    },
    delete(name, val) {
        let exp = new Date();
        exp.setTime(exp.getTime() - 1);
        window.document.cookie =
            name +
            "=" +
            val +
            ";expires=" +
            exp.toGMTString();
    }
};