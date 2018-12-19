package com.xtool.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.xtool.enterprise.RespState;
import com.xtool.enterprise.data.DataSearchResult;
import com.xtool.iot808data.inorder.inorderCondition;
import com.xtool.iot808data.inorder.inorderModel;

import feign.hystrix.FallbackFactory;

@Component
public class InOrderServiceFallbackFactory implements FallbackFactory<IInOrderServiceClient>{

	@Override
	public IInOrderServiceClient create(Throwable cause) {
		return new IInOrderServiceClient() {
			
			@Override
			public RespState<Boolean> remove(String oid) {
				RespState<Boolean> result=new RespState<Boolean>();
				result.setCode(1000);
				result.setData(false);
				result.setMsg("remote remove service not accessible");
				return result;
			}
			
			@Override
			public RespState<DataSearchResult<inorderModel>> get(inorderCondition condition) {
				RespState<DataSearchResult<inorderModel>> result=new RespState<DataSearchResult<inorderModel>>();
				
				DataSearchResult<inorderModel> data=new DataSearchResult<inorderModel>();
				data.pageIndex=0;
				data.pageSize=0;
				data.total=0;
				data.data=new ArrayList<inorderModel>(0);
				
				result.setCode(1000);
				result.setData(data);
				result.setMsg("remote get service not accessible");
				return result;
			}
			
			@Override
			public RespState<Boolean> add(inorderModel data) {
				RespState<Boolean> result=new RespState<Boolean>();
				result.setCode(1000);
				result.setData(false);
				result.setMsg("remote add service not accessible");
				return result;
			}
		};
	}

}
