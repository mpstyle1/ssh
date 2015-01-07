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
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery/plugin/treeview/css/jquery.treeview.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/plugin/treeview/jquery.treeview.js"></script>
    
	<script type="text/javascript">
	
	$(document).ready(function() {
		
		$("#MenuTree").treeview();
		
	});
	
	</script>
		
</head>

<body>

	<h4>트리 - 트리메뉴 사용이나 그외 트리형태에 사용</h4>

    <div id="menu" >
        <ul id="MenuTree" class="filetree" style="margin-left:5px;margin-top:5px;">
            <li class="open"><span class="folder">Section 1.UI</span>
                <ul>
                    <li><span class="file">treeView</span></li>
                    <li><span class="file">accordion</span></li>
                    <li><span class="file">tabs</span></li>
                    <li><span class="file">dialog</span></li>
                </ul>
            </li>
            <li class="open"><span class="folder">Section 2.그리드</span>
                <ul>
                    <li><span class=z"file">jqgrid query</span></li>
                    <li><span class="file">jqgrid edit</span></li>
                    <li><span class="file">상품문의 답변등록</span></li>                    
                </ul>                
            </li>
            <li class="open"><span class="folder">Section 3.차트</span>
                <ul>
                    <li><span class="file">차트조회1</span></li>
                    <li><span class="file">차트조회2</span></li>
                </ul>                
            </li>
        </ul>
    </div>
    
    <h4>참고 사이트 - <a href="javascript:var win = window.open('https://github.com/jzaefferer/jquery-treeview');">https://github.com/jzaefferer/jquery-treeview</a></h4>
</body>
</html>