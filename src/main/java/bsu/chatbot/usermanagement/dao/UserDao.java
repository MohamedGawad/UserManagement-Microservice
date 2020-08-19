package bsu.chatbot.usermanagement.dao;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public interface UserDao {
	public boolean rbLogin(String username, String password) throws Exception;
}
