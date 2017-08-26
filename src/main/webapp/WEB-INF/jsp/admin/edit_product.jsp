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
                <form action="${contextPath}/update_product" method="post">
                    <div class="form-group row">
                        <label class="form-control-label col-sm-4" for="productId"><spring:message code="lang.product_id" /></label>
                        <div class="col-sm-8">
                            <input type="text" name="id" readonly class="form-control" id="productId" value='<c:out value="${product.id}" />'>
                        </div>

                    </div>
                    <div class="form-group row">
                        <label class="form-control-label col-sm-4" for="productName"><spring:message code="lang.product_name" /></label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="productName" value='<c:out value="${product.name}" />' required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="form-control-label col-sm-4" for="productCategory"><spring:message code="lang.product_category" /></label>
                        <div class="col-sm-8">
                            <select class="form-control" name="product_category" id="productCategory">
                    <c:forEach var="category" items="${productCategories}">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="form-control-label col-sm-4" for="imageURL"><spring:message code="lang.product_image" /></label>
                        <div class="col-sm-8">
                            <input type="url" name="image" class="form-control" id="imageURL" value='<c:out value="${product.image}" />' required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="form-control-label col-sm-4" for="description"><spring:message code="lang.product_description" /></label>
                        <div class="col-sm-8">
                            <textarea class="form-control" name="description" id="description" rows="3" required><c:out value="${product.description}" /></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="form-control-label col-sm-4" for="price"><spring:message code="lang.product_price" /></label>
                        <div class="col-sm-8">
                            <input type="number" name="price" class="form-control" id="price" value='<c:out value="${product.price}" />' required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <button type="submit" class="btn btn-success btn-block">
                <span class="glyphicon glyphicon-plus"></span> <spring:message code="lang.update" />
            </button>
                    </div>
                </form>
            </div>
        </div>