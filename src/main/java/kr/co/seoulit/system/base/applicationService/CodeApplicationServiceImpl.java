package kr.co.seoulit.system.base.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.system.base.mapper.CodeDAO;
import kr.co.seoulit.system.base.mapper.CodeDetailDAO;
import kr.co.seoulit.system.base.to.CodeDetailTO;
import kr.co.seoulit.system.base.to.CodeTO;

@Component
public class CodeApplicationServiceImpl implements CodeApplicationService {

	// DAO 참조변수
	@Autowired
	private CodeDAO codeDAO;
	@Autowired	
	private CodeDetailDAO codeDetailDAO;
	

	@Override
	public ArrayList<CodeTO> getCodeList() {

		ArrayList<CodeTO> codeList = null;

			codeList = codeDAO.selectCodeList();

			for (CodeTO bean : codeList) {

				bean.setCodeDetailTOList(codeDetailDAO.selectDetailCodeList(bean.getDivisionCodeNo()));

			}

		return codeList;
	}

	@Override
	public ArrayList<CodeDetailTO> getDetailCodeList(String divisionCode) {

		ArrayList<CodeDetailTO> codeDetailList = null;

			codeDetailList = codeDetailDAO.selectDetailCodeList(divisionCode);
			
		return codeDetailList;

	}

	public Boolean checkCodeDuplication(String divisionCode, String newDetailCode) {

		ArrayList<CodeDetailTO> detailCodeList = null;
		Boolean duplicated = false;


			detailCodeList = codeDetailDAO.selectDetailCodeList(divisionCode);

			for (CodeDetailTO bean : detailCodeList) {

				if (bean.getDetailCode().equals(newDetailCode)) {

					duplicated = true; // 입력받은 newDetailCode 와 같은 값이 있으면 중복된 코드임

				}

			}

		return duplicated; // 중복된 코드이면 true 반환

	}

	@Override
	public HashMap<String, Object> batchCodeListProcess(ArrayList<CodeTO> codeList) {

		HashMap<String, Object> resultMap = new HashMap<>();

			ArrayList<String> insertList = new ArrayList<>();
			ArrayList<String> updateList = new ArrayList<>();
			ArrayList<String> deleteList = new ArrayList<>();

			for (CodeTO bean : codeList) {

				String status = bean.getStatus();

				switch (status) {

				case "INSERT":

					codeDAO.insertCode(bean);

					insertList.add(bean.getDivisionCodeNo());

					break;

				case "UPDATE":

					codeDAO.updateCode(bean);

					updateList.add(bean.getDivisionCodeNo());

					break;

				case "DELETE":

					codeDAO.deleteCode(bean);

					deleteList.add(bean.getDivisionCodeNo());

					break;

				}

			}

			resultMap.put("INSERT", insertList);
			resultMap.put("UPDATE", updateList);
			resultMap.put("DELETE", deleteList);

		return resultMap;

	}

	@Override
	public HashMap<String, Object> batchDetailCodeListProcess(ArrayList<CodeDetailTO> detailCodeList) {

		HashMap<String, Object> resultMap = new HashMap<>();

			ArrayList<String> insertList = new ArrayList<>();
			ArrayList<String> updateList = new ArrayList<>();
			ArrayList<String> deleteList = new ArrayList<>();

			for (CodeDetailTO bean : detailCodeList) {

				String status = bean.getStatus();

				switch (status) {

				case "INSERT":

					codeDetailDAO.insertDetailCode(bean);

					insertList.add(bean.getDivisionCodeNo() + " / " + bean.getDetailCode());

					break;

				case "UPDATE":

					codeDetailDAO.updateDetailCode(bean);

					updateList.add(bean.getDivisionCodeNo() + " / " + bean.getDetailCode());

					break;

				case "DELETE":

					codeDetailDAO.deleteDetailCode(bean);

					deleteList.add(bean.getDivisionCodeNo() + " / " + bean.getDetailCode());

					break;

				}

			}

			resultMap.put("INSERT", insertList);
			resultMap.put("UPDATE", updateList);
			resultMap.put("DELETE", deleteList);

		return resultMap;

	}

	@Override
	public HashMap<String, Object> changeCodeUseCheckProcess(ArrayList<CodeDetailTO> detailCodeList) {

		HashMap<String, Object> resultMap = new HashMap<>();

			ArrayList<String> codeUseList = new ArrayList<>();
			ArrayList<String> codeNotUseList = new ArrayList<>();

			for (CodeDetailTO bean : detailCodeList) {

				String codeUseCheck = ((bean.getCodeUseCheck() == null) ? "" : bean.getCodeUseCheck().toUpperCase());

				switch (codeUseCheck) {

				case "N":

					codeDetailDAO.changeCodeUseCheck(bean.getDivisionCodeNo(), bean.getDetailCode(), "N");

					codeNotUseList.add(bean.getDivisionCodeNo() + " / " + bean.getDetailCode());

					break;

				default:

					codeDetailDAO.changeCodeUseCheck(bean.getDivisionCodeNo(), bean.getDetailCode(), "");

					codeUseList.add(bean.getDivisionCodeNo() + " / " + bean.getDetailCode());

					break;

				}
			}

			resultMap.put("USE", codeUseList);
			resultMap.put("NOT_USE", codeNotUseList);

		return resultMap;
	}

}
