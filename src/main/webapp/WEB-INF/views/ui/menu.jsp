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
	
	<style>
  		.ui-menu { width: 150px; }
  	</style>
  
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$( "#menu" ).menu();
		
	});
	
	</script>
	
</head>
<body>

	<ul id="menu">
		<li class="ui-state-disabled">Aberdeen</li>
	  	<li>Ada</li>
	  	<li>Adamsville</li>
	  	<li>Addyston</li>
	  	<li>Delphi
		    <ul>
		      	<li class="ui-state-disabled">Ada</li>
		      	<li>Saarland</li>
		      	<li>Salzburg an der schönen Donau</li>
		    </ul>
	  	</li>
	  	<li>Saarland</li>
	  	<li>Salzburg
	    	<ul>
	      		<li>Delphi
	        		<ul>
	          			<li>Ada</li>
	          			<li>Saarland</li>
	          			<li>Salzburg</li>
	        		</ul>
	      		</li>
	      		<li>Delphi
	        		<ul>
	          			<li>Ada</li>
	          			<li>Saarland</li>
	          			<li>Salzburg</li>
	        		</ul>
	      		</li>
	      		<li>Perch</li>
	    	</ul>
	  	</li>
	  	<li class="ui-state-disabled">Amesville</li>
	</ul>
			
</body>
</html>