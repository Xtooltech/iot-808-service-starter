package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.pos.posCondition;
import com.xtool.iot808data.pos.posModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="iot-808-position-service", fallbackFactory=PositionServiceFallbackFactory.class)
public interface IPositionServiceClient
{
    @RequestMapping(path="/test", method=RequestMethod.GET)
    RespState<Boolean> test();
    
    @RequestMapping(path="/add", method=RequestMethod.POST, headers= {"Content-Type=application/json"})
    RespState<Boolean> add(@RequestBody posModel position);
    
    @RequestMapping(path="/addrange", method=RequestMethod.POST, headers= {"Content-Type=application/json"})
    RespState<Boolean> addrange(@RequestBody posModel[] positions);
    
    @RequestMapping(path="/get", method=RequestMethod.POST, headers= {"Content-Type=application/json"})
    RespState<DataSearchResult<posModel>> get(@RequestBody posCondition condition);
    
    @RequestMapping(path="/getbyid", method=RequestMethod.GET)
    RespState<posModel> getbyid(String id);
    
    @RequestMapping(path="/getlastedpos", method=RequestMethod.GET)
    RespState<DataSearchResult<posModel>> getlastedpos();
}
