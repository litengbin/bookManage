<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.font1 {
	font-size: 13px;
}
</style>
</head>
<body>
	<table border="1" width="200" cellspacing="1" class="font1">
		<tr bgcolor="#E9EDF5">
			<td>功能选择</td>
		</tr>
		<tr>
			<td align="center" valign="top" height="400"><br> <s:submit
					value="图书追加" method="addBook"></s:submit><br> <br> <s:submit
					value="图书删除" method="deleteBook"></s:submit><br> <br> <s:submit
					value="图书修改" method="updateBook"></s:submit><br> <br> <s:submit
					value="图书查询" method="selectBook"></s:submit></td>
		</tr>
	</table>
</body>
</html>