package com.opencodez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencodez.domain.Users;
import com.opencodez.repo.CustomRepository;
import com.opencodez.repo.UserRepository;

@SpringBootApplication
public class MongoBootApplication implements CommandLineRunner {

	@Autowired
	UserRepository repository;
	
	@Autowired
	CustomRepository crepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();
		findFirst();
		findByRegex();
	}
	
	public void deleteAll() {
		System.out.println("Deleting all records..");
		repository.deleteAll();
	}
	
	public void addSampleData() {
		System.out.println("Adding sample data");
		repository.save(new Users("Jack Bauer", "New York", 11111d));
		repository.save(new Users("Harvey Spectre", "London", 22222d));
		repository.save(new Users("Mike Ross", "New Jersey", 333333d));
		repository.save(new Users("Louise Litt", "Kathmandu", 44444d));
	}
	
	public void listAll() {
		System.out.println("Listing sample data");
		repository.findAll().forEach(u -> System.out.println(u));
	}
	
	public void findFirst() {
		System.out.println("Finding first by Name");
		Users u = repository.findFirstByName("Louise Litt");
		System.out.println(u);
	}
	
	public void findByRegex() {
		System.out.println("Finding by Regex - All with address starting with ^New");
		repository.findCustomByRegExAddress("^New").forEach(u -> System.out.println(u));
	}
}
