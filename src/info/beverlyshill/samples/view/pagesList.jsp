<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
	<head>
		<title>Beverly S Hill</title>
		<LINK REL=stylesheet HREF="includes/sample.css" TYPE="text/css"/>
		<script src="includes/pagesList.js"></script>
	</head>
	<body bgcolor = #CEF6F5>
		<table width="100%" border="0" align="left" cellpadding="10"
						cellspacing="10" bgcolor = #D8CEF6>
			<tr>
				<td>
					<h1 id="headingMessage"></h1>
				</td>
			</tr>
		</table>
		<table width="65%" border="0" align="right" cellpadding="0"
						cellspacing="0">	
			<tr>
				<td>
					<table width="100%" border="0" align="center" cellpadding="0"
														cellspacing="0">
						<tr align="middle">
							<td idth="100%" valign="middle">
								<c:forEach items="${pages}" var="pages">
									<tr>
										<td align="left">
											<br />
											<h6>
											</h6>
												<c:out value="${pages.textDesc}"/>	
										</td>
									</tr>
								</c:forEach>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>