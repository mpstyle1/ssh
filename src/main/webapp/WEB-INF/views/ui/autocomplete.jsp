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
		
		var availableTags = [
   			"ActionScript",
   			"AppleScript",
   			"Asp",
   			"BASIC",
   			"C",
   			"C++",
   			"Clojure",
   			"COBOL",
   			"ColdFusion",
   			"Erlang",
   			"Fortran",
   			"Groovy",
   			"Haskell",
   			"Java",
   			"JavaScript",
   			"Lisp",
   			"Perl",
   			"PHP",
   			"Python",
   			"Ruby",
   			"Scala",
   			"Scheme"
   		];
   		
   		var availableTags2 = [
   			"신승현",
   			"정남식",
   			"박래웅",
   			"최선우",
   			"박재형",
   			"허성준",
   			"김승원",
   			"최준빈"
   		];
           
        $("#tags").autocomplete({
   			source: availableTags
   		});
   		
   		$("#tags2").autocomplete({
   			source: availableTags2
   		});
		
	});
	
	</script>
		
</head>

<body>

	<h4>자동완성</h4>
    
    <label for="tags">개발언어: </label><input id="tags" type="text" />&nbsp;&nbsp; ja 만 입력해도 java 선택가능
    <br/><br/>
	<label for="tags2">팀원명 :&nbsp;&nbsp;&nbsp;</label><input id="tags2" type="text" />
    
</body>
</html>