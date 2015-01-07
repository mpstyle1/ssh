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
		#resizable { width: 150px; height: 150px; padding: 0.5em; }
  		#resizable h3 { text-align: center; margin: 0; }
	</style>
	
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$("#resizable").resizable();
		
	});
	
	</script>
		
</head>

<body>
	
	<div id="resizable" class="ui-widget-content">
		<h3 class="ui-widget-header">Resizable</h3>
	</div>
    
</body>
</html>