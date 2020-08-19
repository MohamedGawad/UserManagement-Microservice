package bsu.chatbot.usermanagement.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
@Entity(name = "Msngruserprofile")
@Table(name = "Msngruserprofile")
@NamedQueries(
		  {@NamedQuery(name = "Msngruserprofile.findAll", 
		               query = "SELECT p FROM Msngruserprofile p"),
		   @NamedQuery(name = "Msngruserprofile.findById", 
		               query = "SELECT p FROM Msngruserprofile p WHERE p.Id = :userId")}
		)

public class UserProfile  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 378161349616597168L;

	@Id
    @Column(nullable = false, length = 20, name = "Id")
	private BigInteger Id;

	@Column(nullable = false, length = 256, name = "UserUniqueId")
	private BigInteger UserUniqueId;
	
	@Column(name = "FisrtName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "profilePic")
	private String profilePic;

	@Column(name = "locale")
	private String locale;

	@Column(name = "timeZone")
	private String timezone;

	@Column(name = "IsActive",nullable = false)
	private int isActive;

	@Column(name = "appId",nullable = false)
	private BigInteger appId;
	
	@Column(name = "channelId",nullable = false)
	private BigInteger channelId;
	

	public BigInteger getId() {
		return Id;
	}

	public void setId(BigInteger id) {
		Id = id;
	}

	public BigInteger getUserUniqueId() {
		return UserUniqueId;
	}

	public void setUserUniqueId(BigInteger userUniqueId) {
		UserUniqueId = userUniqueId;
	}

	public BigInteger getAppId() {
		return appId;
	}

	public void setAppId(BigInteger appId) {
		this.appId = appId;
	}

	public BigInteger getChannelId() {
		return channelId;
	}

	public void setChannelId(BigInteger channelId) {
		this.channelId = channelId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + isActive;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((Id== null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (isActive != other.isActive)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
