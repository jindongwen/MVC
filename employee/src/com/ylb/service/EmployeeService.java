package com.ylb.service;

import com.ylb.entity.employee;

import java.util.List;

public interface EmployeeService {
//    登陆
    employee login(String ename,String pwd);

//    添加用户
    int save(employee emp);

    List<employee>findAll();
}
