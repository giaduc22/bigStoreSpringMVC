<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="row">

	<div class="row">
		<c:forEach var="p" items="${products}">
			<div class="col-sm-3 col-lg-3 col-md-3">
				<div class="thumbnail">
					<img src="${p.image}" alt="${p.id}">
					<div class="caption">
						<h4 class="pull-right">${p.price}</h4>
						<h4>
							<a href="item.html">${p.name}</a>
						</h4>
						<p>${p.description}</p>
					</div>
					<div class="ratings">
						<p>
							<a href="item.html?id=${p.id}" class="btn btn-info btn-md"> <span
								class="glyphicon glyphicon-shopping-cart"></span> Add to cart
							</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
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
</div>