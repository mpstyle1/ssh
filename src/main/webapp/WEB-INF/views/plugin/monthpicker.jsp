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
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery/plugin/jquery-ui-month-picker-master/css/MonthPicker.2.1.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/plugin/jquery-ui-month-picker-master/MonthPicker.2.1.js"></script>
    
	<script type="text/javascript">
	
	$(document).ready(function() {
		$('#TextBox1').MonthPicker({ StartYear: 2020, ShowIcon: false });
		$('#TextBox2').MonthPicker().css('backgroundColor', 'lightyellow');
	});
	
	</script>
		
</head>

<body>

	<h4>월 달력</h4>
	
	<input id="TextBox1" type="text" style="width:100px;" />
	&nbsp;&nbsp;&nbsp;
	<input id="TextBox2" type="text" style="width:100px;" />
	
</body>
</html>