package com.project.anpr.util;

public enum LoginStatus {
	
	LOGGEDIN("LOGGEDIN", "loggedin"), 
	LOGOUT("LOGOUT", "logout");

	private final String value;
	private final String description;

	

	public String value() {
		return this.value;
	}

	/**
	 * @param value
	 * @param description
	 */
	private LoginStatus(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getReasonPhrase() {
		return this.description;
	}

	@Override
	public String toString() {
		return this.value;
	}


}