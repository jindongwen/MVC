package com.ylb.servlet;

import com.ylb.entity.employee;
import com.ylb.service.EmployeeService;
import com.ylb.service.imp.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeFindAll")
public class EmployeeFindAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        List<employee> list = employeeService.findAll();

        req.setAttribute("list",list);
        req.getRequestDispatcher("listUser.jsp").forward(req,resp);
    }
}
