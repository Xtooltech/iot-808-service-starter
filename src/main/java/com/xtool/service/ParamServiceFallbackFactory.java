package com.xtool.service;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.inorder.inorderCondition;
import com.xtool.iot808data.inorder.inorderModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class ParamServiceFallbackFactory implements FallbackFactory<IParamServiceClient>
{
	@Override
	public IParamServiceClient create(Throwable cause)
    {
		return new IParamServiceClient()
        {
            @Override
            public RespState<Boolean> add(inorderModel data)
            {
                RespState<Boolean> result=new RespState<Boolean>();
                result.setCode(1000);
                result.setData(false);
                result.setMsg("remote add service not accessible");
                return result;
            }
    
            @Override
            public RespState<DataSearchResult<inorderModel>> get(inorderCondition condition)
            {
                return null;
            }
    
            @Override
            public RespState<Boolean> remove(String oid)
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
