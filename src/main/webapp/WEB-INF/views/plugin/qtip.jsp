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
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/plugin/jquery.qtip-1.0.0.custom/jquery.qtip-1.0.0.min.js"></script>
    
	<script type="text/javascript">
	
	$(document).ready(function() {

		/**
		 * content: 튤팁내용
		 * 스타일 : 튤팁 스타일
		 
		 *
		 */
		 
		$("#divMain #id1").qtip({
			content: "가오리",
			//style: 'cream',
			style: {
				tip: true,
            	name: 'cream'
			},
			position: {
            	corner: { tooltip: 'topLeft', target: 'bottomLeft'}
			},
			show: { effect: {type :'slide'} }
			 
		});

		$("#divMain #id2").qtip({
			content: "나비",
			style: 'dark',
			position: {
            	corner: { tooltip: 'topRight', target: 'bottomLeft'}
			}
		});

		$("#divMain #id3").qtip({
			content: "다람쥐",
			style: 'green',
			position: {
            	corner: { tooltip: 'topLeft', target: 'bottomRight'}
			}
		});

		$("#divMain #id4").qtip({
			content: "라디오",
			style: 'light',
			position: {
            	corner: { tooltip: 'topRight', target: 'bottomLeft'}
			}
		});

		$("#divMain #id5").qtip({
			content: "마법사",
			style: 'red',
			position: {
            	corner: { tooltip: 'topRight', target: 'bottomLeft'}
			}
		});

		$("#divMain #id6").qtip({
			content: "바보",
			style: 'blue',
			position: {
            	corner: { tooltip: 'topRight', target: 'bottomLeft'}
			}
		});
		
	});
	
	</script>
		
</head>

<body>

	<h4>qtip - 튤팁</h4>

    <div id="divMain" style="padding-left:100px;border: solid 1px;">
	
		<p id="id1" style="width:100px;">가가가가가</p>
		<p id="id2" style="width:100px;">나나나나나</p>
		<p id="id3" style="width:70px;">다다다다다</p>
		<p id="id4" style="width:100px;">라라라라라</p>
		<p id="id5" style="width:100px;">마마마마마</p>
		<p id="id6" style="width:100px;">바바바바바</p>
		
	</div>
    
    <h4>참고 사이트 - <a href="javascript:var win = window.open('http://craigsworks.com/projects/qtip/docs');">http://craigsworks.com/projects/qtip/docs</a></h4>
    
</body>
</html>