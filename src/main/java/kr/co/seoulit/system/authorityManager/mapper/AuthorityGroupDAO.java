package kr.co.seoulit.system.authorityManager.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.authorityManager.to.AuthorityGroupTO;
import kr.co.seoulit.system.authorityManager.to.EmployeeAuthorityTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityGroupDAO {
	
	public ArrayList<AuthorityGroupTO> selectUserAuthorityGroupList(String empCode);

	public ArrayList<AuthorityGroupTO> selectAuthorityGroupList();
	
	public void insertEmployeeAuthorityGroup(EmployeeAuthorityTO bean);
	
	public void deleteEmployeeAuthorityGroup(String empCode);

}
