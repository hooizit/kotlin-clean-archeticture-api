package com.github.aantoniadis.dataproviders.db.jpa.repositories

import com.github.aantoniadis.core.entities.Product
import com.github.aantoniadis.core.entities.ProductCode
import com.github.aantoniadis.dataproviders.db.jpa.entities.toProduct
import com.github.aantoniadis.dataproviders.db.jpa.entities.toProductEntity
import com.github.aantoniadis.delivery.usecases.core.gateways.ProductRepository
import javax.transaction.Transactional

open class JpaProductRepository(private val dbProductRepository: DBProductRepository) :
    ProductRepository {
    override fun existsProductCode(productCode: ProductCode) = dbProductRepository.existsById(productCode.value)

    override fun getByProductCode(productCode: ProductCode) =
        dbProductRepository.findByCode(productCode.value).toProduct()

    @Transactional
    override fun save(product: Product) {
        dbProductRepository.save(product.toProductEntity())
    }

    @Transactional
    override fun deleteProductByCode(productCode: ProductCode) {
        dbProductRepository.deleteProduct(productCode.value)
    }

    @Transactional
    override fun update(code: ProductCode, product: Product): Product? {
        dbProductRepository.save(product.toProductEntity())
        return getByProductCode(code)
    }

    override fun getAllProducts() = dbProductRepository.getAllProducts()?.map { productEntity -> productEntity.toProduct() }

}