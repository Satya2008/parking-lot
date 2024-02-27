package com.parking.repository;

import java.util.List;

import com.parking.model.Vehicle;
import com.parking.model.VehicleSpace;
import com.parking.model.VehicleType;

public interface ParkingStrategy {

	boolean findSpace(VehicleType vehicleType);

	VehicleSpace parkVehicle(VehicleType vehicleType, Vehicle vehicle);

	void removeVehicle(String registrationNumber);

	List<VehicleSpace> getSpaces();

}
