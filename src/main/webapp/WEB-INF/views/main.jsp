<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	
	<title>DzWeb</title>
		
	<%@ include file="common/common.jsp"%>
	
	<link rel="stylesheet" type="text/css" href="jquery/plugin/superfish-1.4.8/css/superfish.css" media="screen">
	
	<script type="text/javascript" src="jquery/plugin/superfish-1.4.8/js/hoverIntent.js"></script>
	<script type="text/javascript" src="jquery/plugin/superfish-1.4.8/js/superfish.js"></script>
	
	<style>
        * {
        	margin: 0px;
        	padding: 0px;
        }
        
        body
        {
        	margin: 0px auto;
        	/* padding-top: 10px; */
        	
        }
        
        #divHeader 
        {
        	background-color: #5B5C60;
        	position: relative;
        	height: 50px;
        	width: 100%;
        	margin: 0px auto;
        }
        
        #title 
        {
        	position:absolute;
        	left: 40px;
        	top: 15px;
        	color: #ffffff;
        }
        
        #titleSub 
        {
        	position:absolute;
        	right: 40px;
        	top: 20px;
        	color: #ffffff;
        }
        
        #divMenu
        {
        	width: 90%;
        	height: 40px;
        	margin: 0px auto;
        	background-color: #ffffff;
        }
        
        html, body{
        	height: 100%;
        }
        
        #divContents
        {
        	width: 89%;
        	height: 88%;
        	min-height: 700px;
        	margin: 0px auto;
        	border:2px solid #5B5C60;
        	border-radius:0px;
        }
       	
       	#divFooter 
        {
        	margin: 0px auto;
        	background-color: #5B5C60;
        	
        	width: 90%;
        	height:30px;
        	text-align: center;
        	color: White;
        }	

		#footerTitle 
        {
        	padding-top: 4px;
        	color: #ffffff;
        }
        
    </style>
    
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		// 메뉴 생성
		$('ul.sf-menu').superfish({
			delay:       0,                            // one second delay on mouseout 
            animation:   {opacity:'show',height:'show'},  // fade-in and slide-down animation 
            speed:       'normal',                          // faster animation speed 
            autoArrows:  false,                           // disable generation of arrow mark-up 
            dropShadows: false                            // disable drop shadows 
		});
		
		// 메인페이지 열기
		fnOpen('./home.do');
	});
	
	function fnOpen(url){
		$("#iContainer").attr("src", url);
		$(".sf-menu > li > ul").hide();
	}
	
	</script>
		
</head>

<body scroll="no">

	<header id="divHeader">
        <hgroup id="title">
            <h2>SSH Framework</h2>
        </hgroup>
        <h4 id="titleSub">Made By SSH</h4>
    </header>
    
	<div id="divMenu">
		<ul class="sf-menu" style="padding-top: 2px;padding-left: 0px;">
			<li class="current"><a href="javascript:fnOpen('home.do')">Home</a></li>
			<li>
				<a>jQuery UI</a>
				<ul>
					<li><a href="javascript:fnOpen('ui/accordion.do')">Accordion</a></li>
					<li><a href="javascript:fnOpen('ui/tabs.do')">Tabs</a></li>
					<li><a href="javascript:fnOpen('ui/dialog.do')">Dialog</a></li>
					<li><a href="javascript:fnOpen('ui/datepicker.do')">DatePicker</a></li>
					<li><a href="javascript:fnOpen('ui/progressbar.do')">Progressbar</a></li>
					<li><a href="javascript:fnOpen('ui/autocomplete.do')">AutoComplete</a></li>
					<li><a href="javascript:fnOpen('ui/menu.do')">Menu</a></li>
					<li><a href="javascript:fnOpen('ui/tooltip.do')">Tooltip</a></li>
					
					<li><a href="javascript:fnOpen('ui/button.do')">Button</a></li>
					<li><a href="javascript:fnOpen('ui/selectmenu.do')">Selectmenu</a></li>
					<li><a href="javascript:fnOpen('ui/slider.do')">Slider</a></li>
					
					<li><a href="javascript:fnOpen('ui/draggable.do')">Draggable</a></li>
					<li><a href="javascript:fnOpen('ui/droppable.do')">Droppable</a></li>
					<li><a href="javascript:fnOpen('ui/resizable.do')">Resizable</a></li>
					<li><a href="javascript:fnOpen('ui/selectable.do')">Selectable</a></li>
					<li><a href="javascript:fnOpen('ui/sortable.do')">Sortable</a></li>
				</ul>
			</li>
			<li>
				<a>Plugin</a>
				<ul>
					<li><a href="javascript:fnOpen('plugin/treeview.do')">treeview</a></li>
					<li><a href="javascript:fnOpen('plugin/toastmessage.do')">toastMessage</a></li>
					<li><a href="javascript:fnOpen('plugin/qtip.do')">qtip</a></li>
					<li><a href="javascript:fnOpen('plugin/slidebox.do')">slidebox</a></li>
					<li><a href="javascript:fnOpen('plugin/monthpicker.do')">monthpicker</a></li>
				</ul>
								
			</li>
			<li>
				<a>dz Plugin</a>
				<ul>
					<li><a href="javascript:fnOpen('dzplugin/dzMonthpicker.do')">dzMonthPicker</a></li>
				</ul>
			</li>
			<li>
				<a>HTML5</a>
				<ul>
					<li><a href="javascript:fnOpen('dzplugin/dzMonthpicker.do')">html5</a></li>
				</ul>
			</li>
			<li>
				<a>Grid/Chart</a>
				<ul>
					<li>
						<a href="#ab">jqGrid</a>
						<ul>
							<li><a href="#">jqGrid1</a></li>
							<li><a href="#aba">jqGrid2</a></li>
							<li><a href="#abb">jqGrid3</a></li>
							<li><a href="#abc">jqGrid4</a></li>
							<li><a href="#abd">jqGrid5</a></li>
						</ul>
					</li>
					<li><a href="#aa">fixedGrid</a></li>
					<li><a href="javascript:fnOpen('chart.jqplot.do')">jqplot</a></li>
				</ul>
			</li>
			
			<li>
				<a>Sample</a>
				<ul>
					<li><a href="#aa">Sample 1</a></li>
				</ul>
			</li>
			
			<li>
				<a>Project</a>
				<ul>
					<li><a href="#aa">Project 1</a></li>
				</ul>
			</li>
						
		</ul>
	</div>
	
	<div id="divContents">
		<iframe id="iContainer" src="" style="border:0;width:98%;height:98%;padding: 0px 8px" scroll="auto" frameborder="0" marginheight="0" marginwidth="0" ></iframe>
	</div>
	
	<!-- 
	<footer id="divFooter" >
        <h3 id="footerTitle">Duzon Bizon</h3>
    </footer>
     -->
</body>
</html>