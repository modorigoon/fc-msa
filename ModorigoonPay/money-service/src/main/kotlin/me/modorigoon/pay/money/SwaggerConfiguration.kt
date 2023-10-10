package me.modorigoon.pay.money

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
class SwaggerConfiguration {

    @Bean
    fun restApi(): Docket = Docket(DocumentationType.OAS_30)
        .select()
        .apis(RequestHandlerSelectors.basePackage("me.modorigoon.pay.money"))
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(false)
}
