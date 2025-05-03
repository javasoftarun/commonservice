package com.yatranow.CommonService.controller;

import com.yatranow.CommonService.entity.Notification;
import com.yatranow.CommonService.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/common/notifications")
@Tag(name = "Notification Controller", description = "APIs for managing notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    @Operation(summary = "Send a notification", description = "Sends a notification and returns a success message")
    public String sendNotification(
            @Parameter(description = "Notification object to be sent") @RequestBody Notification notification) {
        notificationService.sendNotification(notification);
        return "Notification sent successfully!";
    }

    @GetMapping("/all")
    @Operation(summary = "Get all notifications", description = "Retrieves a list of all notifications")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}
