package com.github.aantoniadis.delivery.rest.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/products")
interface ProductsResource {
    @GetMapping("/all")
    fun getAllProducts() {
        println("get all products list")
    }

    @GetMapping("/{code}")
    fun getProductByCode(@PathVariable("code") code: String): CompletionStage<ProductDto>

    @PostMapping("/add")
    fun createProduct(@RequestBody productDto: ProductDto): CompletionStage<ResponseEntity<Unit>>

    @DeleteMapping("/{code}")
    fun deleteProductByCode(@PathVariable("code") code: String) {
        println("delete product $code")
    }

    @PutMapping("/{code}")
    fun updateProductByCode(@PathVariable("code") code: String) {
        println("update product $code")
    }
}