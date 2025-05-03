package com.yatranow.CommonService.controller;

import com.yatranow.CommonService.entity.Offer;
import com.yatranow.CommonService.service.OfferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/common/offer")
@Tag(name = "Offer Controller", description = "APIs for managing offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping("/create")
    @Operation(summary = "Create a new offer", description = "Creates a new offer and returns the created offer")
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.createOffer(offer);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all offers", description = "Retrieves a list of all offers")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get offer by ID", description = "Retrieves an offer by its ID")
    public Offer getOfferById(@Parameter(description = "ID of the offer to retrieve") @PathVariable("id") Long id) {
        return offerService.getOfferById(id);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update an offer", description = "Updates an existing offer by its ID")
    public Offer updateOffer(
            @Parameter(description = "ID of the offer to update") @PathVariable("id") Long id,
            @RequestBody Offer offer) {
        offer.setId(id);
        return offerService.createOffer(offer);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete an offer", description = "Deletes an offer by its ID")
    public void deleteOffer(@Parameter(description = "ID of the offer to delete") @PathVariable("id") Long id) {
        offerService.deleteOffer(id);
    }
}
