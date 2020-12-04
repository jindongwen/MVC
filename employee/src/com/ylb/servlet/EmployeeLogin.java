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

@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("ename");
        String password = req.getParameter("pwd");

        EmployeeService emps = new EmployeeServiceImpl();
        employee employee = emps.login(name, password);

        if (employee!=null){
            resp.sendRedirect(req.getContextPath() + "/index.html");
        }else{
            req.setAttribute("msg","登录失败");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
