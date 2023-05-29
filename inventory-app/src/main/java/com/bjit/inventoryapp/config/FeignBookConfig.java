package com.bjit.inventoryapp.config;

import com.bjit.inventoryapp.dto.BookResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
@FeignClient(name= "book-app" ,url = "http://localhost:9090/book-app")
public interface FeignBookConfig {
    @GetMapping("/books/bookDetails/{bookId}")
    public BookResponseModel bookDetails(@PathVariable Integer bookId);
    @PutMapping("/books/reduceQuantity/{id}/{quantity}")
    public String updateBookQuantity(@PathVariable Integer id,@PathVariable Integer quantity);
}
