//package com.ryan.horsegod.models;
//
//import java.util.Date;
//import java.util.UUID;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//
//@Entity
//@Table(name="trait")
//public abstract class Trait {
//	@Id
//	@GeneratedValue(generator="uuid2")
//	@GenericGenerator(name="uuid2", strategy="uuid2")
//	@Column(columnDefinition="BINARY(16)")
//	private UUID id;
//	private Boolean isTurf;
//	private Boolean isdirt;
//	private Double groundMoisture;
//	//(1)Front Runner (2)Near Front (3)Plodder (4)Behind Pace Grouping
//	private Double pacePosition;
//	//???? Scale 1-???
//	private Double temperament;
//	public Trait(Boolean isTurf, Boolean isDirt, Double groundMoisture, Double pacePosition, Double temperament) {
//		this.isTurf = isTurf;
//		this.isdirt = isDirt;
//		this.groundMoisture = groundMoisture;
//		this.pacePosition = pacePosition;
//		this.temperament = temperament;
//	}
//	public abstract void displayInfo();
//	@Column(updatable = false)
//	private Date createdAt;
//	private Date updatedAt;
//	@OneToOne(fetch = FetchType.LAZY, optional=true)
//	@JoinColumn(name="mare_id")
//	private Mare mare;
//	@OneToOne(fetch = FetchType.LAZY, optional=true)
//	@JoinColumn(name="stallion_id")
//	private Stallion stallion;
//
//	public UUID getId() {
//		return id;
//	}
//
//	public void setId(UUID id) {
//		this.id = id;
//	}
//
//	public Boolean isTurf() {
//		return isTurf;
//	}
//
//	public void setisTurf(Boolean turf) {
//		this.isTurf = turf;
//	}
//
//	public Boolean isDirt() {
//		return isdirt;
//	}
//
//	public void setisDirt(Boolean dirt) {
//		this.isdirt = dirt;
//	}
//
//	public double getGroundMoisture() {
//		return groundMoisture;
//	}
//
//	public void setGroundMoisture(Double groundMoisture) {
//		this.groundMoisture = groundMoisture;
//	}
//
//	public double getPacePosition() {
//		return pacePosition;
//	}
//
//	public void setPacePosition(Double pacePosition) {
//		this.pacePosition = pacePosition;
//	}
//
//	public double getTemperament() {
//		return temperament;
//	}
//
//	public void setTemperament(Double temperament) {
//		this.temperament = temperament;
//	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	public Mare getMare() {
//		return mare;
//	}
//
//	public void setMare(Mare mare) {
//		this.mare = mare;
//	}
//	
//	public Stallion getStallion() {
//		return stallion;
//	}
//
//	public void setStallion(Stallion stallion) {
//		this.stallion = stallion;
//	}
//
//	@PrePersist
//	protected void onCreate() {
//		this.createdAt = new Date();
//	}
//	
//	@PreUpdate
//	protected void onUpdate() {
//		this.updatedAt = new Date();
//	}
//}
