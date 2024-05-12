package com.perpro.rest.common.mapper;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
class ObjectToDateConverter extends CustomConverter<String, Date> {

	@Override
	public Date convert(String source, Type<? extends Date> destinationType) {
		if (source instanceof String) {
			try {
				return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse((String) source);
			} catch (ParseException e) {
				return null;
			}
		}
		return null;
	}
}