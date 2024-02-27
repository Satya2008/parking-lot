package com.parking.model;

public class Vehicle {
	private String registrationNumber;
	private String color;
	private VehicleType type;
	private int timestamp;

	public Vehicle(String registrationNumber, String color, VehicleType type, int timestamp) {
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.type = type;
		this.timestamp = timestamp;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public VehicleType getType() {
		return type;
	}

	public int getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", color=" + color + ", type=" + type
				+ ", timestamp=" + timestamp + "]";
	}

}
