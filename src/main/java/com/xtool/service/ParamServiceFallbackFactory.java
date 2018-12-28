package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.devparam.devparamCondition;
import com.xtool.iot808data.devparam.devparamModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class ParamServiceFallbackFactory implements FallbackFactory<IParamServiceClient>
{
	@Override
	public IParamServiceClient create(Throwable cause)
    {
		return new IParamServiceClient()
        {
            @Override
            public RespState<Boolean> add(devparamModel data)
            {
                RespState<Boolean> result=new RespState<Boolean>();
                result.setCode(1000);
                result.setData(false);
                result.setMsg("remote add service not accessible");
                return result;
            }
    
            @Override
            public RespState<DataSearchResult<devparamModel>> get(devparamCondition condition)
            {
                RespState<DataSearchResult<devparamModel>> result = new RespState<DataSearchResult<devparamModel>>();
    
                DataSearchResult<devparamModel> data = new DataSearchResult<devparamModel>();
                data.pageIndex = 0;
                data.pageSize = 0;
                data.total = 0;
                data.data = new ArrayList<devparamModel>(0);
    
                result.setCode(1000);
                result.setData(data);
                result.setMsg("remote get service not accessible");
                return result;
            }
    
            @Override
            public RespState<Boolean> upsert(devparamModel data)
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
