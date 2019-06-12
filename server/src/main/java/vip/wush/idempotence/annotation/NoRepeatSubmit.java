package vip.wush.idempotence.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @ClassName: noRepeatSubmit
 * @Description: 自定义注解
 * @Author: wush
 * @Date: 2019/6/12 11:02
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface NoRepeatSubmit {

    int lockTime() default 100;

}
