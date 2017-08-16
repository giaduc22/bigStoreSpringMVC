<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />

			<div class="row">
				<div>
					<h2>Product manager</h2>
					<a class="btn btn-success" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample"> 
						<span class="glyphicon glyphicon-plus"></span> Add
					</a>
				</div>
				<div class="collapse" id="collapseExample">
					<div class="card card-body">
						<form action="${contextPath}/add_product.html" method="post">
							<div class="form-group">
								<label class="form-control-label" for="productName">Product name</label>
								<input type="text" name="name" class="form-control" id="productName" placeholder="Product name" required>
							</div>
							<div class="form-group">
								<label class="form-control-label" for="productCategory">Product category</label>
								<select name="product_category" class="form-control" id="productCategory">
									<c:forEach var="p" items="${productCategories}">
										<option value="${p.id}" >${p.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label class="form-control-label" for="imageURL">Image URL</label>
								<input type="url" name="image" class="form-control" id="imageURL" placeholder="Image URL" required>
							</div>
							<div class="form-group">
								<label class="form-control-label" for="description">Description</label>
								<textarea name="description" class="form-control" id="description" rows="3" placeholder="Description" required></textarea>
							</div>
							<div class="form-group">
								<label class="form-control-label" for="price">Price</label>
								<input type="number" name="price" class="form-control" id="price" placeholder="Price" required>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-plus"></span> Add</button>
							</div>
						</form>
					</div>
				</div>
				<table class="table">
					<thead class="thead-default">
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Image</th>
							<th>Description</th>
							<th>Price</th>
							<th>Edit</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${products}">
							<tr>
								<th>${p.id}</th>
								<td>
									<h3>${p.name}</h3>
								</td>
								<td><img src="${p.image}" alt="${p.id}" class="img-responsive img-fluid"></td>
								<td>${p.description}</td>
								<td>${p.price}</td>
								<td>
									<a href="#${p.id}" class="btn btn-info" data-toggle="collapse" aria-expanded="false" aria-controls="${p.id}"> 
										<span class="glyphicon glyphicon-edit"></span> Edit
									</a>
								</td>
								<td>
									<a href="${contextPath}/delete_product.html?id=${p.id}" class="btn btn-danger"> 
										<span class="glyphicon glyphicon-remove"></span> Remove
									</a>
								</td>
							</tr>
							<tr>
								<td colspan="7">
									<div id="${p.id}" class="collapse">
										<form  action="${contextPath}/update_product.html" method="post">
											<div class="form-group">
												<label class="form-control-label" for="productId">Product Id</label>
												<input type="text" name="id" readonly class="form-control" id="productId" value="${p.id}">
											</div>
											<div class="form-group">
												<label class="form-control-label" for="productName">Product name</label>
												<input type="text" name="name" class="form-control" id="productName" value="${p.name}" required>
											</div>
											<div class="form-group">
												<label class="form-control-label" for="productCategory">Product category</label>
												<select class="form-control" name="product_category" id="productCategory">
													<c:forEach var="category" items="${productCategories}">
														<option value="${category.id}">${category.name}</option>
													</c:forEach>
												</select>
											</div>
											<div class="form-group">
												<label class="form-control-label" for="imageURL">Image URL</label>
												<input type="url" name="image" class="form-control" id="imageURL" value="${p.image}" required>
											</div>
											<div class="form-group">
												<label class="form-control-label" for="description">Description</label>
												<textarea class="form-control" name="description" id="description" rows="3" required>${p.description}</textarea>
											</div>
											<div class="form-group">
												<label class="form-control-label" for="price">Price</label>
												<input type="number" name="price" class="form-control" id="price" value="${p.price}" required>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-plus"></span> Update</button>
											</div>
										</form>
									</div>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>