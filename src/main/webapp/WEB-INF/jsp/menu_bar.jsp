<%@page import="org.hibernate.Hibernate"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="search.jsp"></jsp:include>
<p class="lead">
	<spring:message code="lang.product_category" />
</p>
<div class="list-group">

	<a href="index.html" class="list-group-item">All</a>
	<c:forEach var="p" items="${productCategories}" varStatus="i">
		<a href="index.html?category=${p.id}" class="list-group-item">${p.name}
			<span class="badge pull-right">
				${p.id}
				<%-- <c:out value="${size.get}"></c:out> --%>
			</span>
		</a>
	</c:forEach>

</div>

