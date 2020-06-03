package com.family.bbkingweb.aspect;

public @interface PraiseView {
    /**
     * 描述
     */
    String description()  default "点赞切面注解";
}
