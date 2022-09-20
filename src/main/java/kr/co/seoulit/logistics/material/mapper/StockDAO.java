package kr.co.seoulit.logistics.material.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.material.to.StockLogTO;
import kr.co.seoulit.logistics.material.to.StockTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockDAO {
	
	public ArrayList<StockTO> selectStockList();
	
	public ArrayList<StockLogTO> selectStockLogList(HashMap<String, String> param);
	
	public void warehousing(HashMap<String, String> param);
	
	public ModelMap updatesafetyAllowance(HashMap<String, String> param);
}
