package com.github.aantoniadis.delivery.usecases.core.product

import com.github.aantoniadis.core.entities.Product
import com.github.aantoniadis.core.entities.ProductCode
import com.github.aantoniadis.delivery.usecases.core.UseCase
import com.github.aantoniadis.delivery.usecases.core.exceptions.NotFoundException

class DeleteProductUseCase(private val productRepository: ProductRepository) :
        UseCase<ProductCode, Unit> {
    override fun execute(productCode: ProductCode) =
        productRepository.deleteProductByCode(productCode) ?: throw NotFoundException("No product for code: $productCode")


    interface ProductRepository {
        fun deleteProductByCode(productCode: ProductCode)
    }
}