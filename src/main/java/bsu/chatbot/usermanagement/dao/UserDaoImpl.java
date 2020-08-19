package bsu.chatbot.usermanagement.dao;

import javax.enterprise.context.RequestScoped;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
@RequestScoped
public class UserDaoImpl implements UserDao {

	@Override
	public boolean rbLogin(String username, String password) throws Exception {
		return true;
	}

}
