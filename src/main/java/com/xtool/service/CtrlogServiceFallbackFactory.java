package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.ctrlog.ctrlogCondition;
import com.xtool.iot808data.ctrlog.ctrlogModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class CtrlogServiceFallbackFactory implements FallbackFactory<ICtrlogServiceClient>
{
	@Override
	public ICtrlogServiceClient create(Throwable cause)
    {
		return new ICtrlogServiceClient()
        {
			@Override
            public RespState<Boolean> add(ctrlogModel data)
            {
                return response(1000, false, "ctrlog service not accessible");
			}
			
			
			@Override
            public RespState<Boolean> addrange(ctrlogModel[] datas)
            {
                return response(1000, false, "ctrlog service not accessible");
			}
    

            @Override
            public RespState<DataSearchResult<ctrlogModel>> get(ctrlogCondition condition)
            {
                RespState<DataSearchResult<ctrlogModel>> result = new RespState<DataSearchResult<ctrlogModel>>();
        
                DataSearchResult<ctrlogModel> data = new DataSearchResult<ctrlogModel>();
                data.pageIndex = 0;
                data.pageSize = 0;
                data.total = 0;
                data.data = new ArrayList<ctrlogModel>(0);
        
                result.setCode(1000);
                result.setData(data);
                result.setMsg("ctrlog service not accessible");
                return result;
            }
    
    
            @Override
            public RespState<ctrlogModel> getbyid(String id)
            {
                return response(1000, null, "ctrlog service not accessible");
            }
    
            
            private <T> RespState<T> response(int code, T data, String message)
            {
                RespState<T> result = new RespState<>();
                result.setCode(code);
                result.setMsg(message);
                result.setData(data);
                return result;
            }
        };
	}

}
