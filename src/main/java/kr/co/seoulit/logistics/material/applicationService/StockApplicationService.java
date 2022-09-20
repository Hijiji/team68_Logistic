package kr.co.seoulit.logistics.material.applicationService;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.material.to.StockLogTO;
import kr.co.seoulit.logistics.material.to.StockTO;

public interface StockApplicationService {
	
	public ArrayList<StockTO> getStockList();
	
	public ArrayList<StockLogTO> getStockLogList(String startDate,String endDate);
	
	public ModelMap warehousing(ArrayList<String> orderNoArr);
	
	public ModelMap changeSafetyAllowanceAmount(String itemCode, String itemName,
			String safetyAllowanceAmount);
}
