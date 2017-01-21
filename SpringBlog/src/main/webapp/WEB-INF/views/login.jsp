<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />
<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header"
	style="background-image: url('${pageContext.request.contextPath}/resources/img/login.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="page-heading">
					<h1>Login</h1>
					<hr class="small">
					<a href="${pageContext.request.contextPath}/register"><span
						class="subheading">Register</span></a>
				</div>
			</div>
		</div>
	</div>
</header>

<!-- Main Content -->
	<div class="container">
	<c:url value="/login" var="loginVar" />
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">			
				<form action="${pageContext.request.contextPath}/login"
					method="post">
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Username</label> 
							<input type="text" class="form-control" size="30"
								placeholder="Username" name="username" required
								data-validation-required-message="Please enter your username.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Password</label> 
							<input type="password"
								class="form-control" size="30" placeholder="Password" name="password"
								required
								data-validation-required-message="Please enter your password.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<sec:csrfInput />

					<c:if test="${param.logout != null }">
						<p>You have successfully been logged out.</p>
					</c:if>

					<c:if test="${param.error != null }">
						<p>Invalid Username and Password.</p>
					</c:if>
					<div id="success"></div>
					<div class="row">
						<div class="form-group col-xs-12">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp" />
