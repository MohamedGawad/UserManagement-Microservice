package bsu.chatbot.usermanagement.service;

import org.modelmapper.ModelMapper;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public class MapperServiceImpl implements MapperService {
	private ModelMapper modelMapper = new ModelMapper();

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public <X> Object convertToDto(Class<X> entity, Object object) {
		Object Dto = modelMapper.map(object, entity);
		return Dto;
	}

	@Override
	public <X> Object convertToEntity(Class<X> dto, Object object) {
		Object entity = modelMapper.map(object, dto);
		return entity;
	}
}
