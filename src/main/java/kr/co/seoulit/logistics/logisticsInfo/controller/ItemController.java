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
import com.google.gson.reflect.TypeToken;

import kr.co.seoulit.logistics.logisticsInfo.serviceFacade.LogisticsInfoServiceFacade;
import kr.co.seoulit.logistics.logisticsInfo.to.ItemInfoTO;
import kr.co.seoulit.logistics.logisticsInfo.to.ItemTO;

@RestController
@RequestMapping("/logisticsInfo/*")
public class ItemController {

	// serviceFacade 참조변수 선언
	@Autowired
	private LogisticsInfoServiceFacade logisticsSF;
	
	private ModelMap modelMap = new ModelMap();
	
	// GSON 라이브러리
	private static Gson gson = new GsonBuilder().serializeNulls().create(); // 속성값이 null 인 속성도 JSON 변환

	@RequestMapping(value="/searchItem.do" , method=RequestMethod.POST)
	public ModelMap searchItem(HttpServletRequest request, HttpServletResponse response) {

		String searchCondition = request.getParameter("searchCondition");
		String itemClassification = request.getParameter("itemClassification");
		String itemGroupCode = request.getParameter("itemGroupCode");
		String minPrice = request.getParameter("minPrice");
		String maxPrice = request.getParameter("maxPrice");

		ArrayList<ItemInfoTO> itemInfoList = null;
		String[] paramArray = null;

		try {

			switch (searchCondition) {

			case "ALL":

				paramArray = null;
				break;

			case "ITEM_CLASSIFICATION":

				paramArray = new String[] { itemClassification };
				break;

			case "ITEM_GROUP_CODE":

				paramArray = new String[] { itemGroupCode };
				break;

			case "STANDARD_UNIT_PRICE":

				paramArray = new String[] { minPrice, maxPrice };
				break;

			}

			itemInfoList = logisticsSF.getItemInfoList(searchCondition, paramArray);

			modelMap.put("gridRowJson", itemInfoList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e1) {
			e1.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e1.getMessage());
		}

		return modelMap;
	}
	
	@RequestMapping(value="/getStandardUnitPrice.do", method=RequestMethod.POST)
	public ModelMap getStandardUnitPrice(HttpServletRequest request, HttpServletResponse response) {


		String itemCode = request.getParameter("itemCode");
			System.out.println("itemCode = "+itemCode);

		int price = 0;

		try {

			price = logisticsSF.getStandardUnitPrice(itemCode);

			modelMap.put("gridRowJson", price);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e1) {
			e1.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e1.getMessage());
		}

		return modelMap;
	}
	
	@RequestMapping(value="/getStandardUnitPriceBox.do", method=RequestMethod.POST)
	public ModelMap getStandardUnitPriceBox(HttpServletRequest request, HttpServletResponse response) {

		String itemCode = request.getParameter("itemCode");
	

		int price = 0;

		try {

			price = logisticsSF.getStandardUnitPriceBox(itemCode);

			modelMap.put("gridRowJson", price);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e1) {
			e1.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e1.getMessage());

		}

		return modelMap;
	}
	
	@RequestMapping(value="/batchListProcess.do", method=RequestMethod.POST)
	public ModelMap batchListProcess(HttpServletRequest request, HttpServletResponse response) {

		String batchList = request.getParameter("batchList");

		ArrayList<ItemTO> itemTOList = gson.fromJson(batchList, new TypeToken<ArrayList<ItemTO>>() {
		}.getType());

		ModelMap model = new ModelMap();

		try {

			 model= logisticsSF.batchItemListProcess(itemTOList);

			modelMap.put("result", model);
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
