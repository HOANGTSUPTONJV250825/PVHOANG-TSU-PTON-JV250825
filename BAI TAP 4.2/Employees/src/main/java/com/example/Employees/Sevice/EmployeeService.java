package com.example.Employees.Sevice;

import com.example.Employees.Model.entity.Employees;
import com.example.Employees.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employees> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employees getEmployeeByID(int ID){
        return employeeRepository.findByID(ID).orElse(null);
    }

    public Employees createEmployees(Employees employee){
        employeeRepository.addEmployees(employee);
        return employee;
    }

    public Employees updateEmployee(int ID, Employees employee){
        if (employeeRepository.findByID(ID).isPresent()){
            employeeRepository.updateInfor(ID,employee);
            return employee;
        }
        return null;
    }

    public boolean deleteEmployee(int ID){
     return employeeRepository.delInfor(ID);
    }

    public List<Employees> findEmployeeByName(String name){
        return employeeRepository.findAll().stream()
                .filter(e->e.getFullName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

}
