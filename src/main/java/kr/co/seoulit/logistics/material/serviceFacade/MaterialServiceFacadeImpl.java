package kr.co.seoulit.logistics.material.serviceFacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.material.applicationService.BomApplicationService;
import kr.co.seoulit.logistics.material.applicationService.OrderApplicationService;
import kr.co.seoulit.logistics.material.applicationService.StockApplicationService;
import kr.co.seoulit.logistics.material.to.BomDeployTO;
import kr.co.seoulit.logistics.material.to.BomInfoTO;
import kr.co.seoulit.logistics.material.to.BomTO;
import kr.co.seoulit.logistics.material.to.OrderInfoTO;
import kr.co.seoulit.logistics.material.to.StockLogTO;
import kr.co.seoulit.logistics.material.to.StockTO;

@Service
public class MaterialServiceFacadeImpl implements MaterialServiceFacade {

	// 참조변수 선언
	@Autowired
	private BomApplicationService bomAS;
	@Autowired
	private OrderApplicationService orderAS;
	@Autowired
	private StockApplicationService stockAS;
	
	private ModelMap modelMap = new ModelMap();
	
	@Override
	public ArrayList<BomDeployTO> getBomDeployList(String deployCondition, String itemCode,
			String itemClassificationCondition) {

		ArrayList<BomDeployTO> bomDeployList = null;

			bomDeployList = bomAS.getBomDeployList(deployCondition, itemCode, itemClassificationCondition);

		return bomDeployList;
	}

	@Override
	public ArrayList<BomInfoTO> getBomInfoList(String parentItemCode) {

		ArrayList<BomInfoTO> bomInfoList = null;

			bomInfoList = bomAS.getBomInfoList(parentItemCode);

		return bomInfoList;
	}

	@Override
	public ModelMap getOrderList(String startDate, String endDate) {

		ModelMap modelMap = null;

		modelMap = orderAS.getOrderList(startDate, endDate);

		return modelMap;
	}

	@Override
	public ArrayList<BomInfoTO> getAllItemWithBomRegisterAvailable() {

		ArrayList<BomInfoTO> allItemWithBomRegisterAvailable = null;

			allItemWithBomRegisterAvailable = bomAS.getAllItemWithBomRegisterAvailable();

		return allItemWithBomRegisterAvailable;
	}

	@Override
	public ModelMap batchBomListProcess(ArrayList<BomTO> batchBomList) {

		modelMap = bomAS.batchBomListProcess(batchBomList);

		return modelMap;

	}

	@Override
	public ModelMap getOrderDialogInfo(String mrpNoArr) {

        modelMap = orderAS.getOrderDialogInfo(mrpNoArr);

		return modelMap;

	}

	@Override
	public ModelMap order(ArrayList<String> mrpGaNoArr) {

        modelMap = orderAS.order(mrpGaNoArr);

    	return modelMap;
		
	}

	@Override
	public ModelMap optionOrder(String itemCode, String itemAmount) {
		// TODO Auto-generated method stub

        modelMap = orderAS.optionOrder(itemCode, itemAmount);

    	return modelMap;
		
	}

	@Override
	public ArrayList<StockTO> getStockList() {

		ArrayList<StockTO> stockList = null;

			stockList = stockAS.getStockList();

		return stockList;
	}

	@Override
	public ArrayList<StockLogTO> getStockLogList(String startDate, String endDate) {

		ArrayList<StockLogTO> stockLogList = null;


			stockLogList = stockAS.getStockLogList(startDate, endDate);

		return stockLogList;
	}

	@Override
	public ArrayList<OrderInfoTO> getOrderInfoListOnDelivery() {

		ArrayList<OrderInfoTO> orderInfoListOnDelivery = null;

			orderInfoListOnDelivery = orderAS.getOrderInfoListOnDelivery();

		return orderInfoListOnDelivery;

	}

	@Override
	public ModelMap warehousing(ArrayList<String> orderNoArr) {

        modelMap = stockAS.warehousing(orderNoArr);

    	return modelMap;
	}

	@Override
	public ArrayList<OrderInfoTO> getOrderInfoList(String startDate, String endDate) {

		ArrayList<OrderInfoTO> orderInfoList  = null;

			orderInfoList = orderAS.getOrderInfoList(startDate,endDate);

		return orderInfoList;

	}

	@Override
	public ModelMap changeSafetyAllowanceAmount(String itemCode, String itemName,
			String safetyAllowanceAmount) {

		modelMap = stockAS.changeSafetyAllowanceAmount(itemCode, itemName, safetyAllowanceAmount);

		return modelMap;
	}

	@Override
	public ModelMap checkOrderInfo(ArrayList<String> orderNoArr) {
		// TODO Auto-generated method stub
		ModelMap modelMap = null;
		
		modelMap = orderAS.checkOrderInfo(orderNoArr);

		return modelMap;
	}
}
