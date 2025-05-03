package com.yatranow.CommonService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yatranow.CommonService.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	// Custom query methods can be defined here if needed

}
