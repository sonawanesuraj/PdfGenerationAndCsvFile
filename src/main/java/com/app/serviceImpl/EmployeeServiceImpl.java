package com.app.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.EmployeeEntity;
import com.app.repository.EmployeeRepository;
import com.app.serviceInterface.EmployeeServiceInterface;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void bulkupload(MultipartFile file) throws IOException {

		List<EmployeeEntity> employeeEntity = new ArrayList<>();
		Workbook workbook = new XSSFWorkbook(file.getInputStream());
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {
			Row row = rows.next();
			if (row.getRowNum() == 0)
				continue;
			EmployeeEntity employee = new EmployeeEntity();
			employee.setName(row.getCell(0).getStringCellValue());
			employee.setEmail(row.getCell(1).getStringCellValue());
			employee.setGender(row.getCell(2).getStringCellValue());
			employee.setDateOfBirth(row.getCell(3).getDateCellValue());
			employee.setAddress(row.getCell(4).getStringCellValue());
			DataFormatter dataFormatter = new DataFormatter();
			employee.setPhoneNumber(dataFormatter.formatCellValue(row.getCell(5)));
			employee.setJoiningDate(row.getCell(6).getDateCellValue());
			employee.setExperience((int) row.getCell(7).getNumericCellValue());
			employee.setSalary(row.getCell(8).getNumericCellValue());
			employeeEntity.add(employee);
		}
		employeeRepository.saveAll(employeeEntity);
	}

}
