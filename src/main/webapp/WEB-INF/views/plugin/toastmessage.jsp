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
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery/plugin/toastmessage/css/jquery.toastmessage.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/plugin/toastmessage/jquery.toastmessage.js"></script>
    
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$("#btnTest1").click(function (e) {
			$().toastmessage('showToast', {
			    text     : '성공입니다.',
			    sticky   : false,
			    position : 'middle-center',	//top-left, top-center, top-right, middle-left, middle-center, middle-right
			    type     : 'success',	//notice, warning, error, success
			    stayTime : 1000
			});
        });
		
		$("#btnTest2").click(function (e) {
			$().toastmessage('showToast', {
			    text     : '안내입니다.',
			    sticky   : false,
			    position : 'middle-center',	//top-left, top-center, top-right, middle-left, middle-center, middle-right
			    type     : 'notice',	//notice, warning, error, success
			    stayTime : 1000
			});
        });
		
		$("#btnTest3").click(function (e) {
			$().toastmessage('showToast', {
			    text     : '경고입니다.',
			    sticky   : false,
			    position : 'middle-center',	//top-left, top-center, top-right, middle-left, middle-center, middle-right
			    type     : 'warning',	//notice, warning, error, success
			    stayTime : 1000
			});
        });
		
		$("#btnTest4").click(function (e) {
			$().toastmessage('showToast', {
			    text     : '에러입니다.',
			    sticky   : false,
			    position : 'middle-center',	//top-left, top-center, top-right, middle-left, middle-center, middle-right
			    type     : 'error',	//notice, warning, error, success
			    stayTime : 1000
			});
        });
		
	});
	
	//========================================================//
	// Toast Message 
	// 
	// *options*
	// inEffectDuration:  600,   // in effect duration in miliseconds
	// stayTime:         3000,   // time in miliseconds before the item has to disappear
	// text:               '',   // content of the item
	// sticky:          false,   // should the toast item sticky or not?
	// type:         'notice',   // notice, warning, error, success
	// position:  'top-right',   // top-left, top-center, top-right, middle-left, middle-center, middle-right
	//	                           // Position of the toast container holding different toast.
	//	                           // Position can be set only once at the very first call,
	//	                           // changing the position after the first call does nothing
	// closeText:         '',    // text which will be shown as close button,
	//	                           // set to '' when you want to introduce an image via css
	// close:            null    // callback function when the toastmessage is closed
	//========================================================//
	
	</script>
		
</head>

<body>

	<h4>Toast Message</h4>
	
	<fieldset>
		<span><input id="btnTest1" type="button" value="Success" ></span>
		<span><input id="btnTest2" type="button" value="notice" ></span>
		<span><input id="btnTest3" type="button" value="warning" ></span>
		<span><input id="btnTest4" type="button" value="error" ></span>
	</fieldset>
    
    
    <h4>참고 사이트 - <a href="javascript:var win = window.open('http://akquinet.github.com/jquery-toastmessage-plugin');">http://akquinet.github.com/jquery-toastmessage-plugin</a></h4>
    
</body>
</html>