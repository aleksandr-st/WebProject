<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:joda="http://www.joda.org/joda/time/tags"
	version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" />

	<H1>Contact Listing</H1>
	<c:if test=${not empty contacts}">
		<table>
			<thead>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Birth date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.firstName}</td>
						<td>${contact.lastName}</td>
						<td><joda:format value="${contact.birthDate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
				<tr>
					<td>${contact1.firstName}</td>
					<td>${contact1.lastName}</td>
					<td><joda:format value="${contact1.birthDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</tbody>			
		</table>
	</c:if>
</div>