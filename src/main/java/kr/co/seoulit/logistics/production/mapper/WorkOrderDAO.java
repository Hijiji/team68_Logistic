package kr.co.seoulit.logistics.production.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.production.to.ProductionPerformanceInfoTO;
import kr.co.seoulit.logistics.production.to.WorkOrderInfoTO;
import kr.co.seoulit.logistics.production.to.WorkSiteLogTO;

@Mapper
public interface WorkOrderDAO {

	public HashMap<String,Object> getWorkOrderableMrpList(HashMap<String, String> map);
	
	public ModelMap getWorkOrderSimulationList(HashMap<String, String> map);	
	
	public ModelMap workOrder(HashMap<String, String> map);
	
	public ArrayList<WorkOrderInfoTO> selectWorkOrderInfoList();
	
	public ModelMap workOrderCompletion(HashMap<String, String> map);
	
	public ArrayList<ProductionPerformanceInfoTO> selectProductionPerformanceInfoList();
	
	public HashMap<String,Object> selectWorkSiteSituation(HashMap<String, Object> map);
	
	public void updateWorkCompletionStatus(HashMap<String,String> map);
	
	public ArrayList<WorkSiteLogTO> workSiteLogList(String workSiteLogDate);
	
}
