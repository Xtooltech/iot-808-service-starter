package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.pos.posCondition;
import com.xtool.iot808data.pos.posModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


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
				RespState<Boolean> result=new RespState<Boolean>();
				result.setCode(1000);
				result.setData(false);
				result.setMsg("position test service not accessible");
				return result;
			}
			
			@Override
            public RespState<Boolean> add(posModel position)
            {
                RespState<Boolean> result=new RespState<Boolean>();
                result.setCode(1000);
                result.setData(false);
                result.setMsg("remote add service not accessible");
                return result;
			}
			
			
			@Override
            public RespState<Boolean> addrange(posModel[] positions)
            {
				RespState<Boolean> result=new RespState<Boolean>();
				result.setCode(1000);
				result.setData(false);
				result.setMsg("remote add service not accessible");
				return result;
			}
    
			
            @Override
            public RespState<DataSearchResult<posModel>> get(posCondition condition)
            {
                return null;
            }
    
    
            @Override
            public RespState<DataSearchResult<posModel>> getbyid(String id)
            {
                return null;
            }
    
            @Override
            public RespState<DataSearchResult<posModel>> getlastedpos()
            {
                return null;
            }
		};
	}

}
