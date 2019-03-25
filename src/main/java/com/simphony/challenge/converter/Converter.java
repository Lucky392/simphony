package com.simphony.challenge.converter;

import com.simphony.challenge.dto.AbstractDTO;
import com.simphony.challenge.model.AbstractModel;

public interface Converter<M extends AbstractModel, D extends AbstractDTO> {

	M fromDto(D d);
	D toDto(M m);
	
}
