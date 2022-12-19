package io.zipcoder.persistenceapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.zipcoder.persistenceapp.entities.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Long> {

}
