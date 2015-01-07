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
  		#feedback { font-size: 1.4em; }
  		#selectable .ui-selecting { background: #FECA40; }
  		#selectable .ui-selected { background: #F39814; color: white; }
  		#selectable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
  		#selectable li { margin: 3px; padding: 0.4em; font-size: 1.4em; height: 18px; }
  	</style>
  
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$("#selectable").selectable();
		
	});
	
	</script>
		
</head>

<body>
	
	<ol id="selectable">
  		<li class="ui-widget-content">Item 1</li>
  		<li class="ui-widget-content">Item 2</li>
  		<li class="ui-widget-content">Item 3</li>
  		<li class="ui-widget-content">Item 4</li>
  		<li class="ui-widget-content">Item 5</li>
  		<li class="ui-widget-content">Item 6</li>
  		<li class="ui-widget-content">Item 7</li>
	</ol>
    
</body>
</html>