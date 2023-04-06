package com.app.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostOfficeResponse {

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("PostOffice")
	private List<PostOfficeResponse> postOffice;
}
