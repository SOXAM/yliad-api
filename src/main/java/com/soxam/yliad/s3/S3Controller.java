package com.soxam.yliad.s3;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/s3")
public class S3Controller {

	private final S3Service s3Service;

	public S3Controller(S3Service s3Service) {
		this.s3Service = s3Service;
	}

	@GetMapping("/list")
	public String listBucket() {
		String bucketName = s3Service.getBucketName();

		return "File downloaded to: " + bucketName;
	}

	@GetMapping("/download")
	public String downloadFile() {
		String downloadPath = "test/iu.jpg";

		// S3에서 파일 다운로드
		s3Service.downloadFile(downloadPath);

		return "File downloaded to: " + downloadPath;
	}

}
