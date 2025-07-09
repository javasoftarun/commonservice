package com.yatranow.CommonService.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class CabRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookingId;
    private Long cabRegistrationId;
    private Long userId;
    private String userName;
    private String cabName;
    private String cabType;
    private String cabCapacity;
    private String cabImageUrl;
    private String driverName;
    private int rating;
    private String comment;
    private LocalDateTime insertedAt;

    @PrePersist
    protected void onCreate() {
		insertedAt = LocalDateTime.now();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

	public Long getCabRegistrationId() {
		return cabRegistrationId;
	}

	public void setCabRegistrationId(Long cabRegistrationId) {
		this.cabRegistrationId = cabRegistrationId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCabName() {
		return cabName;
	}

	public void setCabName(String cabName) {
		this.cabName = cabName;
	}

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	public String getCabCapacity() {
		return cabCapacity;
	}

	public void setCabCapacity(String cabCapacity) {
		this.cabCapacity = cabCapacity;
	}

	public String getCabImageUrl() {
		return cabImageUrl;
	}

	public void setCabImageUrl(String cabImageUrl) {
		this.cabImageUrl = cabImageUrl;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public LocalDateTime getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(LocalDateTime insertedAt) {
		this.insertedAt = insertedAt;
	}
}

