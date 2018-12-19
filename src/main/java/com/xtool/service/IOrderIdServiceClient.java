package com.xtool.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xtool.enterprise.RespState;

@FeignClient(value="iot-808-orderid-service",fallbackFactory=OrderIdServiceFallbackFactory.class)
public interface IOrderIdServiceClient {

	@RequestMapping(value="/nextid")
	RespState<String> NextId();
}
