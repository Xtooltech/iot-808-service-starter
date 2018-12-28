package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.device.deviceCondition;
import com.xtool.iot808data.device.deviceModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class DeviceServiceFallbackFactory implements FallbackFactory<IDeviceServiceClient>
{
	@Override
	public IDeviceServiceClient create(Throwable cause)
    {
		return new IDeviceServiceClient()
        {
            @Override
            public RespState<Boolean> upsert(deviceModel data)
            {
                RespState<Boolean> result=new RespState<Boolean>();
                result.setCode(1000);
                result.setData(false);
                result.setMsg("remote add service not accessible");
                return result;
            }
    
            @Override
            public RespState<DataSearchResult<deviceModel>> get(deviceCondition condition)
            {
                RespState<DataSearchResult<deviceModel>> result = new RespState<DataSearchResult<deviceModel>>();
    
                DataSearchResult<deviceModel> data = new DataSearchResult<>();
                data.pageIndex = 0;
                data.pageSize = 0;
                data.total = 0;
                data.data = new ArrayList<deviceModel>(0);
    
                result.setCode(1000);
                result.setData(data);
                result.setMsg("remote get service not accessible");
                return result;
            }
    
            
            @Override
            public RespState<Boolean> remove(String sno)
            {
                RespState<Boolean> result=new RespState<Boolean>();
                result.setCode(1000);
                result.setData(false);
                result.setMsg("remote remove service not accessible");
                return result;
            }
    
            
            @Override
            public RespState<Boolean> updprop(deviceModel data)
            {
                RespState<Boolean> result=new RespState<Boolean>();
                result.setCode(1000);
                result.setData(false);
                result.setMsg("remote remove service not accessible");
                return result;
            }
		};
	}

}
