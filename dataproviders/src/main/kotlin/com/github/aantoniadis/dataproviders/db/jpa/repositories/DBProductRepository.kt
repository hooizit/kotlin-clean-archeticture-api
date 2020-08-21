package com.github.aantoniadis.dataproviders.db.jpa.repositories

import com.github.aantoniadis.dataproviders.db.jpa.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface DBProductRepository : JpaRepository<ProductEntity, String> {

    @Query("select p from ProductEntity as p")
    fun getAllProducts(): List<ProductEntity>?

    @Query("from ProductEntity where code = :code")
    fun findByCode(code: String): ProductEntity

    @Modifying
    @Query("delete from ProductEntity p where p.code = :code")
    fun deleteProduct(code: String)
}