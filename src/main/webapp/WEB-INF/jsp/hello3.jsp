

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN INFORMATION</title>
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

        .menuButton button {
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
<br>
<h5>🎬 부산광역시_연극 목록</h5>
<br>
    <div align="center">
        <div id="myGrid" class="ag-theme-balham" style="height:500px; width:auto; text-align: center;"></div>
    </div>
<script>
	const myGrid = document.querySelector('#myGrid');

	let openApiColumn = [
	    {headerName: "공연명", field: "title"},
	    {headerName: "공연시작일", field: "opStDt"},
	    {headerName: "공연종료일", field: "opEdDt"},
	    {headerName: "오픈런", field: "opAt", cellRenderer: function (params) {
	    	  if (params.value == "Y") {
	                return params.value =  "🟢" ;
	            }
	            return '✖️' ; 
	    	}
	    },
	    {headerName: "시설명", field: "placeNm"},
	    {headerName: "유료 여부", field: "payAt", cellRenderer: function (params) {
	    	  if (params.value == "Y") {
	                return params.value =  "🟢" ;
	            }
	            return '✖️' ; 
	    	}
	    },
	  ];
	
	let openApiData = [];
	
	let openApiGridOptions = {
			    columnDefs: openApiColumn,
			    rowSelection: 'single',
			    rowData: openApiData,
			    defaultColDef: {editable: false},
			    overlayNoRowsTemplate: "조회된 정보가 없습니다",
			    onGridReady: function (event) {
			      event.api.sizeColumnsToFit();
			    },
			    onGridSizeChanged: function (event) {
			      event.api.sizeColumnsToFit();
			    }
			  }
	
	document.addEventListener('DOMContentLoaded',() =>{
			 $.ajax({
			      type: "GET",
			      url: "${pageContext.request.contextPath}/openApi.do",
			      dataType: "json",
			      success: function (jsonObj) {
					console.log("		@API리스트 로드 성공");
					console.log(jsonObj);
					openApiGridOptions.api.setRowData(jsonObj.openApi);
			      }
			  });
		  
		  new agGrid.Grid(myGrid, openApiGridOptions);
		  });
</script>

</body>
</html>