package com.github.aantoniadis.delivery.usecases.core.gateways

import com.github.aantoniadis.delivery.usecases.core.product.*

interface ProductRepository :
        GetProductByIdUseCase.ProductRepository,
        CreateProductUseCase.ProductRepository,
        DeleteProductUseCase.ProductRepository,
        UpdateProductUseCase.ProductRepository,
        GetAllProductsUseCase.ProductRepository