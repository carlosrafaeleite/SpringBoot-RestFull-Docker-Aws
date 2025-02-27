//package com.br.carlos.config;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.br.carlos.SerializationConverter.YmlJacksonHttlMessageConverter;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer{
//
//
//	//private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("aplication/x-yaml");
//
//	@Override
//	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new YmlJacksonHttlMessageConverter());
//	}
//
//	@Override	
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		
//		/*
//		 * via query String
//		 * http://localhost:8080/api/pessoa/v1/2?mediaType=xml
//		 * 
//		configurer.favorParameter(true)
//		.parameterName("mediaType")
//		.ignoreAcceptHeader(true)
//		.useRegisteredExtensionsOnly(false)
//		.defaultContentType(MediaType.APPLICATION_JSON)
//			.mediaType("json", MediaType.APPLICATION_JSON)
//			.mediaType("xml", MediaType.APPLICATION_XML);
//			*/
//		
//		/**
//		 *  via Header
//		 *  http://localhost:8080/api/pessoa/v1/2
//		 */
//		configurer.favorParameter(false)
//		.ignoreAcceptHeader(false)	
//		.useRegisteredExtensionsOnly(false)
//		.defaultContentType(MediaType.APPLICATION_JSON)
//			.mediaType("json", MediaType.APPLICATION_JSON)
//			.mediaType("xml", MediaType.APPLICATION_XML)
//			//.mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML)
//			;
//		
//	
//	}
//
//}
