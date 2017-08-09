<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<footer>
	<div class="row">
		<div class="col-lg-12">
			<p>Copyright &copy; Your Website 2014</p>
		</div>
		<h1>
			<spring:message code="greeting" />
		</h1>

		<span><spring:message code="lang.change" /></span> 
		<select id="locales">     
			<option value=""></option>     
			<option value="en"><spring:message code="lang.eng" /></option>     
			<option value="vi"><spring:message code="lang.vn" /></option>
		</select>
	</div>

	
</footer>