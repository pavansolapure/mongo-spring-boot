package com.opencodez.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class Users {

	@Id
	private String id;
	private String name;
	private String address;
	private Double salary;
	
	public Users(String name, String address, Double salary) {
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
}
