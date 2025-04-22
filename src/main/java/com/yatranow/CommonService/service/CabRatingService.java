package com.yatranow.CommonService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatranow.CommonService.entity.CabRating;
import com.yatranow.CommonService.repository.CabRatingRepository;

import java.util.List;

@Service
public class CabRatingService {
    @Autowired
    private CabRatingRepository repository;

    public CabRating addRating(CabRating rating) {
        return repository.save(rating);
    }

    public List<CabRating> getRatingsByCabId(Long cabId) {
        return repository.findByCabId(cabId);
    }

    public double getAverageRating(long cabId) {
        List<CabRating> ratings = repository.findByCabId(cabId);
        return ratings.stream().mapToInt(CabRating::getRating).average().orElse(0.0);
    }
}
