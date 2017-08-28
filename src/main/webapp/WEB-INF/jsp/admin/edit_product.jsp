<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
            <div class="card">
            	<div class="card-body">
                <form:form modelAttribute="product" action="${contextPath}/update_product" method="post">
                    <div class="form-group">
                        <label class="form-control-label" for="productId"><spring:message code="lang.product_id" /></label>
                        <input type="text" name="id" readonly class="form-control" id="productId" value='<c:out value="${product.id}" />'>
                        <small class="text-muted text-danger">
					    	<form:errors path="id" />
					    </small>

                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="productName"><spring:message code="lang.product_name" /></label>
                        <input type="text" name="name" class="form-control" id="productName" value='<c:out value="${product.name}" />' >
                        <small class="text-muted text-danger">
					    	<form:errors path="name" />
					    </small>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="productCategory"><spring:message code="lang.product_category" /></label>
                        <select class="form-control" name="product_category" id="productCategory">
		                    <c:forEach var="category" items="${productCategories}">
		                        <option value="${category.id}">${category.name}</option>
		                    </c:forEach>
		                </select>
                        
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="imageURL"><spring:message code="lang.product_image" /></label>
                        <input type="url" name="image" class="form-control" id="imageURL" value='<c:out value="${product.image}" />' >
                       	<small class="text-muted text-danger">
					    	<form:errors path="image" />
					    </small>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="description"><spring:message code="lang.product_description" /></label>
                       	<textarea class="form-control" name="description" id="description" rows="3" ><c:out value="${product.description}" /></textarea>
                        <small class="text-muted text-danger">
					    	<form:errors path="description" />
					    </small>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="price"><spring:message code="lang.product_price" /></label>
                       	<input type="number" name="price" class="form-control" id="price" value='<c:out value="${product.price}" />' >
                        <small class="text-muted text-danger">
					    	<form:errors path="price" />
					    </small>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success btn-block">
			                <span class="glyphicon glyphicon-plus"></span> <spring:message code="lang.update" />
			            </button>
                    </div>
                    
                </form:form>
                </div>
            </div>
        </div>