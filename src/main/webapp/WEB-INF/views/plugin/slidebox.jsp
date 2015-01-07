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
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery/plugin/slidebox/simple_slidebox/jquery.mSimpleSlidebox.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/plugin/slidebox/simple_slidebox/jquery.mSimpleSlidebox.js"></script>
    
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$(".slidebox").mSlidebox({
		    autoPlayTime:1000,
		    animSpeed:800,
		    easeType:"easeInOutQuint",
		    controlsPosition:{
		        buttonsPosition:"inside",
		        thumbsPosition:"inside"
		    },
		    pauseOnHover: true,
		    numberedThumbnails: false
		});
		
	});
	
	</script>
		
</head>

<body>

	<h4>Slide Box - 배너 </h4>

    <div class="slidebox">
	    <ul>
	        <li>
	            <div><a href="http://naver.com"><img src="<%=request.getContextPath()%>/jquery/plugin/slidebox/demo_images/sb-img-1.jpg"/></a></div>
	        </li>
	        <li>
	            <div><img src="<%=request.getContextPath()%>/jquery/plugin/slidebox/demo_images/sb-img-2.jpg"/></div>
	        </li>
	        <li>
	            <div><img src="<%=request.getContextPath()%>/jquery/plugin/slidebox/demo_images/sb-img-3.jpg"/></div>
	        </li>
	        <li>
	            <div><img src="<%=request.getContextPath()%>/jquery/plugin/slidebox/demo_images/sb-img-4.jpg"/></div>
	        </li>
	        <li>
	            <div><img src="<%=request.getContextPath()%>/jquery/plugin/slidebox/demo_images/sb-img-5.jpg"/></div>
	        </li>
	    </ul>
	</div>
    
    <h4>참고 사이트 - <a href="javascript:var win = window.open('http://manos.malihu.gr/slidebox-jquery-banner-rotator');">http://manos.malihu.gr/slidebox-jquery-banner-rotator</a></h4>
    <h4>jquery UI easing - <a href="javascript:var win = window.open('http://jqueryui.com/demos/effect/easing.html');">http://jqueryui.com/demos/effect/easing.html</a></h4>
    
</body>
</html>