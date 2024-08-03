package com.briz.oneonefinal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
	// there are two ways for one to one 
	// this is by first way
List<Employee> findByAddressCity(String city);// search by another entity note this style 
// above is the first style using function 
// note- address is inside employee thats it this is one to one unidirectional mapping
@Query("select e from employee e where e.address.city=?1")// this is advance concept JPQL
// above is the second style using query annotation 
// this can be modified by using native sql query too 
// above is useful when multiple fields are used into the query fields 
List<Employee>findByCityName(String city);
}
