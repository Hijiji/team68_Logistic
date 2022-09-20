package kr.co.seoulit.logistics.material.applicationService;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.material.to.BomDeployTO;
import kr.co.seoulit.logistics.material.to.BomInfoTO;
import kr.co.seoulit.logistics.material.to.BomTO;

public interface BomApplicationService {

	public ArrayList<BomDeployTO> getBomDeployList(String deployCondition, String itemCode, String itemClassificationCondition);
	
	public ArrayList<BomInfoTO> getBomInfoList(String parentItemCode);
	
	public ArrayList<BomInfoTO> getAllItemWithBomRegisterAvailable();
	
	public ModelMap batchBomListProcess(ArrayList<BomTO> batchBomList);

}
