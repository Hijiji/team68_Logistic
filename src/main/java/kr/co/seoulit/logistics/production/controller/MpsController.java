package kr.co.seoulit.logistics.production.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import kr.co.seoulit.logistics.production.serviceFacade.ProductionServiceFacade;
import kr.co.seoulit.logistics.production.to.ContractDetailInMpsAvailableTO;
import kr.co.seoulit.logistics.production.to.MpsTO;
import kr.co.seoulit.logistics.production.to.SalesPlanInMpsAvailableTO;

@RestController
@RequestMapping("/production/*")
public class MpsController  {
   // serviceFacade 참조변수 선언
   @Autowired
   private ProductionServiceFacade productionSF;
 
   private ModelMap modelmap = new ModelMap();
   
   // gson 라이브러리
   private static Gson gson = new GsonBuilder().serializeNulls().create(); // 속성값이 null 인 속성도 json 변환
   
   @RequestMapping(value="/searchMpsInfo.do", method=RequestMethod.POST)
   public ModelMap searchMpsInfo(HttpServletRequest request, HttpServletResponse response) {

      String startDate = request.getParameter("startDate");
      String endDate = request.getParameter("endDate");
      String includeMrpApply = request.getParameter("includeMrpApply"); 
                        // 포함 = includeMrpApply, 미포함 = excludeMrpApply;
      try {
         ArrayList<MpsTO> mpsTOList = productionSF.getMpsList(startDate, endDate, includeMrpApply);

         modelmap.put("gridRowJson", mpsTOList);
         modelmap.put("errorCode", 1);
         modelmap.put("errorMsg", "성공");
         
      }catch (Exception e2) {
         
         e2.printStackTrace();
         modelmap.put("errorCode", -2);
         modelmap.put("errorMsg", e2.getMessage());

      }
      return modelmap;
   }
   
   @RequestMapping(value="/searchContractDetailInMpsAvailable.do", method=RequestMethod.POST)
   public ModelMap searchContractDetailListInMpsAvailable(HttpServletRequest request,
         HttpServletResponse response) {
      String searchCondition = request.getParameter("searchCondition"); //수주일자 = contractDate, 납기일 = dueDateOfContract
            System.out.println(searchCondition);
      String startDate = request.getParameter("startDate");
            System.out.println(startDate);
      String endDate = request.getParameter("endDate");
            System.out.println(endDate);

      try {
         ArrayList<ContractDetailInMpsAvailableTO> contractDetailInMpsAvailableList = productionSF
               .getContractDetailListInMpsAvailable(searchCondition, startDate, endDate);
                                          //contractDate, 2019-07-01, 2019-07-31
         modelmap.put("gridRowJson", contractDetailInMpsAvailableList);
         modelmap.put("errorCode", 1);
         modelmap.put("errorMsg", "성공");

      }catch (Exception e2) {
         e2.printStackTrace();
         modelmap.put("errorCode", -2);
         modelmap.put("errorMsg", e2.getMessage());

      }
      return modelmap;
   }

   @RequestMapping(value="/searchSalesPlanListInMpsAvailable.do" , method=RequestMethod.POST)
   public ModelMap searchSalesPlanListInMpsAvailable(HttpServletRequest request, HttpServletResponse response) {

      String searchCondition = request.getParameter("searchCondition");
      String startDate = request.getParameter("startDate");
      String endDate = request.getParameter("endDate");

      try {
         ArrayList<SalesPlanInMpsAvailableTO> salesPlanInMpsAvailableList = productionSF
               .getSalesPlanListInMpsAvailable(searchCondition, startDate, endDate);

         modelmap.put("gridRowJson", salesPlanInMpsAvailableList);
         modelmap.put("errorCode", 1);
         modelmap.put("errorMsg", "성공");

      }catch (Exception e2) {
         e2.printStackTrace();
         modelmap.put("errorCode", -2);
         modelmap.put("errorMsg", e2.getMessage());

      }
      return modelmap;
   }

   @RequestMapping(value="/convertContractDetailToMps.do", method=RequestMethod.POST)
   public ModelMap convertContractDetailToMps(HttpServletRequest request, HttpServletResponse response) {

      String batchList = request.getParameter("batchList"); // 수주상세 데이터 
            System.out.println("batchList = "+batchList);
      ArrayList<ContractDetailInMpsAvailableTO> contractDetailInMpsAvailableList = gson.fromJson(batchList,
            new TypeToken<ArrayList<ContractDetailInMpsAvailableTO>>() {
            }.getType());
            //제너릭클래스를 사용할경우 컴파일시 자동으로 ContractDetailInMpsAvailableTO 라고 한 이름이 Object 로 바뀌어서 역직렬화가 어려워진다 그래서 이렇게 한다고한다

      try {
         HashMap<String, Object> resultMap = productionSF
               .convertContractDetailToMps(contractDetailInMpsAvailableList);

         modelmap.put("result", resultMap);
         modelmap.put("errorCode", 1);
         modelmap.put("errorMsg", "성공");

      }catch (Exception e2) {
         e2.printStackTrace();
         modelmap.put("errorCode", -2);
         modelmap.put("errorMsg", e2.getMessage());

      }
      return modelmap;
   }

   @RequestMapping(value="/convertSalesPlanToMps.do", method=RequestMethod.POST)
   public ModelMap convertSalesPlanToMps(HttpServletRequest request, HttpServletResponse response) {

      String batchList = request.getParameter("batchList");

      ArrayList<SalesPlanInMpsAvailableTO> salesPlanInMpsAvailableList = gson.fromJson(batchList,
            new TypeToken<ArrayList<SalesPlanInMpsAvailableTO>>() {
            }.getType());

      try {
         HashMap<String, Object> resultMap = productionSF.convertSalesPlanToMps(salesPlanInMpsAvailableList);

         modelmap.put("result", resultMap );
         modelmap.put("errorCode", 1);
         modelmap.put("errorMsg", "성공");

      }catch (Exception e2) {
         e2.printStackTrace();
         modelmap.put("errorCode", -2);
         modelmap.put("errorMsg", e2.getMessage());

      }
      return modelmap;
   }

}