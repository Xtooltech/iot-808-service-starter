package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.devparam.devparamModel;
import com.xtool.iot808data.pos.posCondition;
import com.xtool.iot808data.pos.posModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class PositionServiceFallbackFactory implements FallbackFactory<IPositionServiceClient>
{
	@Override
	public IPositionServiceClient create(Throwable cause)
    {
		return new IPositionServiceClient()
        {
			@Override
			public RespState<Boolean> test()
            {
                return response(1000, false, "position test service not accessible");
			}
			
			@Override
            public RespState<Boolean> add(posModel position)
            {
                return response(1000, false, "position test service not accessible");
			}
			
			
			@Override
            public RespState<Boolean> addrange(posModel[] positions)
            {
                return response(1000, false, "position test service not accessible");
			}
    
			
            @Override
            public RespState<DataSearchResult<posModel>> get(posCondition condition)
            {
                RespState<DataSearchResult<posModel>> result = new RespState<DataSearchResult<posModel>>();
    
                DataSearchResult<posModel> data = new DataSearchResult<posModel>();
                data.pageIndex = 0;
                data.pageSize = 0;
                data.total = 0;
                data.data = new ArrayList<posModel>(0);
    
                result.setCode(1000);
                result.setData(data);
                result.setMsg("remote get service not accessible");
                return result;
            }
    
    
            @Override
            public RespState<posModel> getbyid(String id)
            {
                return response(1000, null, "position test service not accessible");
            }
    
            @Override
            public RespState<DataSearchResult<posModel>> getlastedpos()
            {
                RespState<DataSearchResult<posModel>> result = new RespState<DataSearchResult<posModel>>();
    
                DataSearchResult<posModel> data = new DataSearchResult<posModel>();
                data.pageIndex = 0;
                data.pageSize = 0;
                data.total = 0;
                data.data = new ArrayList<posModel>(0);
    
                result.setCode(1000);
                result.setData(data);
                result.setMsg("remote get service not accessible");
                return result;
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
