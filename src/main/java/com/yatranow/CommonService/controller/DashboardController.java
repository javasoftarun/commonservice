package com.yatranow.CommonService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatranow.CommonService.response.ApiResponse;
import com.yatranow.CommonService.response.DashboardResponse;
import com.yatranow.CommonService.service.DashboardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/common/dashboard")
@Tag(name = "Dashboard API", description = "API for retrieving dashboard data")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/data")
	@Operation(summary = "Get Dashboard Data", description = "Fetches the dashboard data including total users, bookings, and cabs.")
	public ResponseEntity<ApiResponse> getDashboardData() {
		try {
			DashboardResponse response = dashboardService.getDashboardData();
			return ResponseEntity.ok(new ApiResponse("success", response, 200));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponse("error", e.getMessage(), 500));
		}
	}
}
