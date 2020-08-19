package bsu.chatbot.usermanagement.service;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.ws.rs.WebApplicationException;

import bsu.chatbot.usermanagement.dao.UserProfileDao;
import bsu.chatbot.usermanagement.model.App;
import bsu.chatbot.usermanagement.model.UserProfile;
import bsu.chatbot.usermanagement.model.UserProfileDto;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public class UserProfileServiceImpl implements UserProfileService {

	private static Logger logger = Logger.getLogger(UserProfileServiceImpl.class.getName());

	@Inject
	public UserProfileDao userProfileDao;

	@Inject
	public JDBCService JDBCService;

	private List<UserProfile> users;

	private List<App> apps;

//	@Override
//	public void refreshUsers() {
////		setUsers(userProfileDao.getAllUsers());
//	}

	public List<UserProfile> getUsers() {
		return users;
	}

	public void setUsers(List<UserProfile> users) {
		this.users = users;
	}

	@Override
	public UserProfileDto getUserById(String senderId) {
		logger.warning("UserProfile sent: " + senderId);
		return (UserProfileDto) JDBCService.convertToDto(UserProfileDto.class, userProfileDao.getUserBySenderId(senderId));
	}

	@Override
	public UserProfileDto addUser(UserProfileDto userProfileDto) {
		UserProfile userProfileEntity;
		try {
			userProfileEntity = (UserProfile) JDBCService.convertToEntity(UserProfile.class, userProfileDto);
			userProfileEntity = userProfileDao.addUser(userProfileEntity);
		} catch (EntityExistsException e) {
			logger.warning("UserProfile already exists for: " + userProfileDto.getId());
			throw new WebApplicationException("UserProfile already exists for " + userProfileDto.getId() + "!", 409);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			throw e;
		}
		return (UserProfileDto) JDBCService.convertToDto(UserProfileDto.class, userProfileEntity);
	}

	@Override
	public void updateUser(UserProfile userProfile) {
		userProfileDao.updateUser(userProfile);
	}

	public List<App> getApps() {
		return apps;
	}

	public void setApps(List<App> apps) {
		this.apps = apps;
	}

	@Override
	public App getAppByAppId(long id) {
		for (App app : getApps()) {
			if (app.getId() == id) {
				return app;
			}
		}
		return null;
	}

	@Override
	public void deleteUser(UserProfile userProfile) {
		userProfileDao.deleteUser(userProfile);

	}

}
