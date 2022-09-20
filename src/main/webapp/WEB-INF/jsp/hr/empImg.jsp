<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>assign Authority Group</title>
    <script src="https://unpkg.com/ag-grid-community/dist/ag-grid-community.min.noStyle.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/ag-grid-community/dist/styles/ag-grid.css">
    <link rel="stylesheet" href="https://unpkg.com/ag-grid-community/dist/styles/ag-theme-balham.css">
    <style>
        * {
            margin: 0px;
        }

        h5 {
            margin-top: 3px;
            margin-bottom: 3px;
        }

        .ag-header-cell-label {
            justify-content: center;
        }
        .ag-cell-value {
            padding-left: 50px;
        }

        input[type="submit"] {
            background-color: #506FA9;
            border: none;
            color: white;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            border-radius: 3px;
        }

    </style>
</head>
<body>
<h4>📷사원사진관리</h4>
<h6>사진을 수정할 사원을 선택하세요</h6>
<table>
<tr>
<td> 
<article class="EmpGrid">
    <h5>사원</h5>
    <div align="center">
        <div id="myGrid1" class="ag-theme-balham" style="height:500px; width:500px; text-align: center;"></div>
    </div>
</article>
</td>
<td>
	<form id="frm" name="frm" id="frm" method="post" 
		action="${pageContext.request.contextPath}/base/imgFileUpload.do" enctype="multipart/form-data">
		<input type="file" id="uploadImgFile" name="uploadImgFile" multiple="multiple">
	    <input type="hidden" name="empCode" value="">
		<input type="submit" id="submit" style="float:right; background-color:#F15F5F" value="&nbsp;저장&nbsp;">
	</form>
	
<article class="ImgGrid">
    <div align="center">
        <div id="myGrid2" class="ag-theme-balham" style="height:500px; width:500px; text-align: center;"></div>
    </div>
</article>
</td>
</tr>
</table>
<script>
	const myGrid1 = document.querySelector('#myGrid1');
	const myGrid2 = document.querySelector('#myGrid2');
	
	let empInformationColumn = [
	    {headerName: "사원명", field: "empName", checkboxSelection: true},
	    {headerName: "직책", field: "positionName"},
	    {headerName: "부서", field: "deptName"}
	  ];
	
	let empInformationRowData = [];
	let empInformationGridOptions = {
			    columnDefs: empInformationColumn,
			    rowSelection: 'single',
			    rowData: empInformationRowData,
			    defaultColDef: {editable: false},
			    overlayNoRowsTemplate: "사용자 정보가 없습니다.",
			    onGridReady: function (event) {
			      event.api.sizeColumnsToFit();
			    },
			    onGridSizeChanged: function (event) {
			      event.api.sizeColumnsToFit();
			    },
			    onRowClicked: function(event) {
			    	getEmpImg();
			      }  
			  }
	
	let empImgColumn = [
	    {headerName: "등록된 사진", field: "image", cellRenderer: function (params) {
            return "<img src='/img/empPhoto/" + params.value + "' style='width:250px; height:200px;' />" ; 
        }}
	  ];
	let empImgRowData = [];
	let empImgGridOptions = {
			    columnDefs: empImgColumn,
			    rowSelection: 'single',
			    rowData: empImgRowData,
			    defaultColDef: {editable: false},
			    overlayNoRowsTemplate: "등록된 사진이 없습니다.",
			    rowMultiSelectWithClick: true, 
			    rowHeight: 200,
			    onGridReady: function (event) {
			      event.api.sizeColumnsToFit();
			    },
			    onGridSizeChanged: function (event) {
			      event.api.sizeColumnsToFit();
			    }
			}
	
	let EmployeeData;
	function getEmployeeData(){
        let xhr = new XMLHttpRequest(); 
        xhr.open('POST', '${pageContext.request.contextPath}/hr/searchAllEmpList.do' +
            "?method=searchAllEmpList"
            + "&searchCondition=ALL"
            + "&companyCode=COM-01",
            true);
        xhr.setRequestHeader('Accept', 'application/json');
        xhr.send();
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4 && xhr.status == 200) {
                let txt = xhr.responseText;
                EmployeeData = JSON.parse(txt).gridRowJson;
                // console.log(EmployeeData);
                if (txt.errorCode < 0) {
                    Swal.fire({
                        text: '데이터를 불러들이는데 오류가 발생했습니다.',
                        icon: 'error',
                    });
                    return;
                }
            }
        }
	}
	
	let empData;
	let empCode;
	let companyCode;
	function getEmpImg(){
		let employeeRowNode = empInformationGridOptions.api.getSelectedNodes();
		empCode = employeeRowNode[0].data.empCode;
		companyCode = employeeRowNode[0].data.companyCode;
		// console.log(empCode);
		// console.log(companyCode);
        let xhr = new XMLHttpRequest(); 
        xhr.open('POST', '${pageContext.request.contextPath}/hr/searchEmpInfo.do' 
        	+ "?empCode="+empCode+"&companyCode="+companyCode, true);
        xhr.setRequestHeader('Accept', 'application/json');
        xhr.send();
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4 && xhr.status == 200) {
                let txt = xhr.responseText;
                empData = JSON.parse(txt).empInfo;
                // console.log(empData);
                empImgGridOptions.api.setRowData(empData.empDetailTOList);
                if (txt.errorCode < 0) {
                    Swal.fire({
                        text: '데이터를 불러들이는데 오류가 발생했습니다.',
                        icon: 'error',
                    });
                    return;
                }
            }
        }  
	} 
	  
		
	  function setGrid(){
			new agGrid.Grid(myGrid1, empInformationGridOptions);
			empInformationGridOptions.api.setRowData(EmployeeData);
			new agGrid.Grid(myGrid2, empImgGridOptions);
	  } 
	  
	  submit.addEventListener('click', () => {		  
		  document.frm.empCode.value=empCode;
		  console.log(document.frm.empCode.value);
	  	  });
	
	  document.addEventListener('DOMContentLoaded', () => {
		  
		  getEmployeeData();
		  setTimeout("setGrid()",200);
		  
		  });
</script>
</body>
</html>