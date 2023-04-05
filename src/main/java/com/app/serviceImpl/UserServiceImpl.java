package com.app.serviceImpl;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import com.app.serviceInterface.UserServiceInterface;
import com.opencsv.CSVReader;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserEntity> getCsvData(String fileName) throws IOException, ParseException {
		List<UserEntity> csvDataList = new ArrayList<>();
		try {
			CSVReader reader = new CSVReader(new FileReader(fileName));
			List<String[]> records = reader.readAll();
			String[] headers = records.get(0);
			for (int i = 1; i < records.size(); i++) {
				UserEntity entity = new UserEntity();
				String[] values = records.get(i);
				entity.setName(values[0].isEmpty() ? null : values[0]);
				entity.setEmail(values[1].isEmpty() ? null : values[1]);
				entity.setAddress(values[2].isEmpty() ? null : values[2]);
				entity.setGender(values[3].isEmpty() ? null : values[3]);
				entity.setPhoneNumber(values[4].isEmpty() ? null : values[4]);
				csvDataList.add(entity);
			}
			userRepository.saveAll(csvDataList);
			return csvDataList;
		} catch (IOException e) {
			throw new RuntimeException("Error occurred while reading CSV file: " + e.getMessage());
		} catch (NumberFormatException e) {
			throw new RuntimeException("Error occurred while parsing CSV file: " + e.getMessage());
		}
	}
}
