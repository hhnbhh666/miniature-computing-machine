package com.example.controller;

import com.example.common.Result;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController{

    @Resource
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Result add(@RequestBody Employee employee) {
        employeeService.add(employee);
        return Result.success("增加数据成功");
    }

    @PutMapping("/update")
    public Result update(@RequestBody Employee employee) {
        employeeService.update(employee);
        return Result.success("更改数据成功");
    }

    @DeleteMapping("/deleteById/{id}")
    public Result delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return Result.success("删除数据成功");
    }

    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        employeeService.deleteBatch(ids);
        return Result.success("批量删除成功");
    }



    @GetMapping("/selectAll")
    public Result selectAll(Employee employee) {
        List<Employee> list=employeeService.selectAll(employee);
    return Result.success(list);
    }

    @GetMapping("/selectPage")
    public Result selectPage(Employee employee,
                            @RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "3") Integer pageSize) {
    return Result.success(employeeService.selectPage(employee,pageNum,pageSize));
    }


}
