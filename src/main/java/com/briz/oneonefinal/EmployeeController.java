package com.briz.oneonefinal;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeRepository erepo;
	// note-this is unidirectional mapping only employeerepository can be used to
	// search by name or by address,street too.
	@RequestMapping("/testing")
	public String test()
	{
		return "this is one to one test";
	}
	
	@RequestMapping("/save")//{"name":"abhinanndan","dept":"driver", "address": {"city":"patna","street":"central street"}}
    
	public Employee save(@RequestBody Employee employee)
	{
	erepo.save(employee);
	return employee;				
	}
	@RequestMapping("/all")
	public Collection<Employee> all() // valid syntax is here 
	{
		return erepo.findAll();		
	}
	@RequestMapping("/{id}")
	public Optional<Employee> byid(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	@RequestMapping("/by/{city}")// search by city another entity very important example
	public List<Employee> bycity(@PathVariable String city)
	{
		return erepo.findByAddressCity(city);// check the employee repository
	}
	@RequestMapping("/by/city/{city}")
	public List<Employee> cityname(@PathVariable String city)
	{
		return erepo.findByCityName(city);
	}
	@RequestMapping("/del/{id}")//  OK WORKING FINE WITH BOTH TABLES 
	public String del(@PathVariable int id)
	{
		erepo.deleteById(id);
		return "data deleted";
	}
	@RequestMapping("/update/{id}")
	public String upd(@PathVariable int id,@RequestBody Employee employee)
	{
		Employee emp=erepo.findById(id).get();
		emp.setDept(employee.getDept());
		emp.setName(employee.getName());
		//  BELOW IS THE CODE OF UPDATE AND PATCH NOTE THIS 
		emp.address.setCity(employee.getAddress().getCity());
		emp.address.setStreet(employee.getAddress().getStreet());
	   
		erepo.save(emp);	
		return "data updated";
	}
	
}
