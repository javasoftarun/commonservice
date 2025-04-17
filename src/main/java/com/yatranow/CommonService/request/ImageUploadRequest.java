package com.yatranow.CommonService.request;

/**
 * This class represents a request to upload an image.
 * It contains the user ID and the Base64 encoded image string.
 */
public class ImageUploadRequest {

	private String userId;
	private String base64Image;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	
}
