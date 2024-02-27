package com.parking.repository;

import java.util.ArrayList;
import java.util.List;

import com.parking.model.Vehicle;
import com.parking.model.VehicleSpace;
import com.parking.model.VehicleType;

public class FloorImpl implements ParkingStrategy {

	private int floorNumber;
	private ParkingStrategy parkingStrategy;

	public FloorImpl(int floorNumber, ParkingStrategy parkingStrategy) {
		this.floorNumber = floorNumber;
		this.parkingStrategy = parkingStrategy;
	}

	@Override
	public boolean findSpace(VehicleType vehicleType) {
		return parkingStrategy.findSpace(vehicleType);
	}

	@Override
	public VehicleSpace parkVehicle(VehicleType vehicleType, Vehicle vehicle) {
		return parkingStrategy.parkVehicle(vehicleType, vehicle);
	}

	@Override
	public void removeVehicle(String registrationNumber) {
		parkingStrategy.removeVehicle(registrationNumber);
	}

	public int getFloorNumber() {
		return floorNumber;
	}
    
	@Override
	public List<VehicleSpace> getSpaces() {
		return new ArrayList<>();
	}

}
