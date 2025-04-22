package com.yatranow.CommonService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yatranow.CommonService.entity.UploadedImage;

@Repository
public interface UploadedImageRepository extends JpaRepository<UploadedImage, Long> {

	@Query("SELECT u FROM UploadedImage u WHERE u.userId = :userId")
	List<UploadedImage> getImageUrlByUserId(@Param("userId") String userId);

}

