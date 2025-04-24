package com.yatranow.CommonService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatranow.CommonService.entity.CabRating;
import com.yatranow.CommonService.response.ApiResponse;
import com.yatranow.CommonService.service.CabRatingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/common/cab-rating/")
@Tag(name = "Cab Rating API", description = "API for managing cab ratings")
public class CabRatingController {
    @Autowired
    private CabRatingService service;

    @Operation(summary = "Add a new cab rating", description = "Adds a new rating for a specific cab.")
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addRating(@RequestBody CabRating rating) {
        try {
            CabRating savedRating = service.addRating(rating);
            return ResponseEntity.ok(new ApiResponse("success", savedRating, 200));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse("error", e.getMessage(), 500));
        }
    }

    @Operation(summary = "Get all ratings for a cab", description = "Fetches all ratings for a specific cab by cabId.")
    @GetMapping("/{cabId}")
    public ResponseEntity<ApiResponse> getRatings(
            @Parameter(description = "ID of the cab to fetch ratings for", required = true) @PathVariable("cabId") Long cabId) {
        try {
            List<CabRating> ratings = service.getRatingsByCabId(cabId);
            return ResponseEntity.ok(new ApiResponse("success", ratings, 200));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse("error", e.getMessage(), 500));
        }
    }

    @Operation(summary = "Get average rating for a cab", description = "Calculates the average rating for a specific cab by cabId.")
    @GetMapping("/{cabId}/average-rating")
    public ResponseEntity<ApiResponse> getAverageRating(
            @Parameter(description = "ID of the cab to calculate the average rating for", required = true) @PathVariable("cabId") long cabId) {
        try {
            double averageRating = service.getAverageRating(cabId);
            return ResponseEntity.ok(new ApiResponse("success", averageRating, 200));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse("error", e.getMessage(), 500));
        }
    }
}
