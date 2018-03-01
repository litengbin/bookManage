<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
<title>Insert title here</title>
</head>
<body bgcolor="#71CABF">
	<s:form action="login" method="post" theme="simple">
		<table>
			<caption>用户登录</caption>
			<tr>
				<td>登录名</td>
				<td><s:textfield name="login.name" size="20" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码</td>
				<td><s:password name="login.password" size="21" /></td>
			</tr>
			<tr>
				<td><s:submit value="登录" /></td>
				<td><s:reset value="重置" /></td>
			</tr>
			<!-- 验证失败信息或错误信息在这里显示 -->
			<tr>
				<td colspan="2"><font color="red"><s:fielderror /> <s:property
							value="message" /></font></td>
		</table>
	</s:form>
</body>
</html>