<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

			<div class="row">

				<c:forEach var="p" items="${product}">
					<div class="col-md-6">
						<img class="img-responsive" src="${p.image }" alt="${p.id}">
					</div>
					<div class="col-md-6">
						<div>
							<h2>Buy your new ${p.name}</h2>
							<p>Buy online and get fast, free shipping.</p>
							<p class="pull-right">
								<a href="item.html?id=${p.id}" class="btn btn-info btn-md"> <span
						class="glyphicon glyphicon-shopping-cart"></span> Add to cart
					</a>
							</p>
							<h3>$${p.price }</h3>

							<p>${p.description}</p>
						</div>
					</div>
				</c:forEach>

			</div>