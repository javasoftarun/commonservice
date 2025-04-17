package com.yatranow.CommonService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yatranow.CommonService.entity.UploadedImage;

@Repository
public interface UploadedImageRepository extends JpaRepository<UploadedImage, Long> {
}

