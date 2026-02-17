package com.example.Employees.Controller;

import com.example.Employees.EmployeesApplication;
import com.example.Employees.Model.dto.Filter;
import com.example.Employees.Model.entity.Employees;
import com.example.Employees.Sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employees>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping({"/{ID}"})
    public ResponseEntity<Employees> getEmployeeByID(@PathVariable int ID){
        Employees employee = employeeService.getEmployeeByID(ID);
        if (employee != null){
            return ResponseEntity.ok(employee);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Employees> addEmployee(@RequestBody Employees employee){
        Employees createEmp = employeeService.createEmployees(employee);
       return ResponseEntity.status(HttpStatus.CREATED).body(createEmp);
    }

    @PutMapping({"/{ID}"})
    public ResponseEntity<Employees> updateEmployees(@PathVariable int ID,@RequestBody Employees employee){
        Employees updateEmp = employeeService.updateEmployee(ID,employee);
        if (updateEmp != null){
            return ResponseEntity.ok(updateEmp);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/{ID}"})
    public ResponseEntity<String> deleteEmployees(@PathVariable int ID){
        boolean isDelete = employeeService.deleteEmployee(ID);
        if (isDelete){
            return ResponseEntity.ok("xoa thanh cong ID:"+ID);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("khong tim thay ID "+ID);
        }
    }

    @GetMapping({"/search"})
    public ResponseEntity<List<Employees>> findEmployeeByName(@RequestParam String name){
        return ResponseEntity.ok(employeeService.findEmployeeByName(name));
    }

    @GetMapping({"/filter"})
    public ResponseEntity<String> findEmployeeByFilter(@ModelAttribute Filter employeeFilter){
        return ResponseEntity.ok("danh sach loc theo ten: "+employeeFilter.getName()+" phong ban: "+employeeFilter.getDepartment());
    }

}
