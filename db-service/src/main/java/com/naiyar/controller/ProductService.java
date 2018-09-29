package com.naiyar.controller;

import com.naiyar.domain.Product;
import com.naiyar.model.ProductVO;
import com.naiyar.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Created by vikasnaiyar on 29/09/18.
 */
@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Collection<ProductVO> getMatchingProducts(String searchText) {
        Collection<Product> allProducts = productRepository.findByNameContaining(searchText);
        return getProductVOs(allProducts);
    }

    private Collection<ProductVO> getProductVOs(Collection<Product> products) {
        if(products == null) {
            return Collections.EMPTY_LIST;
        }

        Collection<ProductVO> productVOs =
                products.stream().map(
                        product -> {
                            ProductVO productVO = new ProductVO();
                            productVO.setId(product.getId());
                            productVO.setName(product.getName());
                            productVO.setPrice(product.getPrice());
                            productVO.setRating(product.getRating());
                            return productVO;
                        }
                ).collect(Collectors.toCollection(HashSet::new));

        return productVOs;
    }

}
