package com.soxam.yliad.image;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ImageUploadController {

	@PostMapping("/image/upload")
	public ResponseEntity<Map<String, String>> handleImageUpload(@RequestParam("file") MultipartFile file)
			throws IOException {

		log.info("wow...");
		Map<String, String> map = new HashMap<>();

		map.put("fileName", file.getOriginalFilename());
		map.put("fileSize", Long.toString(file.getSize()));
		map.put("fileContentType", file.getContentType());

		map.put("message", "File upload done");
		return ResponseEntity.ok(map);
	}

}
