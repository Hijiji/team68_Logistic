package kr.co.seoulit.logistics.sales.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.logistics.sales.to.EstimateTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EstimateDAO {
	public ArrayList<EstimateTO> selectEstimateList(HashMap<String,String> param);

	public EstimateTO selectEstimate(String estimateNo);

	public int selectEstimateCount(String estimateDate);

	public void insertEstimate(EstimateTO TO);

	public void updateEstimate(EstimateTO TO);

	public void changeContractStatusOfEstimate(HashMap<String,String> param);

}
