

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
<h5>๐ฌ ๋ถ์ฐ๊ด์ญ์_์ฐ๊ทน ๋ชฉ๋ก</h5>
<br>
    <div align="center">
        <div id="myGrid" class="ag-theme-balham" style="height:500px; width:auto; text-align: center;"></div>
    </div>
<script>
	const myGrid = document.querySelector('#myGrid');

	let openApiColumn = [
	    {headerName: "๊ณต์ฐ๋ช", field: "title"},
	    {headerName: "๊ณต์ฐ์์์ผ", field: "opStDt"},
	    {headerName: "๊ณต์ฐ์ข๋ฃ์ผ", field: "opEdDt"},
	    {headerName: "์คํ๋ฐ", field: "opAt", cellRenderer: function (params) {
	    	  if (params.value == "Y") {
	                return params.value =  "๐ข" ;
	            }
	            return 'โ๏ธ' ; 
	    	}
	    },
	    {headerName: "์์ค๋ช", field: "placeNm"},
	    {headerName: "์ ๋ฃ ์ฌ๋ถ", field: "payAt", cellRenderer: function (params) {
	    	  if (params.value == "Y") {
	                return params.value =  "๐ข" ;
	            }
	            return 'โ๏ธ' ; 
	    	}
	    },
	  ];
	
	let openApiData = [];
	
	let openApiGridOptions = {
			    columnDefs: openApiColumn,
			    rowSelection: 'single',
			    rowData: openApiData,
			    defaultColDef: {editable: false},
			    overlayNoRowsTemplate: "์กฐํ๋ ์ ๋ณด๊ฐ ์์ต๋๋ค",
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
					console.log("		@API๋ฆฌ์คํธ ๋ก๋ ์ฑ๊ณต");
					console.log(jsonObj);
					openApiGridOptions.api.setRowData(jsonObj.openApi);
			      }
			  });
		  
		  new agGrid.Grid(myGrid, openApiGridOptions);
		  });
</script>

</body>
</html>