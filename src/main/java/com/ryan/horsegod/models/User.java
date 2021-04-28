package com.ryan.horsegod.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Column(columnDefinition="BINARY(16)")
	private UUID id;
	@Size(min=3, max=12)
	public String username;
	@Size(min=2, max=40)
	public String fname;
	@Size(min=2, max=40)
	public String lname;
	public String state;
	@Min(5)
	public Long zip;
	@Email
	public String email;
	@Size(min=5)
	public String password;
	@Transient
	public String passwordConfirmation;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Stallion> stallion;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Mare> mare;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Stud> stud;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Sire> sire;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Dam> dam;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Foal> foal;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Colt> colt;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Filly> filly;
	
	public User() {
		
	}
	
	public List<Stud> getStud() {
		return stud;
	}

	public void setStud(List<Stud> stud) {
		this.stud = stud;
	}

	public List<Mare> getMare() {
		return mare;
	}

	public void setMare(List<Mare> mare) {
		this.mare = mare;
	}

	public List<Stallion> getStallion() {
		return stallion;
	}

	public void setStallion(List<Stallion> stallion) {
		this.stallion = stallion;
	}

	public List<Sire> getSire() {
		return sire;
	}

	public void setSire(List<Sire> sire) {
		this.sire = sire;
	}

	public List<Dam> getDam() {
		return dam;
	}

	public void setDam(List<Dam> dam) {
		this.dam = dam;
	}

	public List<Foal> getFoal() {
		return foal;
	}

	public void setFoal(List<Foal> foal) {
		this.foal = foal;
	}

	public List<Colt> getColt() {
		return colt;
	}

	public void setColt(List<Colt> colt) {
		this.colt = colt;
	}

	public List<Filly> getFilly() {
		return filly;
	}

	public void setFilly(List<Filly> filly) {
		this.filly = filly;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getZip() {
		return zip;
	}
	public void setZip(Long zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
			return password;
		}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
