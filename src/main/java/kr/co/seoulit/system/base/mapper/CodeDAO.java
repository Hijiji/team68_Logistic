package kr.co.seoulit.system.base.mapper;

import java.util.ArrayList;

import kr.co.seoulit.system.base.to.CodeTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeDAO {

	public ArrayList<CodeTO> selectCodeList();

	public void insertCode(CodeTO codeTO);

	public void updateCode(CodeTO codeTO);

	public void deleteCode(CodeTO codeTO);

}
