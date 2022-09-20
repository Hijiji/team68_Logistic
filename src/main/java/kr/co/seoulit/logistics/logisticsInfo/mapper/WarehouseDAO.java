package kr.co.seoulit.logistics.logisticsInfo.mapper;

import java.util.ArrayList;

import kr.co.seoulit.logistics.logisticsInfo.to.WarehouseTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WarehouseDAO {
	public ArrayList<WarehouseTO> selectWarehouseList();
}
