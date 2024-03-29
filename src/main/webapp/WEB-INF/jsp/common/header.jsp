<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />


			<!-- Navigation -->
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="${contextPath}/index">Big Store</a>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li>
								<a href="${contextPath}/product_manager">
									<spring:message code="lang.product_manager" />
								</a>
							</li>
							<li>
								<a href="${contextPath}/category_manager">
									<spring:message code="lang.product_category_manager" />
								</a>
							</li>
						</ul>	
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container -->
			</nav>