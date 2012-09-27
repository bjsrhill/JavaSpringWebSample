<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-US">
	<head>
		<title>Beverly S Hill</title>
		<LINK REL=stylesheet HREF="includes/sample.css" TYPE="text/css"/>
		<script src="includes/pagesList.js"></script>
	</head>
	<body>
		<section id="banner">  
	    	<h1 id="headingMessage"></h1>   
	    </section> 
		<section id="pitches">
			<article class="mainEmail">
				<c:forEach items="${pages}" var="pages">
					<h6>
					</h6>
				<h2>
				  <c:out value="${pages.textDesc}"/>
				</h2>	
				</c:forEach>
				<h6>
				</h6>
			</article>
		</section>
	</body>
</html>