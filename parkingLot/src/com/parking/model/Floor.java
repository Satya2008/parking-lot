package com.parking.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {

	public int floorNumber;
	public List<VehicleSpace> vehicleSpaces;

	public Floor(int floorNumber, int totalSpaces) {
		this.floorNumber = floorNumber;
		this.vehicleSpaces = initializeVehicleSpaces(totalSpaces);
	}

	private List<VehicleSpace> initializeVehicleSpaces(int totalSpaces) {
		List<VehicleSpace> spaces = new ArrayList<>();
		for (int i = 1; i <= totalSpaces; i++) {
			spaces.add(new VehicleSpace(i));
		}
		return spaces;
	}

	@Override
	public String toString() {
		return "Floor [floorNumber=" + floorNumber + ", vehicleSpaces=" + vehicleSpaces + "]";
	}
	
	
	
}
