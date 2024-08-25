package com.br.carlos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{


	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		/*
		 * via query String
		 * http://localhost:8080/api/pessoa/v1/2?mediaType=xml
		 * 
		configurer.favorParameter(true)
		.parameterName("mediaType")
		.ignoreAcceptHeader(true)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML);
			*/
		
		/**
		 *  via Header
		 *  http://localhost:8080/api/pessoa/v1/2
		 */
		configurer.favorParameter(false)
		.ignoreAcceptHeader(false)	
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML);
	}

}
