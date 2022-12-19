package io.zipcoder.persistenceapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.repositories.DepartmentRepo;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Iterable<Department> findAll() {
        return departmentRepo.findAll();
    }

    public Department findOne(Long id) {
        return departmentRepo.findOne(id);
    }

    public Department create(Department department) {
        return departmentRepo.save(department);
    }

    public Department update(Long id, Department newDepartmentData) {
        Department originalDepartment = departmentRepo.findOne(id);
        originalDepartment.setDepartmentName(newDepartmentData.getDepartmentName());
        originalDepartment.setDepartmentNumber(newDepartmentData.getDepartmentNumber());
        originalDepartment.setManager(newDepartmentData.getManager());
        return departmentRepo.save(originalDepartment);
    }

    public Boolean delete(Long id) {
        departmentRepo.delete(id);
        return true;
    }
}
