package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api-products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    IProductService productService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products= (List<Product>) productService.findAll();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id){
        Optional<Product> product= productService.findById(id);
        return new ResponseEntity<>(product.get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@PathVariable Long id,@RequestBody Product product) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        product.setId(id);
        productService.save(product);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> edit(@PathVariable Long id){
        productService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Product>> findAllByName(@PathVariable("name") String name){
        List<Product> products= (List<Product>) productService.findAllByName("%"+name+"%");
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
