package com.example.restjpatest;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);
  
  List<Customer> findByLastNameIn(List<String> lastNames);

  Customer findById(long id);
}