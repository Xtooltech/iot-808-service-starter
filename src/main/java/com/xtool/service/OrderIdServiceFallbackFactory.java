package com.xtool.service;

import org.springframework.stereotype.Component;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.xtool.enterprise.RespState;

import feign.hystrix.FallbackFactory;

@Component
public class OrderIdServiceFallbackFactory implements FallbackFactory<IOrderIdServiceClient> {

	//private Logger logger= LoggerFactory.getLogger(getClass());
	@Override
	public IOrderIdServiceClient create(Throwable cause) {
		//logger.error(cause.getMessage());
		return new IOrderIdServiceClient() {
			
			@Override
			public RespState<String> NextId() {
				RespState<String> result=new RespState<>();
				result.setCode(1000);
				result.setData("");
				result.setMsg(cause.getMessage());
				return result;
			}
		};
	}

}