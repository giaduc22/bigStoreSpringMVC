<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />

			<div class="row">
				<h2>
					<spring:message code="lang.product_manager" />
				</h2>
				<div class="col-md-6">
					<a class="btn btn-success" href="${contextPath}/add_product"> <span
						class="glyphicon glyphicon-plus"></span> <spring:message code="lang.add" />
					</a>
				</div>
				<div class="col-md-6">
					<jsp:include page="../common/search.jsp"></jsp:include>
				</div>
				<table class="table" id="myTable">
					<thead class="thead-inverse">
						<tr>
							<th>
								<spring:message code="lang.product_id" />
							</th>
							<th>
								<spring:message code="lang.product_name" />
							</th>
							<th>
								<spring:message code="lang.product_image" />
							</th>
							<th>
								<spring:message code="lang.product_description" />
							</th>
							<th>
								<spring:message code="lang.product_price" />
							</th>
							<th>
								<spring:message code="lang.edit" />
							</th>
							<th>
								<spring:message code="lang.remove" />
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${products}">
							<tr>
								<td>${p.id}</td>
								<td>${p.name}</td>
								<td><img src="${p.image}" alt="${p.id}" class="img-responsive img-fluid"></td>
								<td>${p.description}</td>
								<td>${p.price}</td>
								<td><a href="${contextPath}/edit_product?id=${p.id}" class="btn btn-info"> <span
							class="glyphicon glyphicon-edit"></span> <spring:message code="lang.edit" />
					</a></td>
								<td><a href="${contextPath}/delete_product?id=${p.id}" class="btn btn-danger delete"> <span
							class="glyphicon glyphicon-remove"></span> <spring:message code="lang.remove" />
					</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>