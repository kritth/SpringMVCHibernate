<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Spring Web MVC Example</title>
		<!-- Boot strap CDN -->
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<!-- Example use of spring resource mapping -->
		<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" />
	</head>
	<body>
		<div style="width: 100%;">
			<!-- This section is showing the usage of spring form -->
			<!-- Traditional form -->
			<form action="model/insert/" method="post">
				<table class="table">
					<thead>
						<tr>
							<th colspan="2">Register value with traditional form</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">Value</th>
							<!-- name is using the RequestParam we define in the controller -->
							<td><input type="text" name="val" placeholder="Enter value" /></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><input type="submit" value="Insert" /></td>
						</tr>
					</tfoot>
				</table>
			</form>
			<br />
			<!-- Spring form -->
			<!-- new_model is the object we passed from the initial controller -->
			<form:form action="model/insert/spring" method="post" commandName="newModel">
				<table class="table">
					<thead>
						<tr>
							<th colspan="2">Register value with spring form</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">Value</th>
							<!-- path is using the variable name we define in the model class -->
							<td><form:input type="text" path="val" placeholder = "Enter value" /></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><input type="submit" value="Insert" /></td>
						</tr>
					</tfoot>
				</table>
			</form:form>
			<br />
			<!-- This section is showing the usage of jsp -->
			<table class="table">
				<tbody>
					<tr>
						<th scope="row">Search</th>
						<td colspan="2"><input id="text-search" type="text" placeholder="Id to search and press enter" /></td>
					</tr>
				</tbody>
			</table>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Value</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:choose>
							<c:when test="${ empty model }">
								<th colspan="2" scope="row" style="text-align: center">No data found</th>
							</c:when>
							<c:otherwise>
								<td><c:url value="${ model.id }" /></td>
								<td><c:url value="${ model.val }" /></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
	
	<!-- Use spring resource mapping to get javascript -->
	<script src="<c:url value="/resources/js/main.js" />"></script>
</html>
