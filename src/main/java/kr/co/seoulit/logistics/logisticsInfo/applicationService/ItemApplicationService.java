package kr.co.seoulit.logistics.logisticsInfo.applicationService;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.logisticsInfo.to.ItemInfoTO;
import kr.co.seoulit.logistics.logisticsInfo.to.ItemTO;

public interface ItemApplicationService {

	public ArrayList<ItemInfoTO> getItemInfoList(String searchCondition, String[] paramArray);
	
	public ModelMap batchItemListProcess(ArrayList<ItemTO> itemTOList);
		
	public int getStandardUnitPrice(String itemCode);
	
	public int getStandardUnitPriceBox(String itemCode);
}
