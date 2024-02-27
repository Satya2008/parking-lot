package com.parking.service;

import com.parking.model.VehicleType;

public interface CostStrategy {

	void setRate(VehicleType vehicleType, double rate);

	double getRate(VehicleType vehicleType);
}
