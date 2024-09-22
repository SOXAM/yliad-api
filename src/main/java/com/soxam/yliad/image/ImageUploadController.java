package com.soxam.yliad.image;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.soxam.yliad.image.storage.StorageFileNotFoundException;
import com.soxam.yliad.image.storage.StorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ImageUploadController {

	private final StorageService storageService;

	@Autowired
	public ImageUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/image/files/{filename:.+}")
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);

		if (file == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
			.body(file);
	}

	@PostMapping("/image")
	public ResponseEntity<Map<String, String>> handleImageUpload(@RequestParam("file") MultipartFile file)
			throws IOException {

		Map<String, String> map = new HashMap<>();

		map.put("fileName", file.getOriginalFilename());
		map.put("fileSize", Long.toString(file.getSize()));
		map.put("fileContentType", file.getContentType());

		map.put("message", "File upload done");

		storageService.store(file);

		return ResponseEntity.ok(map);
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException e) {
		return ResponseEntity.notFound().build();
	}

}
