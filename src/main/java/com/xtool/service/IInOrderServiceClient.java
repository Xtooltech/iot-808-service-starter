package com.xtool.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.inorder.inorderCondition;
import com.xtool.iot808data.inorder.inorderModel;

@FeignClient(value="iot-808-inorder-service",fallbackFactory=InOrderServiceFallbackFactory.class)
public interface IInOrderServiceClient {

	@RequestMapping(path="/inorder/add",method=RequestMethod.POST,headers= {"Content-Type=application/json"})
	public RespState<Boolean> add(@RequestBody inorderModel data);
	
	@RequestMapping(value="/inorder/get",method= {RequestMethod.POST},headers= {"Content-Type=application/json"})
	public RespState<DataSearchResult<inorderModel>> get(@RequestBody inorderCondition condition);
	
	@RequestMapping(path="/inorder/remove",method= {RequestMethod.POST},headers= {"Content-Type=application/x-www-form-urlencoded"})
	public RespState<Boolean> remove(@RequestParam String oid);
}
