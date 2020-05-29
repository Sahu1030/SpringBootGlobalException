package com.sarat.dataJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarat.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

	

}
