package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.device.deviceCondition;
import com.xtool.iot808data.device.deviceModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="iot-808-device-service", fallbackFactory=DeviceServiceFallbackFactory.class)
public interface IDeviceServiceClient
{
    @RequestMapping(path="/upsert", method={RequestMethod.POST}, headers={"Content-Type=application/json"})
    RespState<Boolean> upsert(@RequestBody deviceModel data);
    
    @RequestMapping(value="/get", method={RequestMethod.POST}, headers={"Content-Type=application/json"})
    RespState<DataSearchResult<deviceModel>> get(@RequestBody deviceCondition condition);
    
    @RequestMapping(path="/remove", method=RequestMethod.POST, headers= {"Content-Type=application/x-www-form-urlencoded"})
	RespState<Boolean> remove(@RequestParam(name = "sno", required = true) String sno);
    
    @RequestMapping(value="/updprop", method={RequestMethod.POST}, headers={"Content-Type=application/json"})
    RespState<Boolean> updprop(@RequestBody deviceModel data);
}
