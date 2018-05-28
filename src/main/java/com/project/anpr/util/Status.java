package com.project.anpr.util;

public enum Status {
	

	ACTIVE("ACTIVE", "Active Status"),

	DELETE("DELETE", "Delete Status"),

	BLOCKED("BLOCKED", "Blocked Status");
	

	private final String value;
	private final String description;

	private Status(String value, String description) {
		this.value = value;
		this.description = description;
	}

	/**
	 * Return the String value of this status.
	 */
	public String value() {
		return this.value;
	}

	/**
	 * Return the description of this status.
	 */
	public String getReasonPhrase() {
		return this.description;
	}

	/**
	 * Return a string representation of this status value.
	 */
	@Override
	public String toString() {
		return this.value;
	}


}
