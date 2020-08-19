package bsu.chatbot.usermanagement.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.convert.BigIntegerConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bsu.chatbot.usermanagement.model.UserProfile;


/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
@RequestScoped
public class UserProfileDaoImpl implements UserProfileDao {

	@PersistenceContext(name = "jpa-unit")
    private EntityManager em;
	
	private static final Logger LOGGER = Logger.getLogger(UserProfileDaoImpl.class.getName());

	private String INSERT_USER_PROFILE_STMT = "INSERT INTO userprofile(senderId, FisrtName, LastName, gender, locale, profilePic, timeZone, isActive,appId)" + " VALUES (?,?,?,?,?,?,?,?,?)";

	private String GET_USER_PROFILE_STMT = "select * from Msngruserprofile";
	
	private String GET_USER_PROFILE_STMT_BY_ID = "select * from userMsngruserprofileprofile where Id = ?";
	
	private String DELETE_USER_PROFILE_STMT_BY_ID = "delete from Msngruserprofile where Id = ?";

	private String UPDATE_USER_PROFILE_STMT = "UPDATE Msngruserprofile SET FisrtName=?,LastName=?,gender=?,locale=?," + "profilePic=?,timeZone=?,LastUpdatedDate=?,IsActive=? WHERE senderId=?";

	public void init() {
	}

	@Override
	public UserProfile getUserBySenderId(String userId) {
		BigInteger bigIntegerStr = null;
		LOGGER.log(Level.INFO,GET_USER_PROFILE_STMT_BY_ID +">>>>>"+ userId);
		try {
			bigIntegerStr=new BigInteger(userId);
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
			throw e; 
		}
		
		return  em.createNamedQuery("Msngruserprofile.findById", UserProfile.class).setParameter("userId", bigIntegerStr).getSingleResult();
	}

	public UserProfile addUser(UserProfile userProfile) {
		LOGGER.log(Level.INFO,INSERT_USER_PROFILE_STMT);
		em.persist(userProfile);
		return userProfile;
	}

	@Override
	public List<UserProfile> getAllUsers() {
		LOGGER.log(Level.INFO,GET_USER_PROFILE_STMT);
		return em.createNamedQuery("Portfolio.findAll", UserProfile.class).getResultList();
	}

	@Override
	public void updateUser(UserProfile userProfile) {
		LOGGER.log(Level.INFO,UPDATE_USER_PROFILE_STMT);
		em.merge(userProfile);
	    em.flush();
	}
	
	@Override
	public void deleteUser(UserProfile userProfile) {
		LOGGER.log(Level.INFO,DELETE_USER_PROFILE_STMT_BY_ID);
        em.remove(em.merge(userProfile));
    }

}
