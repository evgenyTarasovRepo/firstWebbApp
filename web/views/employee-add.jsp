<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.04.2020
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit employee</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />
<body>
    <div class="container">
        <h1>Employee Directory</h1>
        <hr/>
        <div class="row">
            <div class="col-md-4">
                <form action="${pageContext.request.contextPath}/EmployeeController" method="post">
                    <div class="group-form">
                        <input type="text" name="firstname" value="${employee.name}" placeholder="Enter your name" class="form-control" /><br/>
                    </div>
                    <div class="group-form">
                        <input type="date" name="dob" value="${employee.dateOfbirth}" placeholder="Enter date of birth" class="form-control" /><br/>
                    </div>
                    <div class="group-form">
                        <input type="text" name="department" value="${employee.department}" placeholder="Enter department" class="form-control" /><br/>
                    </div>
                    <input type="hidden" value="${employee.id}" name="id" />
                    <button class="btn btn-primary" type="submit">Save Employee</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
