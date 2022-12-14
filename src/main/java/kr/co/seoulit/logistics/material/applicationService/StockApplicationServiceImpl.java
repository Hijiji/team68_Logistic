package kr.co.seoulit.logistics.material.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.material.mapper.StockDAO;
import kr.co.seoulit.logistics.material.to.StockLogTO;
import kr.co.seoulit.logistics.material.to.StockTO;

@Component
public class StockApplicationServiceImpl implements StockApplicationService{

	@Autowired
	private StockDAO stockDAO;
	
		@Override
		public ArrayList<StockTO> getStockList() {

			ArrayList<StockTO> stockList = null;

				stockList = stockDAO.selectStockList();

			return stockList;
		}
	
		@Override
		public ArrayList<StockLogTO> getStockLogList(String startDate,String endDate) {

			HashMap<String, String> param = new HashMap<>();
			param.put("startDate", startDate);
			param.put("endDate", endDate);

			return stockDAO.selectStockLogList(param);
		}

		@Override
		public ModelMap warehousing(ArrayList<String> orderNoArr) {

			String orderNoList = orderNoArr.toString().replace("[", "").replace("]", "");

			HashMap<String, String> param = new HashMap<>();
			param.put("orderNoList", orderNoList);

			stockDAO.warehousing(param);
			
			ModelMap modelMap = new ModelMap();
			modelMap.put("errorCode", param.get("ERROR_CODE"));
			modelMap.put("errorMsg", param.get("ERROR_MSG"));
			
        	return modelMap;
			
		}
		
		@Override
		public ModelMap changeSafetyAllowanceAmount(String itemCode, String itemName,
				String safetyAllowanceAmount) {

			HashMap<String,String> param = new HashMap<>();
			param.put("itemCode",itemCode);
			param.put("itemName",itemName);
			param.put("safetyAllowanceAmount",safetyAllowanceAmount);

			stockDAO.updatesafetyAllowance(param);

			ModelMap modelMap = new ModelMap();
			modelMap.put("errorCode", param.get("ERROR_CODE")); //성공시 0
			modelMap.put("errorMsg", param.get("ERROR_MSG")); //## MPS등록완료 ##
			
			return modelMap;
		}
		
}
