package team.bxcc.sap.aop.resolvers;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.core.MethodParameter;
import team.bxcc.sap.config.ConStants;
import team.bxcc.sap.util.annotation.RequestAccount;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import team.bxcc.sap.model.AccountModel;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * User参数验证拦截器
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@Component
public class RequestUserArgumentResolver implements HandlerMethodArgumentResolver {

    private AccountModel checkUserPassword(String user_name, String password) {
        if ((user_name != null) && (password != null)) {
            if ((!user_name.equals("")) && (!password.equals(""))) {
                if (user_name.matches(ConStants.MATCH_REGULAR_EXP_ACCOUNT)
                        && (password.matches(ConStants.MATCH_WEAK1_REGULAR_EXP_PASSWORD) ||
                        password.matches(ConStants.MATCH_WEAK2_REGULAR_EXP_PASSWORD) ||
                        password.matches(ConStants.MATCH_WEAK3_REGULAR_EXP_PASSWORD) ||
                        password.matches(ConStants.MATCH_MID_REGULAR_EXP_PASSWORD) ||
                        password.matches(ConStants.MATCH_STRONG_REGULAR_EXP_PASSWORD))) {
                    return new AccountModel(user_name, password);
                }
            }
        }
        return null;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是AccountModel并且有RequestAccount注解则支持
        return parameter.getParameterType().isAssignableFrom(AccountModel.class) &&
                parameter.hasParameterAnnotation(RequestAccount.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws IOException {
        HttpServletRequest requests = (HttpServletRequest) webRequest.getNativeRequest();
        if (requests.getContentType().equals("application/json")) {
            StringBuilder all_line = new StringBuilder();
            String line;
            while ((line = requests.getReader().readLine()) != null) {
                all_line.append(line);
            }
            JSONObject obj = new JSONObject(all_line.toString());
            return checkUserPassword((String) obj.get("user_name"), (String) obj.get("password"));
        }
        return null;
    }
}
