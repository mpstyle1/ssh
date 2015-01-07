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
	
	<style>
		#draggable { width: 150px; height: 150px; padding: 0.5em; }
	</style>
	
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$("#draggable").draggable();
		
	});
	
	</script>
		
</head>

<body>
	
	<div id="draggable" class="ui-widget-content">
		<p>Drag me around</p>
	</div>
    
</body>
</html>