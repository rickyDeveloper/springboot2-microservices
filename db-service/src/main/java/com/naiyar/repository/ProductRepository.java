package com.naiyar.repository;

import com.naiyar.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by vikasnaiyar on 29/09/18.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    List<Product> findByNameContaining(String searchText);

}

