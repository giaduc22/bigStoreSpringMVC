<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>

			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
				<title>Insert title here</title>
			</head>

			<body>

				<table>
					<tr>
						<th>User</th>
						<th>Password</th>
						<th>Fullname</th>
						<th></th>
					</tr>
					<c:forEach var="u" items="${users}">
						<tr>
							<th>${u.username}</th>
							<th>${u.password}</th>
							<th>${u.fullname}</th>
							<th></th>
						</tr>
					</c:forEach>

				</table>

			</body>

			</html>