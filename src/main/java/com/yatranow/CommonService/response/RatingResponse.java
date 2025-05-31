package com.yatranow.CommonService.response;

public class RatingResponse {

	private Long cabRegistrationId;
	private double averageRating;
	private int totalRatings;
	public Long getCabRegistrationId() {
		return cabRegistrationId;
	}
	public void setCabRegistrationId(Long cabRegistrationId) {
		this.cabRegistrationId = cabRegistrationId;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	public int getTotalRatings() {
		return totalRatings;
	}
	public void setTotalRatings(int totalRatings) {
		this.totalRatings = totalRatings;
	}
	
}
