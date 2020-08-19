package bsu.chatbot.usermanagement.service;

import javax.inject.Inject;


/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */

public class UserServiceImpl implements UserService {

//	@Inject
//	private UserDao userDao;

	@Inject
	private UserProfileService userProfileService;

//	@Inject
//	private LookupService lookupService;
//
//	@Inject
//	private Publisher publisher;
//
//	@Inject
//	private ContextService contextService;

	@Override
	public boolean isValidUser(String username, String password, String senderId) throws Exception {
//		publisher.setServer(PayloadValues.PLATFORM_SERVER);
		boolean result = false;
//		HttpSession httpSession = HttpSessionCollector.find(senderId);
//		if (httpSession == null) {
//			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//			httpSession = attr.getRequest().getSession(true);
//			httpSession.setAttribute("senderId", senderId);
//			ContextDetails contextDetails = new ContextDetails();
//			contextDetails.setSenderID(senderId);
//			contextDetails.setAuthenticated(false);
//			contextService.setContextDetails(contextDetails);
//			UserContextDetails userContextDetails = new UserContextDetails();
//			userContextDetails.setSenderID(senderId);
//			contextService.setUserContextDetails(userContextDetails);
//		}
//		boolean response = userDao.rbLogin(username, password);
//		if (response) {
//			result = true;
//			UserProfile userProfile = userProfileService.getUserById(senderId);
//
//			ContextDetails contextDetails = contextService.getContextDetails(senderId);
//			contextDetails.setLastAccessTime(new Date().getTime());
//			contextDetails.setLocale(userProfile.getLocale());
//			contextDetails.setAuthenticated(true);
//
//			UserContextDetails userContextDetails = contextService.getUserContextDetails(senderId);
//			userContextDetails.setLastAccessTime(new Date().getTime());
//			userContextDetails.setLocale(userProfile.getLocale());
//			userContextDetails.setAuthenticated(true);
//
//			lookupService.setUserProfile(userProfile);
//			List<NormalMessage> msgs = lookupService.getBusinessService(PayloadValues.PAYLOD_FOR_ACCOUNTS).send();
//			userContextDetails.setAuthenticated(true);
//			userContextDetails.setCurrentPayload(PayloadValues.PAYLOD_FOR_ACCOUNTS);
//			contextDetails.setAuthenticated(true);
//			contextDetails.setCurrentPayload(PayloadValues.PAYLOD_FOR_ACCOUNTS);
//
//			publisher.publish(msgs);
//		}

		return result;
	}
}
