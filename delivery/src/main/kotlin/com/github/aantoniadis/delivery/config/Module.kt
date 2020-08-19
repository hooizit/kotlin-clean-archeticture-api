package com.github.aantoniadis.delivery.config

import com.github.aantoniadis.dataproviders.db.jpa.repositories.DBProductRepository
import com.github.aantoniadis.dataproviders.db.jpa.repositories.JpaProductRepository
import com.github.aantoniadis.delivery.rest.imp.ProductResourceImp
import com.github.aantoniadis.delivery.usecases.core.UseCaseExecutor
import com.github.aantoniadis.delivery.usecases.core.UseCaseExecutorImp
import com.github.aantoniadis.delivery.usecases.core.gateways.ProductRepository
import com.github.aantoniadis.delivery.usecases.core.product.CreateProductUseCase
import com.github.aantoniadis.delivery.usecases.core.product.DeleteProductUseCase
import com.github.aantoniadis.delivery.usecases.core.product.GetProductByIdUseCase
import com.github.aantoniadis.delivery.usecases.core.product.UpdateProductUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Module {
    @Bean
    fun productsResourceImp(
        useCaseExecutor: UseCaseExecutor,
        getProductByIdUseCase: GetProductByIdUseCase,
        createProductUseCase: CreateProductUseCase,
        deleteProductUseCase: DeleteProductUseCase,
        updateProductUseCase: UpdateProductUseCase
    ) = ProductResourceImp(
            useCaseExecutor, getProductByIdUseCase, createProductUseCase, deleteProductUseCase, updateProductUseCase
    )

    @Bean
    fun useCaseExecutor() = UseCaseExecutorImp()

    @Bean
    fun getProductByIdUseCase(productRepository: ProductRepository) = GetProductByIdUseCase(productRepository)

    @Bean
    fun createProductUseCase(productRepository: ProductRepository) = CreateProductUseCase(productRepository)

    @Bean
    fun deleteProductUseCase(productRepository: ProductRepository) = DeleteProductUseCase(productRepository)

    @Bean
    fun updateProductUseCase(productRepository: ProductRepository) = UpdateProductUseCase(productRepository)

    @Bean
    fun productRepository(dbProductRepository: DBProductRepository) = JpaProductRepository(dbProductRepository)
}