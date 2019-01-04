package app.dto;

import java.io.Serializable;
import java.util.Set;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_detail")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * @Id
	 * 
	 * @Column(name="userId")
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
	 * 
	 * @Id
	 * 
	 * @GeneratedValue(generator = "UUID")
	 * 
	 * @GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator"
	 * )
	 * 
	 * @Column(name = "id", updatable = false, nullable = false) private UUID id;
	 */

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "userId", unique = true)
	private String id;

	@Column(name = "userName", unique = true, nullable = false)
	private String username;
	@NotBlank(message = "Please enter first name!")
	@Column(name = "firstName")
	private String firstName;
	@NotBlank(message = "Please enter last name!")
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email", unique = true, nullable = false)
	@NotBlank(message = "Please enter email address!")
	private String email;
	private String password;
	@Transient
	private String confirmPassword;

	private boolean isActive = true;
	private boolean isLocked = false;
	private String createdById;
	private Instant createdOn;
	private String modifiedById;
	private Instant modifiedOn;
	private int attemptLimit;
	private int currentLimit;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	private Set<Address> Adresses;
	
	
	//@OneToMany(mappedBy = "User", cascade = CascadeType.ALL) 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	private Set<Phone> phones;

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	
	public Set<Address> getAdresses() {
		return Adresses;
	}

	public void setAdresses(Set<Address> adresses) {
		Adresses = adresses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public String getCreatedBy() {
		return createdById;
	}

	public String getModifiedById() {
		return modifiedById;
	}

	public void setModifiedById(String modifiedById) {
		this.modifiedById = modifiedById;
	}

	public Instant getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Instant modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setCreatedBy(String createdBy) {
		this.createdById = createdBy;
	}

	public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	public int getAttemptLimit() {
		return attemptLimit;
	}

	public void setAttemptLimit(int attemptLimit) {
		this.attemptLimit = attemptLimit;
	}

	public int getCurrentLimit() {
		return currentLimit;
	}

	public void setCurrentLimit(int currentLimit) {
		this.currentLimit = currentLimit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

}
