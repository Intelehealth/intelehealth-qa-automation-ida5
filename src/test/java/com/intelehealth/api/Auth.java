package com.intelehealth.api;

import com.intelehealth.config.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Auth {
	/**
	 * GOing forward we will be using these methods for visit creation as CHW,
	 * starting the visit as doctor, sign and submit
	 */

	/**
	 * API Authorization methods
	 * 
	 */

	public static RequestSpecification buildRequestWithNurseAuthorization() {
		String credentials = ConfigManager.getInstance().getChwCredentialsBase64();
		return RestAssured.given().header("Authorization", "Basic " + credentials).contentType(ContentType.JSON);
	}

	/**
	 * Doctor authorization — resolves credentials based on project + env
	 */
	public static RequestSpecification buildRequestWithDoctorAuthorization() {
		String credentials = ConfigManager.getInstance().getDoctorCredentialsBase64();
		return RestAssured.given().header("Authorization", "Basic " + credentials).contentType(ContentType.JSON);
	}
}
