package kr.co.seoulit.system.basicInfo.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.basicInfo.to.WorkplaceTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkplaceDAO {
	
	public ArrayList<WorkplaceTO> selectWorkplaceList(String companyCode);

	public void insertWorkplace(WorkplaceTO TO);
	
	public void updateWorkplace(WorkplaceTO TO);
	
	public void deleteWorkplace(WorkplaceTO TO);
}
