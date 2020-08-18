package com.github.aantoniadis.dataproviders.db.jpa.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.io.IOException
import javax.sql.DataSource


@Configuration
@EntityScan(basePackages = ["com.github.aantoniadis.dataproviders.db.jpa.entities"])
@EnableJpaRepositories(basePackages = ["com.github.aantoniadis.dataproviders.db.jpa.repositories"])
class DBConfig {
    @Bean
    @Throws(IOException::class)
    fun datasource(): DataSource {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/myca")
                .username("postgres")
                .password("postgres")
                .build()
    }
}