<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/jsp/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(${pageContext.request.contextPath}/resources/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="${pageContext.request.contextPath}/index.shtml" target="_parent"><img src="${pageContext.request.contextPath}/resources/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="default.html" target="rightFrame" class="selected"><img src="${pageContext.request.contextPath}/resources/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    <li><a href="imgtable.html" target="rightFrame"><img src="${pageContext.request.contextPath}/resources/images/icon02.png" title="模型管理" /><h2>用户管理</h2></a></li>
    <li><a href="imglist.html"  target="rightFrame"><img src="${pageContext.request.contextPath}/resources/images/icon03.png" title="模块设计" /><h2>学生管理</h2></a></li>
    <li><a href="tools.html"  target="rightFrame"><img src="${pageContext.request.contextPath}/resources/images/icon04.png" title="常用工具" /><h2>教师管理</h2></a></li>
    <li><a href="computer.html" target="rightFrame"><img src="${pageContext.request.contextPath}/resources/images/icon05.png" title="文件管理" /><h2>班级管理</h2></a></li>
    <li><a href="tab.html"  target="rightFrame"><img src="${pageContext.request.contextPath}/resources/images/icon06.png" title="系统设置" /><h2>楼宇管理</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="${pageContext.request.contextPath}/resources/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${pageContext.request.contextPath}/loginOut.shtml" target="_parent">退出</a></li>
    </ul>
    <div class="user">
    <span>admin</span>
    <i>消息</i>
    <b>5</b>
    </div>    
    </div>

</body>
</html>
