<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>menu</title>
	
	<%@ include file="../common/common.jsp"%>
	
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$("#age").tooltip();
		$("#year").tooltip({ position: { my : "right center", at: "left-20 center" }});
		$("#sex").tooltip({ position: { my : "right top", at: "left bottom" }});
	});
	
	</script>
	
</head>
<body>
	<div>
		<p><a href="#" title="That's what this widget is">Tooltips</a> can be attached to any element. When you hover
		the element with your mouse, the title attribute is displayed in a little box next to the element, just like a native tooltip.</p>
		<p>But as it's not a native tooltip, it can be styled. Any themes built with
		<a href="http://themeroller.com" title="ThemeRoller: jQuery UI's theme builder application">ThemeRoller</a>
		will also style tooltips accordingly.</p>
		<p>Tooltips are also useful for form elements, to show some additional information in the context of each field.</p>
		
		<p>&nbsp;&nbsp;&nbsp;&nbsp;<label for="age">이름&nbsp;:&nbsp;</label><input id="age" title="이름을 입력하삼" /></p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;<label for="year">나이&nbsp;:&nbsp;</label><input id="year" title="나이를 입력하셈" /></p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;<label for="sex">성별&nbsp;:&nbsp;</label><input id="sex" title="성별은 무엇이오?" /></p>
		
		<p>Hover the field to see the tooltip.</p>
	</div>	
</body>
</html>