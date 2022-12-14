package kr.co.seoulit.logistics.sales.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.logistics.sales.to.DeliveryInfoTO;

@Mapper
public interface DeliveryDAO {

	public ArrayList<DeliveryInfoTO> selectDeliveryInfoList();
	
	public HashMap<String, String> deliver(HashMap<String, String> map);
	
	public void insertDeliveryResult(DeliveryInfoTO TO);

	public void updateDeliveryResult(DeliveryInfoTO TO);

	public void deleteDeliveryResult(DeliveryInfoTO TO);
}
