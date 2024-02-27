package com.parking.repository;

import java.util.ArrayList;
import java.util.List;

import com.parking.model.Vehicle;
import com.parking.model.VehicleSpace;
import com.parking.model.VehicleType;

public class ParkingStrategyImpl implements ParkingStrategy {


    private List<VehicleSpace> spaces;

    public ParkingStrategyImpl(int spaceFloor) {
        this.spaces = initializeSpaces(spaceFloor);
    }

    @Override
    public boolean findSpace(VehicleType vehicleType) {
        for (VehicleSpace s : spaces) {
            if (s.isAvailable() && s.getVehicle() == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public VehicleSpace parkVehicle(VehicleType vehicleType, Vehicle vehicle) {
        for (VehicleSpace s : spaces) {
            if (s.isAvailable() && s.getVehicle() == null) {
                s.occupy(vehicle);
                return s;
            }
        }
        return null;
    }

    @Override
    public void removeVehicle(String registrationNumber) {
        for (VehicleSpace s : spaces) {
            if (!s.isAvailable() && s.getVehicle() != null &&
                    s.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
                s.vacate();
                break; 
            }
        }
    }

    private List<VehicleSpace> initializeSpaces(int totalSpaces) {
        List<VehicleSpace> in = new ArrayList<>();
        for (int i = 1; i <= totalSpaces; i++) {
            in.add(new VehicleSpace(i));
        }
        return in;
    }

    @Override
    public List<VehicleSpace> getSpaces() {
        return new ArrayList<>(spaces);
    }
	
}
