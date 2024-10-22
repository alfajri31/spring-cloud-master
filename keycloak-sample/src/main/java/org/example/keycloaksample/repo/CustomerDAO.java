package org.example.keycloaksample.repo;

import org.example.keycloaksample.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Long> {

}
