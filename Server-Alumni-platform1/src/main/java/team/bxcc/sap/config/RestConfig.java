package team.bxcc.sap.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import team.bxcc.sap.aop.interceptor.AuthorizationInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import team.bxcc.sap.aop.resolvers.RequestUserArgumentResolver;
import team.bxcc.sap.aop.resolvers.RequestUserInfoArgumentResolver;

import java.util.List;

/**
 * 配置类，增加自定义拦截器和解析器
 *
 * @author FengTao
 * @date 2018/1/19.
 * @see team.bxcc.sap.aop.interceptor.AuthorizationInterceptor
 */
@Configuration
public class RestConfig extends WebMvcConfigurerAdapter {

    private final AuthorizationInterceptor athorization_interceptor;

    private final RequestUserArgumentResolver requestuserargumentresolver;

    private final RequestUserInfoArgumentResolver requestuserinfoargumentresolver;

    @Autowired
    public RestConfig(AuthorizationInterceptor athorization_interceptor, RequestUserArgumentResolver requestuserargumentresolver, RequestUserInfoArgumentResolver requestuserinfoargumentresolver) {
        this.athorization_interceptor = athorization_interceptor;
        this.requestuserargumentresolver = requestuserargumentresolver;
        this.requestuserinfoargumentresolver = requestuserinfoargumentresolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(athorization_interceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(requestuserargumentresolver);
        argumentResolvers.add(requestuserinfoargumentresolver);
    }
}
