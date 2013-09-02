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
		
		<h2>전화번호부 목록</h2>
		<hr>
		<br />
		
		<c:if test="${empty phones}">
			<h3 style="color:grey">&nbsp;&nbsp;&nbsp;등록된 연락처가 없습니다. 신규 등록해주세요.</h3>
		</c:if>
		
		<c:if test="${!empty phones}">
			<br />
			<center>
				<table width="90%">
					<tr style="background-color: gray;">
						<th>번호</th>
						<th>이름</th>
						<th>연락처</th>
						<th>이메일</th>
						<th>생년월일</th>
						<th>수정 | 삭제</th>
					</tr>
					<c:forEach items="${phones}" var="phone">
						<tr style="background-color: silver;">
							<td align="center"><c:out value="${phone.id}"/></td>
							<td align="center"><c:out value="${phone.name}"/></td>
							<td align="center"><c:out value="${phone.tel}"/></td>
							<td align="center"><c:out value="${phone.email}"/></td>
							<td align="center"><c:out value="${phone.birthday}"/></td>
							<td align="center">
								<a href="updatePhone/id/${phone.id}">수정</a>&nbsp;&nbsp;
								<a href="deletePhone/id/${phone.id}">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</center>
			<br />
		</c:if>
		
		<center>
		<p><a href="addPhone">신규 등록 바로 가기</a></p>
		</center>
	</body>
</html>