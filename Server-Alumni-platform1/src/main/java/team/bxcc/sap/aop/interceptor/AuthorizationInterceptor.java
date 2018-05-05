package team.bxcc.sap.aop.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.service.TokenService;
import team.bxcc.sap.util.annotation.Authorization;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.method.HandlerMethod;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 权限验证拦截器
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private final TokenService tokenService;

    @Autowired
    public AuthorizationInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过?
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //如果方法注明了Authorization,校验token
        if (method.getAnnotation(Authorization.class) != null) {
            //从header中得到token
            String authorization = request.getHeader("authorization");
            if (authorization != null) {
                boolean check_token_res = tokenService.check_AccessToken(authorization);
                if (!check_token_res) {
                    response.getWriter().print(HttpResponseObj.generateJsonHttpResponse(HttpStatus.ERROR_TOKEN, "invalid access_token!"));
                }
                return check_token_res;
            } else {
                response.getWriter().print(HttpResponseObj.generateJsonHttpResponse(HttpStatus.ERROR_TOKEN, "access_token is null!"));
                return false;
            }
        }

        return true;
    }
}
