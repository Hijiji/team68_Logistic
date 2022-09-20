package kr.co.seoulit.logistics.logisticsInfo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.co.seoulit.logistics.logisticsInfo.serviceFacade.LogisticsInfoServiceFacade;
import kr.co.seoulit.logistics.logisticsInfo.to.WarehouseTO;

@RestController
@RequestMapping("/logisticsInfo/*")
public class WarehouseController {

	// serviceFacade 참조변수 선언
	@Autowired
	private LogisticsInfoServiceFacade logisticsSF;

	private ModelMap modelMap = new ModelMap();
	
	// GSON 라이브러리
	private static Gson gson = new GsonBuilder().serializeNulls().create(); // 속성값이 null 인 속성도 json 변환

	@RequestMapping(value = "/warehouseInfo.do", method = RequestMethod.POST)
	public ModelMap getWarehouseList(HttpServletRequest request, HttpServletResponse response) {

		try {
			ArrayList<WarehouseTO> WarehouseTOList = logisticsSF.getWarehouseInfoList();
			modelMap.put("gridRowJson", WarehouseTOList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");
			
		} catch (Exception e1) {
			e1.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e1.getMessage());
		}

		return modelMap;
	}

	
	public ModelMap modifyWarehouseInfo(HttpServletRequest request, HttpServletResponse response) {

		String batchList = request.getParameter("batchList");

		try {
			WarehouseTO WarehouseTO = gson.fromJson(batchList, WarehouseTO.class);
			logisticsSF.modifyWarehouseInfo(WarehouseTO);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e1) {
			e1.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e1.getMessage());
		}

		return null;
	}
	
	
	public ModelMap findLastWarehouseCode(HttpServletRequest request, HttpServletResponse response){

		try {

			String warehouseCode = logisticsSF.findLastWarehouseCode();
			modelMap.put("lastWarehouseCode", warehouseCode);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");
		
		} catch (Exception e1) {
			
			e1.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e1.getMessage());
		}

		return modelMap;
	}
	

}
