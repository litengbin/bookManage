<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search页面</title>
<style type="text/css">
.font1 {
	font-size: 13px;
}
</style>
</head>
<body>
	<s:form action="selectBook" method="post" theme="simple">
		<table border="1" width="200" cellspacing="1" class="font1">
			<tr bgcolor="#E9EDF5">
				<td>内容选择</td>
			</tr>
			<tr>
				<td align="left" valign="top" height="400"><br>借书证号:<br>
					<br> <s:textfield name="lend.readerId" size="15" /> <s:submit
						value="查询"></s:submit></td>
			</tr>
		</table>
	</s:form>
</body>
</html>