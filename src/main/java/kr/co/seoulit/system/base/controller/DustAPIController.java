package kr.co.seoulit.system.base.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import kr.co.seoulit.system.base.to.DustTO;

@RestController
@RequestMapping("/base/*")
public class DustAPIController {
	
	private ModelMap map =new ModelMap();

	@RequestMapping("/DustAPI.do")
	public ModelMap DustTornado(HttpServletRequest request, HttpServletResponse response) {
		try {
			String url = "http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo?serviceKey=9RbkmCUIz5c9p87aaukTSgHpP46TtSzwphBIEkm%2FI5n3JRehFLCwv4Rp9kReXL6KP%2BtnGTXAPvUYyodpnZXfAA%3D%3D&returnType=xml&numOfRows=10&pageNo=1&year=2021";
			
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("item");
            
            ArrayList<DustTO> list = new ArrayList<DustTO>();
            
            for (int temp=0;temp < nList.getLength() ;temp++){
          	  DustTO dust = new DustTO();
                Node nNode = nList.item(temp);
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                	Element eElement = (Element) nNode;
                	
                	
                    dust.setDistrictName(getTagValue("districtName", eElement));
                    dust.setDataDate(getTagValue("dataDate", eElement));
                    dust.setClearDate(getTagValue("clearDate", eElement));
                    dust.setIssueGbn(getTagValue("issueGbn", eElement));
                 
                    
                    list.add(dust);
                }
            }
            
            map = new ModelMap();
            map.put("list",list);
		}
            catch (Exception e) {
                e.printStackTrace();
             }
             
             return map; 
       }
	
	
//	흐름
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        // 하위 노드 리스트의 첫 번째 노드(item index 0)
        if (nValue == null) {
           return null;
        }
        return nValue.getNodeValue();
     }
    

}
