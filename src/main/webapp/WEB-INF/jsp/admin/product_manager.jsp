<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">
	<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Image</th>
					<th>Description</th>
					<th>Price</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${products}">
					<tr>
						<td>${p.name}</td>
						<td><img src="${p.image}" alt="${p.id}"
							class="img-responsive"></td>
						<td>${p.description}</td>
						<td>${p.price}</td>
						<td><a href="#" class="label label-danger""> <span
								class="glyphicon glyphicon-remove" /></span> Remove
						</a></td>
					</tr>
				</c:forEach>

				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{cart.grandTotal}}</th>
					<th></th>
				</tr>
			</tbody>
		</table>
		<a href="<spring:url value="/products" />" class="btn btn-success">
			<span class="glyphicon-circle-arrow-left glyphicon"></span> continue
			shopping
		</a>
	</div>
</section>