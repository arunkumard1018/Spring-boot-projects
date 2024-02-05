package com.app.aws.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AmzonClientService {

	private final AmazonS3 s3client;
	@Value("${aws.bucketName}")
	private String bucketName;
    @Value("${aws.endpointUrl}")
    private String endpointUrl;

	public AmzonClientService(AmazonS3 s3client) {
		this.s3client = s3client;
	}

	public String upload(MultipartFile file) {
		File localFile = convertMultipartFileToFile(file);
		String fileName = generateFileName(file);
		String fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
		s3client.putObject(
				new PutObjectRequest(bucketName , fileName, localFile)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	
		return fileUrl;
	}
	
	private File convertMultipartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), convertedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return convertedFile;
    }
	
	
	private String generateFileName(MultipartFile multiPart) {
	    return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	
	public String deleteFileFromS3Bucket(String fileUrl) {
		String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
		s3client.deleteObject(new DeleteObjectRequest(bucketName , fileName));
		return "deleted : " + fileName;
	}

}
