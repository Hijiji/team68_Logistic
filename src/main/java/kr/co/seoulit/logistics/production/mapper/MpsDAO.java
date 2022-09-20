package kr.co.seoulit.logistics.production.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.logistics.production.to.MpsTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MpsDAO {

	public ArrayList<MpsTO> selectMpsList(HashMap<String, String> param);
	
	public ArrayList<MpsTO> selectMpsCount(String mpsPlanDate);
	
	public void insertMps(MpsTO TO);
	
	public void updateMps(MpsTO TO);
	
	public void changeMrpApplyStatus(HashMap<String, String> map);
	
	public void deleteMps(MpsTO TO);
	
}
