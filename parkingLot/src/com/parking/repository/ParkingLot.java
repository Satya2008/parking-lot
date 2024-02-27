package com.parking.repository;

import java.util.ArrayList;
import java.util.List;

import com.parking.model.Vehicle;
import com.parking.model.VehicleSpace;
import com.parking.model.VehicleType;
import com.parking.service.CostStrategy;

public class ParkingLot implements ParkingStrategy {
	private List<FloorImpl> floors;
	private CostStrategy costStrategy;

	public ParkingLot(int totalFloors, int spacesPerFloor, CostStrategy costStrategy) {
		this.floors = initializeFloors(totalFloors, spacesPerFloor);
		this.costStrategy = costStrategy;
	}

	@Override
	public boolean findSpace(VehicleType vehicleType) {
		for (FloorImpl floor : floors) {
			if (floor.findSpace(vehicleType)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public VehicleSpace parkVehicle(VehicleType vehicleType, Vehicle vehicle) {
		for (FloorImpl floor : floors) {
			VehicleSpace s = floor.parkVehicle(vehicleType, vehicle);
			if (s != null) {
				return s;
			}
		}
		return null;
	}

	@Override
	public void removeVehicle(String rNumber) {
		for (FloorImpl f : floors) {
			f.removeVehicle(rNumber);
		}
	}

	public List<VehicleSpace> getSpaces() {
		List<VehicleSpace> allSpa = new ArrayList<>();
		for (FloorImpl f : floors) {
			allSpa.addAll(f.getSpaces());
		}
		return allSpa;
	}

	public void setHourlyRate(VehicleType vehicleType, double rate) {
		costStrategy.setRate(vehicleType, rate);
	}

	private List<FloorImpl> initializeFloors(int totalFloors, int spacesPerFloor) {
		List<FloorImpl> init = new ArrayList<>();
		for (int floorNumber = 1; floorNumber <= totalFloors; floorNumber++) {
			init.add(new FloorImpl(floorNumber, new ParkingStrategyImpl(spacesPerFloor)));
		}
		return init;
	}

	public boolean checkAvailability(int floorNumber, VehicleType vehicleType) {
		if (floorNumber >= 1 && floorNumber <= floors.size()) {
			FloorImpl f= floors.get(floorNumber - 1);
			return f.findSpace(vehicleType);
		}
		return false;
	}

	public void addVehicle(VehicleType vehicleType, String regNumber, String color, int time) {
		for (FloorImpl floor : floors) {
			if (floor.findSpace(vehicleType)) {
				Vehicle ve = new Vehicle(regNumber, color, vehicleType, time);
				VehicleSpace space = floor.parkVehicle(vehicleType, ve);
				if (space != null) {
					System.out.println("Vehicle parked" + floor.getFloorNumber() + ", Space " + space.getSpaceNumber());
					return;
				}
			}
		}
		System.out.println("Parking is full " + vehicleType);
	}

}
