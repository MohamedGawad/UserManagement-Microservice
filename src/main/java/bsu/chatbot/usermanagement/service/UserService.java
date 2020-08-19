package bsu.chatbot.usermanagement.service;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public interface UserService {
	public boolean isValidUser(String username, String password,String senderId) throws Exception;
}
