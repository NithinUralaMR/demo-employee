package com.example.CRUDEmployee.Service;

import com.example.CRUDEmployee.Module.Employee;

import java.util.List;

public interface EmployeeDao
{
    public List<Employee> findAll();

    public Employee findById(int id);

    public int deleteById(int id);

    public int save(Employee e);

    public int update(Employee e, int id);
}
