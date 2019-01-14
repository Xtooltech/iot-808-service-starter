package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.ctrlog.ctrlogCondition;
import com.xtool.iot808data.ctrlog.ctrlogModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="iot-808-ctrlog-service", fallbackFactory=CtrlogServiceFallbackFactory.class)
public interface ICtrlogServiceClient
{
    @RequestMapping(path="/add", method=RequestMethod.POST, headers= {"Content-Type=application/json"})
    RespState<Boolean> add(@RequestBody ctrlogModel data);
    
    @RequestMapping(path="/addrange", method=RequestMethod.POST, headers= {"Content-Type=application/json"})
    RespState<Boolean> addrange(@RequestBody ctrlogModel[] datas);
    
    @RequestMapping(path="/get", method=RequestMethod.POST, headers= {"Content-Type=application/json"})
    RespState<DataSearchResult<ctrlogModel>> get(@RequestBody ctrlogCondition condition);
    
    @RequestMapping(path="/getbyid", method=RequestMethod.GET)
    RespState<ctrlogModel> getbyid(String id);
}
