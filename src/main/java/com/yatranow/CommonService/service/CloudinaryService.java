package com.yatranow.CommonService.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.yatranow.CommonService.entity.UploadedImage;
import com.yatranow.CommonService.repository.UploadedImageRepository;
import com.yatranow.CommonService.request.ImageUploadRequest;

import jakarta.annotation.PostConstruct;

@Service
public class CloudinaryService {

    private Cloudinary cloudinary;
    
    @Autowired
    private UploadedImageRepository uploadedImageRepository;
    
    @Value("${cloudinary.cloud_name}")
    private String cloudName;
    
    @Value("${cloudinary.api_key}")
    private String apiKey;
    
    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    /**
	 * Constructor to initialize Cloudinary with configuration values.
	 */
    @PostConstruct
    public void inti() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        System.out.println(config);
        this.cloudinary = new Cloudinary(config);
    }

    /**
	 * Uploads a Base64 encoded image to Cloudinary and returns the URL of the uploaded image.
	 *
	 * @param base64Image The Base64 encoded image string.
	 * @return The URL of the uploaded image.
	 * @throws Exception If an error occurs during the upload process.
	 */
    public String uploadBase64Image(ImageUploadRequest request) throws Exception {
        // Prepare the Base64 data
        String base64Data = "data:image/png;base64," + request.getBase64Image();

        // Upload the image
        Map<String, Object> uploadResult = cloudinary.uploader().upload(base64Data, ObjectUtils.emptyMap());
        String imageUrl = uploadResult.get("url").toString();

        // Save the image URL to the database
        UploadedImage uploadedImage = new UploadedImage();
        uploadedImage.setUserId(Long.parseLong(request.getUserId()));
        uploadedImage.setImageUrl(imageUrl);
        uploadedImageRepository.save(uploadedImage);

        return imageUrl;
    }
}

