package com.yatranow.CommonService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatranow.CommonService.entity.CabRating;
import com.yatranow.CommonService.repository.CabRatingRepository;
import com.yatranow.CommonService.response.RatingResponse;

import java.util.List;

@Service
public class CabRatingService {
    @Autowired
    private CabRatingRepository repository;

    public CabRating addRating(CabRating rating) {
        return repository.save(rating);
    }

    public RatingResponse getRatingsByCabId(Long cabRegistrationId) {
    	double averageRating = 0.0;
    	int totalRatings = 0;
    	RatingResponse ratingResponse = new RatingResponse();
    	List<CabRating> ratings = repository.findByCabRegistrationId(cabRegistrationId);
    	if (ratings != null && !ratings.isEmpty()) {
    		averageRating = ratings.stream().mapToInt(CabRating::getRating).average().orElse(0.0);
    		totalRatings = ratings.size();
			ratingResponse.setAverageRating(averageRating);
			ratingResponse.setTotalRatings(totalRatings);
    	}
        return ratingResponse;
    }

    public double getAverageRating(long cabRegistrationId) {
        List<CabRating> ratings = repository.findByCabRegistrationId(cabRegistrationId);
        return ratings.stream().mapToInt(CabRating::getRating).average().orElse(0.0);
    }
}
