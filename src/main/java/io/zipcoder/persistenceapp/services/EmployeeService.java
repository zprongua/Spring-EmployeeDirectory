package io.zipcoder.persistenceapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.repositories.EmployeeRepo;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findOne(Long id) {
        return employeeRepo.findOne(id);
    }

    public Employee create(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee update(Long id, Employee newEmployeeData) {
        Employee originalEmployee = employeeRepo.findOne(id);
        originalEmployee.setFirstName(newEmployeeData.getFirstName());
        originalEmployee.setLastName(newEmployeeData.getLastName());
        originalEmployee.setTitle(newEmployeeData.getTitle());
        originalEmployee.setPhoneNumber(newEmployeeData.getPhoneNumber());
        originalEmployee.setEmail(newEmployeeData.getEmail());
        originalEmployee.setHireDate(newEmployeeData.getHireDate());
        originalEmployee.setManager(newEmployeeData.getManager());
        originalEmployee.setDepartmentNumber(newEmployeeData.getDepartmentNumber());
        return employeeRepo.save(originalEmployee);
    }

    public Boolean delete(Long id) {
        employeeRepo.delete(id);
        return true;
    }
}
