package com.app.serviceInterface;

import com.app.util.PostOfficeResponse;

public interface PostalServiceInterface {

	public PostOfficeResponse fetchPostOfficeDetailsByCity(String city);

}
