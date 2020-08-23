package bsu.chatbot.usermanagement.dao;

import java.util.List;

import bsu.chatbot.usermanagement.model.UserProfile;


/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */

public interface UserProfileDao {
	public UserProfile getUserBySenderId(String senderId);

	public UserProfile addUser(UserProfile userProfile);

	public void updateUser(UserProfile userProfile);

	public List<UserProfile> getAllUsers();
	
	public void deleteUser(UserProfile userProfile);

}
