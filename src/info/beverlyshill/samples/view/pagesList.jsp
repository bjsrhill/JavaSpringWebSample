<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
				  <c:out value="${pages.textDesc}"/>	
				</c:forEach>
				<h6>
				</h6>
			</article>
		</section>
	</body>
</html>