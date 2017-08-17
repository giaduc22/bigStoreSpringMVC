<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			<title>Shop Homepage</title>

			<!-- Bootstrap Core CSS -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
			 crossorigin="anonymous">

			<!-- Custom CSS -->
			<link href='<c:url value="resources/css/style.css" />' rel="stylesheet">


		</head>

		<body>
			<!-- HEADER -->
			<jsp:include page="common/header.jsp"></jsp:include>
			
			<!-- PAGE CONTAINER -->
			<div class="container">
				<div class="row">
					<jsp:include page="${param.view}"></jsp:include>
				</div>
			</div>

			<!-- FOOTER -->
			<div class="container">
				<hr>
				<jsp:include page="common/footer.jsp"></jsp:include>
			</div>

			<!-- jQuery -->
			<!-- <script src="js/jquery.js"></script> -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


			<!-- Bootstrap Core JavaScript -->
			<!-- <script src="js/bootstrap.min.js"></script> -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			 crossorigin="anonymous"></script>

			<script type="text/javascript">
				$(() => {
					$("#locales").change(() => {
						let selectedOption = $('#locales').val();
						let path = window.location.pathname;
						let url = path + '?language=';
						if (selectedOption !== '') {
							$.get(url + selectedOption, () => {
								location.reload();
							});
						} 
					});
				});
			</script>


		</body>

		</html>