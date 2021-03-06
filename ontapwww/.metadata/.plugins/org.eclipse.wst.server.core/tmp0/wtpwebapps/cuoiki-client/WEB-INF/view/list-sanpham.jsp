
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<!-- reference our style sheet -->

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Product Relationship Manager</h2>
			<c:if test="${pageContext.request.userPrincipal.name==null }">
				<a href="<c:url value="/login" />">Login</a>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
				<a href="<c:url value="" />">${pageContext.request.userPrincipal.name}</a>
				<a href="<c:url value="/login" />">Logout</a>

			</c:if>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Product"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<%--  window.location.href returns the href (URL) of the current page
                            Changing the value of the property will redirect the page.--%>
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Ten San Pham</th>
					<th>Don Gia</th>
					<th>Loai San Pham</th>

				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempSanPham" items="${sanpham}">
					<c:url var="updateLink" value="/sanpham/showFormForUpdate">
						<c:param name="maSP" value="${tempSanPham.maSP }"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/sanpham/delete">
						<c:param name="maSP" value="${tempSanPham.maSP }"></c:param>
					</c:url>
					<tr>
						<td>${tempSanPham.tenSP}</td>
						<td>${tempSanPham.donGia}</td>
						<td>${tempSanPham.loaiSP.tenLoaiSP}</td>
						<td><a href="${updateLink}">cap nhat</a> <c:if
								test="${pageContext.request.userPrincipal.name!=null }">
								 <a href="${deleteLink}"
							onclick="if(!(confirm('ban co muon xoa?'))) return flase">xoa</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









