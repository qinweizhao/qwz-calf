package com.qinweizhao.core.annotation;

import java.lang.annotation.*;

/**
 * 该注解可以限制某些条件下禁止访问api
 * @author qinweizhao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DisableOnCondition {

}
