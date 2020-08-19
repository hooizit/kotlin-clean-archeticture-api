package com.github.aantoniadis.delivery.rest.imp

import com.github.aantoniadis.core.entities.ProductCode
import com.github.aantoniadis.delivery.rest.api.ProductDto
import com.github.aantoniadis.delivery.rest.api.ProductsResource
import com.github.aantoniadis.delivery.rest.api.toProduct
import com.github.aantoniadis.delivery.rest.api.toProductDto
import com.github.aantoniadis.delivery.usecases.core.UseCaseExecutor
import com.github.aantoniadis.delivery.usecases.core.product.CreateProductUseCase
import com.github.aantoniadis.delivery.usecases.core.product.DeleteProductUseCase
import com.github.aantoniadis.delivery.usecases.core.product.GetProductByIdUseCase
import com.github.aantoniadis.delivery.usecases.core.product.UpdateProductUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.concurrent.CompletionStage

class ProductResourceImp(
    private val useCaseExecutor: UseCaseExecutor,
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val createProductUseCase: CreateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase
) : ProductsResource {

    override fun getProductByCode(@PathVariable("code") code: String) =
        useCaseExecutor(
            useCase = getProductByIdUseCase,
            requestDto = code,
            requestConverter = { ProductCode(it) },
            responseConverter = { it.toProductDto() })

    override fun createProduct(@RequestBody productDto: ProductDto) =
        useCaseExecutor(
            useCase = createProductUseCase,
            requestDto = productDto,
            requestConverter = { it.toProduct() },
            responseConverter = { _ -> ResponseEntity<Unit>(HttpStatus.CREATED) })

    override fun updateProduct(code: String, productDto: ProductDto): CompletionStage<ProductDto> {
            productDto.code = code
            return useCaseExecutor(
                    useCase = updateProductUseCase,
                    requestDto = productDto,
                    requestConverter = { it.toProduct() },
                    responseConverter = { it.toProductDto() }
            )
    }

    override fun deleteProduct(code: String) =
            useCaseExecutor(
                    useCase = deleteProductUseCase,
                    requestDto = code,
                    requestConverter = { ProductCode(it) },
                    responseConverter = { _ -> ResponseEntity<Unit>(HttpStatus.OK) })

}