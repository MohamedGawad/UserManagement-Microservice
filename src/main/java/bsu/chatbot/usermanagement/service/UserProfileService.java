package bsu.chatbot.usermanagement.service;

import java.math.BigInteger;
import java.util.List;

import bsu.chatbot.usermanagement.model.App;
import bsu.chatbot.usermanagement.model.UserProfile;
import bsu.chatbot.usermanagement.model.UserProfileDto;


/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public interface UserProfileService {

	public UserProfileDto addUser(UserProfileDto userProfile);

	public void updateUser(UserProfile userProfile);
	
	public void deleteUser(UserProfile userProfile);

//	public void refreshUsers();

	public UserProfileDto getUserById(String senderId);

	public App getAppByAppId(long id);

	public List<UserProfile> getUsers();

}
