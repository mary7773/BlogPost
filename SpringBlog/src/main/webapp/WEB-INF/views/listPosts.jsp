<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url(${pageContext.request.contextPath}/resources/img/home-bg.jpg)">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>Spring Blog</h1>
						<hr class="small">
						<span class="subheading">All Spring Blog Posts</span>
					</div>
				</div>
			</div>
		</div>
	</header>

<c:set var="number" scope="session" value="${number}"/>
<c:set var="finish"  value="false"/>
	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<c:forEach var="post" items="${listPosts}" varStatus="status">
					<c:choose>
						<c:when test="${status.index le number}">
							<div class="post-preview">
								<a href="${pageContext.request.contextPath}/post?id=${post.id}">
									<h2 class="post-title">${post.title}</h2>
									<div class="post-subtitle"
										style="overflow: hidden; text-overflow: ellipsis; height: 200px">
										${post.text}</div>
								</a>
								<p class="post-meta">Posted by ${post.user.username} Date:
									${post.createDate}</p>
							</div>
						</c:when>
						<c:when test="${not finish && status.index ge number}">
							<!-- Pager -->
							<form id="my_form" action="${pageContext.request.contextPath}/increase"  method="post">
							<ul class="pager">
								<li class="next"><a href="#" onclick="document.getElementById('my_form').submit(); return false;" >Older
										Posts &rarr;</a></li>
							</ul>
							<input type="hidden" name="number" value="${number}">
							</form>
							<c:set var="finish"  value="true"/>
						</c:when>
					</c:choose>
					<hr>
				</c:forEach>
			</div>
		</div>
	</div>

	<hr>
<jsp:include page="footer.jsp" />