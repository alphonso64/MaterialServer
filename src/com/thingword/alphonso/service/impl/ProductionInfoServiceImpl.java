package com.thingword.alphonso.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingword.alphonso.Configure.MESSAGE;
import com.thingword.alphonso.Configure.ReturnData;
import com.thingword.alphonso.bean.LoadingInfo;
import com.thingword.alphonso.bean.ProductInfoDetail;
import com.thingword.alphonso.bean.ProductionInfo;
import com.thingword.alphonso.bean.StoreProductionInfo;
import com.thingword.alphonso.bean2.VOrderDetail;
import com.thingword.alphonso.dao.ProductionInfoDao;
import com.thingword.alphonso.dao.impl.ERPDaoImpl;
import com.thingword.alphonso.dao.impl.ProductionInfoDaoImpl;
import com.thingword.alphonso.service.ProductionInfoService;

public class ProductionInfoServiceImpl implements ProductionInfoService{

	@Autowired
	private ProductionInfoDaoImpl productionInfoDaoImpl;
	
	@Autowired
	private ERPDaoImpl erpDaoImpl;
	
	@Override
	public ReturnData<ProductionInfo> getProductionInfoByDate(String Date) {
		ReturnData<ProductionInfo> returnData= new ReturnData<>();
			
		List<ProductionInfo> ls= productionInfoDaoImpl.getProductionInfoByDate(Date);
		returnData.setReturn_code(MESSAGE.RETURN_FAIL);
		returnData.setReturn_msg(MESSAGE.QUERY_NONE);
		if(ls != null){
			if(!ls.isEmpty()){
				returnData.setReturn_code(MESSAGE.RETURN_SUCCESS);
				returnData.setReturn_msg(MESSAGE.QUERY_SUCCESS);
				returnData.setData(ls);
			}
		}
		return returnData;
	}

	@Override
	public ReturnData<ProductionInfo> getProductionInfoByDateAndLine(String Date, String Line) {
		ReturnData<ProductionInfo> returnData= new ReturnData<>();
		
		List<ProductionInfo> ls= productionInfoDaoImpl.getProductionInfoByDateAndLine(Date,Line);
		returnData.setReturn_code(MESSAGE.RETURN_FAIL);
		returnData.setReturn_msg(MESSAGE.QUERY_NONE);
		if(ls != null){
			if(!ls.isEmpty()){
				returnData.setReturn_code(MESSAGE.RETURN_SUCCESS);
				returnData.setReturn_msg(MESSAGE.QUERY_SUCCESS);
				returnData.setData(ls);
			}
		}
		return returnData;
	}

	@Override
	public ReturnData<ProductInfoDetail> getProductInfoDetailByDateAndLine(String Date, String Line) {
		ReturnData<ProductInfoDetail> returnData= new ReturnData<>();	
		List<ProductInfoDetail> ls= productionInfoDaoImpl.getProductionInfoDetailByDateAndLine(Date,Line);
		returnData.setReturn_code(MESSAGE.RETURN_FAIL);
		returnData.setReturn_msg(MESSAGE.QUERY_NONE);
		if(ls != null){
			if(!ls.isEmpty()){
				returnData.setReturn_code(MESSAGE.RETURN_SUCCESS);
				returnData.setReturn_msg(MESSAGE.QUERY_SUCCESS);
				returnData.setData(ls);
			}
		}
		return returnData;
	}
	
	@Override
	public ReturnData<ProductInfoDetail> getProductionDetailByTasknumAndProductcode(
			ProductionInfo productionInfo) {
		ReturnData<ProductInfoDetail> returnData= new ReturnData<>();	

		List<ProductionInfo> ls = new ArrayList<>();
		ls.add(productionInfo);
		List<VOrderDetail> vOrderDetails = erpDaoImpl.getVOrderDetail(ls);
		List<ProductInfoDetail> productInfoDetails =  erpDaoImpl.getProductInfoDetail(vOrderDetails);
		
		returnData.setReturn_code(MESSAGE.RETURN_FAIL);
		returnData.setReturn_msg(MESSAGE.QUERY_NONE);
		if(productInfoDetails != null){
			if(!productInfoDetails.isEmpty()){
				returnData.setReturn_code(MESSAGE.RETURN_SUCCESS);
				returnData.setReturn_msg(MESSAGE.QUERY_SUCCESS);
				returnData.setData(productInfoDetails);
			}
		}
		return returnData;
	}

	@Override
	public ReturnData<StoreProductionInfo> getStoreProductionInfoByDate(String Date) {
		ReturnData<StoreProductionInfo> returnData= new ReturnData<>();
		
		List<StoreProductionInfo> ls= productionInfoDaoImpl.getStoreProductionInfoByDate(Date);
		returnData.setReturn_code(MESSAGE.RETURN_FAIL);
		returnData.setReturn_msg(MESSAGE.QUERY_NONE);
		if(ls != null){
			if(!ls.isEmpty()){
				returnData.setReturn_code(MESSAGE.RETURN_SUCCESS);
				returnData.setReturn_msg(MESSAGE.QUERY_SUCCESS);
				returnData.setData(ls);
			}
		}
		return returnData;
	}

	@Override
	public ReturnData<ProductInfoDetail> getProductInfoDetailForTest(String task, String product) {
		ReturnData<ProductInfoDetail> returnData= new ReturnData<>();	
		List<ProductInfoDetail> ls= productionInfoDaoImpl.getProductionInfoForLocalTest(task, product);
		returnData.setReturn_code(MESSAGE.RETURN_FAIL);
		returnData.setReturn_msg(MESSAGE.QUERY_NONE);
		if(ls != null){
			if(!ls.isEmpty()){
				returnData.setReturn_code(MESSAGE.RETURN_SUCCESS);
				returnData.setReturn_msg(MESSAGE.QUERY_SUCCESS);
				returnData.setData(ls);
			}
		}
		return returnData;
	}

}
