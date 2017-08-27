<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- Multiple @RequestParam Handle -->
<%
	/* if category == null ? url = contextPath/index? : url = contextPath/index?category=category? */

	String requesParam = request.getParameter("category");
	String contextPath = request.getContextPath();
	String url = null;
	if (null != requesParam) {
		url = contextPath + "/index?" + "category=" + requesParam + "&";
	} else {
		url = contextPath + "/index?";
	}
%>


<div class="row">
	<div class="row">
		<c:forEach var="p" items="${products}">
			<div class="col-sm-3 col-lg-3 col-md-3">
				<div class="thumbnail">
					<img src="${p.image}" alt="${p.id}">
					<div class="caption">
						<h4 class="pull-right">$ ${p.price}</h4>
						<h4>
							<a href="item?id=${p.id}">${p.name}</a>
						</h4>
						<p>${p.description}</p>
						<p>${p.id }</p>
					</div>
					<div class="ratings">
						<p>
							<a href="item?id=${p.id}" class="btn btn-info btn-block"> <span
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
				<c:forEach var="page" end="${pagination}" begin="0">
					<li><a href="<%=url%>page=${page + 1}">${page + 1}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>