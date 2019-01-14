package com.xtool.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.devonl.devonlCondition;
import com.xtool.iot808data.devonl.devonlModel;

@FeignClient(value="iot-808-devonl-service",fallbackFactory=DevonlServiceFallbackFactory.class)
public interface IDevonlServiceClient {
	@RequestMapping(path="/devonl/upsert"
			,method=RequestMethod.POST
			,headers= {"Content-Type=application/json"})
	public RespState<Boolean> upsert(
			@RequestParam(name="ignoreNull",required=false) 
			@Nullable
			Boolean ignoreNull
			, @RequestBody
			devonlModel model);
	
	@RequestMapping(value="/devonl/get"
			,method= {RequestMethod.POST}
			,headers= {"Content-Type=application/json"})
	public RespState<DataSearchResult<devonlModel>> get(
			@RequestBody 
			devonlCondition condition);
	
	@RequestMapping(path="/devonl/remove"
			,method= {RequestMethod.POST}
			,headers= {"Content-Type=application/x-www-form-urlencoded"})
	public RespState<Boolean> remove(
			@RequestParam(name="sno",required=true) 
			String sno);
}
