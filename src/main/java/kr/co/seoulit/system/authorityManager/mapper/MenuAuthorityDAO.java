package kr.co.seoulit.system.authorityManager.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.authorityManager.to.AuthorityGroupMenuTO;
import kr.co.seoulit.system.authorityManager.to.MenuAuthorityTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuAuthorityDAO {
	
	public void deleteMenuAuthority(String authorityGroupCode);
	
	public void insertMenuAuthority(MenuAuthorityTO bean);
	
	public ArrayList<MenuAuthorityTO> selectMenuAuthorityList(String authorityGroupCode);
	
	public ArrayList<AuthorityGroupMenuTO> selectUserMenuAuthorityList(String empCode);
		
}
