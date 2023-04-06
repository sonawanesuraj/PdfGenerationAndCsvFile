package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.serviceInterface.PostalServiceInterface;
import com.app.util.PostOfficeResponse;

@RestController()
@RequestMapping("/postal")
public class PostDetailsController {

	@Autowired
	private PostalServiceInterface postalServiceInterface;

	@RequestMapping(value = "/byCity", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PostOfficeResponse getPostalByCity(@RequestParam String city) {

		PostOfficeResponse postOfficeResponse;
		postOfficeResponse = this.postalServiceInterface.fetchPostOfficeDetailsByCity(city);
		return postOfficeResponse;

	}

}
