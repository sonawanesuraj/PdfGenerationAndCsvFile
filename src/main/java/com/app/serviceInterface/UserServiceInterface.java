package com.app.serviceInterface;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.app.entity.UserEntity;

public interface UserServiceInterface {

	List<UserEntity> getCsvData(String fileName) throws IOException, ParseException;

}
