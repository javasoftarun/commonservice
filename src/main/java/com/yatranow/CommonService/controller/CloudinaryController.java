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

import com.yatranow.CommonService.entity.UploadedImage;
import com.yatranow.CommonService.repository.UploadedImageRepository;
import com.yatranow.CommonService.request.ImageUploadRequest;
import com.yatranow.CommonService.response.ApiResponse;
import com.yatranow.CommonService.service.CloudinaryService;

@RestController
@RequestMapping("/api/common")
public class CloudinaryController {

    private final CloudinaryService cloudinaryService;
    
    @Autowired
    private UploadedImageRepository uploadedImageRepository;

    public CloudinaryController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    /**
	 * Endpoint to upload a Base64 encoded image to Cloudinary.
	 *
	 * @param base64Image The Base64 encoded image string.
	 * @return The URL of the uploaded image.
	 */
    @PostMapping("/uploadBase64Image")
    public ResponseEntity<ApiResponse> uploadBase64Image(@RequestBody ImageUploadRequest request) {
        try {
            String imageUrl = cloudinaryService.uploadBase64Image(request);
            return ResponseEntity.ok(new ApiResponse("success", imageUrl, 200));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse("error", e.getMessage(), 500));
        }
    }
    
    @GetMapping("/getImage/{userId}")
    public ResponseEntity<ApiResponse> getImage(@PathVariable("userId") String userId) {
		try {
			List<UploadedImage> response = uploadedImageRepository.getImageUrlByUserId(userId);
			return ResponseEntity.ok(new ApiResponse("success", response, 200));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ApiResponse(e.getMessage(), null, 500));
		}
	}
}

