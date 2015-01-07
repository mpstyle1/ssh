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
		
		$("#progressbar").progressbar({
			value: 0,
			max: 100
		});
		
		var timer = setInterval(function(){
			$("#progressbar").progressbar("value", $("#progressbar").progressbar("value") + 1);
			$("#txtPer").text($("#progressbar").progressbar("value") + "%");
			if ( $("#progressbar").progressbar("value") >= 100 ){
				clearInterval(timer);
			}
		}, 50);
		
	});
	
	</script>
		
</head>

<body>

	<h4>progressbar</h4>
    
    <div id="progressbar" style="width:500px;"></div>
    <p id="txtPer">10%</p>
    
</body>
</html>