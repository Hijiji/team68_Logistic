package kr.co.seoulit.logistics.material.serviceFacade;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.material.to.BomDeployTO;
import kr.co.seoulit.logistics.material.to.BomInfoTO;
import kr.co.seoulit.logistics.material.to.BomTO;
import kr.co.seoulit.logistics.material.to.OrderInfoTO;
import kr.co.seoulit.logistics.material.to.StockLogTO;
import kr.co.seoulit.logistics.material.to.StockTO;



public interface MaterialServiceFacade {

	public ArrayList<BomDeployTO> getBomDeployList(String deployCondition, String itemCode, String itemClassificationCondition);
	
	public ArrayList<BomInfoTO> getBomInfoList(String parentItemCode);
	
	public ArrayList<BomInfoTO> getAllItemWithBomRegisterAvailable();
	
	public ModelMap batchBomListProcess(ArrayList<BomTO> batchBomList);
	
	public ModelMap getOrderList(String startDate, String endDate);
	
	public ModelMap getOrderDialogInfo(String mrpNoArr);
	
	public ModelMap order(ArrayList<String> mrpGaNoArr);
	
	public ModelMap optionOrder(String itemCode, String itemAmount);
	
	public ModelMap warehousing(ArrayList<String> orderNoArr);
	
	public ArrayList<StockTO> getStockList();
	
	public ArrayList<StockLogTO> getStockLogList(String startDate,String endDate);
	
	public ArrayList<OrderInfoTO> getOrderInfoListOnDelivery();
	
	public ArrayList<OrderInfoTO> getOrderInfoList(String startDate,String endDate);

	public ModelMap changeSafetyAllowanceAmount(String itemCode, String itemName,
			String safetyAllowanceAmount);

	public ModelMap checkOrderInfo(ArrayList<String> orderNoArr);
}
