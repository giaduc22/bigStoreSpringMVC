<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="row">
<h2><spring:message code="lang.product_manager" /></h2>
	<div class="col-md-6">
		<a class="btn btn-success" data-toggle="collapse"
			href="#collapseExample" aria-expanded="false"
			aria-controls="collapseExample"> <span
			class="glyphicon glyphicon-plus"></span> <spring:message code="lang.add" />
		</a>
	</div>
	<div class="col-md-6">
					<jsp:include page="../common/search.jsp"></jsp:include>
				</div>
	<div class="collapse" id="collapseExample">
		<div class="card card-body">
			<form action="${contextPath}/add_product" method="post">
				<div class="form-group">
					<label class="form-control-label" for="productName"><spring:message code="lang.product_name" /></label> 
					<input type="text" name="name" class="form-control"
						id="productName" placeholder="Product name" required>
				</div>
				<div class="form-group">
					<label class="form-control-label" for="productCategory"><spring:message code="lang.product_category" /></label> 
						<select name="product_category" class="form-control"
						id="productCategory">
						<c:forEach var="p" items="${productCategories}">
							<option value="${p.id}">${p.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label class="form-control-label" for="imageURL"><spring:message code="lang.product_image" /></label>
					<input type="url" name="image" class="form-control" id="imageURL"
						placeholder="Image URL" required>
				</div>
				<div class="form-group">
					<label class="form-control-label" for="description"><spring:message code="lang.product_description" /></label>
					<textarea name="description" class="form-control" id="description"
						rows="3" placeholder="Description" required></textarea>
				</div>
				<div class="form-group">
					<label class="form-control-label" for="price"><spring:message code="lang.product_price" /></label> <input
						type="number" name="price" class="form-control" id="price"
						placeholder="Price" required>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success btn-block">
						<span class="glyphicon glyphicon-plus"></span> <spring:message code="lang.add" />
					</button>
				</div>
			</form>
		</div>
	</div>
	<table class="table" id="myTable">
		<thead class="thead-inverse">
			<tr>
				<th><spring:message code="lang.product_id" /></th>
				<th><spring:message code="lang.product_name" /></th>
				<th><spring:message code="lang.product_image" /></th>
				<th><spring:message code="lang.product_description" /></th>
				<th><spring:message code="lang.product_price" /></th>
				<th><spring:message code="lang.edit" /></th>
				<th><spring:message code="lang.remove" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td><img src="${p.image}" alt="${p.id}"
						class="img-responsive img-fluid"></td>
					<td>${p.description}</td>
					<td>${p.price}</td>
					<td><a href="#${p.id}" class="btn btn-info"
						data-toggle="collapse" aria-expanded="false"
						aria-controls="${p.id}"> <span
							class="glyphicon glyphicon-edit"></span> <spring:message code="lang.edit" />
					</a></td>
					<td><a href="${contextPath}/delete_product?id=${p.id}"
						class="btn btn-danger delete"> <span
							class="glyphicon glyphicon-remove"></span> <spring:message code="lang.remove" />
					</a></td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th colspan="3">
						<div id="${p.id}" class="collapse">
							<form action="${contextPath}/update_product" method="post">
								<div class="form-group row">
									<label class="form-control-label col-sm-4" for="productId"><spring:message code="lang.product_id" /></label> 
									<div class="col-sm-8">
										<input type="text" name="id" readonly class="form-control"
										id="productId" value="${p.id}">
									</div>	
										
								</div>
								<div class="form-group row">
									<label class="form-control-label col-sm-4" for="productName"><spring:message code="lang.product_name" /></label> 
									<div class="col-sm-8">
										<input type="text" name="name" class="form-control"
										id="productName" value="${p.name}" required>
									</div>
								</div>
								<div class="form-group row">
									<label class="form-control-label col-sm-4" for="productCategory"><spring:message code="lang.product_category" /></label> 
									<div class="col-sm-8">
										<select class="form-control" name="product_category"
										id="productCategory">
											<c:forEach var="category" items="${productCategories}">
												<option value="${category.id}">${category.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="form-control-label col-sm-4" for="imageURL"><spring:message code="lang.product_image" /></label> 
									<div class="col-sm-8">
										<input type="url" name="image" class="form-control"
										id="imageURL" value="${p.image}" required>
									</div>
								</div>
								<div class="form-group row">
									<label class="form-control-label col-sm-4" for="description"><spring:message code="lang.product_description" /></label>
									<div class="col-sm-8">
										<textarea class="form-control" name="description"
											id="description" rows="3" required>${p.description}</textarea>
									</div>
								</div>
								<div class="form-group row">
									<label class="form-control-label col-sm-4" for="price"><spring:message code="lang.product_price" /></label> 
									<div class="col-sm-8">
										<input type="number" name="price" class="form-control" id="price"
											value="${p.price}" required>
									</div>
								</div>
								<div class="form-group row">
									<button type="submit" class="btn btn-success btn-block">
										<span class="glyphicon glyphicon-plus"></span> <spring:message code="lang.update" />
									</button>
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