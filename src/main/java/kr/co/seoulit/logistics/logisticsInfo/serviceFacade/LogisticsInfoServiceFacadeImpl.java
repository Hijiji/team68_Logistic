package kr.co.seoulit.logistics.logisticsInfo.serviceFacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.logisticsInfo.applicationService.ItemApplicationService;
import kr.co.seoulit.logistics.logisticsInfo.applicationService.WarehouseApplicationService;
import kr.co.seoulit.logistics.logisticsInfo.to.ItemInfoTO;
import kr.co.seoulit.logistics.logisticsInfo.to.ItemTO;
import kr.co.seoulit.logistics.logisticsInfo.to.WarehouseTO;

@Service
public class LogisticsInfoServiceFacadeImpl implements LogisticsInfoServiceFacade {

	// 참조변수 선언
	@Autowired
	private ItemApplicationService itemAS;
	@Autowired
	private WarehouseApplicationService warehouseAS;

	@Override
	public ArrayList<ItemInfoTO> getItemInfoList(String searchCondition, String[] paramArray) {

		ArrayList<ItemInfoTO> itemInfoList = null;

			itemInfoList = itemAS.getItemInfoList(searchCondition, paramArray);


		return itemInfoList;
	}

	@Override
	public ModelMap batchItemListProcess(ArrayList<ItemTO> itemTOList) {

		ModelMap modelMap = new ModelMap();

		modelMap = itemAS.batchItemListProcess(itemTOList);

		return modelMap;
	}

	@Override
	public ArrayList<WarehouseTO> getWarehouseInfoList() {

		ArrayList<WarehouseTO> warehouseInfoList = null;

			warehouseInfoList = warehouseAS.getWarehouseInfoList();

		return warehouseInfoList;
	}

	@Override
	public void modifyWarehouseInfo(WarehouseTO warehouseTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findLastWarehouseCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStandardUnitPrice(String itemCode) {

		int price = 0;

			price = itemAS.getStandardUnitPrice(itemCode);

		return price;
		
	}
	
	@Override
	public int getStandardUnitPriceBox(String itemCode) {

		int price = 0;

			price = itemAS.getStandardUnitPriceBox(itemCode);

		return price;
		
	}

}
