package team.bxcc.sap.aop.resolvers;

import org.json.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import team.bxcc.sap.config.ConStants;
import team.bxcc.sap.domain.mysql.UserInfo;
import team.bxcc.sap.util.annotation.RequestUserInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * User info参数验证拦截器
 *
 * @author FengTao
 * @date 2018/2/1.
 */
@Component
public class RequestUserInfoArgumentResolver implements HandlerMethodArgumentResolver {

    private UserInfo checkInputParam(String user_id, long date1, long date2, String home, String job, String name,
                                     int nation, int political, int sex, String speciality, String undergraduate,
                                     String workstation) {
        if (!user_id.equals("") && name.matches(ConStants.MATCH_REGULAR_EXP_NAME)) {
            return new UserInfo(user_id, name, sex, nation, home, political, workstation, job, undergraduate,
                    speciality, new Timestamp(date1), new Timestamp(date2));
        } else {
            return null;
        }

    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是UserInfo并且有CheckCurrentUser注解则支持
        return parameter.getParameterType().isAssignableFrom(UserInfo.class) &&
                parameter.hasParameterAnnotation(RequestUserInfo.class);
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
            return checkInputParam((String) obj.get("user_id"), (Long) obj.get("date1"), (Long) obj.get("date2"), (String) obj.get("home"),
                    (String) obj.get("job"), (String) obj.get("name"), (Integer) obj.get("nation"),
                    (Integer) obj.get("political"), (Integer) obj.get("sex"), (String) obj.get("speciality"),
                    (String) obj.get("undergraduate"), (String) obj.get("workstation"));
        }
        return null;
    }
}
