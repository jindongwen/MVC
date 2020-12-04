package com.ylb.mapper;

import com.ylb.entity.employee;

import java.util.List;

public interface EmployeeMapper {
    employee selectOne(String name,String pwd);

    //    添加
    int insert(employee employee);

//    查询所有员工
    List<employee> selectAll();
}

