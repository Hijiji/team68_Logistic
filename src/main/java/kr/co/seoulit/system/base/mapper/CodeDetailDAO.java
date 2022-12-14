package kr.co.seoulit.system.base.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.base.to.CodeDetailTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeDetailDAO {

	ArrayList<CodeDetailTO> selectDetailCodeList(String divisionCode);

	void insertDetailCode(CodeDetailTO TO);

	void updateDetailCode(CodeDetailTO TO);

	public void deleteDetailCode(CodeDetailTO TO);
	
	public void changeCodeUseCheck(String divisionCodeNo, String detailCode, String codeUseCheck);
	
	
}
