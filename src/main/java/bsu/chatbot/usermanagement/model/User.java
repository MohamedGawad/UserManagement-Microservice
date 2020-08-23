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
@Entity(name = "User")
@Table(name = "User")
@NamedQueries(
		  {@NamedQuery(name = "User.findAll", 
		               query = "SELECT p FROM User p"),
		   @NamedQuery(name = "User.findById", 
		               query = "SELECT p FROM User p WHERE p.Id = :userId")}
		)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5308507530706836334L;
	
	@Id
    @Column(nullable = false, length = 20, name = "Id")
	private BigInteger Id;

	@Column(name = "FisrtName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "gender")
	private String gender;

	@Column(name = "profilePic")
	private String profilePic;

	@Column(name = "favourite_local")
	private String locale;

	@Column(name = "IsActive",nullable = false)
	private int isActive;

	@Column(name = "appId",nullable = false)
	private BigInteger appId;
	
}
