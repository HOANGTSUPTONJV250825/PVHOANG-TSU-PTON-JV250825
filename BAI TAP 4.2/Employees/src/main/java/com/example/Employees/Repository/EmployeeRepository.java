package com.example.Employees.Repository;

import com.example.Employees.Model.entity.Employees;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    private final List<Employees> employeesList = new ArrayList<>();

    public EmployeeRepository(){
        employeesList.add(new Employees(1,"Pham Van Hoang", "hoang@gmail.com","maintenance"));
        employeesList.add(new Employees(2,"Tran Van Tam", "Tam@gmail.com","maintenance"));
    }

    public List<Employees> findAll(){
        return employeesList;
    }

    public Optional<Employees> findByID(int ID){
        return employeesList.stream().filter(e->e.getID() == ID).findFirst();
    }

    public void addEmployees(Employees employees){
        employeesList.add(employees);
    }

    public void updateInfor(int ID, Employees newInfor){
        findByID(ID).ifPresent(e->{
            e.setFullName(newInfor.getFullName());
            e.setEmail(newInfor.getEmail());
            e.setDepartment(newInfor.getDepartment());
        });
    }

    public boolean delInfor(int ID){
        return employeesList.removeIf(e->e.getID() == ID);
    }
}
