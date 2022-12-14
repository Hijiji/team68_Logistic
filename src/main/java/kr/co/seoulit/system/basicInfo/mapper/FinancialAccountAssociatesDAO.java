package kr.co.seoulit.system.basicInfo.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.basicInfo.to.FinancialAccountAssociatesTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FinancialAccountAssociatesDAO {

	public ArrayList<FinancialAccountAssociatesTO> selectFinancialAccountAssociatesListByCompany();

	public ArrayList<FinancialAccountAssociatesTO> selectFinancialAccountAssociatesListByWorkplace(
			String workplaceCode);

	public void insertFinancialAccountAssociates(FinancialAccountAssociatesTO TO);

	public void updateFinancialAccountAssociates(FinancialAccountAssociatesTO TO);

	public void deleteFinancialAccountAssociates(FinancialAccountAssociatesTO TO);

}
