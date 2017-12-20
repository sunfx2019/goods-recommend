<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/jsp/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
1.jsp

	<form action="${pageContext.request.contextPath}/common/action/saveAction.shtml" method="post">
		<input name="id" value="1"/>
		<input name="action" value=""/>
		<input name="userid" value="2"/>
		<input type="submit">
	</form>

</body>
</html>