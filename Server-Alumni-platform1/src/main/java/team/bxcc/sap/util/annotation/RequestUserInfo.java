package team.bxcc.sap.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在Controller的方法参数中使用此注解，该方法在映射时会注入当前登录的UserInfo对象
 *
 * @author FengTao
 * @date 2018/2/1.
 * @see team.bxcc.sap.aop.resolvers.RequestUserInfoArgumentResolver
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestUserInfo {
}
