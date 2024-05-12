/**
 * 
 */
package com.perpro.rest.common.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author mohit
 *
 */
@Component
@Getter
@Setter
public class BaseMapper<S, D> extends ConfigurableMapper {

	@Autowired
	private ObjectMapper jacksonMapper;

	@SuppressWarnings("hiding")
	public <S, D> D mapSrcToDest(S src, D dest) {
		map(src, dest);
		return dest;
	}

	@SuppressWarnings("hiding")
	public <D> D copyNullAwareMapProp(@SuppressWarnings("rawtypes") Map map, D dest) {
		final BeanWrapper trg = new BeanWrapperImpl(dest);
		String fieldName = null;
		for (final Field field : dest.getClass().getDeclaredFields()) {
			fieldName = field.getName();
			if (map.containsKey(fieldName)) {
				trg.setPropertyValue(fieldName, map.get(fieldName));
			}
		}
		return dest;
	}

	protected void configure(MapperFactory mapperFactory) {
		mapperFactory.getConverterFactory().registerConverter(new ObjectToDateConverter());
	}

	public <T> T convertValue(Object obj, Class<T> clazz) {
		return getJacksonMapper().convertValue(obj, clazz);
	}

	public <T> T mapJsonAsList(String json, TypeReference<T> typeRef) {
		T t = null;
		try {
			t = jacksonMapper.readValue(json, typeRef);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}

	public <T> T mapJsonAsObject(String json, Class<T> clazz) {
		T t = null;
		try {
			t = jacksonMapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}
}
