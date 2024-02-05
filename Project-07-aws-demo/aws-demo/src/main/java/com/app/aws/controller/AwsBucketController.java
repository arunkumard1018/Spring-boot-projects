package com.app.aws.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.aws.service.AmzonClientService;

@RestController
public class AwsBucketController {
	private AmzonClientService AmzonClientService;

	
	
	public AwsBucketController(com.app.aws.service.AmzonClientService amzonClientService) {
		AmzonClientService = amzonClientService;
	}



	@PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.AmzonClientService.upload(file);
    }
	
	
	
	
	
	
	
	
	
	@PostMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.AmzonClientService.deleteFileFromS3Bucket(fileUrl);
    }
}
