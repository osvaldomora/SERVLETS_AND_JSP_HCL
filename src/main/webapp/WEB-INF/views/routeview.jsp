<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<!-- <form action="rideServlet" method="post"> -->

		<table style="with: 80%">
			<tr>
			    <td>userId</td>
				<td>Source</td>
				<td>Destination</td>
				<td>Duration</td>
			</tr>
		
			<c:forEach items="${rList}" var="route">
			
			<c:url var="Book" value ="rideServlet"> 		
			<c:param name="routeId" value="${route.routeId}"></c:param>
			<c:param name="userId" value="${userId}"></c:param>
			
			</c:url>
				<tr>
				    <td>${userId}</td>
					<td>${route.source}</td>
					<td>${route.destination}</td>
					<td>${route.duration}</td>
					<td><a href="${Book}">Book</a> </td>
					
<!-- 					<td><input value="Book" type="submit" /></td> -->
				</tr>
				
			</c:forEach>

		</table>
<!-- 		<input type = "hidden" name="action" value="book"/> -->
		
<!-- </form> -->

</body>
</html>