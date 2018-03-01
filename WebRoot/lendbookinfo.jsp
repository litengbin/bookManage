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
	<table border="1" align="center" width="685" cellpadding="10"
		cellspacing="0" bgcolor="#71CABF" class="font1">
		<tr bgcolor="#E9EDF5">
			<th>图书</th>
			<th>ISBN</th>
			<th>书名</th>
			<th>出版社</th>
			<th>价格</th>
			<th>借书时间</th>
		</tr>
		<s:iterator value="#request.list" id="lend">
			<tr>
				<td><s:property value="#lend[0]" /></td>
				<td><s:property value="#lend[1]" /></td>
				<td><s:property value="#lend[2]" /></td>
				<td><s:property value="#lend[3]" /></td>
				<td><s:property value="#lend[4]" /></td>
				<td><s:date name="#lend[5]" format="yyyy-MM-dd" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>