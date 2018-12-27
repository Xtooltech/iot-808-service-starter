package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.inorder.inorderCondition;
import com.xtool.iot808data.inorder.inorderModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="iot-808-param-service", fallbackFactory=ParamServiceFallbackFactory.class)
public interface IParamServiceClient
{
	@RequestMapping(path="/param/add", method=RequestMethod.POST, headers={"Content-Type=application/json"})
	public RespState<Boolean> add(@RequestBody inorderModel data);
	
	@RequestMapping(value="/param/get", method={RequestMethod.POST}, headers={"Content-Type=application/json"})
	public RespState<DataSearchResult<inorderModel>> get(@RequestBody inorderCondition condition);
	
	@RequestMapping(path="/param/remove", method={RequestMethod.POST}, headers={"Content-Type=application/x-www-form-urlencoded"})
	public RespState<Boolean> remove(@RequestParam(value = "oid", required = true) String oid);
}
