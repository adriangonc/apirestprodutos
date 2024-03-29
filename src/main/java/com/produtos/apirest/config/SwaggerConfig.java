package com.produtos.apirest.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.produtos.apirest")).paths(PathSelectors.regex("/api.*"))
				.build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		return new ApiInfo("Produtos API REST", "API REST para cadastro edição e deleção de produtos.", "1.0.1",
				"Terms of service", new Contact("Adriano Gonçalves", "www.example.com", "adriangonc@hotmail.com"),
				"Apache License, Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}

}
