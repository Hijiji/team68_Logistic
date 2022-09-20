package kr.co.seoulit.system.authorityManager.mapper;

import java.util.HashMap;

import kr.co.seoulit.system.authorityManager.to.UserMenuTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMenuDAO {

	public HashMap<String, UserMenuTO> selectUserMenuCodeList(String workplaceCode, String deptCode, String positionCode);

}
