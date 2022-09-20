package kr.co.seoulit.logistics.material.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.logistics.material.to.BomDeployTO;
import kr.co.seoulit.logistics.material.to.BomInfoTO;
import kr.co.seoulit.logistics.material.to.BomTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BomDAO {
	
	public ArrayList<BomDeployTO> selectBomDeployList(HashMap<String, String> param);
	
	public ArrayList<BomInfoTO> selectBomInfoList(String parentItemCode);
	
	public ArrayList<BomInfoTO> selectAllItemWithBomRegisterAvailable();
	
	public void insertBom(BomTO TO);
	
	public void updateBom(BomTO TO);
	
	public void deleteBom(BomTO TO);
	
}
