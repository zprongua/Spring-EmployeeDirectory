package io.zipcoder.persistenceapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.zipcoder.persistenceapp.entities.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

}
