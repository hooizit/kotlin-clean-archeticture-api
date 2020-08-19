package com.github.aantoniadis.delivery.usecases.core.gateways

import com.github.aantoniadis.delivery.usecases.core.product.CreateProductUseCase
import com.github.aantoniadis.delivery.usecases.core.product.DeleteProductUseCase
import com.github.aantoniadis.delivery.usecases.core.product.GetProductByIdUseCase
import com.github.aantoniadis.delivery.usecases.core.product.UpdateProductUseCase

interface ProductRepository :
        GetProductByIdUseCase.ProductRepository,
        CreateProductUseCase.ProductRepository,
        DeleteProductUseCase.ProductRepository,
        UpdateProductUseCase.ProductRepository