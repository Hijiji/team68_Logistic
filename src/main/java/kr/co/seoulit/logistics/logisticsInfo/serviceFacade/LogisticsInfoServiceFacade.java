package kr.co.seoulit.logistics.logisticsInfo.serviceFacade;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.logisticsInfo.to.ItemInfoTO;
import kr.co.seoulit.logistics.logisticsInfo.to.ItemTO;
import kr.co.seoulit.logistics.logisticsInfo.to.WarehouseTO;

public interface LogisticsInfoServiceFacade {

	public ArrayList<ItemInfoTO> getItemInfoList(String searchCondition, String[] paramArray);
	
	public ModelMap batchItemListProcess(ArrayList<ItemTO> itemTOList);

	public ArrayList<WarehouseTO> getWarehouseInfoList();

	public void modifyWarehouseInfo(WarehouseTO warehouseTO);

	public String findLastWarehouseCode();
	
	public int getStandardUnitPrice(String itemCode);
	
	public int getStandardUnitPriceBox(String itemCode);
	
}
