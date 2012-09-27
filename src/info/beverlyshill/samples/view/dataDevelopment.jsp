<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-US">
	<head>
		<title>Beverly S Hill</title>
		<META name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
		<link rel="stylesheet" href="includes/bshMobile.css" TYPE="text/css"/>
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.css" />
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="includes/pagesListMobile.js" TYPE="text/javascript"></script>
		<script src="http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.js"></script>
	</head>
	<body>
		<div data-role="page" id="page" data-theme="i">
			<section id="pitches">
				<article class="mainSections">
					<ul data-role="listview" data-theme="i">
						<li><h2><c:out value="${pages.textDesc}"/></h2></li>
						<h6></h6>
					</ul>
				</article>
			</section><!-- /pitches -->	
			<div data-role="header" data-position="fixed" data-theme="a">
		    	<h4 id="headingMessage"></h4>
		    	<a href="pagesListMobile.htm" rel="external" data-icon="arrow-l" class="ui-btn-left">Home</a>
	        </div><!-- /header -->	
	        <div data-role="footer" data-position="fixed" data-theme="a">
	        	<h4 id="footerMessage"></h4>
	        </div><!-- /footer -->		
		</div>
	</body>
</html>