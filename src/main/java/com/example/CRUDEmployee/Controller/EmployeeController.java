package com.example.CRUDEmployee.Controller;

import com.example.CRUDEmployee.Module.Employee;
import com.example.CRUDEmployee.Service.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/findall")
    public List<Employee> findAll()
    {
        return employeeDao.findAll();
    }

    @GetMapping("/findBYId/{id}")
    public Employee findById(int id)
    {
        return employeeDao.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        return employeeDao.deleteById(id)+" Employee(s) delete from the database";
    }

    @PostMapping("/")
    public String save(@RequestBody Employee e) {
        return employeeDao.save(e)+" Employee(s) saved successfully";
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody Employee e, @PathVariable int id) {
        return employeeDao.update(e, id)+" Employee(s) updated successfully";
    }

}
