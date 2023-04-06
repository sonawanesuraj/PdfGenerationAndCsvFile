package com.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.serviceInterface.PostalServiceInterface;
import com.app.util.PostOfficeResponse;

@Service
public class PostalServiceImpl implements PostalServiceInterface {
	@Autowired
	RestTemplate restTemplate;

	@Override
	public PostOfficeResponse fetchPostOfficeDetailsByCity(String cityValue) {
		String url = "https://api.postalpincode.in/postoffice/{city}";
		url = url.replace("{city}", cityValue);
		System.out.println("Url is :" + url);

		ResponseEntity<PostOfficeResponse[]> postalEntity = restTemplate.getForEntity(url, PostOfficeResponse[].class);

		System.out.println("Response Status Code is : " + postalEntity.getStatusCodeValue());
		PostOfficeResponse[] responceBeanArray = postalEntity.getBody();
		return null;

//		for(PostOfficeResponse officeResponse:responceBeanArray) {
//		List<PostOfficeResponse>officeResponses = officeResponse.getPostOffice();
//		
//		for(PostOfficeResponse pob :)
//		}
//		return null;
	}

}
