package bsu.chatbot.usermanagement.service;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public interface JDBCService {
	public <X> Object convertToDto(Class<X> entity, Object object);

	public <X> Object convertToEntity(Class<X> dto, Object object);
}
