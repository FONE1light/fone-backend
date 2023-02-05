package com.fone.filmone.common.config

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager

@Configuration
@EnableR2dbcRepositories(entityOperationsRef = "mySQLEntityTemplate")
class MySQLConfiguration {

    @Autowired
    private lateinit var env: Environment

    @Bean
    @Qualifier("mySQLConnectionFactory")
    fun mySQLConnectionFactory(): ConnectionFactory {
        val url = "r2dbcs:mysql://root:fone-flim-be@localhost:3306/fone"
        return ConnectionFactories.get(url)
    }

    @Bean
    fun reactiveTransactionManager(@Qualifier("mySQLConnectionFactory") connectionFactory: ConnectionFactory): ReactiveTransactionManager {
        return R2dbcTransactionManager(connectionFactory)
    }
}