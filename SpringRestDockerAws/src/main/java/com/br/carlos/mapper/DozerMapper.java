package com.br.carlos.mapper;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	
	private static Mapper mapper =  DozerBeanMapperBuilder.buildDefault();
	
	
	public static <O,D> D parceObject(O origem, Class<D> destino) {
		return mapper.map(origem, destino);        
		
	}
	
	public static <O,D> List<D> parceLisytObjects(List<O> origem, Class<D> destino) {
		
		List<D> destinoObjeto = new ArrayList<>();
		
		for (O o : origem) {
			destinoObjeto.add(mapper.map(o, destino));
		}
		
		return destinoObjeto;        
		
	}
}
