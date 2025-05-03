package com.yatranow.CommonService.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String state;
    private String city;
    private Double percentage;
    private String promocode;
    private String restriction;
    private LocalDateTime promoStartDate;
    private LocalDateTime promoEndDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
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

