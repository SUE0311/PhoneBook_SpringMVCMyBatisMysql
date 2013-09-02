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
		
		<legend>전화번호부 등록</legend>
		
		<center>
		
		<%-- <form> 태그를 위한 커스텀 태그 활용 --%>
		<!-- 
			커멘드 객체의 이름이 기본값인 "command"가 아니면
			commandName 속성에 커맨드 객체의 이름을 명시해주어야 함
		-->
		<form:form commandName="phone" action="addPhoneOk" name="phoneForm">
		<table>
			<tr>
				<td colspan="2" align="left">
					<form:errors path="*" cssStyle="color : red;"/>
				</td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td>
					<form:input path="name" size="30" />
				</td>
			</tr>
			<tr>	
				<td>연락처 : </td>
				<td>
					<form:input path="tel" size="30" />
				</td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td>
					<form:input path="email" size="30" />
				</td>
			</tr>
			<tr>
				<td>생일 : </td>
				<td>
					<form:input path="birthday" size="30" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="저장" />&nbsp;
					<input type="button" name="cancel" value="취소" onclick="javascript:history.go(-1);return false;"/>
				</td>
			</tr>
		</table>
		
		</form:form>
		
		</center>
		
		</fieldset>
	
	</body>
</html>