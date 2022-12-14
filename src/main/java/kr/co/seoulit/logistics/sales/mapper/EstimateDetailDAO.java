package kr.co.seoulit.logistics.sales.mapper;

import java.util.ArrayList;

import kr.co.seoulit.logistics.sales.to.EstimateDetailTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EstimateDetailDAO {

	public ArrayList<EstimateDetailTO> selectEstimateDetailList(String estimateNo);

	public int selectEstimateDetailCount(String estimateNo);

	public void insertEstimateDetail(EstimateDetailTO TO);

	public void updateEstimateDetail(EstimateDetailTO TO);

	public void deleteEstimateDetail(EstimateDetailTO TO);

	public int selectEstimateDetailSeq(String estimateDate);
	
	public void initDetailSeq();
	
	public void reArrangeEstimateDetail(EstimateDetailTO bean);
}