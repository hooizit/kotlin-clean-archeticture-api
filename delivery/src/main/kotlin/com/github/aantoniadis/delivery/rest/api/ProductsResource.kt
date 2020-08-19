package com.github.aantoniadis.delivery.rest.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/products")
interface ProductsResource {
    @GetMapping("/")
    fun getAllProducts(): CompletionStage<List<ProductDto>>

    @GetMapping("/{code}")
    fun getProductByCode(@PathVariable("code") code: String): CompletionStage<ProductDto>

    @PostMapping("/add")
    fun createProduct(@RequestBody productDto: ProductDto): CompletionStage<ResponseEntity<Unit>>

    @DeleteMapping("/{code}")
    fun deleteProduct(@PathVariable("code") code: String): CompletionStage<ResponseEntity<Unit>>

    @PutMapping("/{code}")
    fun updateProduct(
            @PathVariable("code") code: String,
            @RequestBody productDto: ProductDto): CompletionStage<ProductDto>
}