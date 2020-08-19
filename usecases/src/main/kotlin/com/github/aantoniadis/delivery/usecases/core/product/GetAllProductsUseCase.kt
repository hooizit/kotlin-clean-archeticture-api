package com.github.aantoniadis.delivery.usecases.core.product

import com.github.aantoniadis.core.entities.Product
import com.github.aantoniadis.delivery.usecases.core.UseCase
import com.github.aantoniadis.delivery.usecases.core.exceptions.NotFoundException

class GetAllProductsUseCase(private val productRepository: ProductRepository) :
    UseCase<Unit, List<Product>> {

    override fun execute(request: Unit) =
            productRepository.getAllProducts() ?: throw NotFoundException("No products")

    interface ProductRepository {
        fun getAllProducts(): List<Product>?
    }
}