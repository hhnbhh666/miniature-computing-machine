package com.example.service;

import com.example.entity.Employee;
import com.example.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    public void add(Employee employee) {
        employeeMapper.insert(employee);
    }

    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    public void delete(Integer id) {
        employeeMapper.delete(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            this.delete(id);
        }
    }

    public List<Employee> selectAll(Employee employee) {
        return employeeMapper.selectAll(employee);
    }

    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }

    public List<Employee> selectlist(Employee employee) {
        System.out.println(employee);
        return null;
    }

    public PageInfo<Employee> selectPage(Employee employee, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Employee> list = employeeMapper.selectAll(employee);
        return PageInfo.of(list);
    }



}
