<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
<style type="text/css">
.font1 {
	font-size: 13px;
}
</style>
<script type="text/javascript">
	function check(thisObject) {
		var sTmp = "";
		sTmp = thisObject.value;
		if (isNaN(sTmp)) {
			alert("请输入数字");
			thisObject.select();
		}
	}
</script>
</head>
<body>
	<table bgcolor="#71CABF" align="center" class="font1">
		<tr>
			<td colspan="2"><jsp:include page="head.jsp" /></td>
		</tr>
		<tr>
			<s:form action="book" theme="simple" method="post"
				enctype="multipart/form-data" validate="true">
				<td><jsp:include page="funcselect.jsp" /></td>
				<td><jsp:include page="bookinfo.jsp" /></td>
			</s:form>
		</tr>
		<tr>
			<td colspan="2" align="center"><font size="2">南京师范大学:南京市宁海路122号&nbsp;&nbsp;邮编:210097<br>师教教育研究中心版权所有2010-1015
			</font></td>
		</tr>
	</table>
</body>
</html>