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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="stud")
public class Stud {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Column(columnDefinition="BINARY(16)")
	private UUID id;
	protected Double height;
	protected Double weight;
	protected Double speed;
	protected Double gait;
	protected Double endurance;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stallion_id")
	private Stallion stallion;
	@OneToMany(mappedBy="stud", fetch=FetchType.LAZY)
	private List<Sire> sires;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Stud() {
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Stallion getStallion() {
		return stallion;
	}

	public void setStallion(Stallion stallion) {
		this.stallion = stallion;
	}

	public List<Sire> getSires() {
		return sires;
	}

	public void setSires(List<Sire> sires) {
		this.sires = sires;
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

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
