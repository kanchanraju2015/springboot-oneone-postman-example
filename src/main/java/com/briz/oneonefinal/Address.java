package com.briz.oneonefinal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="address")
public class Address 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
String street;
String city;


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}
}
