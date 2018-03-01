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
	<table border="1" width="599">
		<s:form action="lendBook" method="post" theme="simple">
			<tr bgcolor="#E8EDF5" class="font1">
				<s:if test="#request.readerId==null">
					<td colspan="2">图书信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ISBN<s:textfield
							name="lend.ISBN" size="15" disabled="true" />
						&nbsp;&nbsp;&nbsp;&nbsp;图书ID<s:textfield name="lend.bookId"
							size="15" disabled="true" /> <s:submit value="借书"
							disabled="true"></s:submit>
					</td>
				</s:if>
				<s:else>
					<td colspan="2">图书信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ISBN<s:textfield
							name="lend.ISBN" size="15" disabled="false" />
						&nbsp;&nbsp;&nbsp;&nbsp;图书ID<s:textfield name="lend.bookId"
							size="15" disabled="false" />
							<input type = "hidden" name = "lend.readerId" value = "<s:property value = "#request.readerId"/>"/>
							 <s:submit value="借书"
							disabled="false"></s:submit>
					</td>
				</s:else>
			</tr>
		</s:form>

		<tr>
			<td height="360" valign="top"><jsp:include
					page="lendbookinfo.jsp" /></td>
		</tr>
		<tr>
			<td align="center"><font color="red"><s:property
						value="message" /></font></td>
		</tr>
		<tr bgcolor="#E9EDF5" class="font1">
			<td align="right">
				<!-- 取出page --> <s:set name="page" value="#request.page"></s:set> <!-- 首页始终显示在第一页 -->
				<a
				href="selectBook.action?pageNow=1&lend.readerId=<s:property value = "#request.readerId"/>">首页</a>
				<!-- 如果有前一页就提交前一页的pageNow值 --> <s:if test="#page.hasPre">
					<a
						href="selectBook.action?pageNow=<s:property value = "#page.pageNow-1"/>&lend.readerId=<s:property value = "#request.readerId"/>">上一页</a>
				</s:if> <!-- 如果没有就提交第一页的pageNow值 --> <s:else>
					<a
						href="selectBook.action?pageNow=1&lend.readerId=<s:property value ="#request.readerId"/>">上一页</a>
				</s:else> <!-- 如果有下一页就提交下一页的passNow值 --> <s:if test="#page.hasNext">
					<a
						href="selectBook.action?pageNow=<s:property value ="#page.pageNow + 1"/>&lend.readerId=<s:property value = "#request.readerId"/>">下一页</a>
				</s:if> <!-- 如果没有就提交最后一页的pageNow值 --> <s:else>
					<a
						href="selectBook.action?pageNow=<s:property value = "#page.totalPage"/>&lend.readerId=<s:property value = "#request.readerId"/>">下一页</a>
				</s:else> <!-- 尾页始终提交最后一页的pageNow值 --> <a
				href="selectBook.action?pageNow=<s:property value ="#page.totalPage"/>&lend.readerId=<s:property value="#request.readerId"/>">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>