package kr.co.seoulit.logistics.production.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.production.mapper.WorkOrderDAO;
import kr.co.seoulit.logistics.production.to.ProductionPerformanceInfoTO;
import kr.co.seoulit.logistics.production.to.WorkOrderInfoTO;
import kr.co.seoulit.logistics.production.to.WorkSiteLogTO;

@Component
public class WorkOrderApplicationServiceImpl implements WorkOrderApplicationService {

	// DAO 참조변수 선언
	// private static MpsDAO mpsDAO = MpsDAOImpl.getInstance();
	// private static MrpDAO mrpDAO = MrpDAOImpl.getInstance();
	@Autowired
	private WorkOrderDAO workOrderDAO;

	@Override
	public ModelMap getWorkOrderableMrpList() {
		ModelMap resultMap = new ModelMap();
		HashMap<String, String> map = new HashMap<>();
		workOrderDAO.getWorkOrderableMrpList(map);
		resultMap.put("gridRowJson", map.get("RESULT"));
        resultMap.put("errorCode",map.get("ERROR_CODE"));
        resultMap.put("errorMsg", map.get("ERROR_MSG"));
		return resultMap;
	}

	@Override
	public ModelMap getWorkOrderSimulationList(String mrpGatheringNo, String mrpNo) {
		HashMap<String, String> map=new HashMap<>();
		map.put("mrpGatheringNo", mrpGatheringNo);		
		map.put("mrpNo", mrpNo);
		workOrderDAO.getWorkOrderSimulationList(map);
		
		ModelMap resultMap = new ModelMap();

		resultMap.put("gridRowJson", map.get("RESULT"));
		resultMap.put("errorCode",map.get("ERROR_CODE"));
	    resultMap.put("errorMsg", map.get("ERROR_MSG"));
		return resultMap;

	}

	@Override
	public ModelMap workOrder(String mrpGatheringNo, String workPlaceCode, String productionProcess,
			String mrpNo) {
		HashMap<String, String> map=new HashMap<>();
		map.put("mrpGatheringNo", mrpGatheringNo);
		map.put("workPlaceCode", workPlaceCode);
		map.put("productionProcess", productionProcess);
		map.put("mrpNo", mrpNo);	
		workOrderDAO.workOrder(map);
		
		ModelMap resultMap = new ModelMap();

		resultMap.put("errorCode",map.get("ERROR_CODE"));
	    resultMap.put("errorMsg", map.get("ERROR_MSG"));
		return resultMap;

	}

	@Override
	public ArrayList<WorkOrderInfoTO> getWorkOrderInfoList() {
		ArrayList<WorkOrderInfoTO> workOrderInfoList = null;
		workOrderInfoList = workOrderDAO.selectWorkOrderInfoList();
		return workOrderInfoList;

	}

	@Override
	public ModelMap workOrderCompletion(String workOrderNo, String actualCompletionAmount) {
		HashMap<String, String> map=new HashMap<>();
		map.put("workOrderNo", workOrderNo);
		map.put("actualCompletionAmount", actualCompletionAmount);

		workOrderDAO.workOrderCompletion(map);
		
		ModelMap resultMap = new ModelMap();
		resultMap.put("errorCode",map.get("ERROR_CODE"));
	    resultMap.put("errorMsg", map.get("ERROR_MSG"));
		
		return resultMap;
	}

	@Override
	public ArrayList<ProductionPerformanceInfoTO> getProductionPerformanceInfoList() {

		ArrayList<ProductionPerformanceInfoTO> productionPerformanceInfoList = null;
		productionPerformanceInfoList = workOrderDAO.selectProductionPerformanceInfoList();
		
		return productionPerformanceInfoList;

	}

	@Override
	public ModelMap showWorkSiteSituation(String workSiteCourse, String workOrderNo,
			String itemClassIfication) {

		ModelMap map = new ModelMap();
	  	map.put("workOrderNo", workOrderNo);
	  	map.put("workSiteCourse", workSiteCourse);
	  	map.put("itemClassIfication", itemClassIfication);
		
	  	workOrderDAO.selectWorkSiteSituation(map);

		ModelMap resultMap = new ModelMap();
	  	resultMap.put("gridRowJson",map.get("RESULT"));
	  	resultMap.put("errorCode",map.get("ERROR_CODE"));
	  	resultMap.put("errorMsg",map.get("ERROR_MSG"));

	  	return resultMap;
	}

	@Override
	public void workCompletion(String workOrderNo, String itemCode, ArrayList<String> itemCodeListArr) {
		String itemCodeList = itemCodeListArr.toString().replace("[", "").replace("]", "");
		
		HashMap<String,String> map = new HashMap<>();
	  	map.put("workOrderNo", workOrderNo);
	  	map.put("itemCode", itemCode);
	  	map.put("itemCodeList", itemCodeList);
		
		workOrderDAO.updateWorkCompletionStatus(map);
	}

	@Override
	public ModelMap workSiteLogList(String workSiteLogDate) {
		ArrayList<WorkSiteLogTO> list = workOrderDAO.workSiteLogList(workSiteLogDate);
		ModelMap resultMap = new ModelMap();
   	  	
		resultMap.put("gridRowJson",list);
		
		return resultMap;
	}

}
