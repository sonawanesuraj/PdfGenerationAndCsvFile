package com.app.serviceInterface;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface EmployeeServiceInterface {

	public void bulkupload(MultipartFile file) throws IOException;

}
