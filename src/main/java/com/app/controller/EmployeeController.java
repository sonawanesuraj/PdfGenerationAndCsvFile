package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.serviceInterface.EmployeeServiceInterface;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	@PostMapping("/bulkupload")
	public ResponseEntity<String> bulkUpload(@RequestParam("file") MultipartFile file) {
		try {
			employeeServiceInterface.bulkupload(file);
			return ResponseEntity.status(HttpStatus.CREATED).body("Data uploaded successfully");
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error uploading data: " + e.getMessage());
		}
	}

}
