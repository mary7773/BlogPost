<%@ page isELIgnored="false"%>

<jsp:include page="header.jsp" />

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url(${pageContext.request.contextPath}/resources/img/new-post1.jpg)">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>Spring Blog</h1>
						<hr class="small">
						<span class="subheading">Start creating your posts with
							Spring Blog</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<form action="${pageContext.request.contextPath}/savePost" method="post">
			<div class="row">
				<label for="title">Title:</label><br /> 
				<input id="title" class="input" name="title" type="text" value="" size="30" required /><br />
			</div>
			<div class="row">
				<label for="content">Content:</label><br />
				<textarea id="txtEditor" name="content" class="txtEditor" rows="7"
					cols="90"  required></textarea>
				<br />
			</div>
			<div class="form-group col-xs-12">
                <button type="submit" class="btn btn-default">POST</button>
            </div>
		</form>
	</div>

	<hr>

<jsp:include page="footer.jsp" />