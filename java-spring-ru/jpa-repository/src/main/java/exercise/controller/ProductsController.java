package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.ArrayList;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping
    public List<Product> index(@RequestParam(defaultValue = "0") int min,
                               @RequestParam(defaultValue = "0") int max) {
        
        Sort sort = Sort.by(Sort.Order.asc("price"));

        List<Product> result = new ArrayList<>();

        if (min != 0 && max != 0) {
            result = productRepository.findByPriceBetweenAndSort(min, max, sort);
        } else if (min == 0 && max != 0) {
            result = productRepository.findByPriceLessThanEqualAndSort(max, sort);
        } else if (min != 0 && max == 0) {
            result = productRepository.findByPriceGreaterThanEqualAndSort(min, sort);
        } else {
            result = productRepository.findAll(sort);
        }
        return result;
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
