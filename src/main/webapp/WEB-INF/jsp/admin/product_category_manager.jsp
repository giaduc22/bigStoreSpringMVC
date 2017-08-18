<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

			<div class="row">
			<h2>Product category manager</h2>
				<div class="col-md-6">
					<a class="btn btn-success" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample"> 
						<span
						class="glyphicon glyphicon-plus"></span> Add
					</a>
				</div>
				<div class="col-md-6">
					<jsp:include page="../common/search.jsp"></jsp:include>
				</div>
				<div class="collapse" id="collapseExample">
					<div class="card card-body">
						<form action="${contextPath}/add_product_category" method="post">
							<div class="form-group">
								<label class="form-control-label" for="productCategoryName">Product category name</label>
								<input type="text" name="name" class="form-control" id="productCategoryName" placeholder="Product name" required>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-plus"></span> Add</button>
							</div>
						</form>
					</div>
				</div>
				<table class="table" id="myTable">
					<thead class="thead-inverse">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Edit</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${productCategories}">
							<tr>
								<td>${p.id}</td>
								<td>${p.name}</td>
								<td>
									<a class="btn btn-info"  data-toggle="collapse" href="#${p.id}" aria-expanded="false" aria-controls="${p.id}"> 
										<span class="glyphicon glyphicon-edit"></span> Edit
									</a>
								</td>
								<td>
									<a href="${contextPath}/delete_product_category?id=${p.id}" class="btn btn-danger"> 
										<span class="glyphicon glyphicon-remove"></span> Remove
									</a>
								</td>
							</tr>
							<tr>
								<th></th>
								<th colspan="2">
									<div class="collapse" id="${p.id}">
										<form action="${contextPath}/update_product_category" method="post">
											<div class="form-group">
												<label class="form-control-label" for="productCategoryId">Product category id</label>
												<input type="text" name="id" readonly class="form-control" id="productCategoryId" value="${p.id}" >
											</div>
											<div class="form-group">
												<label class="form-control-label" for="productCategoryName">Product category name</label>
												<input type="text" name="name" class="form-control" id="productCategoryName" value="${p.name}" required>
											</div>
											
											<div class="form-group">
												<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-plus"></span> Update</button>
											</div>
										</form>
									</div>
								</th>
								<th></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>