package com.practise.repository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practise.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
}
