package kr.co.seoulit.logistics.material.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.material.to.OrderInfoTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDAO {
	
	 public ModelMap getOrderList(HashMap<String, String> param);
	 
	 public ModelMap getOrderDialogInfo(HashMap<String, String> param);
	 
	 public ArrayList<OrderInfoTO> getOrderInfoListOnDelivery();
	 
	 public ArrayList<OrderInfoTO> getOrderInfoList(HashMap<String, String> param);

	 public void order(HashMap<String, String> param);	 
	 
	 public ModelMap optionOrder(HashMap<String, String> param);

	 public void updateOrderInfo(HashMap<String, String> param);
}
