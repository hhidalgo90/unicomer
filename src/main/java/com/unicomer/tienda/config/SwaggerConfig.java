package com.unicomer.tienda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Método para incorporar swagger a la aplicación
     *
     * @return
     */
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(new ApiInfo(
                        "Tienda Unicomer API",
                        "API para capturar los datos de candidatos de posibles clientes para Unicomer Jamaica.",
                        "1.0.0",
                        ApiInfo.DEFAULT.getTermsOfServiceUrl(),
                        ApiInfo.DEFAULT.getContact(),
                        ApiInfo.DEFAULT.getLicense(),
                        ApiInfo.DEFAULT.getLicenseUrl(),
                        ApiInfo.DEFAULT.getVendorExtensions()))
                .useDefaultResponseMessages(false)
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.unicomer.tienda.controller"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}
