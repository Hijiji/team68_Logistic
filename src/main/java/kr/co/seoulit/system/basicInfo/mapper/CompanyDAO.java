package kr.co.seoulit.system.basicInfo.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.basicInfo.to.CompanyTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyDAO {
	
	public ArrayList<CompanyTO> selectCompanyList();
	
	public void insertCompany(CompanyTO TO);
	
	public void updateCompany(CompanyTO TO);

	public void deleteCompany(CompanyTO TO);
	
}
