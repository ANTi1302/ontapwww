
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Product</title>
    <!-- reference our style sheet -->
   
</head>
<body>
<div id="wrapper">
        <div id="header">
                <h2>CRM - Product Relationship Manager</h2>
        </div>
</div>
<div id="container">
        <div id="content">
                <!-- put new button: Add Customer -->
               
                <table>
                        <tr>
                                <th>Ten Loai</th>
                              
                        </tr>
                        <!-- loop over and print our customers -->
                        <c:forEach var="tempSanPham" items="${sanpham}">
                                <!-- construct an "update" link with customer id -->
                                <c:url var="updateLink" value="/sanpham/showSPbyID">
                                        <c:param name="maLoai" value="${tempSanPham.maLoai}" />
                                </c:url>					
                                <tr>
                                        <td> <a href="${updateLink}"> ${tempSanPham.tenLoaiSP} </a></td>
                                        
                                </tr>
                        </c:forEach>

                </table>

        </div>

</div>


</body>

</html>









