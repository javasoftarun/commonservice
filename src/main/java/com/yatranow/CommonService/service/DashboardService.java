package com.yatranow.CommonService.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.yatranow.CommonService.response.DashboardResponse;

/**
 * Service class for managing dashboard data.
 * This class interacts with external APIs to fetch data related to users, bookings, and cabs,
 * and processes the data to generate a consolidated dashboard response.
 */
@Service
public class DashboardService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${userservice.api.url}")
    private String userApiUrl;

    @Value("${cabandbookings.api.url}")
    private String bookingApiUrl;

    public long activeCabs;
    public long inactiveCabs;
    public double totalProfit = 0.0;
    public int pendingBookings = 0;
    public int canceledBookings = 0;

    /**
     * Fetches and consolidates dashboard data including total users, bookings, and cabs.
     *
     * @return a {@link DashboardResponse} object containing the dashboard data.
     */
    public DashboardResponse getDashboardData() {
        long totalUsers = getTotalUsers();
        long totalCabs = getTotalCabs();
        long totalBookings = getTotalBookings();

        return new DashboardResponse(totalUsers, totalProfit, totalBookings, pendingBookings, canceledBookings,
                totalCabs, activeCabs, inactiveCabs);
    }

    /**
     * Fetches the total number of users from the user service API.
     *
     * @return the total number of users, or 0 if an error occurs.
     */
    @SuppressWarnings("unchecked")
    public int getTotalUsers() {
        try {
            Map<String, Object> response = restTemplate.getForObject(userApiUrl + "all", Map.class);
            List<?> users = (List<?>) response.get("responseData");
            return users != null ? users.size() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Fetches the total number of bookings from the booking service API.
     * Also calculates the number of pending and canceled bookings, and the total profit.
     *
     * @return the total number of bookings, or 0 if an error occurs.
     */
    @SuppressWarnings("unchecked")
    public int getTotalBookings() {
        try {
            ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(
                    bookingApiUrl + "booking/find/all", HttpMethod.GET, null,
                    new ParameterizedTypeReference<Map<String, Object>>() {
                    });

            Map<String, Object> response = responseEntity.getBody();
            if (response != null) {
                List<Map<String, Object>> bookings = (List<Map<String, Object>>) response.get("responseData");
                if (bookings != null) {
                    for (Map<String, Object> booking : bookings) {
                        String status = (String) booking.get("bookingStatus");
                        if ("PENDING".equalsIgnoreCase(status)) {
                            pendingBookings++;
                        }
                        if ("CANCELED".equalsIgnoreCase(status)) {
                            canceledBookings++;
                        }
                        totalProfit += booking.get("tokenAmount") != null
                                ? Double.parseDouble(booking.get("tokenAmount").toString())
                                : 0.0;
                    }
                    return bookings.size();
                }
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Fetches the total number of cabs from the cab registration service API.
     * Also calculates the number of active and inactive cabs.
     *
     * @return the total number of cabs, or 0 if an error occurs.
     */
    @SuppressWarnings("unchecked")
    public int getTotalCabs() {
        Map<String, Object> response = restTemplate.getForObject(bookingApiUrl + "registration/get/all", Map.class);
        List<Map<String, Object>> cabs = (List<Map<String, Object>>) response.get("responseData");
        if (cabs != null) {
            activeCabs = cabs.stream().filter(cab -> "ACTIVE".equalsIgnoreCase((String) cab.get("status"))).count();
            inactiveCabs = cabs.stream().filter(cab -> "INACTIVE".equalsIgnoreCase((String) cab.get("status"))).count();
            return cabs.size();
        }
        return 0;
    }
}
