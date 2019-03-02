package com.xtool.service;

import java.util.ArrayList;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.devonl.devonlCondition;
import com.xtool.iot808data.devonl.devonlModel;

import feign.hystrix.FallbackFactory;

public class DevonlServiceFallbackFactory implements FallbackFactory<IDevonlServiceClient>{

	@Override
	public IDevonlServiceClient create(Throwable cause) {
		return new IDevonlServiceClient() {
			
			@Override
			public RespState<DataSearchResult<devonlModel>> get(devonlCondition condition) {
				RespState<DataSearchResult<devonlModel>> result=new RespState<DataSearchResult<devonlModel>>();
				
				DataSearchResult<devonlModel> data=new DataSearchResult<devonlModel>();
				data.pageIndex=0;
				data.pageSize=0;
				data.total=0;
				data.data=new ArrayList<devonlModel>(0);
				
				result.setCode(1000);
				result.setData(data);
				result.setMsg("remote get service not accessible");
				return result;
			}
			
			@Override
			public RespState<Boolean> upsert(Boolean ignoreNull,devonlModel data) {
				RespState<Boolean> result=new RespState<Boolean>();
				result.setCode(1000);
				result.setData(false);
				result.setMsg("remote add service not accessible");
				return result;
			}
            
            @Override
            public RespState<Boolean> bupsert(Boolean ignoreNull,devonlModel[] datas) {
                RespState<Boolean> result=new RespState<Boolean>();
                result.setCode(1000);
                result.setData(false);
                result.setMsg("remote add service not accessible");
                return result;
            }

			@Override
			public RespState<Boolean> remove(String sno) {
				RespState<Boolean> result=new RespState<Boolean>();
				result.setCode(1000);
				result.setData(false);
				result.setMsg("remote remove service not accessible");
				return result;
			}
		};
	}

}
