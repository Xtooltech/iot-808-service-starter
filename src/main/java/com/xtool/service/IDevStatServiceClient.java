package com.xtool.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.devstat.devstatCondition;
import com.xtool.iot808data.devstat.devstatModel;

@FeignClient(value="iot-808-devstat-service",fallbackFactory=DevStatServiceFallbackFactory.class)
public interface IDevStatServiceClient {

	@RequestMapping(path="/devstat/upsert",method=RequestMethod.POST,headers= {"Content-Type=application/json"})
	public RespState<Boolean> upsert(@RequestBody devstatModel data);
	
	@RequestMapping(value="/devstat/get",method= {RequestMethod.POST},headers= {"Content-Type=application/json"})
	public RespState<DataSearchResult<devstatModel>> get(@RequestBody devstatCondition condition);
	
}
