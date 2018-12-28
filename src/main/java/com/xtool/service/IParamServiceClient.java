package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.devparam.devparamModel;
import com.xtool.iot808data.devparam.devparamCondition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="iot-808-param-service", fallbackFactory=ParamServiceFallbackFactory.class)
public interface IParamServiceClient
{
	@RequestMapping(path="/add", method=RequestMethod.POST, headers={"Content-Type=application/json"})
	RespState<Boolean> add(@RequestBody devparamModel data);
	
	@RequestMapping(value="/get", method={RequestMethod.POST}, headers={"Content-Type=application/json"})
	RespState<DataSearchResult<devparamModel>> get(@RequestBody devparamCondition condition);
	
	@RequestMapping(path="/upsert", method={RequestMethod.POST}, headers={"Content-Type=application/json"})
	RespState<Boolean> upsert(@RequestBody devparamModel data);
}
