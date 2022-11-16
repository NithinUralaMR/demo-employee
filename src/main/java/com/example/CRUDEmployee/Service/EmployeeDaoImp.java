package com.example.CRUDEmployee.Service;

import com.example.CRUDEmployee.Module.Employee;
import com.fasterxml.jackson.databind.BeanProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> findAll()
    {
        return jdbcTemplate.query("select * from emp", new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee findById(int id)
    {
        return jdbcTemplate.queryForObject("select * from emp WHERE id=?", new BeanPropertyRowMapper<Employee>(Employee.class),id);
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("Delete from emp WHERE id=?",id);
    }

    @Override
    public int save(Employee e) {
        return jdbcTemplate.update("insert into emp(name,location,department) values(?,?,?)",new Object[] {e.getName(),e.getLocation(),e.getDepartment()});
    }

    @Override
    public int update(Employee e, int id) {
        return jdbcTemplate.update("update emp set name =?,location=?,department=? where id=?",new Object[] {e.getName(),e.getLocation(),e.getDepartment(),id});
    }
}
