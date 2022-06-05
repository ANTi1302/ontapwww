<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <title>Save Product</title>
    <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/style.css">
              <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
                <h2>CRM - Product Manager</h2>
        </div>
    </div>
    <div id="container">
            <h3>Save Customer</h3>
            <form:form action="saveSanPham" modelAttribute="sanpham" method="Post">
                    <!-- need to associate this data with customer id -->
                <form:hidden path="maSP" />
                <table>  <tbody>
                        <tr>
                                <td><label>Ten San Pham:</label></td>
                                <td>
                                <form:input path="tenSP" />
                                <form:errors  path="tenSP" cssClass="error"/>
                                </td>
                        </tr>
                        <tr>
                                <td><label>Don Gia:</label></td>
                                <td>
                                <form:input path="donGia" />
                                <form:errors  path="donGia" cssClass="error"/>
                                </td>
                        </tr>
                        <tr>
                                <td><label></label></td>
                                <td><input type="submit" value="Save" class="save" /></td>
                        </tr>
                        </tbody>   </table>
            </form:form>
            <div ></div>
            <p>
                    <a href="${pageContext.request.contextPath}/sanpham/list">Back to List</a>
            </p>
    </div>
</body>

</html>










