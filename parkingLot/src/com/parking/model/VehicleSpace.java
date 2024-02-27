package com.parking.model;

public class VehicleSpace {
	private int spaceNumber;
	private boolean availability;
	private Vehicle vehicle;

	public VehicleSpace(int spaceNumber) {
		this.spaceNumber = spaceNumber;
		this.availability = true;
		this.vehicle = null;
	}

	public int getSpaceNumber() {
		return spaceNumber;
	}

	public boolean isAvailable() {
		return availability;
	}

	public void occupy(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.availability = false;
	}

	public void vacate() {
		this.vehicle = null;
		this.availability = true;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	@Override
	public String toString() {
		return "VehicleSpace [spaceNumber=" + spaceNumber + ", availability=" + availability + ", vehicle=" + vehicle
				+ "]";
	}

}
