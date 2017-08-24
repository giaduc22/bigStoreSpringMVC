<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<footer>
				<div class="row">
					<div class="col-lg-12 text-center">
						<p>Copyright &copy; Developed by giaduc</p>
					</div>
					<div class="form-group pull-left">
						<select id="locales" class="form-control">
							<option value=""><spring:message code="lang.change" /></option>
							<option value="en"><spring:message code="lang.eng" /></option>
							<option value="vi"><spring:message code="lang.vn" /></option>
						</select>
					</div>
				</div>


			</footer>