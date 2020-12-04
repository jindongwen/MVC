package com.ylb.servlet;

import com.ylb.entity.employee;
import com.ylb.service.imp.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@WebServlet("/EmployeeSave")
public class EmployeeSave  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String ename = req.getParameter("ename");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String[] hobbies = req.getParameterValues("hobby");

//        String 数组转成String 字符串
        String hobby = Arrays.toString(hobbies);

        String date = req.getParameter("birth");
//        字符串转成 Local 再转 sql.Date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate birth = LocalDate.parse(date,dateTimeFormatter);

        String phone = req.getParameter("phone");
        String remark = req.getParameter("remark");


        employee emp = new employee( 0, ename,  pwd,  sex,  hobby,  birth,  phone, remark);

        System.out.println(emp);
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        int save = service.save(emp);
        if (save > 0){
            resp.sendRedirect(req.getContextPath() +"/listUser.html");
        }else{
            req.setAttribute("msg","添加失败");
            req.getRequestDispatcher("/saveUser.html").forward(req,resp);
        }
    }
}
