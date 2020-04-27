<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees list</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />
<body>
    <div class="container">
        <button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button>
        <table border="1" class="table table-striped table-bordered">
            <tr class="thead-dark">
                <th>Name</th>
                <th>Department</th>
                <th>Date of birth</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${list}" var="employee">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td>${employee.dateOfbirth}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/EmployeeController?action=UPDATE&id=${employee.id}">Update</a>
                        |
                        <a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
