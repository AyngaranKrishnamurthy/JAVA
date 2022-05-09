package com.solution.test.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.solution.test.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

}
