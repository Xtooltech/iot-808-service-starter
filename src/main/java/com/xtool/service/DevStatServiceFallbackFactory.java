package com.xtool.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.devstat.devstatCondition;
import com.xtool.iot808data.devstat.devstatModel;

import feign.hystrix.FallbackFactory;

@Component
public class DevStatServiceFallbackFactory implements FallbackFactory<IDevStatServiceClient>{

	@Override
	public IDevStatServiceClient create(Throwable cause) {
		return new IDevStatServiceClient() {
			
			@Override
			public RespState<DataSearchResult<devstatModel>> get(devstatCondition condition) {
				RespState<DataSearchResult<devstatModel>> result=new RespState<DataSearchResult<devstatModel>>();
				
				DataSearchResult<devstatModel> data=new DataSearchResult<devstatModel>();
				data.pageIndex=0;
				data.pageSize=0;
				data.total=0;
				data.data=new ArrayList<devstatModel>(0);
				
				result.setCode(1000);
				result.setData(data);
				result.setMsg("remote get service not accessible");
				return result;
			}
			
			@Override
			public RespState<Boolean> upsert(devstatModel data) {
				RespState<Boolean> result=new RespState<Boolean>();
				result.setCode(1000);
				result.setData(false);
				result.setMsg("remote add service not accessible");
				return result;
			}
		};
	}

}