//路由懒加载
const LoginPage = r => require.ensure([], () => r(require('@/pages/login')))
const MainPage = r => require.ensure([], () => r(require('@/pages/main')))
const RegisterPage = r => require.ensure([], () => r(require('@/pages/register')))
const HomePage = r => require.ensure([], () => r(require('@/pages/home')))
const ResumePage = r => require.ensure([], () => r(require('@/pages/resume')))
const EditPersonPage = r => require.ensure([], () => r(require('@/pages/editperson')))
const PaperPage = r => require.ensure([], () => r(require('@/pages/paper')))
const InfoBroadCastPage = r => require.ensure([], () => r(require('@/pages/infobroadcast')))
const ErrorPage = r => require.ensure([], () => r(require('@/pages/error')))
const VerifyPage = r => require.ensure([], () => r(require('@/pages/verify')))
const BetaInfoPage = r => require.ensure([], () => r(require('@/pages/beta_info')))
const FindPdPage = r => require.ensure([], () => r(require('@/pages/findpassword')))
const ForumPage = r => require.ensure([], () => r(require('@/pages/forum')))
const PublishPage = r => require.ensure([], () => r(require('@/pages/publish')))
const myPostPage = r => require.ensure([], () => r(require('@/pages/myPost')))
let router = new VueRouter({
    // mode: "hash", 在浏览器不支持的情况下会自动转为hash模式
    mode: "history",
    routes: [{
            path: '/',
            name: 'LoginPage',
            component: LoginPage,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: '/main',
            name: 'MainPage',
            component: MainPage,
            name: '',
            children: [{
                path: '',
                component: HomePage,
                meta: {
                    requiresAuth: true,
                    info: []
                },
            }, {
                path: '/edit',
                component: EditPersonPage,
                meta: {
                    requiresAuth: true,
                    info: ['个人信息', '编辑个人信息']
                }
            }]
        }, {
            path: '/register',
            name: 'RegisterPage',
            component: RegisterPage,
            meta: {
                requiresAuth: false
            }
        }, {
            path: '/beta4info',
            name: 'BetaInfoPage',
            component: BetaInfoPage,
            meta: {}
        }, {
            path: '/verify',
            name: 'VerifyPage',
            component: VerifyPage,
            meta: {}
        }, {
            path: '/findpsd',
            name: 'FindPdPage',
            component: FindPdPage,
            meta: {
                requiresAuth: false
            }
        }, {
            path: '/forum',
            name: 'ForumPage',
            component: ForumPage,
            meta: {
            }
        },{
            path: '/publish',
            name: 'PublishPage',
            component: PublishPage,
            meta: {
            }
        }, 
        {
            path: '/myPost',
            name: 'myPostPage',
            component: myPostPage,
            meta: {
            }
        },{
            path: '/*',
            name: 'ErrorPage',
            component: ErrorPage,
            meta: {}
        },
    ]

});

export default router;