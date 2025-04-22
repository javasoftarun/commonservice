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
    private Long cabId;
    private Long userId;
    private int rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCabId() {
		return cabId;
	}

	public void setCabId(Long cabId) {
		this.cabId = cabId;
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
}

