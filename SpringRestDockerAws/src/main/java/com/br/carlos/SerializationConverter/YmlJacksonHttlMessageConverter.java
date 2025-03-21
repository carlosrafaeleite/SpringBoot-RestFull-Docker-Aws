package com.br.carlos.SerializationConverter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YmlJacksonHttlMessageConverter extends AbstractJackson2HttpMessageConverter {

	public YmlJacksonHttlMessageConverter() {
		super(new YAMLMapper()
				.setSerializationInclusion(JsonInclude.Include.NON_NULL), 
				MediaType.parseMediaType("aplication/x-yaml")
				);
		
	}

}
