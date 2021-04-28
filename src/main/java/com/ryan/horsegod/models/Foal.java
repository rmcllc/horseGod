package com.ryan.horsegod.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="foal")
public class Foal {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Column(columnDefinition="BINARY(16)")
	private UUID id;
	private Double height;
	private Double weight;
	private Double speed;
	private Double gait;
	private Double endurance;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sire_id")
	private Sire sire;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dam_id")
	private Dam dam;
	@OneToOne(mappedBy="foal", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Filly filly;
	@OneToOne(mappedBy="foal", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Colt colt;
	
	public Foal() {
		
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getGait() {
		return gait;
	}

	public void setGait(Double gait) {
		this.gait = gait;
	}

	public Double getEndurance() {
		return endurance;
	}

	public void setEndurance(Double endurance) {
		this.endurance = endurance;
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

	public Dam getDam() {
		return dam;
	}

	public void setDam(Dam dam) {
		this.dam = dam;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Sire getSire() {
		return sire;
	}

	public void setSire(Sire sire) {
		this.sire = sire;
	}
	
	public Filly getFilly() {
		return filly;
	}

	public void setFilly(Filly filly) {
		this.filly = filly;
	}

	public Colt getColt() {
		return colt;
	}

	public void setColt(Colt colt) {
		this.colt = colt;
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
