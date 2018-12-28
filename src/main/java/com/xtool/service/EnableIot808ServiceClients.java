package com.xtool.service;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({
    DeviceServiceFallbackFactory.class
	,DevStatServiceFallbackFactory.class
	,InOrderServiceFallbackFactory.class
	,OrderIdServiceFallbackFactory.class
	,DevonlServiceFallbackFactory.class
    ,ParamServiceFallbackFactory.class
    ,PositionServiceFallbackFactory.class})
@Documented
public @interface EnableIot808ServiceClients {

}
