package kr.co.seoulit.logistics.outsourcing.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.logistics.outsourcing.to.OutSourcingTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OutSourcingDAO {

	ArrayList<OutSourcingTO> selectOutSourcingList(HashMap<String,String>param);

}
