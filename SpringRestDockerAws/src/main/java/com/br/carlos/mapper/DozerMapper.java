package com.br.carlos.mapper;

import java.util.ArrayList;
import java.util.List;

//import org.modelmapper.ModelMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	
	private static Mapper mapper =  DozerBeanMapperBuilder.buildDefault();
	//private static ModelMapper mapper =  new ModelMapper();
	
	
	
	public static <O,D> D parseObject(O origem, Class<D> destino) {
		return mapper.map(origem, destino);        
		
	}
	
	public static <O,D> List<D> parseListObjects(List<O> origem, Class<D> destino) {
		
		List<D> destinoObjeto = new ArrayList<>();
		
		for (O o : origem) {
			destinoObjeto.add(mapper.map(o, destino));
		}
		
		return destinoObjeto;        
		
	}
}
