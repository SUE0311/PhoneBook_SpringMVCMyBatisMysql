<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		<title>Spring MVC PhoneBook</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	</head>
	
	<body>
		<fieldset>
		
		<legend>전화번호부 수정</legend>
		
		<center>
		
		<form:form commandName="phone" action="updatePhoneOk" name="phoneForm">
		
		<table>
			<tr>
				<td colspan="2" align="left">
					<form:errors path="*" cssStyle="color : red;"/>
					<form:hidden path="id" value="${phone.id}"/>
				</td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td>
					<form:input path="name" value="${phone.name}"/>
				</td>
			</tr>
			<tr>	
				<td>연락처 : </td>
				<td>
					<form:input path="tel" value="${phone.tel}"/>
				</td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td>
					<form:input path="email" value="${phone.email}"/>
				</td>
			</tr>
			<tr>
				<td>생일 : </td>
				<td>
					<form:input path="birthday" value="${phone.birthday}"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" />&nbsp;
					<input type="button" name="cancel" value="취소" onclick="javascript:history.go(-1);return false;"/>
				</td>
			</tr>
		</table>
		
		</form:form>
		
		</center>
		
		</fieldset>
	
	</body>
</html>