package com.soxam.yliad.s3;

import org.springframework.stereotype.Component;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import javax.annotation.PostConstruct;

import java.nio.file.Paths;

@Component
public class S3Service {

	private final AwsProperties awsProperties;

	private S3Client s3Client;

	public S3Service(AwsProperties awsProperties) {
		this.awsProperties = awsProperties;
	}

	@PostConstruct
	public void init() {
		AwsBasicCredentials awsCreds = AwsBasicCredentials.create(awsProperties.getAccessKeyId(),
				awsProperties.getSecretKey());
		this.s3Client = S3Client.builder()
			.region(Region.of(awsProperties.getRegion()))
			.credentialsProvider(StaticCredentialsProvider.create(awsCreds))
			.build();
	}

	public String getBucketName() {
		return awsProperties.getBucketName();
	}

	public void downloadFile(String downloadPath) {
		GetObjectRequest getObjectRequest = GetObjectRequest.builder()
			.bucket(awsProperties.getBucketName())
			.key(downloadPath)
			.build();

		s3Client.getObject(getObjectRequest, Paths.get(downloadPath));
	}

	public void uploadFile(String key, String filePath) {
		PutObjectRequest putObjectRequest = PutObjectRequest.builder()
			.bucket(awsProperties.getBucketName())
			.key(key)
			.build();

		s3Client.putObject(putObjectRequest, RequestBody.fromFile(Paths.get(filePath)));
	}

}
