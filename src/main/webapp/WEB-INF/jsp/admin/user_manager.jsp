<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row">
	<div>
		<h2>User manager</h2>
	</div>
	<table class="table">
		<thead class="thead-inverse">
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Email</th>
				<th>Edit</th>
				<th>Remove</th>
			</tr>
		</thead>
		<%-- <tbody>
			<c:forEach var="p" items="${productCategories}">
					<tr>
						<td>${p.id}</td>
						<td>${p.name}</td>
						<td><a href="#" class="btn btn-info"> <span
								class="glyphicon glyphicon-edit"></span> Edit
						</a></td>
						<td><a href="#" class="btn btn-danger"> <span
								class="glyphicon glyphicon-remove"></span> Remove
						</a></td>
					</tr>
			</c:forEach>
		</tbody> --%>
	</table>
</div>
<div class="row">
	<div class="text-center">
		<ul class="pagination">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>
</div>