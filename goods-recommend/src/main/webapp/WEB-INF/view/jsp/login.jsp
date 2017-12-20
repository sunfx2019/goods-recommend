<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/jsp/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>欢迎登录后台管理系统</title>
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/resources/js/cloud.js" type="text/javascript"></script>
	<script language="javascript">
		$(function(){
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	    })  
	});  
	</script> 
	<c:if test="${not empty message}">
    	<script type="text/javascript">alert('${message}');</script>
    </c:if>
</head>

<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/resources/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div> 
    <!--  
	<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    -->
    <div class="loginbody">
	    <form action="${pageContext.request.contextPath}/loginCheck.shtml" method="post">
	    <span class="systemlogo"></span> 
	    <div class="loginbox">
	    <ul>
		    <li><input name="username" type="text" class="logininput" value="" onclick="JavaScript:this.value=''"/></li>
		    <li><input name="password" type="password" class="logininput" value="" onclick="JavaScript:this.value=''"/></li>
		    <li>
		    	<input type="submit" class="loginbtn" value="登录"  onclick="" />
		    	<label style="height: 20px;"><input name="" type="checkbox" value="" style="line-height: 20px;vertical-align:middle;height: 20px;"/>&nbsp;记住密码</label>
		    	<label><a href="#">忘记密码？</a></label>
		    </li>
	    </ul>
	    </div>
	    </form>
    </div>
    <div class="loginbm">版权所有  2013  <a href="http://www.abc.com">www.abc.com</a>  仅供学习交流，勿用于任何商业用途</div>
</body>
</html>
