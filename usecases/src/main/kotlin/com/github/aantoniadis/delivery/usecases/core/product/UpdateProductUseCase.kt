package com.github.aantoniadis.delivery.usecases.core.product

import com.github.aantoniadis.core.entities.Product
import com.github.aantoniadis.core.entities.ProductCode
import com.github.aantoniadis.delivery.usecases.core.UseCase
import com.github.aantoniadis.delivery.usecases.core.exceptions.NotFoundException

class UpdateProductUseCase(private val productRepository: ProductRepository) :
    UseCase<Product, Product> {
    override fun execute(product: Product): Product =
        productRepository.update(product.code, product) ?: throw NotFoundException("No products for code")

    interface ProductRepository {
        fun update(code: ProductCode, product: Product): Product?
    }
}