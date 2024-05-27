<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<div class="container">
	<c:choose>
		<c:when test="${!empty stdList.getContent() }">
			<h1 style="color: red; text-align: center;">Student Data</h1>
			<table class="table" border="1">
				<tr class="table-danger">
					<th>Student Id</th>
					<th>Student name</th>
					<th>Student email</th>
					<th>Phone Number</th>
					<th>Date Of Birth</th>
					<th>Adhar Number</th>
					<th>Operations</th>
				</tr>
				<c:forEach var="std" items="${stdList.getContent()}">
					<tr class="table-success">
						<td>${std.id }</td>
						<td>${std.name }</td>
						<td>${std.email }</td>
						<td>${std.phoneNumber }</td>
						<td>${std.dob }</td>
						<td>${std.adharNumber }</td>
						<td><a href="std_update?no=${std.id }"><input
								type="button" value="Edit"
								style="background-color: DodgerBlue; color: white;"></a> <a
							href="std_delete?no=${std.id }"
							onclick="return confirm('Do you want to delte the student')"><input
								type="button" value="Delete" style="color: red;"></a></td>
					</tr>
				</c:forEach>
			</table>
			<p style="text-align: center;">
				<c:if test="${stdList.hasPrevious() }">
					<a href="std_report_page?page=${stdList.getPageable().getPageNumber()-1 }">previous</a>&nbsp;	&nbsp;
			</c:if>
				<c:if test="${stdList.isFirst() }">
					<a href="std_report_page?page=0"> First</a> &nbsp; &nbsp;
			  </c:if>
				<c:forEach var="i" begin="1" end="${stdList.getTotalPages()-1}"
					step="1">
			 [<a href="std_report_page?page=${i-1}">${i}</a>] &nbsp; &nbsp;
			  </c:forEach>
				<c:if test="${stdList.isLast() }">
					<a href="std_report_page?page=${stdList.getTotalPages()-1 }">Last</a> &nbsp; &nbsp;
			  </c:if>
				<c:if test="${stdList.hasNext() }">
					<a href="std_report_page?page=${stdList.getPageable().getPageNumber()+1 }">Next</a>
				</c:if>
			</p>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center;">No recotds Foumd</h1>
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty resultMsg }">
		<h3 style="color: orange; text-align: center;">${resultMsg}</h3>
	</c:if>
	<h1 style="color: blue; text-align: center;">
		<a href="std_add">Add Student</a>
	</h1>
	<h1 style="color: blue; text-align: center;">
		<a href="./">Home</a>
	</h1>
</div>