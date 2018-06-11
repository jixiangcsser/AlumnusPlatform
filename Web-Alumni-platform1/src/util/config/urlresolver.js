import router from '../../routers'
import store from '../../pages/vuex/store'

/**
 * @author Blust
 * @description 全局导航守卫中检查元字段(路由拦截)(根据路由的元信息 meta字段 进行拦截，具体规则课对照router.js与这里进行猜测)
 * @todo  此处next函数被调用时不会立即返回，所以必须设置多个next
 * @param {any} {
 *         to,   -  即将要进入的目标 路由对象
 *         from, -  当前导航正要离开的路由
 *         next  -  一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数。
 *     }
 * @returns 
 * @version 1.32
 */
router.beforeEach((to, from, next) => {
    let access_token = store.getters.access_token;
    if (to.matched.some(record => record.meta.requiresAuth)) {//设置需要验证，作用是一旦token失效跳到登陆页面
        //token失效
        if (access_token == "" || access_token == undefined) {
            next({
                path: '/'
            });
        } else {
            next();
        }
    } else if (to.meta.requiresAuth != undefined) {//设置了false，这里设置是为了当用户已经登陆了，但是通过路径直接去注册或登陆.
        //本地存有accesstoken并且token没有过期
        if (access_token != "" && access_token != undefined) {
            next({
                path: '/main'
            });
        } else {
            next();
        }
    } else {//没有设置
        next();
    }
});

export default router;