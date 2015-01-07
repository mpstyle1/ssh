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
	
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$("#datepicker").datepicker("enable");
        $("#datepicker").datepicker();
        $("#datepicker").change(function() {
            //jQuery(this).val(Page.format.date(jQuery(this).val(), "yyyy-MM-dd"));
        });
		
	});
	
	</script>
		
</head>

<body>

	<h4>달력</h4>
    
    <p>Date: <input type="text" id="datepicker" style="width:100px;text-align:center;" /></p>
    
</body>
</html>