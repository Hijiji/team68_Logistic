package kr.co.seoulit.system.authorityManager.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.authorityManager.to.MenuTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDAO {

	public ArrayList<MenuTO> selectAllMenuList();
	
}
