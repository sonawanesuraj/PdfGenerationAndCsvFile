package com.app.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import com.app.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/CsvData")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping()
	public List<UserEntity> getCsvData() throws ParseException {

		String fileName = "C:\\Users\\HP\\Desktop\\CSVDATA.csv";
		try {
			return userServiceImpl.getCsvData(fileName);
		} catch (IOException e) {
			throw new RuntimeException("Error occurred while reading CSV file: " + e.getMessage());
		} catch (ParseException e) {
			throw new RuntimeException("Error occurred while parsing CSV file: " + e.getMessage());
		}
	}
}
