<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="row">
    <h2>
        <spring:message code="lang.product_category_manager" />
    </h2>
    <div>
        <a class="btn btn-success" href="${contextPath}/category_manager"> 
            <span class="glyphicon glyphicon-menu-left"></span> Back
        </a>
    </div>
    <div>
        <form:form modelAttribute="productCategory" action="${contextPath}/add_category" method="post">
            <div class="form-group">
            	<label class="form-control-label" for="productCategoryName"><spring:message code="lang.product_category_name" /></label>            
	            <input type="text" name="name" class="form-control" id="productCategoryName" placeholder="Product category name">
                <small class="text-muted text-danger">
			    	<form:errors path="name" />
			    </small>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-plus"></span> <spring:message code="lang.add" /></button>
            </div>
        </form:form>
    </div>
</div>