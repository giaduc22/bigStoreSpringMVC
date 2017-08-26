<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />

			<div class="row">
				<h2>
					<spring:message code="lang.product_manager" />
				</h2>
				<div>
					<a class="btn btn-success" href="${contextPath}/product_manager"> 
					<span class="glyphicon glyphicon-menu-left"></span> Back
				</a>
				</div>
				<div>
					<div class="card card-body">
						<form action="${contextPath}/add_product" method="post">
							<div class="form-group">
								<label class="form-control-label" for="productName"><spring:message code="lang.product_name" /></label>
								<input type="text" name="name" class="form-control" id="productName" placeholder="Product name" required>
							</div>
							<div class="form-group">
								<label class="form-control-label" for="productCategory"><spring:message code="lang.product_category" /></label>
								<select name="product_category" class="form-control" id="productCategory">
					<c:forEach var="p" items="${productCategories}">
						<option value="${p.id}">${p.name}</option>
					</c:forEach>
				</select>
							</div>
							<div class="form-group">
								<label class="form-control-label" for="imageURL"><spring:message code="lang.product_image" /></label>
								<input type="url" name="image" class="form-control" id="imageURL" placeholder="Image URL" required>
							</div>
							<div class="form-group">
								<label class="form-control-label" for="description"><spring:message code="lang.product_description" /></label>
								<textarea name="description" class="form-control" id="description" rows="3" placeholder="Description" required></textarea>
							</div>
							<div class="form-group">
								<label class="form-control-label" for="price"><spring:message code="lang.product_price" /></label> <input type="number"
								 name="price" class="form-control" id="price" placeholder="Price" required>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-success btn-block">
					<span class="glyphicon glyphicon-plus"></span> <spring:message code="lang.add" />
				</button>
							</div>
						</form>
					</div>
				</div>
			</div>