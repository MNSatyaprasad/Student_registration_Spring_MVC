<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty stdList}">
		<h3 style="color: red; text-align: center;">Students Report</h3>
		<table border ="1" align="center" bgcolor="orange">
			<tr>
				<th>Student Id</th>
				<th>Student name</th>
				<th>Student email</th>
				<th>Phone Number</th>
				<th>Date Of Birth</th>
				<th>Adhar Number</th>
				<th> Updated </th>
			</tr>
			<c:forEach var="std" items="${stdList}">
				<tr>
					<td>${std.id }</td>
					<td>${std.name }</td>
					<td>${std.email }</td>
					<td>${std.phoneNumber }</td>
					<td>${std.dob }</td>
					<td>${std.adharNumber }</td>
					<td><a href="std_update?no=${std.id }"><input type ="button" value="Edit" style="background-color: DodgerBlue;color: white;"></a></td>
					<td><a href="std_delete?no=${std.id }" onclick="return confirm('Do you want to delte the student')"><input type ="button" value="Delete" style="color: red;"></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
<c:otherwise>
	<h1 style="color: red; text-align: center;">No Student RecordsFound</h1>
</c:otherwise>
</c:choose>
<h1 style="color: blue; text-align: center;"><a href ="std_add">Add Student</a> </h1>
<h1 style="color: blue; text-align: center;"><a href ="./">Home</a> </h1>