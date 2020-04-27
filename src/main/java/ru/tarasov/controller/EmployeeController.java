package ru.tarasov.controller;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImpl;
import ru.tarasov.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmployeeController")
public class EmployeeController extends HttpServlet {

    RequestDispatcher dispatcher = null;

    EmployeeDao employeeDao = null;


    public EmployeeController(){

        employeeDao = new EmployeeDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("firstname");
        String dob = request.getParameter("dob");
        String department = request.getParameter("department");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setDateOfbirth(dob);
        employee.setDepartment(department);

        if (id.isEmpty() || id == null) {
            employeeDao.save(employee);

        } else {
            employee.setId(Integer.parseInt(id));
            employeeDao.update(employee);
        }
        refreshEmpoloyeeList(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");


        if (action == null) {
            action = "LIST";
        }

        switch (action) {
            case "LIST" :
                refreshEmpoloyeeList(request, response);
                break;
            case "UPDATE" :
                getSingleEmployee(request, response);
                break;
            case "DELETE" :
                deleteEmployee(request, response);
                break;
            default:
                refreshEmpoloyeeList(request, response);
        }

    }


    public void refreshEmpoloyeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> list = employeeDao.get();
        request.setAttribute("list", list);
        dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
        dispatcher.forward(request, response);
    }

    public void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee employee = employeeDao.select(Integer.parseInt(id));
        request.setAttribute("employee", employee);

        dispatcher = request.getRequestDispatcher("/views/employee-add.jsp");
        dispatcher.forward(request, response);
    }

    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("Employee id = " + id);
        employeeDao.delete(Integer.parseInt(id));

        refreshEmpoloyeeList(request, response);
    }
}
