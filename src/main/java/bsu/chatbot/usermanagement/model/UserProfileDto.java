package bsu.chatbot.usermanagement.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public class UserProfileDto {
	@Override
	public String toString() {
		return "Subscriber [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", locale=" + locale + ", timezone=" + timezone + "]";
	}

	@NotNull(message = "Id is null")
	private BigInteger Id;
	
	private BigInteger UserUniqueId;

	@NotNull(message = "firstName is null")
	private String firstName;

	@NotNull(message = "lastName is null")
	private String lastName;

	@NotNull(message = "gender is null")
	private String gender;

	private String profilePic;

	@NotNull(message = "locale is null")
	private String locale;

	@NotNull(message = "timezone is null")
	private String timezone;

	private String pageToken;

	@NotNull(message = "appId is null")
	private BigInteger appId;
	
	@NotNull(message = "channelId is null")
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

	public String getAccessToken() {
		return pageToken;
	}

	public void setAccessToken(String accessToken) {
		this.pageToken = accessToken;
	}

	public String getPageToken() {
		return pageToken;
	}

	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
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

	

}
