import router from '../../routers'
import store from '../../pages/vuex/store'

// 全局导航守卫中检查元字段(路由拦截)(根据路由的元信息 meta字段 进行拦截，具体规则课对照router.js与这里进行猜测)
router.beforeEach((to, from, next) => {
    let access_token = store.getters.access_token;
    if (to.matched.some(record => record.meta.requiresAuth)) {
        //token失效
        if (access_token == "" || access_token == undefined) {
            next({
                path: '/'
            });
        }
    } else if (to.meta.requiresAuth != undefined) {
        //本地存有accesstoken并且token没有过期
        if (access_token != "" && access_token != undefined) {
            next({
                path: '/main'
            });
        }
        
    }
    next();
});

export default router;