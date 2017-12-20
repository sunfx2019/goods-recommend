<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/jsp/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		  	$("#add").click(function(){
		  		window.location.href = '${pageContext.request.contextPath}/user/add.shtml';
		  	});
		  	$("#update").click(function(){
		  		window.location.href = '${pageContext.request.contextPath}/user/update.shtml';
		  	});
		  	$("#delete").click(function(){
		  		window.location.href = '${pageContext.request.contextPath}/user/delete.shtml';
		  	});
		});
		function goPage(pageNo){
			debugger;
			var form_ = document.getElementById("searchform");
			if(form_ == null){
				alert("Form对象[${param.formId}]为空！");
			}else{
				if(form_.action.indexOf('?') != -1){
					form_.action = form_.action + "&pageNo=" + pageNo + "&pageSize=${page.pageSize}";
				}else{
					form_.action = form_.action + "?pageNo=" + pageNo + "&pageSize=${page.pageSize}";
				}
				form_.submit();
			}
		}
	</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">用户管理</a></li>
    <li><a href="#">用户列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div style="border: 1px solid #eeeeee;margin-bottom: 18px;padding-top: 10px;padding-bottom: 10px;">
    	<form id="searchform" action="${pageContext.request.contextPath}/user/list.shtml" method="post">
    	<table border="0" width="" cellpadding="0" cellspacing="0">
			<tr>
				<td width="70px" align="center"><b>用户名：</b></td>
				<td><input id="" name="" class="dfinput" style="width: 167px;"/></td>
				<td width="160" align="center"><button type="submit" class="sure">查 询</button></td>
			</tr>	
    	</table>
    	</form>
    </div>
    
    <div class="tools">
    	<ul class="toolbar">
    	<shiro:hasPermission name="/user/add.shtml">
    		<li id="add"><span><img src="${pageContext.request.contextPath}/resources/images/t01.png" /></span>添加</li>
    	</shiro:hasPermission>
    	<shiro:hasPermission name="/user/update.shtml">
    		<li id="update"><span><img src="${pageContext.request.contextPath}/resources/images/t02.png" /></span>修改</li>
    	</shiro:hasPermission>
    	<shiro:hasPermission name="/user/delete.shtml">
    		<li id="delete"><span><img src="${pageContext.request.contextPath}/resources/images/t03.png" /></span>删除</li>
    	</shiro:hasPermission>
        </ul>
        <ul class="toolbar1">
        <li><span><img src="${pageContext.request.contextPath}/resources/images/t05.png" /></span>设置</li>
        </ul>
    </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value=""/></th>
        <th>ID<i class="sort"><img src="${pageContext.request.contextPath}/resources/images/px.gif" /></i></th>
        <th>用户名</th>
        <th>邮箱</th>
        <th>密码</th>
        <th>创建时间</th>
        <th>登陆时间</th>
        <th>是否有效</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        
        <c:if test="${not empty page && not empty page.list}">
			<c:forEach var="v" items="${page.list}">
				<tr>
					<td width="50px"><input name="" type="checkbox" value="${v.id}"/></td>
					<td width="">${v.nickname}</td>
					<td width="">${v.email}</td>
					<td width="">${v.email}</td>
					<td width="">${v.pswd}</td>
					<td width=""><fmt:formatDate value="${v.createTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
					<td width=""><fmt:formatDate value="${v.lastLoginTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
					<td width="">${v.status eq 1 ? '有效':'无效'}</td>
					<td width=""><a href="">修改密码</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty page || empty page.list}">
			<tr>
				<td align="center" colspan="10">没有数据。</td>
			</tr>
		</c:if>
        
        </tbody>
    </table>
    
    <div class="pagin">
    	<div class="message">共&nbsp;<i class="blue">${page.total}</i>&nbsp;条记录，当前显示第&nbsp;<i class="blue">${page.pageNum}&nbsp;</i>页</div>
        
		<ul class="paginList">
			<li class="paginItem"><a href="javascript:goPage(1);" aria-label="Previous">首页</a></li>
			<c:if test="${page.hasPreviousPage}">
				<li><a href="javascript:goPage(${page.pageNum-1});" aria-label="Previous">上一页</a></li>
			</c:if>
			<c:forEach begin="1" end="${page.pages}" var="each">
				<c:choose>
					<c:when test="${each == page.pageNum}">
						<li class="paginItem"><a style="color: black;">${each}</a></li>
					</c:when>
					<c:when test="${each >= (page.pageNum-3) && each <= (page.pageNum+3)}">
						<li class="paginItem"><a href="javascript:goPage(${each});" aria-label="Previous">${each}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${page.hasNextPage}">
				<li class="paginItem"><a href="javascript:goPage(${page.pageNum+1});" aria-label="Next">下一页</a></li>
			</c:if>
			<li class="paginItem"><a href="javascript:goPage(${page.pages});" aria-label="Previous">尾页</a></li>
		</ul>
        
    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
      	<div class="tipinfo">
        <span><img src="${pageContext.request.contextPath}/resources/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    </div>
    
    </div>
    
    <script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
