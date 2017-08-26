${contextPath}/<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

			<div class="row">
				<div class="col-md-6">
					<img class="img-responsive" src='<c:out value="${product.image}" />' alt='<c:out value="${product.id}" />'>
				</div>
				<div class="col-md-6">
					<div>
						<h2>Buy your new
							<c:out value="${product.name}" />
						</h2>
						<p>Buy online and get fast, free shipping.</p>
						<p class="pull-right">
							<a href="item?id=<c:out value=" ${product.id} " />" class="btn btn-info btn-md"> <span
					class="glyphicon glyphicon-shopping-cart"></span> Add to cart
				</a>
						</p>
						<h3>$
							<c:out value="${product.price}" />
						</h3>

						<p>
							<c:out value="${product.description}" />
						</p>
					</div>
				</div>

			</div>