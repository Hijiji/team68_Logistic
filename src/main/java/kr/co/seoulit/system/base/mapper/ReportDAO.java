package kr.co.seoulit.system.base.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.base.to.ContractReportTO;
import kr.co.seoulit.system.base.to.EstimateReportTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportDAO {

	public ArrayList<EstimateReportTO> selectEstimateReport(String estimateNo);

	public ArrayList<ContractReportTO> selectContractReport(String contractNo);
	
}
