package com.yatranow.CommonService.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String promocode;
    private String description;
    private double discount;
    private double minFare;
    private double discountPercentage;
    private double maxDiscount;
    private String state;
    private String city;
    private LocalDateTime promoStartDate;
    private LocalDateTime promoEndDate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getMinFare() {
		return minFare;
	}
	public void setMinFare(double minFare) {
		this.minFare = minFare;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public double getMaxDiscount() {
		return maxDiscount;
	}
	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDateTime getPromoStartDate() {
		return promoStartDate;
	}
	public void setPromoStartDate(LocalDateTime promoStartDate) {
		this.promoStartDate = promoStartDate;
	}
	public LocalDateTime getPromoEndDate() {
		return promoEndDate;
	}
	public void setPromoEndDate(LocalDateTime promoEndDate) {
		this.promoEndDate = promoEndDate;
	}

}

