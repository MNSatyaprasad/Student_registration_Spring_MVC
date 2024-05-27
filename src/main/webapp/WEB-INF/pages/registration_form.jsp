<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: green; text-align: center;"> Student Registration</h1>
<frm:form modelAttribute="std">
<table border="1" bgcolor="cyan" align="center">
	<tr>
		<td>Student Name </td>
		<td><frm:input path ="name"/></td>
	</tr>
	<tr>
		<td>Student email </td>
		<td><frm:input path ="email"/></td>
	</tr>
<tr>
		<td>phone Number </td>
		<td><frm:input type="number" path ="phoneNumber"/></td>
	</tr>
	<tr>
		<td>Date of Birth </td>
		<td><frm:input type="date" path ="dob"/></td>
	</tr>
	<tr>
		<td> Adhar Number </td>
		<td><frm:input type="number" path ="adharNumber"/></td>
	</tr>
	<tr>
	<td><input type="submit" value="Registr"></td>
		<td><input type="reset" value="Cancel"></td>
	</tr>
</table>
</frm:form>
