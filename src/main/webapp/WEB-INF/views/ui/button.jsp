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
		$("input[type=submit], a, button").button().click(function( event ) {
			event.preventDefault();
		});
		
		
	});
	
	</script>
		
</head>

<body>

	<button>A button element</button>
 	<input type="submit" value="A submit button">
 	<a href="#">An anchor</a>
    
</body>
</html>