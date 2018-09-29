package com.naiyar.controller;

import com.naiyar.model.ProductVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by vikasnaiyar on 29/09/18.
 */
//@Path("/product")
/*
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
*/
@Setter
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/product/query/{text}")
    @ResponseBody
    public Collection<ProductVO> getMathingProducts(@PathVariable("text") String searchText) {
        System.out.println("Searching allproduct");
        return productService.getMatchingProducts(searchText);
    }

}
