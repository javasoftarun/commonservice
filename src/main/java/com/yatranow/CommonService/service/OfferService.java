package com.yatranow.CommonService.service;

import com.yatranow.CommonService.entity.Offer;
import com.yatranow.CommonService.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

	public Offer getOfferById(Long id) {
		
		return offerRepository.findById(id).orElse(null);
	}

	public void deleteOffer(Long id) {
		offerRepository.deleteById(id);
	}
}
