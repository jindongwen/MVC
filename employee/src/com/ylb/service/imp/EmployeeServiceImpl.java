package com.ylb.service.imp;

import com.ylb.entity.employee;
import com.ylb.mapper.EmployeeMapper;
import com.ylb.service.EmployeeService;
import com.ylb.util.DBUtil;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public employee login(String ename, String pwd) {
        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        employee employee = mapper.selectOne(ename, pwd);
        DBUtil.closeSqlSession();
        return employee;
    }


    @Override
    public int save(employee emp) {
        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        int insert = mapper.insert(emp);
        DBUtil.closeSqlSession();
        return insert;
    }

    @Override
    public List<employee> findAll() {
        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        List<employee> employees = mapper.selectAll();
        DBUtil.closeSqlSession();
        return  employees;
    }
}
