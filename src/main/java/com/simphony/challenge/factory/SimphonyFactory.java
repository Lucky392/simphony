package com.simphony.challenge.factory;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.dto.AbstractDTO;
import com.simphony.challenge.exception.SimphonyException;
import com.simphony.challenge.model.AbstractModel;

public class SimphonyFactory {

	public static <M extends AbstractModel, D extends AbstractDTO> Converter<M, D> getConverter(Class<? extends Converter<M, D>> clazz) throws SimphonyException {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new SimphonyException(e.getMessage());
		}
	}
	
}
