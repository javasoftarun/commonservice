package com.yatranow.CommonService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yatranow.CommonService.entity.CabRating;

@Repository
public interface CabRatingRepository extends JpaRepository<CabRating, Long> {
    
	List<CabRating> findByCabRegistrationId(Long cabRegistrationId);

	List<CabRating> findByUserId(long userId);
}

