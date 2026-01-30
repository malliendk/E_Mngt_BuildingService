package com.dillian.energymanagement.config

import com.dillian.energymanagement.Constants
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
open class RestClientConfig {

    @Bean
    open fun restClient(): RestClient {
        return RestClient
            .builder()
            .baseUrl(Constants.CALCULATION_SERVICE_SAVE_URL)
            .build()
    }
}