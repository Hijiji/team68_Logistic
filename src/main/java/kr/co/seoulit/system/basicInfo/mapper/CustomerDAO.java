package kr.co.seoulit.system.basicInfo.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.basicInfo.to.CustomerTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDAO {

	public ArrayList<CustomerTO> selectCustomerListByCompany();

	public ArrayList<CustomerTO> selectCustomerListByWorkplace(String workplaceCode);
	
	public void insertCustomer(CustomerTO TO);

	public void updateCustomer(CustomerTO TO);

	public void deleteCustomer(CustomerTO TO);

	public ArrayList<CustomerTO> selectCustomerListByItem(String itemGroupCode);
}
