package com.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostalEntity {

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("BranchType")
	private String branchType;

	@JsonProperty("DeleveryStatus")
	private String deleveryStatus;

	@JsonProperty("Circle")
	private String circle;

	@JsonProperty("District")
	private String district;

	@JsonProperty("Division")
	private String division;

	@JsonProperty("Resion")
	private String resion;

	@JsonProperty("State")
	private String state;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("PinCode")
	private String pinCode;

}
