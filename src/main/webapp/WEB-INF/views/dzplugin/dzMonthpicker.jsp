<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	
	<title>DzWeb</title>
	
	<%@ include file="../common/common.jsp"%>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery/plugin/jquery.dzMonthpicker/css/jquery.dzMonthpicker.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/plugin/jquery.dzMonthpicker/jquery.dzMonthpicker.js"></script>
    
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		Format.setMonthType($("#TextBox2"));
		
	});
	
	</script>
		
</head>

<body>

	<h4>월 달력</h4>
	
	<input id="TextBox2" type="text" style="width:100px;text-align:center;" />
	
</body>
</html>