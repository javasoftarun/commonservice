package com.yatranow.CommonService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CabRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cabRegistrationId;
    private Long userId;
    private int rating;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

